package sk.upjs.paz;

import sk.upjs.jpaz2.WinPane;

public class Launcher {

	public static void main(String[] args) {
		MidtermPane mp=new MidtermPane();
		System.out.println(mp.bestSeeker());
		WinPane wp=new WinPane();
		Midtermarka m=new Midtermarka();
		wp.add(m);

		m.turn(45);
		m.christmasTree(5,5);
		System.out.println(m.containsTwinChar("oOrRrMmMadWuiS"));
	}
}