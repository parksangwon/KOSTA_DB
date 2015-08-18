import java.awt.event.*;

public class EvnetPatientInformation implements ActionListener {

	private KostaHospital kh;

	public EvnetPatientInformation(KostaHospital kh){
		this.kh = kh;
	}

	public void actionPerformed(ActionEvent ae){

		String action = ae.getActionCommand().trim();

	
		if(action.equals("불러오기")){
		}
		else if(action.equals("  삭제  ")){ // 이미지 삭제
		}
		else if(action.equals("검색")){ //주소
			kh.postCodeDialog.setVisible(true);
			kh.DialogSearchTextField.requestFocus();
			kh.display.postCodeClear();
		}
		else if(action.equals("확인")){
			kh.changeStatus(false);
		}
		else if(action.equals("취소")){
			kh.display.editClear();
			kh.changeStatus(false);
		}
		else if(action.equals("재입력")){
			kh.display.editClear();
		}
	}
}