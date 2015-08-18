
import java.util.*;
import javax.swing.*;
import java.awt.event.*;

public class EventPatientManage implements ActionListener {
	
	private KostaHospital kh;

	public EventPatientManage(KostaHospital kh){
		this.kh = kh;
	}
	
	public void actionPerformed(ActionEvent ae){

		String action = ae.getActionCommand().trim();

		if(action.equals("�߰�")){
			kh.display.editClear();
			kh.changeStatus(true);
			kh.nameTextField.selectAll();
			kh.nameTextField.requestFocus();
		}
		else if(action.equals("����")){
			kh.changeStatus(true);
			kh.nameTextField.selectAll();
			kh.nameTextField.requestFocus();
		}
		else if(action.equals("����")){

			kh.nameTextField.selectAll();
			kh.nameTextField.requestFocus();
		}
	}
}
