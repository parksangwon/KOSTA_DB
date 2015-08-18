public class DisplayManager {

	private KostaHospital kh;

	public DisplayManager(KostaHospital kh){
		this.kh = kh;
	}
	public void setPatientListData(ArrayList patients){
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