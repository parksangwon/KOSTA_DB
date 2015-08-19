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

	
		if(action.equals("불러오기")){
			
			JFileChooser jfc = new JFileChooser(".\\img");

			jfc.setDialogTitle("이미지 불러오기");
			jfc.showOpenDialog(kh);

			File file = jfc.getSelectedFile();
			String path = file.getAbsolutePath();

			kh.imgName = path.replace("\\","\\\\");
			kh.display.setImage();

		}
		else if(action.equals("  삭제  ")){ // 이미지 삭제
		}
		else if(action.equals("검색")){ //주소
			kh.postCodeDialog.setVisible(true);
			kh.DialogSearchTextField.requestFocus();
			kh.display.postCodeClear();
		}
		else if(action.equals("확인")){
			kh.function = "Normal";
			kh.display.setButton(kh.function);
			kh.changeStatus(false);
			kh.westList.setEnabled(true);
		}
		else if(action.equals("취소")){
			kh.function = "Normal";
			kh.display.setButton(kh.function);
			kh.display.editClear();
			kh.changeStatus(false);
			kh.westList.setEnabled(true);
		}
		else if(action.equals("재입력")){
			kh.display.editClear();
		}
	}
}