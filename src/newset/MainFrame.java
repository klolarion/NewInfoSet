package newset;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;

//GUI프레임 클래스
@SuppressWarnings("serial")
public class MainFrame extends JFrame{ 
	//동작 상태값
	int stat = 0;
	//텍스트 입력 필드 
	private JTextField jt1;
	private JTextField jt2;
	private JTextField jt3;
	private JTextField jt4;
	private JTextField jt5;
	private JTextField jt6;
	private JTextField jt7;
	
	//프레임 시작 메서드
	public MainFrame() {
        setTitle("신규세팅"); //창 이름
        setLocationRelativeTo(null); //창 위지 중앙으로
        
        Container contentPane = getContentPane(); //컨테이너
        contentPane.setLayout(new GridLayout(10, 1)); //그리드 레이아웃 
        
        JLabel labelNotice = new JLabel("*---매장코드는 공백 없이 입력---*");
        JLabel labelVer = new JLabel("v0.1");
        
        jt1 = new JTextField(); JLabel label1 = new JLabel("      매장명 : ");
        jt2 = new JTextField(); JLabel label2 = new JLabel("      매장코드 : ");
        jt3 = new JTextField(); JLabel label3 = new JLabel("      대표명 : ");
        jt4 = new JTextField(); JLabel label4 = new JLabel("      사업자번호( - 제외) :  ");
        jt5 = new JTextField(); JLabel label5 = new JLabel("      전화번호 :  ");
        jt6 = new JTextField(); JLabel label6 = new JLabel("      주소1 : ");
        jt7 = new JTextField(); JLabel label7 = new JLabel("      주소2 : ");      
        
        //레이블과 텍스트필드를 프레임에 로드
        this.add(labelNotice); this.add(labelVer); 
        this.add(label1); this.add(jt1); 
        this.add(label2); this.add(jt2);
        this.add(label3); this.add(jt3);
        this.add(label4); this.add(jt4);
        this.add(label5); this.add(jt5);
        this.add(label6); this.add(jt6);
        this.add(label7); this.add(jt7);
        
        
        //저장버튼설정
        String save = ("저장");
        JButton btn = new JButton(save);
        this.add(btn);
        btn.addActionListener(new SaveListener());//버튼에 리스너 추가
        
        //적용버튼설정
        String apply = ("적용");
        JButton btn2 = new JButton(apply);
        this.add(btn2);
        btn2.addActionListener(new ApplyListener());//버튼에 리스너 추가
        
        //계기초기화버튼설정
        String gauge = ("계기초기화");
        JButton btn3 = new JButton(gauge);
        this.add(btn3);
        btn3.addActionListener(new GaugeListener());//버튼에 리스너 추가
        
        //세차권삭제버튼설정
        String cwash = ("세차권삭제");
        JButton btn4 = new JButton(cwash);
        this.add(btn4);
        btn4.addActionListener(new CwashListener());//버튼에 리스너 추가
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //종료버튼으로 종료
        setSize(400, 400); //프레임 크기
        setVisible(true); //프레임 보이기           
    }

	//저장리스너 내부클래스
	private class SaveListener implements ActionListener {
		 
        @Override
        public void actionPerformed(ActionEvent e1) {
            JButton b = (JButton)e1.getSource();
            b.getAction();      
            
            //각 텍스트필드의 입력값을 문자열로 가져옴
            String strNm = jt1.getText();
            String strCd = jt2.getText();
            String mngrNm = jt3.getText();
            String bizNum = jt4.getText();
            String telNo = jt5.getText();
            String addr1 = jt6.getText();
            String addr2 = jt7.getText();
                    
            //문자열 처리 클래스 생성자 호출. 입력값 전달.
            TextControll tc = new TextControll(strNm, strCd, mngrNm, bizNum, telNo, addr1, addr2);
            try {
				tc.text(); //문자열 입출력 메서드 호출
				System.out.println("문자열 입출력 정상동작.");
				System.out.println("==============");
				new Popup().sucPop();
			} catch (IOException e11) {
				System.out.println("문자열 입출력 에러.");
				System.out.println("==============");
				e11.printStackTrace();
				new Popup().errPop();
			}
            
        }        
    }
	
	//적용리스너 내부클래스
	private class ApplyListener implements ActionListener {
		
	    @Override
	    public void actionPerformed(ActionEvent e2) {
	    	 System.out.println("계기초기화클래스호출");
	         JButton b = (JButton)e2.getSource();
	         b.getAction();  
	         
	         //
	         Execute excute = new Execute();
	         try {
				excute.exeInfo();
				System.out.println("배치파일실행 정상동작.");
				System.out.println("==============");
				new Popup().sucPop();
			} catch (IOException | InterruptedException e) {
				System.out.println("배치파일실행 에러.");
				System.out.println("==============");
				e.printStackTrace();
				new Popup().errPop();
			}
        }        
    }

	//계기초기화리스너 내부클래스
	private class GaugeListener implements ActionListener {
		
	    @Override
	    public void actionPerformed(ActionEvent e3) {
	    	 System.out.println("계기초기화클래스호출");
	         JButton b = (JButton)e3.getSource();
	         b.getAction();  
	         
	         Execute excute = new Execute();
	         try {
				excute.exeGauge();;
				System.out.println("배치파일실행 정상동작.");
				System.out.println("==============");
				new Popup().sucPop();
			} catch (IOException | InterruptedException e) {
				System.out.println("배치파일실행 에러.");
				System.out.println("==============");
				e.printStackTrace();
				new Popup().errPop();
			}
        }        
    }	
	
	//세차권삭제리스너 내부클래스
	private class CwashListener implements ActionListener {
		
	    @Override
	    public void actionPerformed(ActionEvent e3) {
	    	 System.out.println("세차권삭제클래스호출");
	         JButton b = (JButton)e3.getSource();
	         b.getAction();  
	         
	         //
	         Execute excute = new Execute();
	         try {
				excute.exeCwash();
				System.out.println("배치파일실행 정상동작.");
				System.out.println("==============");
				new Popup().sucPop();
			} catch (IOException | InterruptedException e) {
				System.out.println("배치파일실행 에러.");
				System.out.println("==============");
				e.printStackTrace();
				new Popup().errPop();
			}
        }        
    }	
	
}
