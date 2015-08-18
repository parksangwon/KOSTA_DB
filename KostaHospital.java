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
		
		img = new ImageIcon("facebook.png");
		resizedImg = img.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
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

		imgPanel.add("Center", new JLabel(new ImageIcon(resizedImg)));
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

		//Color
		titleLabel.setForeground(new Color(255,255,255));
		titlePanel.setBackground(new Color(55	 ,99 ,168));

		centerPanel.setBackground(new Color(255 ,255 ,255));

		westSearchPanel.setBackground(new Color(255 ,255 ,255));
		westButtonPanel.setBackground(new Color(255 ,255 ,255));

		imgPanel.setBackground(new Color(255 ,255 ,255));
		imgButtonPanel.setBackground(new Color(255 ,255 ,255));
		
		subInfoPanel1.setBackground(new Color(210 ,231 ,251));
		subInfoPanel2.setBackground(new Color(255 ,255 ,255));
		subInfoPanel3.setBackground(new Color(255 ,255 ,255));
		subInfoPanel4.setBackground(new Color(255 ,255 ,255));
		subInfoPanel5.setBackground(new Color(255 ,255 ,255));
		subInfoPanel6.setBackground(new Color(255 ,255 ,255));

		infoPanel.setBackground(new Color(255 ,255 ,255));
		formMidPanel.setBackground(new Color(255 ,255 ,255));
		formBottomPanel.setBackground(new Color(255 ,255 ,255));
		formSouthPanel.setBackground(new Color(255 ,255 ,255));

		//button Color
		addrSearchButton.setBackground(new Color(55 ,99 ,168));
		addrSearchButton.setForeground(new Color(255 ,255 ,255));

		okButton.setBackground(new Color(55 ,99 ,168));
		okButton.setForeground(new Color(255 ,255 ,255));

		cancleButton.setBackground(new Color(55 ,99 ,168));
		cancleButton.setForeground(new Color(255 ,255 ,255));

		resetButton.setBackground(new Color(55 ,99 ,168));
		resetButton.setForeground(new Color(255 ,255 ,255));

		imgDeleteButton.setBackground(new Color(55 ,99 ,168));
		imgDeleteButton.setForeground(new Color(255 ,255 ,255));

		addButton.setBackground(new Color(55 ,99 ,168));
		addButton.setForeground(new Color(255 ,255 ,255));

		showButton.setBackground(new Color(55 ,99 ,168));
		showButton.setForeground(new Color(255 ,255 ,255));

		updateButton.setBackground(new Color(55 ,99 ,168));
		updateButton.setForeground(new Color(255 ,255 ,255));

		deleteButton.setBackground(new Color(55 ,99 ,168));
		deleteButton.setForeground(new Color(255 ,255 ,255));

		imgLoadButton.setBackground(new Color(55 ,99 ,168));
		imgLoadButton.setForeground(new Color(255 ,255 ,255));

		searchButton.setBackground(new Color(55 ,99 ,168));
		searchButton.setForeground(new Color(255 ,255 ,255));

		//setEditable
		imgLoadButton.setEnabled(false);
		imgDeleteButton.setEnabled(false);
		numTextField.setEditable(false);
		nameTextField.setEditable(false);
		genderComboBox.setEnabled(false);
		birthTextField.setEditable(false);
		subjectComboBox.setEnabled(false);
		phoneTextField.setEditable(false);
		addrNumberTextField.setEditable(false);
		addrSearchButton.setEnabled(false);
		addrTextField.setEditable(false);
		addrDetailTextField.setEditable(false);
		surgeryTextArea.setEnabled(false);
		prescriptionTextArea.setEnabled(false);
		okButton.setEnabled(false);
		cancleButton.setEnabled(false);
		resetButton.setEnabled(false);
		
		//setVisible
		imgLoadButton.setVisible(false);
		imgDeleteButton.setVisible(false);
		addrSearchButton.setVisible(false);
		okButton.setVisible(false);
		cancleButton.setVisible(false);
		resetButton.setVisible(false);

		//****************event*********************

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
}
