package sk.upjs.paz;

import sk.upjs.jpaz2.*;

import java.io.File;

public class Launcher {

	public static void main(String[] args) {

		File Adresar=new File("C:\\Users");
		SmartTurtle st= new SmartTurtle();
		System.out.println(st.totalSizeOfFilesInDirectory(Adresar));

	}
}