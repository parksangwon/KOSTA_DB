import db.*;
import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class EventPatientSearch extends MouseAdapter implements ActionListener, KeyListener {
	KostaHospital kh;

	public EventPatientSearch(KostaHospital kh) {
		this.kh = kh;
	}

	// �˻� button
	public void actionPerformed(ActionEvent e) {
		String ac = e.getActionCommand().trim();
		
		if ( ac.equals("�˻�") ) {
			// �Էµ� �˻�� ���� ��
			String searchText = kh.searchTextField.getText();
			if ( searchText.length() == 0 ) {
				// �˻�� �Է����ּ��� â ����
				JOptionPane.showMessageDialog(this, text, "message3", JOptionPane.WARNING_MESSAGE);
				// �˻��� �ʵ� ��ü ����
				kh.searchTextField.selectAll();
				//kh.searchTextField. // Ŀ�� ������
			}
			// �˻�
		}
	}
	// textfield
	public void keyPressed(KeyEvent e) {
		
	}
	public void keyTyped(KeyEvent e) {}
	public void keyReleased(KeyEvent e) {}
	public void mouseClicked(MouseEvent e) {}
	public void patientSearchReady(String searchType) {
		//String searchType = kh.searchComboBox.getSelectedItem?????(); // ���õ� ������ �̸���������
		patientSearch(searchType);
	}
	public void patientSearch(String searchType) {
	}
}
