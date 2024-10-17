package sk.upjs.paz;

import sk.upjs.jpaz2.*;

public class Launcher {

	public static void main(String[] args) {
		// create new "sandbox" - a place where turtles can live
		AnimatedWinPane sandbox = new AnimatedWinPane();

		// create new turtle and add it to the "sandbox"
		SmartTurtle franklin = new SmartTurtle();
		sandbox.add(franklin);

//		// create new object inspector
//		ObjectInspector oi = new ObjectInspector();
//		// ask the inspector to inspect "franklin" and "sandbox"
//		oi.inspect(franklin);
//		oi.inspect(sandbox);
		franklin.setMoveTurnSpeed(0.0005);
		franklin.square(1000000,60);

		// you can put other initialization commands here)
	}
}