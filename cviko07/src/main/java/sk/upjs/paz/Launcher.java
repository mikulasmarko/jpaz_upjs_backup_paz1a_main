package sk.upjs.paz;

import sk.upjs.jpaz2.*;

import java.io.File;

public class Launcher {

	public static void main(String[] args) {

		File mojSuborik=new File("C:\\Users\\Mikuláš\\IdeaProjects\\skolaPAZ");
		SmartTurtle st= new SmartTurtle();
		System.out.println(st.totalSizeOfFilesInDirectory(mojSuborik));

	}
}