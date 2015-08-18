import java.util.*;

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
			data = data + "\t\t" + name + "\t\t" + sex + "\t\t" + birth + "\t\t" + subject;

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
	}
}