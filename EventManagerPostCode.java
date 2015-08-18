import db.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class EventManagerPostCode extends MouseAdapter implements ActionListener, KeyListener
{
	KostaHospital kh;

	public EventManagerPostCode(KostaHospital kh)
	{
		this.kh = kh;
	}

	public void actionPerformed(ActionEvent e)
	{
		String ac = e.getActionCommand().trim();

		if(ac.equals("주소 검색"))
		{
			postCodeSearch();
		}
		else if(ac.equals("주소 적용"))
		{
			String selectAddr = (kh.DialogResultTextArea.getText()).trim();
			if (selectAddr.length()==0)
			{
				JOptionPane.showMessageDialog(kh, "주소를 검색하여 해당 주소를 선택하세요.", "적용 오류", JOptionPane.ERROR_MESSAGE);

				kh.DialogSearchTextField.requestFocus();
				kh.DialogSearchTextField.selectAll();
				return;
			}

			StringTokenizer st = new StringTokenizer(selectAddr, "\n");
			String postCode = (st.nextToken()).substring(1, 8);
			String addr = st.nextToken();

			kh.addrNumberTextField.setText(postCode);
			kh.addrTextField.setText(addr);
			kh.addrDetailTextField.requestFocus();
			kh.postCodeDialog.setVisible(false);
		}
	}

	public void keyPressed(KeyEvent e)
	{
		if(e.getKeyCode() == KeyEvent.VK_ENTER)
		{
			postCodeSearch();
		}
	}
	public void keyTyped(KeyEvent e){}
	public void keyReleased(KeyEvent e){}

	public void mouseClicked(MouseEvent e)
	{
		System.out.println("마우스클릭");
		String selectAddr = ((String)kh.DialogList.getSelectedValue()).trim();
		String postCode = selectAddr.substring(0, selectAddr.indexOf("]")+1);
		String addr1 = (selectAddr.substring(selectAddr.indexOf("]")+1)).trim();
		String postAddr = addr1;
		String addr2 = "";
		if(addr1.indexOf("[") != -1)
		{
			int seperator = addr1.indexOf("[");
			postAddr = (addr1.substring(0, seperator)).trim();
			addr2 = addr1.substring(seperator+1, addr1.length()-1);
		}
		kh.DialogResultTextArea.setText(postCode);
		kh.DialogResultTextArea.append("\n"+postAddr);
		kh.DialogResultTextArea.append("\n"+addr2);
	}

	private void postCodeSearch()
	{
		String searchKey = (kh.DialogSearchTextField.getText()).trim();
		if (searchKey.length()==0)
		{
			JOptionPane.showMessageDialog(kh, "검색어를 입력하세요.", "검색 오류", JOptionPane.ERROR_MESSAGE);

			kh.DialogSearchTextField.requestFocus();
			kh.DialogSearchTextField.selectAll();
			return;
		}
//		sp.dm.addProgressText("- 우편번호를 검색합니다. [검색어 : " + searchKey + "]");

		StringBuffer sb = new StringBuffer();
		sb.append("SELECT SEQ, CODE, ADDR, BUNJI FROM POST_CODE WHERE ADDR LIKE '%"+searchKey+"%'");

		DBExecute dbe = new DBExecute();
		ArrayList dataList = dbe.execute(sb.toString());
		kh.display.setPostCodeListData(dataList);
	}
}