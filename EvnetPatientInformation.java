import java.awt.event.*;

public class EvnetPatientInformation implements ActionListener {

	private KostaHospital kh;

	public EvnetPatientInformation(KostaHospital kh){
		this.kh = kh;
	}

	public void actionPerformed(ActionEvent ae){

		String action = ae.getActionCommand().trim();

		if(action.equals("�߰�")){
			kh.display.pressAddButton();
		}
		else if(action.equals("��ȸ")){
		}
		else if(action.equals("����")){
			kh.display.pressUpdateButton();
		}
		else if(action.equals("����")){
		}
		else if(action.equals("�ҷ�����")){
		}
		else if(action.equals("  ����  ")){
		}
		else if(action.equals("�˻�")){ //�ּ�
		}
		else if(action.equals("Ȯ��")){
		}
		else if(action.equals("���")){
			kh.display.pressCancleButton();
		}
		else if(action.equals("���Է�")){
			kh.display.pressResetButton();
		}
	}
}