package newset;
import java.io.*;

//���ڿ� ó�� Ŭ����
public class TextControll{
	int end = 0; //�����
	File fileIn = new File("./text/original.sql"); //�о�� ���� ����
	File fileOut = new File("./text/out.sql"); //����� ���� ����
	//������ �ʵ� ����
	private String strNm; //�����
	private String strCd; //�����ڵ�
	private String mngrNm; //��ǥ��
	private String bizNum; //����ڹ�ȣ
	private String telNo; //��ȭ��ȣ
	private String addr1; //�ּ�1
	private String addr2; //�ּ�2
	
	//������
	public TextControll(String strNm, String strCd, String mngrNm, String bizNum, String telNo, String addr1, String addr2) {
		this.strNm = strNm;
		this.strCd = strCd;
		this.mngrNm = mngrNm;
		this.bizNum = bizNum;
		this.telNo = telNo;
		this.addr1 = addr1;
		this.addr2 = addr2;
	}		
	
	//���ڿ� ����� �޼���
	public int text() throws IOException{		

		//�Է°� Ȯ��
		System.out.println(strNm);
		System.out.println(strCd);
		System.out.println(mngrNm);
		System.out.println(bizNum);
		System.out.println(telNo);
		System.out.println(addr1);
		System.out.println(addr2);
		
		BufferedReader br = new BufferedReader(new FileReader(fileIn));
		BufferedWriter bw = new BufferedWriter(new FileWriter(fileOut));
			
		String in; //���ۿ��� �о�� ����
		String out; //���ڿ� ��ü/������ ����
		
		/**
		�������Ͽ��� ���پ� �о�ͼ� �� ���ڿ� ���Կ��� Ȯ�� �� �Է°����� ��ü�ϰ� ������Ͽ� �����
		*/
		while(!((in = br.readLine())==null)){ //�о�� ���۰��� null�̸� ����
			out = textChange(in); //���ڿ� ����/��ü �޼��� ȣ��		
			bw.write(out + System.lineSeparator());
		}			
			
		
		//�ڿ� �ݳ�
		br.close();	
		bw.close();
		
		//����� ��ȯ
		return end;
	}
	
	//���ڿ� ����/��ü �޼���
	String textChange(String s){
		String temp = s;
		if(s.contains("�ڿ�������")){
			temp = temp.replace("�ڿ�������", strNm);
		}
		if(s.contains("WG37")){
			temp = temp.replace("WG37", strCd);
		}
		if(s.contains("ȫ�浿")){
			temp = temp.replace("ȫ�浿", mngrNm);
		}
		if(s.contains("0010010001")){
			temp = temp.replace("0010010001", bizNum);
		}	
		if(s.contains("031-123-1234")){
			temp = temp.replace("031-123-1234", telNo);
		}
		if(s.contains("��⵵ ���ν� ���ﱸ ������")){
			temp = temp.replace("��⵵ ���ν� ���ﱸ ������", addr1);
		}
		if(s.contains("11-11")){
			temp = temp.replace("11-11", addr2);
		}
		System.out.println(temp);
		return temp;
	}
	
}
