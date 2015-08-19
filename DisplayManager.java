import java.util.*;
import java.awt.*;
import javax.swing.*;

public class DisplayManager {

	private KostaHospital kh;

	public DisplayManager(KostaHospital kh){
		this.kh = kh;
	}
	public void setPatientListData(ArrayList patients){

		Vector dataVector = new Vector();

		for(int i=0; i<patients.size(); i++)
		{
			Hashtable dataTable = (Hashtable)patients.get(i);
			String paNum = (String)dataTable.get("PA_NUM");
			String name = (String)dataTable.get("NAME");
			String sex = (String)dataTable.get("SEX");
			String birth = (String)dataTable.get("BIRTH");
			String subject = (String)dataTable.get("SUBJECT");

			String data = "ȯ�� : " + paNum;
			data = data + "             " + sex + "             " + birth + "             ";
			if(subject.length()==2){
				data = data + subject + "                          " + name;
			}else if(subject.length()==3){
				data = data + subject + "                     " + name;
			}else if(subject.length()==4){
				data = data + subject + "                 " + name;
			}else{
				data = data + subject + "             " + name;
			}

			dataVector.add(data);
		}

		kh.westList.setListData(dataVector);
	}
	public void editClear(){
		kh.nameTextField.setText("");
		kh.genderComboBox.setSelectedIndex(0);
		kh.birthTextField.setText("");
		kh.subjectComboBox.setSelectedIndex(0);
		kh.phoneTextField.setText("");
		kh.addrNumberTextField.setText("");
		kh.addrTextField.setText("");
		kh.addrDetailTextField.setText("");
		kh.surgeryTextArea.setText("");
		kh.prescriptionTextArea.setText("");
		kh.imgName = ".\\img\\facebook.png";
		setImage();
	}

	public void setForm(ArrayList patient) {
		if ( patient.size() != 1 ) {
			System.out.println( "ȯ�� ��ȣ�� �˻��� ����� 1���� �ƴ� - �̻���... �Ȼѷ��ش�." );
			return;
		}
		Hashtable dataTable = (Hashtable)patient.get(0);
		String paNum = (String)dataTable.get("PA_NUM");
		String name = (String)dataTable.get("NAME");
		String sex = (String)dataTable.get("SEX");
		String birth = (String)dataTable.get("BIRTH");
		String subject = (String)dataTable.get("SUBJECT");
		String phone = (String)dataTable.get("PHONE");
		String postCode = (String)dataTable.get("POST_CODE");
		String addr1 = (String)dataTable.get("ADDR1");
		String addr2 = (String)dataTable.get("ADDR2");
//			byte[] bytes = "PHOTO";
		String treatment = (String)dataTable.get("TREATMENT");
		String prescription = (String)dataTable.get("PRESCRIPTION");


		kh.numTextField.setText(paNum);
		kh.nameTextField.setText(name);
		
		int genderIdx = 0;
		if ( sex.equals("M") ) {
			genderIdx = 1;
		} else if ( sex.equals("W") ) {
			genderIdx = 2;
		}
		kh.genderComboBox.setSelectedIndex(genderIdx);
		
		kh.birthTextField.setText(birth);

		int subjectIdx = 0;
		if ( subject.equals("�񴢱��") ) {
			subjectIdx = 1;
		} else if ( subject.equals("����ΰ�") ) {
			subjectIdx = 2;
		} else if ( subject.equals("�Ű��") ) {
			subjectIdx = 3;
		} else if ( subject.equals("�ܰ�") ) {
			subjectIdx = 4;
		} else if ( subject.equals("�������а�") ) {
			subjectIdx = 5;
		} else if ( subject.equals("�����ܰ�") ) {
			subjectIdx = 6;
		} else if ( subject.equals("�����") ) {
			subjectIdx = 7;
		} else if ( subject.equals("ġ��") ) {
			subjectIdx = 8;
		} else if ( subject.equals("��οܰ�") ) {
			subjectIdx = 9;
		} else if ( subject.equals("�Ǻΰ�") ) {
			subjectIdx = 10;
		}
		kh.subjectComboBox.setSelectedIndex(subjectIdx);

		kh.phoneTextField.setText(phone);
		kh.addrNumberTextField.setText(postCode);
		kh.addrTextField.setText(addr1);
		kh.addrDetailTextField.setText(addr2);
		kh.surgeryTextArea.setText(treatment);
		kh.prescriptionTextArea.setText(prescription);
	}
	public void setPostCodeListData(ArrayList dataList)
	{
		Vector dataVector = new Vector();

		for(int i=0; i<dataList.size(); i++)
		{
			Hashtable dataTable = (Hashtable)dataList.get(i);
			String seq = (String)dataTable.get("SEQ");
			String code = (String)dataTable.get("CODE");
			String addr = (String)dataTable.get("ADDR");
			String bunji = (String)dataTable.get("BUNJI");
			String data = " [" + code + "] " + addr;
			if(bunji.length()>0)
			{
				data = data + " [" + bunji + "]";
			}
			dataVector.add(data);
		}

		kh.DialogList.setListData(dataVector);
		//addProgressText("- �����ȣ ����� ����Ͽ����ϴ�.");
	}

	public void postCodeClear()
	{
		kh.DialogSearchTextField.setText("");
		setPostCodeListData(new ArrayList());
		kh.DialogResultTextArea.setText("");
	}

	public void setImage(){
		ImageIcon img = new ImageIcon(kh.imgName);
		Image resizedImg = img.getImage().getScaledInstance(140, 140, Image.SCALE_SMOOTH);
		ImageIcon updateImg = new ImageIcon(resizedImg);
		
		kh.imgLabel.setIcon(updateImg);
	}
}
