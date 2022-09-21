package newset;
import java.io.*;

//문자열 처리 클래스
public class TextControll{
	int end = 0; //결과값
	File fileIn = new File("./text/original.sql"); //읽어올 파일 설정
	File fileOut = new File("./text/out.sql"); //출력할 파일 설정
	//변경할 필드 선언
	private String strNm; //매장명
	private String strCd; //매장코드
	private String mngrNm; //대표명
	private String bizNum; //사업자번호
	private String telNo; //전화번호
	private String addr1; //주소1
	private String addr2; //주소2
	
	//생성자
	public TextControll(String strNm, String strCd, String mngrNm, String bizNum, String telNo, String addr1, String addr2) {
		this.strNm = strNm;
		this.strCd = strCd;
		this.mngrNm = mngrNm;
		this.bizNum = bizNum;
		this.telNo = telNo;
		this.addr1 = addr1;
		this.addr2 = addr2;
	}		
	
	//문자열 입출력 메서드
	public int text() throws IOException{		

		//입력값 확인
		System.out.println(strNm);
		System.out.println(strCd);
		System.out.println(mngrNm);
		System.out.println(bizNum);
		System.out.println(telNo);
		System.out.println(addr1);
		System.out.println(addr2);
		
		BufferedReader br = new BufferedReader(new FileReader(fileIn));
		BufferedWriter bw = new BufferedWriter(new FileWriter(fileOut));
			
		String in; //버퍼에서 읽어온 라인
		String out; //문자열 교체/검증된 라인
		
		/**
		원본파일에서 한줄씩 읽어와서 각 문자열 포함여부 확인 후 입력값으로 교체하고 대상파일에 출력함
		*/
		while(!((in = br.readLine())==null)){ //읽어온 버퍼값이 null이면 중지
			out = textChange(in); //문자열 검증/교체 메서드 호출		
			bw.write(out + System.lineSeparator());
		}			
			
		
		//자원 반납
		br.close();	
		bw.close();
		
		//결과값 반환
		return end;
	}
	
	//문자열 검증/교체 메서드
	String textChange(String s){
		String temp = s;
		if(s.contains("자영주유소")){
			temp = temp.replace("자영주유소", strNm);
		}
		if(s.contains("WG37")){
			temp = temp.replace("WG37", strCd);
		}
		if(s.contains("홍길동")){
			temp = temp.replace("홍길동", mngrNm);
		}
		if(s.contains("0010010001")){
			temp = temp.replace("0010010001", bizNum);
		}	
		if(s.contains("031-123-1234")){
			temp = temp.replace("031-123-1234", telNo);
		}
		if(s.contains("경기도 용인시 기흥구 기흥대로")){
			temp = temp.replace("경기도 용인시 기흥구 기흥대로", addr1);
		}
		if(s.contains("11-11")){
			temp = temp.replace("11-11", addr2);
		}
		System.out.println(temp);
		return temp;
	}
	
}
