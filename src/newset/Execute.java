package newset;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//배치파일 실행 클래스
public class Execute {
	//매장정보적용 배치파일 실행 메서드
	public void exeInfo() throws IOException, InterruptedException{
		Process p = Runtime.getRuntime().exec("./bat/new_str_info_set.bat");
		 
			BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
		
			String line = null;
			while ((line = br.readLine()) != null) {
			System.out.println(line);
			} 
	}
	
	//전일계기초기화 배치파일 실행 메서드
	public void exeGauge() throws IOException, InterruptedException{		
			Process p = Runtime.getRuntime().exec("./bat/new_gauge_set.bat");
			 
			BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
			
			String line = null;
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
	}
	
	//세차권삭제 배치파일 실행 메서드
	public void exeCwash() throws IOException, InterruptedException{
		
			Process p = Runtime.getRuntime().exec("./bat/cwash_off.bat");
			 
			BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
			
			String line = null;
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
	}

}
