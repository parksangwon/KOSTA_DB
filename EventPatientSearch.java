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

	// �˻� button, �˻���� comboBox
	public void actionPerformed(ActionEvent e) {
		String ac = e.getActionCommand().trim();
		String selectedOption = kh.searchComboBox.getSelectedItem().toString();
		if ( ac.equals("�˻�") ) {
			// ���� �ۼ��� ����
			patientSearchReady();
		}
		else if( ac.equals("��ȸ") ) {
			// ����Ʈ�� ���õȰ� ã��, ȯ�� ��ȣ �����ϱ�
			Object selectedItem = kh.westList.getSelectedValue();
			if ( selectedItem == null ) {
				// �˻�� �Է����ּ��� â ����
				JOptionPane.showMessageDialog(kh, "�ϳ������� �������ּž�����.", "�����", JOptionPane.WARNING_MESSAGE);
				// �˻��� �ʵ� ��ü ����// Ŀ�� ������
				kh.searchTextField.selectAll();
				kh.searchTextField.requestFocus();
				return;
			}
			String selectedName = selectedItem.toString();
			StringTokenizer tokenizer = new StringTokenizer(selectedName, " ");

			tokenizer.nextToken();
			tokenizer.nextToken();
			String patientNum = tokenizer.nextToken(); // ������ ȯ���� ȯ�ڹ�ȣ
			// ã���� ȯ�� ��ȣ�� ��ȸ�Ѵ��� ������ �ѷ��ֱ�

			ArrayList dataList = setDetailInfo(patientNum);

			kh.display.setForm(dataList);
			
			kh.nameTextField.selectAll();
			kh.nameTextField.requestFocus();
			return;
		}

		// ��ü ��ȸ
		// ��Ʈ ��ȣ�� ����
		else if ( selectedOption.equals("�˻����") ) {
			patientSearch("", "", "PA_NUM");
		}
		// �̸����� ����
		else if ( selectedOption.equals("��        ��") ) {
			patientSearch("", "", "NAME");
		}
		// ��ȣ�� ����
		else if ( selectedOption.equals("��  ��  ��") ) {
			patientSearch("", "", "SUBJECT");
		}
		// �������� ����
		else if ( selectedOption.equals("��ȭ��ȣ") ) {
			patientSearch("", "", "PHONE");
		}
	}
	// textfield
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_ENTER)
		{
			patientSearchReady();
		}
	}
	public void keyTyped(KeyEvent e) {}
	public void keyReleased(KeyEvent e) {}
	public void mouseClicked(MouseEvent e) {}

	public void patientSearchReady() {
		// �Էµ� �˻�� ���� ��
		String keyword = kh.searchTextField.getText();
		if ( keyword.length() == 0 ) {
			// �˻�� �Է����ּ��� â ����
			JOptionPane.showMessageDialog(kh, "�˻���� �Է����ּž�����.", "�����", JOptionPane.WARNING_MESSAGE);
			// �˻��� �ʵ� ��ü ����// Ŀ�� ������
			kh.searchTextField.requestFocus();
			kh.searchTextField.selectAll();
			return;
		}

		// ���õ� ������ �̸���������
		int selectedItemIdx = kh.searchComboBox.getSelectedIndex();
		String option = "PA_NUM"; // �ʱ� �˻� ����
		String align = "NAME"; // �˻��� ������ �̸����� ����
		if(selectedItemIdx == 0 || selectedItemIdx == 1)
		{
			option = "NAME";
		}
		else if(selectedItemIdx == 2)
		{
			option = "SUBJECT";
		}
		else if(selectedItemIdx == 3)
		{
			option = "PHONE";
		}
		patientSearch(keyword, option, align);
		//kh.dm.addProgressText("- ȯ�ڸ� �˻��մϴ�. [�˻��� : " + keyword + "]"); // �α�
	}

	// keyword : �˻���, option : �˻�����, align ���ı���
	public void patientSearch(String keyword, String option, String align) {
		
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT PA_NUM, NAME, SEX, BIRTH, SUBJECT FROM PATIENT WHERE USE_YN = 'Y' ");
		
		if ( !option.equals("") ) {
			sb.append("AND ");
		}
		// �̸����� �˻�
		if ( option.equals("NAME") ) {
			sb.append("NAME LIKE " + "'%" + keyword + "%' ");
		}
		// ����� �˻�
		else if ( option.equals("SUBJECT") ) {
			sb.append("SUBJECT LIKE " + "'%" + keyword + "%' ");
		}
		// ��ȣ���� �˻�
		else if ( option.equals("PHONE") ) {
			sb.append("PHONE LIKE " + "'%" + keyword + "%' ");
		}

		sb.append("ORDER BY " + align + ", " + "PA_NUM"); // ���� �ɼ����� 1������, ��Ʈ��ȣ�� 2������
		DBExecute dbe = new DBExecute();
		ArrayList dataList = dbe.execute(sb.toString());
		kh.display.setPatientListData(dataList); // ����Ʈ�� ���
		// �˻��� �ʵ� ��ü ����// Ŀ�� ������
		kh.searchTextField.requestFocus();
		kh.searchTextField.selectAll();
	}
	
	public ArrayList setDetailInfo(String paNum)
	{
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT PA_NUM, NAME, SEX, BIRTH, SUBJECT, PHONE, POST_CODE, ADDR1, ADDR2, PHOTO, TREATMENT, PRESCRIPTION ");
		sb.append("FROM PATIENT WHERE PA_NUM='"+paNum+"'");

		DBExecute dbe = new DBExecute();
		ArrayList dataList = dbe.execute(sb.toString());

		return dataList;
	}
}
