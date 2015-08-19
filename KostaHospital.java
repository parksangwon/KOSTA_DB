import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class KostaHospital extends JFrame 
{
	String function = "Normal";

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
	String imgName;
	JLabel imgLabel;
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
	Font dialogtitleFont;

	//우편번호 검색 dialog
	JDialog postCodeDialog;

	JPanel DialogPanel;
	JPanel DialogCenterPanel;
	JPanel DialogNorthPanel;

	JPanel DialogSearchPanel;
	JPanel DialogListPanel;

	JPanel DialogResultPanel;
	JPanel DialogResultTextAreaPanel;
	JPanel DialogResultButtonPanel;

	JLabel DialogTitleLabel;

	JLabel DialogSearchLabel;
	JTextField DialogSearchTextField;
	JButton DialogSearchButton;

	JList DialogList;
	JScrollPane DialogListScrollPane;

	JTextArea DialogResultTextArea;
	JButton DialogResultButton;

	//event
	EventPatientSearch eventSearch;
	EvnetPatientInformation eventInformation;
	EventPatientManage eventManage;
	EventManagerPostCode eventPostCode;
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
		searchButton = new JButton("검색");
		
		westList = new JList();
		westListScrollPane = new JScrollPane(westList);

		addButton = new JButton("추가");
		showButton = new JButton("조회");
		updateButton = new JButton("수정");
		deleteButton = new JButton("삭제");

		//east
		formPanel = new JPanel();

		//east(center)
		formCenterPanel = new JPanel();
		formTopPanel = new JPanel();
		formMidPanel = new JPanel();
		formBottomPanel = new JPanel();

		imgPanel = new JPanel();//top
		imgName = ".\\img\\facebook.png";
		imgLabel = new JLabel();
		imgButtonPanel = new JPanel();
		imgLoadButton = new JButton("불러오기");
		imgDeleteButton = new JButton("  삭제  ");
		
		infoPanel = new JPanel();
		subInfoPanel1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		subInfoPanel2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		subInfoPanel3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		subInfoPanel4 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		subInfoPanel5 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		subInfoPanel6 = new JPanel(new FlowLayout(FlowLayout.LEFT));

		numLabel = new JLabel("⊙ 차    트 : ");
		nameLabel = new JLabel("⊙ 성    명 : ");
		genderLabel = new JLabel("⊙ 성    별 : ");
		birthLabel = new JLabel("⊙ 생년월일 : "); 
		subjectLabel = new JLabel("⊙ 진료과 : ");
		phoneLabel = new JLabel("⊙ 전화번호 : ");
		addrLabel = new JLabel("⊙ 주    소 : ");
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
		addrSearchButton = new JButton("검색");


		surgeryLabel = new JLabel("⊙ 진료내용"); // mid
		surgeryTextArea = new JTextArea();
		surgeryScrollPane = new JScrollPane(surgeryTextArea);


		prescriptionLabel = new JLabel("⊙ 처방"); // bottom
		prescriptionTextArea = new JTextArea();
		prescriptionScrollPane = new JScrollPane(prescriptionTextArea);

		//east(south)
		formSouthPanel = new JPanel();
		okButton = new JButton("확인");
		cancleButton = new JButton("취소");
		resetButton = new JButton("재입력");

		//font
		titleFont = new Font("Impact", Font.BOLD+Font.PLAIN, 40);
		dialogtitleFont = new Font("Impact", Font.BOLD+Font.PLAIN, 30);

		//dialog
		postCodeDialog = new JDialog(this, "우편번호 검색", true);

		DialogPanel = new JPanel();
		DialogCenterPanel = new JPanel();
		DialogNorthPanel = new JPanel();

		DialogSearchPanel = new JPanel();
		DialogListPanel = new JPanel();

		DialogResultPanel = new JPanel();
		DialogResultTextAreaPanel = new JPanel();
		DialogResultButtonPanel = new JPanel();

		DialogTitleLabel = new JLabel("POST CODE SEARCH");

		DialogSearchLabel = new JLabel("주소입력 : ");
		DialogSearchTextField = new JTextField(18);
		DialogSearchButton = new JButton("주소 검색");

		DialogList = new JList();
		DialogListScrollPane = new JScrollPane(DialogList);

		DialogResultTextArea = new JTextArea(3,0);
		DialogResultButton = new JButton("주소 적용");

		//event
		eventSearch = new EventPatientSearch(this);
		eventInformation = new EvnetPatientInformation(this);
		eventManage = new EventPatientManage(this);
		eventPostCode = new EventManagerPostCode(this);
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

		searchComboBox.addItem("검색방법");
		searchComboBox.addItem("성        명");
		searchComboBox.addItem("진  료  과");
		searchComboBox.addItem("전화번호");
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

		display.setImage();
		imgLabel.setHorizontalAlignment(JLabel.CENTER);
		imgPanel.add("Center", imgLabel);
		imgPanel.add("South",imgButtonPanel);
		formTopPanel.add("West",imgPanel);	

		subInfoPanel1.add(numLabel);
		subInfoPanel1.add(numTextField);

		subInfoPanel2.add(nameLabel);
		subInfoPanel2.add(nameTextField);
		subInfoPanel2.add(genderLabel);
		subInfoPanel2.add(genderComboBox);
		genderComboBox.addItem("선택");
		genderComboBox.addItem("남");
		genderComboBox.addItem("여");
		subInfoPanel2.add(birthLabel);
		subInfoPanel2.add(birthTextField);

		subInfoPanel3.add(subjectLabel);
		subInfoPanel3.add(subjectComboBox);
		subjectComboBox.addItem("- 진료선택 -");
		subjectComboBox.addItem("비뇨기과");
		subjectComboBox.addItem("산부인과");
		subjectComboBox.addItem("신경과");
		subjectComboBox.addItem("외과");
		subjectComboBox.addItem("응급의학과");
		subjectComboBox.addItem("정형외과");
		subjectComboBox.addItem("진료과");
		subjectComboBox.addItem("치과");
		subjectComboBox.addItem("흉부외과");
		subjectComboBox.addItem("피부과");
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

		//dialog
		postCodeDialog.add(DialogPanel);
		DialogPanel.setLayout(new BorderLayout());
		DialogPanel.add("North", DialogNorthPanel);
		DialogNorthPanel.add(DialogTitleLabel);
		DialogTitleLabel.setFont(dialogtitleFont);
		
		DialogPanel.add("Center", DialogCenterPanel);
		DialogCenterPanel.setLayout(new BorderLayout());

		DialogCenterPanel.add("North", DialogSearchPanel);
		DialogSearchPanel.setLayout(new FlowLayout());
		DialogSearchPanel.add(DialogSearchLabel);
		DialogSearchPanel.add(DialogSearchTextField);
		DialogSearchPanel.add(DialogSearchButton);

		DialogCenterPanel.add("Center",DialogListPanel);
		DialogListPanel.setLayout(new BorderLayout());
		DialogListPanel.add(DialogListScrollPane);

		DialogCenterPanel.add("South",DialogResultPanel);
		DialogResultPanel.setLayout(new BorderLayout());

		DialogResultPanel.add("Center",DialogResultTextAreaPanel);
		DialogResultPanel.add("East",DialogResultButtonPanel);
		DialogResultButtonPanel.setLayout(new BorderLayout());
		DialogResultTextAreaPanel.setLayout(new BorderLayout());

		DialogResultTextAreaPanel.add(DialogResultTextArea);
		DialogResultButtonPanel.add(DialogResultButton);

		DialogListScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		DialogListScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		DialogList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		DialogResultTextArea.setLineWrap(true);
		DialogResultTextArea.setEditable(false);

		postCodeDialog.setSize(400, 400);
		postCodeDialog.setResizable(false);

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

		//dialogColor
		DialogNorthPanel.setBackground(blue);
		DialogTitleLabel.setForeground(white);
		DialogSearchPanel.setBackground(white);
		DialogResultTextAreaPanel.setBackground(white);
		DialogResultButtonPanel.setBackground(white);

		//dialogButtonColor
		DialogResultButton.setBackground(blue);
		DialogResultButton.setForeground(white);
		DialogResultButton.setFocusPainted(false);
		DialogSearchButton.setBackground(blue);
		DialogSearchButton.setForeground(white);
		DialogSearchButton.setFocusPainted(false);

		//setEnabled, setEditable, setVisible
		
		display.setButton(function);
		numTextField.setEditable(false);
		addrNumberTextField.setEditable(false);
		addrTextField.setEditable(false);

		changeStatus(false);

		//****************event*********************
		searchButton.addActionListener(eventSearch);
		searchTextField.addKeyListener(eventSearch);
		searchComboBox.addActionListener(eventSearch);
		showButton.addActionListener(eventSearch);
		westList.addMouseListener(eventSearch);

		addButton.addActionListener(eventManage);
		updateButton.addActionListener(eventManage);
		deleteButton.addActionListener(eventManage);

		imgLoadButton.addActionListener(eventInformation);
		imgDeleteButton.addActionListener(eventInformation);
		addrSearchButton.addActionListener(eventInformation);
		okButton.addActionListener(eventInformation);
		cancleButton.addActionListener(eventInformation);
		resetButton.addActionListener(eventInformation);

		DialogSearchButton.addActionListener(eventPostCode);
		DialogResultButton.addActionListener(eventPostCode);
		DialogList.addMouseListener(eventPostCode);
		DialogSearchTextField.addKeyListener(eventPostCode);

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

	public void changeStatus(boolean status){
		
		//setEditable
		imgLoadButton.setEnabled(status);
		imgDeleteButton.setEnabled(status);
		nameTextField.setEditable(status);
		genderComboBox.setEnabled(status);
		birthTextField.setEditable(status);
		subjectComboBox.setEnabled(status);
		phoneTextField.setEditable(status);
		addrSearchButton.setEnabled(status);
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
