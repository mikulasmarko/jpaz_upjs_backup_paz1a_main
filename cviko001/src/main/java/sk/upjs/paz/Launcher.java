package sk.upjs.paz;

import sk.upjs.jpaz2.*;

import java.awt.*;

public class Launcher {

    public static void main(String[] args) {
        // create new "sandbox" - a place where turtles can live
        AnimatedWinPane sandbox = new AnimatedWinPane();

        // create new turtle and add it to the "sandbox"
        SmartTurtle franklin = new SmartTurtle();
        sandbox.add(franklin);
        Turtle cecil = new Turtle();
        sandbox.add(cecil);
        SmartTurtle albert = new SmartTurtle();
        sandbox.add(albert);
        HomeTurtle fero = new HomeTurtle();
        sandbox.add(fero);

        // create new object inspector
        ObjectInspector oi = new ObjectInspector();
        // ask the inspector to inspect "franklin" and "sandbox"
        oi.inspect(franklin);
        oi.inspect(sandbox);
        oi.inspect(cecil);
        oi.inspect(albert);

        //franklin.moveTo(150,100);
        //franklin.setPenColor(Color.BLUE);
        //cecil.setPosition(200,100);
        //cecil.setPenColor(Color.red);

        //franklin.house(25);
        sandbox.setBackgroundColor(Color.GREEN);
        fero.setMoveTurnSpeed(0);
        fero.flagOfSouthKorea(1000000, 10);


    }
}