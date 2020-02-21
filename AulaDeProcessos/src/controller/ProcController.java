package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ProcController {

		public ProcController() {
			super();
		}
		public void os() {
			String osName = System.getProperty("os.name");
			String osVersion = System.getProperty("os.version");
			String osArch = System.getProperty("os.arch");
			System.out.println("SO: "+osName+" - versão: "+osVersion+" - arquitetura: "+osArch);
		}
		
		public void callProcess(String command) {
			try {
				Runtime.getRuntime().exec(command);
			} catch (IOException e) {
			 if (e.getMessage().contains("740")) {
				StringBuffer buffer = new StringBuffer();
				buffer.append("cmd /c");
				buffer.append(" ");
				buffer.append(command);
				try {
					Runtime.getRuntime().exec(buffer.toString());
				} catch (IOException e1) {
					System.err.println(e1.getMessage());
				}
			 }else {
				 System.err.println("Comando não encontrado");
			 }
			}
		
		
}
		public void readProcess(String command) {
			try {
				Process p = Runtime.getRuntime().exec(command);
				InputStream stream = p.getInputStream();
				InputStreamReader reader = new InputStreamReader(stream);
				BufferedReader buffer = new BufferedReader(reader);
				String line = buffer.readLine();
				while (line!= null) {
					System.out.println(line);
					line = buffer.readLine();
				}
				buffer.close();
				reader.close();
				stream.close();
			} catch (IOException e) {
			System.err.println(e.getMessage());
			}		
		}
		
		public void killProcess (String param) {
			String cmdPid = "taskkill /pid";
			String cmdNome = "taskkill /im";
			int pid = 0;
			StringBuffer buffer = new StringBuffer();
			try {
				Integer.parseInt(param);
				buffer.append(cmdNome);
				buffer.append(" ");
				buffer.append(param);
			}catch(NumberFormatException e) {
				buffer.append(cmdNome);
				buffer.append(" ");
				buffer.append(param);
			}
			callProcess(buffer.toString());
		}
}