import java.awt.event.*;

public class EvnetPatientInformation implements ActionListener {

	private KostaHospital kh;

	public EvnetPatientInformation(KostaHospital kh){
		this.kh = kh;
	}

	public void actionPerformed(ActionEvent ae){

		String action = ae.getActionCommand().trim();

		if(action.equals("추가")){
			kh.display.pressAddButton();
		}
		else if(action.equals("조회")){
		}
		else if(action.equals("수정")){
			kh.display.pressUpdateButton();
		}
		else if(action.equals("삭제")){
		}
		else if(action.equals("불러오기")){
		}
		else if(action.equals("  삭제  ")){
		}
		else if(action.equals("검색")){ //주소
		}
		else if(action.equals("확인")){
		}
		else if(action.equals("취소")){
			kh.display.pressCancleButton();
		}
		else if(action.equals("재입력")){
			kh.display.pressResetButton();
		}
	}
}