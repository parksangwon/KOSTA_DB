import db.*;
import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class EventPatientSearch extends MouseAdapter implements ActionListener, KeyListener {
	KostaHospital kh;

	public EventPatientSearch(KostaHospital kh) {
		this.kh = kh;
	}

	// 검색 button, 검색방법 comboBox
	public void actionPerformed(ActionEvent e) {
		String ac = e.getActionCommand().trim();
		String selectedOption = kh.searchComboBox.getSelectedItem().toString();
		if ( ac.equals("검색") ) {
			// 쿼리 작성후 실행
			patientSearchReady();
		}

		// 전체 조회
		// 차트 번호로 정렬
		else if ( selectedOption.equals("검색방법") ) {
			patientSearch("", "", "PA_NUM");
		}
		// 이름으로 정렬
		else if ( selectedOption.equals("이름") ) {
			patientSearch("", "", "NAME");
		}
		// 번호로 정렬
		else if ( selectedOption.equals("진료과") ) {
			patientSearch("", "", "SUBJECT");
		}
		// 과목으로 정렬
		else if ( selectedOption.equals("번호") ) {
			patientSearch("", "", "PHONE");
		}
	}
	// textfield
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_ENTER)
		{
			patientSearchReady();
		}
	}
	public void keyTyped(KeyEvent e) {}
	public void keyReleased(KeyEvent e) {}
	public void mouseClicked(MouseEvent e) {}

	public void patientSearchReady() {
		// 입력된 검색어가 없을 때
		String keyword = kh.searchTextField.getText();
		if ( keyword.length() == 0 ) {
			// 검색어를 입력해주세요 창 띄우기
			JOptionPane.showMessageDialog(kh, "검색어는 입력해주셔야지요.", "저기요", JOptionPane.WARNING_MESSAGE);
			// 검색어 필드 전체 선택// 커서 앞으로
			kh.searchTextField.requestFocus();
			kh.searchTextField.selectAll();
			return;
		}

		// 선택된 아이템 이름가져오기
		int selectedItemIdx = kh.searchComboBox.getSelectedIndex();
		String option = "PA_NUM"; // 초기 검색 조건
		String align = "NAME"; // 검색은 무조건 이름으로 정렬
		if(selectedItemIdx == 1)
		{
			option = "NAME";
		}
		else if(selectedItemIdx == 2)
		{
			option = "SUBJECT";
		}
		else if(selectedItemIdx == 3)
		{
			option = "PHONE";
		}
		patientSearch(keyword, option, align);
		//kh.dm.addProgressText("- 환자를 검색합니다. [검색어 : " + keyword + "]"); // 로그
	}

	// keyword : 검색어, option : 검색기준, align 정렬기준
	public void patientSearch(String keyword, String option, String align) {
		
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT PA_NUM, NAME, SEX, BIRTH, SUBJECT FROM PATIENT WHERE USE_YN = 'Y' ");
		
		if ( !option.equals("") ) {
			sb.append("AND ");
		}
		// 이름으로 검색
		if ( option.equals("NAME") ) {
			sb.append("NAME LIKE " + "'%" + keyword + "%' ");
		}
		// 과목로 검색
		else if ( option.equals("SUBJECT") ) {
			sb.append("SUBJECT LIKE " + "'%" + keyword + "%' ");
		}
		// 번호으로 검색
		else if ( option.equals("PHONE") ) {
			sb.append("PHONE LIKE " + "'%" + keyword + "%' ");
		}

		sb.append("ORDER BY " + align + ", " + "PA_NUM;"); // 정렬 옵션으로 1차정렬, 차트번호로 2차정렬
		DBExecute dbe = new DBExecute();
		ArrayList dataList = dbe.execute(sb.toString());
		/*sp.dm.setMemberListData(dataList);*/ // 리스트에 출력
	}
}
