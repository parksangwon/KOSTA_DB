import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.*;

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

			File file = jfc.getSelectedFile();
			String path = file.getAbsolutePath();

			kh.imgName = path.replace("\\","\\\\");
			kh.display.setImage();

		}
		else if(action.equals("삭제")){ // 이미지 삭제
			kh.imgName = ".\\img\\facebook.png";
			kh.display.setImage();
		}
		else if(action.equals("검색")){ //주소
			kh.postCodeDialog.setVisible(true);
			kh.DialogSearchTextField.requestFocus();
			kh.display.postCodeClear();
		}
		else if(action.equals("확인")){
			String birth = kh.birthTextField.getText();
			String phone = kh.phoneTextField.getText();
			
			if ((kh.nameTextField.getText()).equals(""))
			{
				JOptionPane.showMessageDialog(kh, "이름을 입력해 주세요.", "이름 오류", JOptionPane.WARNING_MESSAGE);
				return;
			}
			else if(kh.genderComboBox.getSelectedIndex() == 0)
			{
				JOptionPane.showMessageDialog(kh, "성별을 입력해 주세요.", "성별 오류", JOptionPane.WARNING_MESSAGE);
				return;
			}
			else if(kh.birthTextField.getText().equals(""))
			{
				JOptionPane.showMessageDialog(kh, "생년월일을 입력해 주세요.", "생년월일 오류", JOptionPane.WARNING_MESSAGE);
				return;
			}
			else if(kh.subjectComboBox.getSelectedIndex() == 0)
			{
				JOptionPane.showMessageDialog(kh, "진료과목을 입력해 주세요.", "진료과 오류", JOptionPane.WARNING_MESSAGE);
				return;
			}
			else if(kh.phoneTextField.getText().equals(""))
			{
				JOptionPane.showMessageDialog(kh, "전화번호를 입력해 주세요.", "전화번호 오류", JOptionPane.WARNING_MESSAGE);
				return;
			}
			else if(kh.addrNumberTextField.getText().equals("") || kh.addrTextField.getText().equals("") || kh.addrDetailTextField.getText().equals(""))
			{
				JOptionPane.showMessageDialog(kh, "주소를 입력해 주세요.", "주소 오류", JOptionPane.WARNING_MESSAGE);
				return;
			}
			// 생년월일 validation
			if (birth.length() != 6)
			{
				JOptionPane.showMessageDialog(kh, "생년월일을 yymmdd형으로 입력해 주세요", "생년월일 오류", JOptionPane.WARNING_MESSAGE);
				return;
			}
			for (int i =0; i< birth.length() ; i++ )
			{
				char a = birth.charAt(i);
				if (!(a>=48 && a<=57))
				{
					JOptionPane.showMessageDialog(kh, "숫자만 입력해 주세요.", "생년월일 오류", JOptionPane.WARNING_MESSAGE);
					return;
				}	
			}
			// 전화번호 validation
			if (phone.length() != 11)
			{
				JOptionPane.showMessageDialog(kh, "전화번호 11자리를 입력해 주세요", "전화번호 오류", JOptionPane.WARNING_MESSAGE);
				return;
			}
			for (int i =0; i< phone.length() ; i++ )
			{
				char a = phone.charAt(i);
				if (!(a>=48 && a<=57))
				{
					JOptionPane.showMessageDialog(kh, "숫자만 입력해 주세요.", "전화번호 오류", JOptionPane.WARNING_MESSAGE);
					return;
				}	
			}

			// DB에 저장
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