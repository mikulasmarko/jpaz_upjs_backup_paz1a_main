package sk.upjs.paz;

import sk.upjs.jpaz2.*;

public class Launcher {

	public static void main(String[] args) {
		WinPane sandbox = new WinPane();

		Midtermarka franklin = new Midtermarka();
		sandbox.add(franklin);

		ObjectInspector oi = new ObjectInspector();
		oi.inspect(franklin);
		oi.inspect(sandbox);

		franklin.pumpkinsExhibition(9,9);

		Midtermpane mp = new Midtermpane();
		System.out.println(mp.runDown());
		
	}
}
