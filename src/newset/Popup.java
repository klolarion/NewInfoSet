package newset;

import javax.swing.JOptionPane;

//�˾�â ���� Ŭ����
public class Popup {

	//���� �˾����� �޼���
	public void sucPop(){ 
		JOptionPane.showMessageDialog(null, "����","Success", JOptionPane.INFORMATION_MESSAGE);
	}	
	
	//���� �˾����� �޼���
	public void errPop(){
		JOptionPane.showMessageDialog(null, "����","Error", JOptionPane.ERROR_MESSAGE);
	}
}
