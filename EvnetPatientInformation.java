import java.awt.event.*;

public class EvnetPatientInformation implements ActionListener {

	private KostaHospital kh;

	public EvnetPatientInformation(KostaHospital kh){
		this.kh = kh;
	}

	public void actionPerformed(ActionEvent ae){

		String action = ae.getActionCommand().trim();

	
		if(action.equals("�ҷ�����")){
		}
		else if(action.equals("  ����  ")){ // �̹��� ����
		}
		else if(action.equals("�˻�")){ //�ּ�
			kh.postCodeDialog.setVisible(true);
			kh.DialogSearchTextField.requestFocus();
			kh.display.postCodeClear();
		}
		else if(action.equals("Ȯ��")){
			kh.changeStatus(false);
		}
		else if(action.equals("���")){
			kh.display.editClear();
			kh.changeStatus(false);
		}
		else if(action.equals("���Է�")){
			kh.display.editClear();
		}
	}
}