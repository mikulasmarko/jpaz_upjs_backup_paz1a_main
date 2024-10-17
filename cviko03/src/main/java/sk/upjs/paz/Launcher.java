package sk.upjs.paz;

import sk.upjs.jpaz2.*;

import java.awt.*;

public class Launcher {

    public static void main(String[] args) {
//        WinPane sandbox = new WinPane();
////
//		SmartTurtle franklin = new SmartTurtle();
//		sandbox.add(franklin);
//
////		ObjectInspector oi = new ObjectInspector();
////		oi.inspect(franklin);
////		oi.inspect(sandbox);
//		franklin.concrenticCircle(100);
        ScientificTurtle frantisek= new ScientificTurtle();
//		System.out.println(frantisek.power(5,2));
//        HomeTurtle fero = new HomeTurtle();
//        sandbox.add(fero);
//        sandbox.setBackgroundColor(Color.GREEN);
//        fero.turn(90);
//        fero.step(75);
//        fero.turn(-90);
		//fero.flagOfSouthKorea(100000000,150);

        System.out.println(frantisek.isPrime(2));

    }
}
