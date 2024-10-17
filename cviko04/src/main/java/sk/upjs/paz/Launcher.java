package sk.upjs.paz;

import sk.upjs.jpaz2.*;

public class Launcher {

	public static void main(String[] args) {
		// create new "sandbox" - a place where turtles can live
//		AnimatedWinPane sandbox = new AnimatedWinPane();
//
//		// create new turtle and add it to the "sandbox"
//		SmartTurtle franklin = new SmartTurtle();
//		sandbox.add(franklin);
//
//		// create new object inspector
//		ObjectInspector oi = new ObjectInspector();
//		// ask the inspector to inspect "franklin" and "sandbox"
//		oi.inspect(franklin);
//		oi.inspect(sandbox);
//
//		// you can put other initialization commands here

//		GridPane gp= new GridPane();
//		gp.drawGrid();

		HomeTurtle ferko= new HomeTurtle();
//		gp.add(ferko)

//		ferko.squardot(50);


		//System.out.println(ferko.divergence(5));
		System.out.println(ferko.divergence(5));

	}
}