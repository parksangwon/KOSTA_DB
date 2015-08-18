import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class KostaHospital extends JFrame 
{
	Container ctp;
	Toolkit toolkit;
	Dimension screenSize;

	// frame
	JPanel titlePanel, centerPanel;
	JPanel westPanel, eastPanel;

	// title
	JLabel titleLabel;
	
	// west
	JPanel westSearchPanel, westButtonPanel;
	JPanel westListPanel;
	JComboBox searchComboBox;
	JTextField searchTextField;
	JButton searchButton;
	JButton addButton, showButton, updateButton, deleteButton;
	JList westList;
	JScrollPane westListScrollPane;

	// east
	JPanel formPanel;
	JPanel formCenterPanel, formSouthPanel;
	// east-center
	JPanel formTopPanel;
	
	JPanel imgPanel; // top - west
	ImageIcon img;
	Image resizedImg;
	JPanel imgButtonPanel;
	JButton imgLoadButton;
	JButton imgDeleteButton;

	JPanel infoPanel; // top - center	
	JPanel subInfoPanel1, subInfoPanel2, subInfoPanel3, 
			subInfoPanel4, subInfoPanel5, subInfoPanel6;
	JLabel numLabel, nameLabel, genderLabel, birthLabel, 
			subjectLabel, phoneLabel, addrLabel, emptyLabel1, emptyLabel2; 
	JTextField numTextField, nameTextField, birthTextField, 
				phoneTextField, addrNumberTextField, addrTextField, addrDetailTextField;
	JComboBox genderComboBox, subjectComboBox;
	JButton addrSearchButton;

	JPanel formMidPanel; // mid
	JLabel surgeryLabel;
	JTextArea surgeryTextArea;
	JScrollPane surgeryScrollPane;

	JPanel formBottomPanel; // bottom
	JLabel prescriptionLabel;
	JTextArea prescriptionTextArea;
	JScrollPane prescriptionScrollPane;
	// east-south
	JButton okButton, cancleButton, resetButton;

	Font titleFont;

	//event
	EventPatientSearch eventSearch;
	EvnetPatientInformation eventInformation;
	DisplayManager display;
	

	public KostaHospital()
	{
		super("KostaHospital");
		ctp = getContentPane();
		toolkit = Toolkit.getDefaultToolkit();
		screenSize = toolkit.getScreenSize();
		
		titlePanel = new JPanel();
		titleLabel = new JLabel("KOSTA HOSPITAL");

		centerPanel = new JPanel();
		westPanel = new JPanel();
		eastPanel = new JPanel();

		//west
		westSearchPanel = new JPanel();
		westListPanel = new JPanel();
		westButtonPanel = new JPanel();
		
		searchComboBox = new JComboBox();
		searchTextField = new JTextField(20);
		searchButton = new JButton("�˻�");
		
		westList = new JList();
		westListScrollPane = new JScrollPane(westList);

		addButton = new JButton("�߰�");
		showButton = new JButton("��ȸ");
		updateButton = new JButton("����");
		deleteButton = new JButton("����");

		//east
		formPanel = new JPanel();

		//east(center)
		formCenterPanel = new JPanel();
		formTopPanel = new JPanel();
		formMidPanel = new JPanel();
		formBottomPanel = new JPanel();

		imgPanel = new JPanel();//top
		
		img = new ImageIcon("facebook.png");
		resizedImg = img.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
		imgButtonPanel = new JPanel();
		imgLoadButton = new JButton("�ҷ�����");
		imgDeleteButton = new JButton("  ����  ");
		
		infoPanel = new JPanel();
		subInfoPanel1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		subInfoPanel2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		subInfoPanel3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		subInfoPanel4 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		subInfoPanel5 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		subInfoPanel6 = new JPanel(new FlowLayout(FlowLayout.LEFT));

		numLabel = new JLabel("�� ��    Ʈ : ");
		nameLabel = new JLabel("�� ��    �� : ");
		genderLabel = new JLabel("�� ��    �� : ");
		birthLabel = new JLabel("�� ������� : "); 
		subjectLabel = new JLabel("�� ����� : ");
		phoneLabel = new JLabel("�� ��ȭ��ȣ : ");
		addrLabel = new JLabel("�� ��    �� : ");
		emptyLabel1 = new JLabel("                     ");
		emptyLabel2 = new JLabel("                     ");

		numTextField = new JTextField(8);
		nameTextField = new JTextField(5);
		genderComboBox = new JComboBox();
		birthTextField = new JTextField(6);		
		subjectComboBox = new JComboBox();
		phoneTextField = new JTextField(10);
		addrNumberTextField = new JTextField(8);
		addrTextField = new JTextField(28);
		addrDetailTextField = new JTextField(28);
		addrSearchButton = new JButton("�˻�");


		surgeryLabel = new JLabel("�� ���᳻��"); // mid
		surgeryTextArea = new JTextArea();
		surgeryScrollPane = new JScrollPane(surgeryTextArea);


		prescriptionLabel = new JLabel("�� ó��"); // bottom
		prescriptionTextArea = new JTextArea();
		prescriptionScrollPane = new JScrollPane(prescriptionTextArea);

		//east(south)
		formSouthPanel = new JPanel();
		okButton = new JButton("Ȯ��");
		cancleButton = new JButton("���");
		resetButton = new JButton("���Է�");

		//font
		titleFont = new Font("Impact", Font.BOLD+Font.PLAIN, 40);

		//event
		eventSearch = new EventPatientSearch(this);
		eventInformation = new EvnetPatientInformation(this);
		display = new DisplayManager(this);
	}
	public void makeGUI()
	{
		// frame
		centerPanel.setLayout(new GridLayout(1, 2, 15, 15));
		westPanel.setLayout(new BorderLayout());
		eastPanel.setLayout(new BorderLayout());
		centerPanel.add(westPanel);
		centerPanel.add(eastPanel);
		
		// title
		
		titleLabel.setFont(titleFont);
		titlePanel.add(titleLabel);
		

		// west
		westListPanel.setLayout(new BorderLayout());

		searchComboBox.addItem("�˻����");
		searchComboBox.addItem("��        ��");
		searchComboBox.addItem("��  ��  ��");
		searchComboBox.addItem("��ȭ��ȣ");
		westSearchPanel.add(searchComboBox);
		westSearchPanel.add(searchTextField);
		westSearchPanel.add(searchButton);
		
		
		westList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		westButtonPanel.add(addButton);
		westButtonPanel.add(showButton);
		westButtonPanel.add(updateButton);
		westButtonPanel.add(deleteButton);

		westListPanel.add("North", westSearchPanel);
		westListPanel.add(westListScrollPane);
		westListPanel.add("South", westButtonPanel);

		westPanel.add(westListPanel);

		//east
		formPanel.setLayout(new BorderLayout());
		
		formCenterPanel.setLayout(new GridLayout(3, 1));
		formCenterPanel.add(formTopPanel);
		formCenterPanel.add(formMidPanel);
		formCenterPanel.add(formBottomPanel);
		//east-center		
		formTopPanel.setLayout(new BorderLayout());//top

		imgPanel.setLayout(new BorderLayout());
		infoPanel.setLayout(new GridLayout(6, 1));

		imgButtonPanel.add(imgLoadButton);
		imgButtonPanel.add(imgDeleteButton);

		imgPanel.add("Center", new JLabel(new ImageIcon(resizedImg)));
		imgPanel.add("South",imgButtonPanel);
		formTopPanel.add("West",imgPanel);	

		subInfoPanel1.add(numLabel);
		subInfoPanel1.add(numTextField);

		subInfoPanel2.add(nameLabel);
		subInfoPanel2.add(nameTextField);
		subInfoPanel2.add(genderLabel);
		subInfoPanel2.add(genderComboBox);
		genderComboBox.addItem("����");
		genderComboBox.addItem("��");
		genderComboBox.addItem("��");
		subInfoPanel2.add(birthLabel);
		subInfoPanel2.add(birthTextField);

		subInfoPanel3.add(subjectLabel);
		subInfoPanel3.add(subjectComboBox);
		subjectComboBox.addItem("- ���ἱ�� -");
		subjectComboBox.addItem("�񴢱��");
		subjectComboBox.addItem("����ΰ�");
		subjectComboBox.addItem("�Ű��");
		subjectComboBox.addItem("�ܰ�");
		subjectComboBox.addItem("�������а�");
		subjectComboBox.addItem("�����ܰ�");
		subjectComboBox.addItem("�����");
		subjectComboBox.addItem("ġ��");
		subjectComboBox.addItem("��οܰ�");
		subjectComboBox.addItem("�Ǻΰ�");
		subInfoPanel3.add(phoneLabel);
		subInfoPanel3.add(phoneTextField);

		subInfoPanel4.add(addrLabel);
		subInfoPanel4.add(addrNumberTextField);
		subInfoPanel4.add(addrSearchButton);
		
		subInfoPanel5.add(emptyLabel1);
		subInfoPanel5.add(addrTextField);

		subInfoPanel6.add(emptyLabel2);
		subInfoPanel6.add(addrDetailTextField);

		infoPanel.add(subInfoPanel1);
		infoPanel.add(subInfoPanel2);
		infoPanel.add(subInfoPanel3);
		infoPanel.add(subInfoPanel4);
		infoPanel.add(subInfoPanel5);
		infoPanel.add(subInfoPanel6);
		formTopPanel.add("Center",infoPanel);	

		formMidPanel.setLayout(new BorderLayout());// mid
		formMidPanel.add("North",surgeryLabel); 
		formMidPanel.add("Center",surgeryScrollPane);

		formBottomPanel.setLayout(new BorderLayout());// bottom
		formBottomPanel.add("North",prescriptionLabel); 
		formBottomPanel.add("Center",prescriptionScrollPane);
		//east-south
		formSouthPanel.add(okButton);
		formSouthPanel.add(cancleButton);
		formSouthPanel.add(resetButton);

		formPanel.add("Center",formCenterPanel);
		formPanel.add("South",formSouthPanel);

		eastPanel.add(formPanel);

		//setColor
		Color white = new Color(255,255,255);
		Color blue = new Color(55 ,99 ,168);
		Color skyBlue = new Color(210 ,231 ,251);

		titleLabel.setForeground(white);
		titlePanel.setBackground(blue);

		centerPanel.setBackground(white);

		westSearchPanel.setBackground(white);
		westButtonPanel.setBackground(white);

		imgPanel.setBackground(white);
		imgButtonPanel.setBackground(white);
		
		subInfoPanel1.setBackground(skyBlue);
		subInfoPanel2.setBackground(white);
		subInfoPanel3.setBackground(white);
		subInfoPanel4.setBackground(white);
		subInfoPanel5.setBackground(white);
		subInfoPanel6.setBackground(white);

		infoPanel.setBackground(white);
		formMidPanel.setBackground(white);
		formBottomPanel.setBackground(white);
		formSouthPanel.setBackground(white);

		//button Color
		addrSearchButton.setBackground(blue);
		addrSearchButton.setForeground(white);
		addrSearchButton.setFocusPainted(false);
		okButton.setBackground(blue);
		okButton.setForeground(white);
		okButton.setFocusPainted(false);
		cancleButton.setBackground(blue);
		cancleButton.setForeground(white);
		cancleButton.setFocusPainted(false);
		resetButton.setBackground(blue);
		resetButton.setForeground(white);
		resetButton.setFocusPainted(false);
		imgDeleteButton.setBackground(blue);
		imgDeleteButton.setForeground(white);
		imgDeleteButton.setFocusPainted(false);
		addButton.setBackground(blue);
		addButton.setForeground(white);
		addButton.setFocusPainted(false);
		showButton.setBackground(blue);
		showButton.setForeground(white);
		showButton.setFocusPainted(false);
		updateButton.setBackground(blue);
		updateButton.setForeground(white);
		updateButton.setFocusPainted(false);
		deleteButton.setBackground(blue);
		deleteButton.setForeground(white);
		deleteButton.setFocusPainted(false);
		imgLoadButton.setBackground(blue);
		imgLoadButton.setForeground(white);
		imgLoadButton.setFocusPainted(false);
		searchButton.setBackground(blue);
		searchButton.setForeground(white);
		searchButton.setFocusPainted(false);

		//combobox color
		searchComboBox.setBackground(white);
		genderComboBox.setBackground(white);
		subjectComboBox.setBackground(white);


		//setEditable, setVisible
		changeStatus("Start", false);

		//****************event*********************
		searchButton.addActionListener(eventSearch);
		searchTextField.addActionListener(eventSearch);
		searchComboBox.addActionListener(eventSearch);

		addButton.addActionListener(eventInformation);
		showButton.addActionListener(eventInformation);
		updateButton.addActionListener(eventInformation);
		deleteButton.addActionListener(eventInformation);
		imgLoadButton.addActionListener(eventInformation);
		imgDeleteButton.addActionListener(eventInformation);
		addrSearchButton.addActionListener(eventInformation);
		okButton.addActionListener(eventInformation);
		cancleButton.addActionListener(eventInformation);
		resetButton.addActionListener(eventInformation);

		//frame
		ctp.add("North", titlePanel);
		ctp.add("Center", centerPanel);
		setSize(1200, 700);
		setResizable(false);
		setVisible(true);
	}

	public static void main(String[] args) 
	{
		KostaHospital kh = new KostaHospital();
		kh.makeGUI();
	}

	public void changeStatus(String mode, boolean status){

		if(mode.equals("Start")){
			numTextField.setEditable(status);
		}

		//setEditable
		imgLoadButton.setEnabled(status);
		imgDeleteButton.setEnabled(status);
		nameTextField.setEditable(status);
		genderComboBox.setEnabled(status);
		birthTextField.setEditable(status);
		subjectComboBox.setEnabled(status);
		phoneTextField.setEditable(status);
		addrNumberTextField.setEditable(status);
		addrSearchButton.setEnabled(status);
		addrTextField.setEditable(status);
		addrDetailTextField.setEditable(status);
		surgeryTextArea.setEnabled(status);
		prescriptionTextArea.setEnabled(status);
		okButton.setEnabled(status);
		cancleButton.setEnabled(status);
		resetButton.setEnabled(status);
		//setVisible
		imgLoadButton.setVisible(status);
		imgDeleteButton.setVisible(status);
		addrSearchButton.setVisible(status);
		okButton.setVisible(status);
		cancleButton.setVisible(status);
		resetButton.setVisible(status);

	}
}
