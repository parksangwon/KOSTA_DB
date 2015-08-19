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

	
		if(action.equals("����")){
			
			JFileChooser jfc = new JFileChooser(".\\img");

			jfc.setDialogTitle("�̹��� �ҷ�����");
			jfc.showOpenDialog(kh);

			File file = jfc.getSelectedFile();
			String path = file.getAbsolutePath();

			kh.imgName = path.replace("\\","\\\\");
			kh.display.setImage();

		}
		else if(action.equals("����")){ // �̹��� ����
			kh.imgName = ".\\img\\facebook.png";
			kh.display.setImage();
		}
		else if(action.equals("�˻�")){ //�ּ�
			kh.postCodeDialog.setVisible(true);
			kh.DialogSearchTextField.requestFocus();
			kh.display.postCodeClear();
		}
		else if(action.equals("Ȯ��")){
			String birth = kh.birthTextField.getText();
			String phone = kh.phoneTextField.getText();
			
			if ((kh.nameTextField.getText()).equals(""))
			{
				JOptionPane.showMessageDialog(kh, "�̸��� �Է��� �ּ���.", "�̸� ����", JOptionPane.WARNING_MESSAGE);
				return;
			}
			else if(kh.genderComboBox.getSelectedIndex() == 0)
			{
				JOptionPane.showMessageDialog(kh, "������ �Է��� �ּ���.", "���� ����", JOptionPane.WARNING_MESSAGE);
				return;
			}
			else if(kh.birthTextField.getText().equals(""))
			{
				JOptionPane.showMessageDialog(kh, "��������� �Է��� �ּ���.", "������� ����", JOptionPane.WARNING_MESSAGE);
				return;
			}
			else if(kh.subjectComboBox.getSelectedIndex() == 0)
			{
				JOptionPane.showMessageDialog(kh, "��������� �Է��� �ּ���.", "����� ����", JOptionPane.WARNING_MESSAGE);
				return;
			}
			else if(kh.phoneTextField.getText().equals(""))
			{
				JOptionPane.showMessageDialog(kh, "��ȭ��ȣ�� �Է��� �ּ���.", "��ȭ��ȣ ����", JOptionPane.WARNING_MESSAGE);
				return;
			}
			else if(kh.addrNumberTextField.getText().equals("") || kh.addrTextField.getText().equals("") || kh.addrDetailTextField.getText().equals(""))
			{
				JOptionPane.showMessageDialog(kh, "�ּҸ� �Է��� �ּ���.", "�ּ� ����", JOptionPane.WARNING_MESSAGE);
				return;
			}
			// ������� validation
			if (birth.length() != 6)
			{
				JOptionPane.showMessageDialog(kh, "��������� yymmdd������ �Է��� �ּ���", "������� ����", JOptionPane.WARNING_MESSAGE);
				return;
			}
			for (int i =0; i< birth.length() ; i++ )
			{
				char a = birth.charAt(i);
				if (!(a>=48 && a<=57))
				{
					JOptionPane.showMessageDialog(kh, "���ڸ� �Է��� �ּ���.", "������� ����", JOptionPane.WARNING_MESSAGE);
					return;
				}	
			}
			// ��ȭ��ȣ validation
			if (phone.length() != 11)
			{
				JOptionPane.showMessageDialog(kh, "��ȭ��ȣ 11�ڸ��� �Է��� �ּ���", "��ȭ��ȣ ����", JOptionPane.WARNING_MESSAGE);
				return;
			}
			for (int i =0; i< phone.length() ; i++ )
			{
				char a = phone.charAt(i);
				if (!(a>=48 && a<=57))
				{
					JOptionPane.showMessageDialog(kh, "���ڸ� �Է��� �ּ���.", "��ȭ��ȣ ����", JOptionPane.WARNING_MESSAGE);
					return;
				}	
			}

			// DB�� ����
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