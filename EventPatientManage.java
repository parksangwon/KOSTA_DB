
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

			kh.function = "Add";
			kh.display.setButton(kh.function);	
			kh.display.editClear();
			kh.westList.setEnabled(false);

			kh.changeStatus(true);
			kh.nameTextField.selectAll();
			kh.nameTextField.requestFocus();
		}
		else if(action.equals("����")){

			kh.function = "Update";
			kh.display.setButton(kh.function);	
			kh.westList.setEnabled(false);

			kh.changeStatus(true);
			kh.nameTextField.selectAll();
			kh.nameTextField.requestFocus();
		}
		else if(action.equals("����")){

			kh.searchTextField.selectAll();
			kh.searchTextField.requestFocus();
		}
	}
}
