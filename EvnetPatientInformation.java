import java.awt.event.*;
import javax.swing.*;
import java.io.*;

public class EvnetPatientInformation implements ActionListener {

	private KostaHospital kh;

	public EvnetPatientInformation(KostaHospital kh){
		this.kh = kh;
	}

	public void actionPerformed(ActionEvent ae){

		String action = ae.getActionCommand().trim();

	
		if(action.equals("�ҷ�����")){
			
			JFileChooser jfc = new JFileChooser(".\\img");

			jfc.setDialogTitle("�̹��� �ҷ�����");
			jfc.showOpenDialog(kh);

			File file = jfc.getSelectedFile();
			String path = file.getAbsolutePath();

			kh.imgName = path.replace("\\","\\\\");
			kh.display.setImage();

		}
		else if(action.equals("  ����  ")){ // �̹��� ����
		}
		else if(action.equals("�˻�")){ //�ּ�
			kh.postCodeDialog.setVisible(true);
			kh.DialogSearchTextField.requestFocus();
			kh.display.postCodeClear();
		}
		else if(action.equals("Ȯ��")){
			kh.function = "Normal";
			kh.display.setButton(kh.function);
			kh.changeStatus(false);
			kh.westList.setEnabled(true);
		}
		else if(action.equals("���")){
			kh.function = "Normal";
			kh.display.setButton(kh.function);
			kh.display.editClear();
			kh.changeStatus(false);
			kh.westList.setEnabled(true);
		}
		else if(action.equals("���Է�")){
			kh.display.editClear();
		}
	}
}