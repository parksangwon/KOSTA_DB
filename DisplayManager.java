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

			String data = "È¯ÀÚ : " + paNum;
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
	}
}