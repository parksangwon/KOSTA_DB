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

	
		if(action.equals("사진")){
			
			JFileChooser jfc = new JFileChooser(".\\img");

			jfc.setDialogTitle("이미지 불러오기");
			jfc.showOpenDialog(kh);

			kh.imgFile = jfc.getSelectedFile();
			String path = kh.imgFile.getAbsolutePath();

			kh.imgName = path.replace("\\","\\\\");
			kh.display.setImage();

		}
		else if(action.equals("지우기")){ // 이미지 삭제
			kh.imgName = ".\\img\\facebook.png";
			kh.display.setImage();
		}
		else if(action.equals("검색")){ //주소
			kh.postCodeDialog.setVisible(true);
			kh.DialogSearchTextField.requestFocus();
			kh.display.postCodeClear();
		}
		else if(action.equals("취소")){
			
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
		else if(action.equals("재입력")){
			kh.display.editClear();
		}
	}
}