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

	// 검색 button
	public void actionPerformed(ActionEvent e) {
		String ac = e.getActionCommand().trim();
		
		if ( ac.equals("검색") ) {
			// 입력된 검색어가 없을 때
			String searchText = kh.searchTextField.getText();
			if ( searchText.length() == 0 ) {
				// 검색어를 입력해주세요 창 띄우기
				JOptionPane.showMessageDialog(this, text, "message3", JOptionPane.WARNING_MESSAGE);
				// 검색어 필드 전체 선택
				kh.searchTextField.selectAll();
				//kh.searchTextField. // 커서 앞으로
			}
			// 검색
		}
	}
	// textfield
	public void keyPressed(KeyEvent e) {
		
	}
	public void keyTyped(KeyEvent e) {}
	public void keyReleased(KeyEvent e) {}
	public void mouseClicked(MouseEvent e) {}
	public void patientSearchReady(String searchType) {
		//String searchType = kh.searchComboBox.getSelectedItem?????(); // 선택된 아이템 이름가져오기
		patientSearch(searchType);
	}
	public void patientSearch(String searchType) {
	}
}
