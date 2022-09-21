package newset;

import javax.swing.JOptionPane;

//팝업창 관리 클래스
public class Popup {

	//성공 팝업생성 메서드
	public void sucPop(){ 
		JOptionPane.showMessageDialog(null, "성공","Success", JOptionPane.INFORMATION_MESSAGE);
	}	
	
	//실패 팝업생성 메서드
	public void errPop(){
		JOptionPane.showMessageDialog(null, "실패","Error", JOptionPane.ERROR_MESSAGE);
	}
}
