package newset;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;

//GUI������ Ŭ����
@SuppressWarnings("serial")
public class MainFrame extends JFrame{ 
	//���� ���°�
	int stat = 0;
	//�ؽ�Ʈ �Է� �ʵ� 
	private JTextField jt1;
	private JTextField jt2;
	private JTextField jt3;
	private JTextField jt4;
	private JTextField jt5;
	private JTextField jt6;
	private JTextField jt7;
	
	//������ ���� �޼���
	public MainFrame() {
        setTitle("�űԼ���"); //â �̸�
        setLocationRelativeTo(null); //â ���� �߾�����
        
        Container contentPane = getContentPane(); //�����̳�
        contentPane.setLayout(new GridLayout(10, 1)); //�׸��� ���̾ƿ� 
        
        JLabel labelNotice = new JLabel("*---�����ڵ�� ���� ���� �Է�---*");
        JLabel labelVer = new JLabel("v0.1");
        
        jt1 = new JTextField(); JLabel label1 = new JLabel("      ����� : ");
        jt2 = new JTextField(); JLabel label2 = new JLabel("      �����ڵ� : ");
        jt3 = new JTextField(); JLabel label3 = new JLabel("      ��ǥ�� : ");
        jt4 = new JTextField(); JLabel label4 = new JLabel("      ����ڹ�ȣ( - ����) :  ");
        jt5 = new JTextField(); JLabel label5 = new JLabel("      ��ȭ��ȣ :  ");
        jt6 = new JTextField(); JLabel label6 = new JLabel("      �ּ�1 : ");
        jt7 = new JTextField(); JLabel label7 = new JLabel("      �ּ�2 : ");      
        
        //���̺�� �ؽ�Ʈ�ʵ带 �����ӿ� �ε�
        this.add(labelNotice); this.add(labelVer); 
        this.add(label1); this.add(jt1); 
        this.add(label2); this.add(jt2);
        this.add(label3); this.add(jt3);
        this.add(label4); this.add(jt4);
        this.add(label5); this.add(jt5);
        this.add(label6); this.add(jt6);
        this.add(label7); this.add(jt7);
        
        
        //�����ư����
        String save = ("����");
        JButton btn = new JButton(save);
        this.add(btn);
        btn.addActionListener(new SaveListener());//��ư�� ������ �߰�
        
        //�����ư����
        String apply = ("����");
        JButton btn2 = new JButton(apply);
        this.add(btn2);
        btn2.addActionListener(new ApplyListener());//��ư�� ������ �߰�
        
        //����ʱ�ȭ��ư����
        String gauge = ("����ʱ�ȭ");
        JButton btn3 = new JButton(gauge);
        this.add(btn3);
        btn3.addActionListener(new GaugeListener());//��ư�� ������ �߰�
        
        //�����ǻ�����ư����
        String cwash = ("�����ǻ���");
        JButton btn4 = new JButton(cwash);
        this.add(btn4);
        btn4.addActionListener(new CwashListener());//��ư�� ������ �߰�
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //�����ư���� ����
        setSize(400, 400); //������ ũ��
        setVisible(true); //������ ���̱�           
    }

	//���帮���� ����Ŭ����
	private class SaveListener implements ActionListener {
		 
        @Override
        public void actionPerformed(ActionEvent e1) {
            JButton b = (JButton)e1.getSource();
            b.getAction();      
            
            //�� �ؽ�Ʈ�ʵ��� �Է°��� ���ڿ��� ������
            String strNm = jt1.getText();
            String strCd = jt2.getText();
            String mngrNm = jt3.getText();
            String bizNum = jt4.getText();
            String telNo = jt5.getText();
            String addr1 = jt6.getText();
            String addr2 = jt7.getText();
                    
            //���ڿ� ó�� Ŭ���� ������ ȣ��. �Է°� ����.
            TextControll tc = new TextControll(strNm, strCd, mngrNm, bizNum, telNo, addr1, addr2);
            try {
				tc.text(); //���ڿ� ����� �޼��� ȣ��
				System.out.println("���ڿ� ����� ������.");
				System.out.println("==============");
				new Popup().sucPop();
			} catch (IOException e11) {
				System.out.println("���ڿ� ����� ����.");
				System.out.println("==============");
				e11.printStackTrace();
				new Popup().errPop();
			}
            
        }        
    }
	
	//���븮���� ����Ŭ����
	private class ApplyListener implements ActionListener {
		
	    @Override
	    public void actionPerformed(ActionEvent e2) {
	    	 System.out.println("����ʱ�ȭŬ����ȣ��");
	         JButton b = (JButton)e2.getSource();
	         b.getAction();  
	         
	         //
	         Execute excute = new Execute();
	         try {
				excute.exeInfo();
				System.out.println("��ġ���Ͻ��� ������.");
				System.out.println("==============");
				new Popup().sucPop();
			} catch (IOException | InterruptedException e) {
				System.out.println("��ġ���Ͻ��� ����.");
				System.out.println("==============");
				e.printStackTrace();
				new Popup().errPop();
			}
        }        
    }

	//����ʱ�ȭ������ ����Ŭ����
	private class GaugeListener implements ActionListener {
		
	    @Override
	    public void actionPerformed(ActionEvent e3) {
	    	 System.out.println("����ʱ�ȭŬ����ȣ��");
	         JButton b = (JButton)e3.getSource();
	         b.getAction();  
	         
	         Execute excute = new Execute();
	         try {
				excute.exeGauge();;
				System.out.println("��ġ���Ͻ��� ������.");
				System.out.println("==============");
				new Popup().sucPop();
			} catch (IOException | InterruptedException e) {
				System.out.println("��ġ���Ͻ��� ����.");
				System.out.println("==============");
				e.printStackTrace();
				new Popup().errPop();
			}
        }        
    }	
	
	//�����ǻ��������� ����Ŭ����
	private class CwashListener implements ActionListener {
		
	    @Override
	    public void actionPerformed(ActionEvent e3) {
	    	 System.out.println("�����ǻ���Ŭ����ȣ��");
	         JButton b = (JButton)e3.getSource();
	         b.getAction();  
	         
	         //
	         Execute excute = new Execute();
	         try {
				excute.exeCwash();
				System.out.println("��ġ���Ͻ��� ������.");
				System.out.println("==============");
				new Popup().sucPop();
			} catch (IOException | InterruptedException e) {
				System.out.println("��ġ���Ͻ��� ����.");
				System.out.println("==============");
				e.printStackTrace();
				new Popup().errPop();
			}
        }        
    }	
	
}
