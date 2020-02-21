package view;

import controller.ProcController;

public class Principal {

	public static void main (String [] args) {
		ProcController pcont = new ProcController();
//		pcont.os();
//	String command = "regedit.exe";
//	pcont.callProcess(command);
//		String command = "ping -t10 www.google.com.br";
//		pcont.readProcess(command);
		String param = "notepad.exe";
		pcont.killProcess(param);
	}
} 