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

		if(action.equals("�߰�")){

			kh.function = "Add";
			kh.display.setButton(kh.function);	
			kh.display.editClear();
			kh.westList.setEnabled(false);

			kh.changeStatus(true);
			kh.nameTextField.selectAll();
			kh.nameTextField.requestFocus();
		}
		else if(action.equals("Ȯ��")){
			String birth = kh.birthTextField.getText();
			String phone = kh.phoneTextField.getText();
			
			if ((kh.nameTextField.getText()).equals(""))
			{
				JOptionPane.showMessageDialog(kh, "�̸��� �Է��� �ּ���.", "�̸� ����", JOptionPane.WARNING_MESSAGE);
				return;
			}
			else if(kh.genderComboBox.getSelectedIndex() == 0)
			{
				JOptionPane.showMessageDialog(kh, "������ �Է��� �ּ���.", "���� ����", JOptionPane.WARNING_MESSAGE);
				return;
			}
			else if(kh.birthTextField.getText().equals(""))
			{
				JOptionPane.showMessageDialog(kh, "��������� �Է��� �ּ���.", "������� ����", JOptionPane.WARNING_MESSAGE);
				return;
			}
			else if(kh.subjectComboBox.getSelectedIndex() == 0)
			{
				JOptionPane.showMessageDialog(kh, "��������� �Է��� �ּ���.", "����� ����", JOptionPane.WARNING_MESSAGE);
				return;
			}
			else if(kh.phoneTextField.getText().equals(""))
			{
				JOptionPane.showMessageDialog(kh, "��ȭ��ȣ�� �Է��� �ּ���.", "��ȭ��ȣ ����", JOptionPane.WARNING_MESSAGE);
				return;
			}
			else if(kh.addrNumberTextField.getText().equals("") || kh.addrTextField.getText().equals("") || kh.addrDetailTextField.getText().equals(""))
			{
				JOptionPane.showMessageDialog(kh, "�ּҸ� �Է��� �ּ���.", "�ּ� ����", JOptionPane.WARNING_MESSAGE);
				return;
			}
			// ������� validation
			if (birth.length() != 6)
			{
				JOptionPane.showMessageDialog(kh, "��������� yymmdd������ �Է��� �ּ���", "������� ����", JOptionPane.WARNING_MESSAGE);
				return;
			}
			for (int i =0; i< birth.length() ; i++ )
			{
				char a = birth.charAt(i);
				if (!(a>=48 && a<=57))
				{
					JOptionPane.showMessageDialog(kh, "���ڸ� �Է��� �ּ���.", "������� ����", JOptionPane.WARNING_MESSAGE);
					return;
				}	
			}
			// ��ȭ��ȣ validation
			if (phone.length() != 11)
			{
				JOptionPane.showMessageDialog(kh, "��ȭ��ȣ 11�ڸ��� �Է��� �ּ���", "��ȭ��ȣ ����", JOptionPane.WARNING_MESSAGE);
				return;
			}
			for (int i =0; i< phone.length() ; i++ )
			{
				char a = phone.charAt(i);
				if (!(a>=48 && a<=57))
				{
					JOptionPane.showMessageDialog(kh, "���ڸ� �Է��� �ּ���.", "��ȭ��ȣ ����", JOptionPane.WARNING_MESSAGE);
					return;
				}	
			}
			
			

			// DB�� ����
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
		else if(action.equals("����")){

			kh.function = "Update";
			kh.display.setButton(kh.function);	
			kh.westList.setEnabled(false);

			kh.changeStatus(true);
			kh.nameTextField.selectAll();
			kh.nameTextField.requestFocus();
		}
		else if(action.equals("����")){

			String value = (String)kh.westList.getSelectedValue();
			String paName = getAtribute(value, 7);
			int delete = JOptionPane.showOptionDialog(kh, paName + "���� ������ �����Ͻðڽ��ϱ�?", "���!", JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null, null, null);
			
			if(delete == 0){
				String paNum = getAtribute(value, 3);
				patientDelete(paNum); 

				JOptionPane.showMessageDialog(kh, paName + "���� ���������� �����Ǿ����ϴ�.", "����", JOptionPane.PLAIN_MESSAGE);

				kh.eventSearch.patientSearch("", "", "PA_NUM");  //����Ʈ ����
				kh.display.editClear(); // ȯ������ ����

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
