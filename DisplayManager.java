public class DisplayManager {

	private KostaHospital kh;

	public DisplayManager(KostaHospital kh){
		this.kh = kh;
	}

	public void pressAddButton(){
		kh.changeStatus(null, true);
		kh.nameTextField.requestFocus();
	}
	public void pressShowButton(){
		//////////////////////////////
	}
	public void pressUpdateButton(){
		kh.changeStatus(null, true);
		kh.nameTextField.requestFocus();
	}
	public void pressDeleteButton(){
		//////////////////////////////
	}
	public void pressOkButton(){
				//////////////////////////////
	}
	public void pressCancleButton(){
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
		kh.changeStatus(null, false);
	}
	public void pressResetButton(){

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