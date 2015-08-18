import java.awt.event.*;

public class EvnetPatientInformation implements ActionListener {

	private KostaHospital kh;

	public EvnetPatientInformation(KostaHospital kh){
		this.kh = kh;
	}

	public void actionPerformed(ActionEvent ae){

		String action = ae.getActionCommand().trim();

		if(action.equals("�߰�")){
			kh.display.editClear();
			kh.changeStatus(true);
			kh.nameTextField.requestFocus();
		}
		else if(action.equals("��ȸ")){
		}
		else if(action.equals("����")){
			kh.changeStatus(true);
			kh.nameTextField.selectAll();
			kh.nameTextField.requestFocus();
		}
		else if(action.equals("����")){
		}
		else if(action.equals("�ҷ�����")){
		}
		else if(action.equals("  ����  ")){ // �̹��� ����
		}
		else if(action.equals("�˻�")){ //�ּ�
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