package newset;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//��ġ���� ���� Ŭ����
public class Execute {
	//������������ ��ġ���� ���� �޼���
	public void exeInfo() throws IOException, InterruptedException{
		Process p = Runtime.getRuntime().exec("./bat/new_str_info_set.bat");
		 
			BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
		
			String line = null;
			while ((line = br.readLine()) != null) {
			System.out.println(line);
			} 
	}
	
	//���ϰ���ʱ�ȭ ��ġ���� ���� �޼���
	public void exeGauge() throws IOException, InterruptedException{		
			Process p = Runtime.getRuntime().exec("./bat/new_gauge_set.bat");
			 
			BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
			
			String line = null;
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
	}
	
	//�����ǻ��� ��ġ���� ���� �޼���
	public void exeCwash() throws IOException, InterruptedException{
		
			Process p = Runtime.getRuntime().exec("./bat/cwash_off.bat");
			 
			BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
			
			String line = null;
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
	}

}
