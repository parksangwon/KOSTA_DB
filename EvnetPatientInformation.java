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

	
		if(action.equals("����")){
			
			JFileChooser jfc = new JFileChooser(".\\img");

			jfc.setDialogTitle("�̹��� �ҷ�����");
			jfc.showOpenDialog(kh);

			kh.imgFile = jfc.getSelectedFile();
			String path = kh.imgFile.getAbsolutePath();

			kh.imgName = path.replace("\\","\\\\");
			kh.display.setImage();

		}
		else if(action.equals("�����")){ // �̹��� ����
			kh.imgName = ".\\img\\facebook.png";
			kh.display.setImage();
		}
		else if(action.equals("�˻�")){ //�ּ�
			kh.postCodeDialog.setVisible(true);
			kh.DialogSearchTextField.requestFocus();
			kh.display.postCodeClear();
		}
		else if(action.equals("���")){
			
			if(kh.function.equals("Add")){
				kh.display.editClear();
				kh.function = "Normal";
			}
			else{
				kh.function = "Show";
			}
			kh.changeStatus(false);
			kh.westList.setEnabled(true);
			kh.display.setButton(kh.function);
		}
		else if(action.equals("���Է�")){
			kh.display.editClear();
		}
	}
}