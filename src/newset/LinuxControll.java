package newset;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

public class LinuxControll {

    public void commandExe() {

        JSch jSch = new JSch();
        Session session;

        try {
            // 접속 정보 세팅
            String id = "계정";
            String ip = "아아피";
            Integer port = 포트;
            String pw = "비밀번호";

            session = jSch.getSession(id, ip, port);
            session.setPassword(pw);

            Properties properties = new Properties();
            properties.put("StrictHostKeyChecking", "no");
            session.setConfig(properties);

            session.connect();

            try {
                //명령어 리스트
                List<String> commandList = new ArrayList<>();
                //순차적 사용할 명령어는 && 묶는 것이 좋다.
                commandList.add("cd /etc/firewalld/zones" + " && cat public.xml" + " && echo Success");
                commandList.add("systemctl restart firewalld" + " && service firewalld status" + " && echo Success");


                //리스트에 담긴 명령어 수만큼 실행
                for(int i = 0; i < commandList.size(); i++) {
                    //명령어 실행메서드 호출
                    execCommand(session, commandList.get(i));
                }
            }catch (Exception e) {
                System.out.println(e.toString());
                session.disconnect(); //세션 종료
            }
        }catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    //명령어 실행 메서드
    public void execCommand(Session session, String command) {
        System.out.println(command);
        ChannelExec channelExec = null;
        BufferedReader commandReader = null;

        try {
            channelExec = (ChannelExec) session.openChannel("exec"); //명령어 실행 커맨드 객체 생성
            //결과를 가지고 올 bufferReader
            commandReader = new BufferedReader(new InputStreamReader(channelExec.getInputStream()));

            channelExec.setCommand(command);	// 실행할 command 설정
            channelExec.connect();		// command 실행

            String commandLine = "";
            String cTemp = "";


            //실행된 명령어를 콘솔에 출력
            while(!((cTemp)==null)){
                cTemp = commandReader.readLine();
                if(cTemp==null){
                    break;
                }
                commandLine = cTemp;
                System.out.println("commandLine : " + commandLine); //명령어와 실행결과를 콘솔에 출력
            }

            //마지막 출력값에따라 콘솔에 실패/성공 출력
            if(commandLine == null || commandLine.equals("") || !commandLine.equals("Success")) {
                commandLine = "Fail";
            }
            System.out.println(" command Result -> [ " + commandLine + " ] ");

            commandReader.close();
            channelExec.disconnect();
        } catch (JSchException | IOException e) {
            e.printStackTrace();
        }finally {
            try {
                //종료
                System.out.println(" ===== execCommand Reader Close =====");
                commandReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            channelExec.disconnect();
        }
    }
}

