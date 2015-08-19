import db.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;

public class EventPatientManage implements ActionListener {
	
	private KostaHospital kh;

	public EventPatientManage(KostaHospital kh){
		this.kh = kh;
	}
	
	public void actionPerformed(ActionEvent ae){

		String action = ae.getActionCommand().trim();

		if(action.equals("추가")){

			kh.function = "Add";
			kh.display.setButton(kh.function);	
			kh.display.editClear();
			kh.westList.setEnabled(false);

			kh.changeStatus(true);
			kh.nameTextField.selectAll();
			kh.nameTextField.requestFocus();
		}
		else if(action.equals("확인")){
			String birth = kh.birthTextField.getText();
			String phone = kh.phoneTextField.getText();
			
			if ((kh.nameTextField.getText()).equals(""))
			{
				JOptionPane.showMessageDialog(kh, "이름을 입력해 주세요.", "이름 오류", JOptionPane.WARNING_MESSAGE);
				return;
			}
			else if(kh.genderComboBox.getSelectedIndex() == 0)
			{
				JOptionPane.showMessageDialog(kh, "성별을 입력해 주세요.", "성별 오류", JOptionPane.WARNING_MESSAGE);
				return;
			}
			else if(kh.birthTextField.getText().equals(""))
			{
				JOptionPane.showMessageDialog(kh, "생년월일을 입력해 주세요.", "생년월일 오류", JOptionPane.WARNING_MESSAGE);
				return;
			}
			else if(kh.subjectComboBox.getSelectedIndex() == 0)
			{
				JOptionPane.showMessageDialog(kh, "진료과목을 입력해 주세요.", "진료과 오류", JOptionPane.WARNING_MESSAGE);
				return;
			}
			else if(kh.phoneTextField.getText().equals(""))
			{
				JOptionPane.showMessageDialog(kh, "전화번호를 입력해 주세요.", "전화번호 오류", JOptionPane.WARNING_MESSAGE);
				return;
			}
			else if(kh.addrNumberTextField.getText().equals("") || kh.addrTextField.getText().equals("") || kh.addrDetailTextField.getText().equals(""))
			{
				JOptionPane.showMessageDialog(kh, "주소를 입력해 주세요.", "주소 오류", JOptionPane.WARNING_MESSAGE);
				return;
			}
			// 생년월일 validation
			if (birth.length() != 6)
			{
				JOptionPane.showMessageDialog(kh, "생년월일을 yymmdd형으로 입력해 주세요", "생년월일 오류", JOptionPane.WARNING_MESSAGE);
				return;
			}
			for (int i =0; i< birth.length() ; i++ )
			{
				char a = birth.charAt(i);
				if (!(a>=48 && a<=57))
				{
					JOptionPane.showMessageDialog(kh, "숫자만 입력해 주세요.", "생년월일 오류", JOptionPane.WARNING_MESSAGE);
					return;
				}	
			}
			// 전화번호 validation
			if (phone.length() != 11)
			{
				JOptionPane.showMessageDialog(kh, "전화번호 11자리를 입력해 주세요", "전화번호 오류", JOptionPane.WARNING_MESSAGE);
				return;
			}
			for (int i =0; i< phone.length() ; i++ )
			{
				char a = phone.charAt(i);
				if (!(a>=48 && a<=57))
				{
					JOptionPane.showMessageDialog(kh, "숫자만 입력해 주세요.", "전화번호 오류", JOptionPane.WARNING_MESSAGE);
					return;
				}	
			}
			
			

			// DB에 저장
			String value = "'"+kh.numTextField.getText()+"'"+
							"'"+kh.nameTextField.getText()+"'"+
							"'"+kh.genderComboBox.getSelectedItem()+"'"+
							"'"+kh.birthTextField.getText()+"'"+
							"'"+kh.subjectComboBox.getSelectedItem()+"'"+
							"'"+kh.phoneTextField.getText()+"'"+
							"'"+kh.addrNumberTextField.getText()+"'"+
							"'"+kh.addrTextField.getText()+"'"+
							"'"+kh.addrDetailTextField.getText()+"'"+
							"'"+""+"'"+
							"'"+kh.surgeryTextArea.getText()+"'"+
							"'"+kh.prescriptionTextArea.getText()+"'";
		
			patientAdd(value);

			kh.function = "Normal";
			kh.display.setButton(kh.function);
			kh.changeStatus(false);
			kh.westList.setEnabled(true);
		}
		else if(action.equals("수정")){

			kh.function = "Update";
			kh.display.setButton(kh.function);	
			kh.westList.setEnabled(false);

			kh.changeStatus(true);
			kh.nameTextField.selectAll();
			kh.nameTextField.requestFocus();
		}
		else if(action.equals("삭제")){

			String value = (String)kh.westList.getSelectedValue();
			String paName = getAtribute(value, 7);
			int delete = JOptionPane.showOptionDialog(kh, paName + "님을 정말로 삭제하시겠습니까?", "잠깐만!", JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null, null, null);
			
			if(delete == 0){
				String paNum = getAtribute(value, 3);
				patientDelete(paNum); 

				JOptionPane.showMessageDialog(kh, paName + "님이 정상적으로 삭제되었습니다.", "삭제", JOptionPane.PLAIN_MESSAGE);

				kh.eventSearch.patientSearch("", "", "PA_NUM");  //리스트 리셋
				kh.display.editClear(); // 환자정보 리셋

			}

			kh.searchTextField.selectAll();
			kh.searchTextField.requestFocus();
		}
	}

	public void patientAdd(String value){
		String sb = "INSERT INTO PATIENT(PA_NUM, NAME, SEX, BIRTH, SUBJECT, PHONE, POST_CODE, ADDR1, ADDR2, PHOTO, TREATMENT, PRESCRIPTION)"+
					" VALUES(" + value + ")";
		DBExecute dbe = new DBExecute();
		dbe.execute(sb);
	}
	public void patientUpdate(String paNum){
	}
	public void patientDelete(String paNum){

		String sb = "DELETE FROM PATIENT WHERE PA_NUM = " + "'" + paNum + "'";
		DBExecute dbe = new DBExecute();
		dbe.execute(sb);

	}
	public String getAtribute(String value, int num){

		StringTokenizer token = new StringTokenizer(value," ");
		String atribute = null;

		for(int i = 0 ; i < num ; i++){
			atribute = token.nextToken();
		}

		return atribute;
	}

}
