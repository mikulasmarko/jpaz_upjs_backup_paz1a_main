package sk.upjs.paz;

import sk.upjs.jpaz2.Turtle;
import sk.upjs.jpaz2.WinPane;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.time.Year;


public class ClickPane extends WinPane {


    private int clickCounter = 1;
    private double prvyX = 0;
    private double prvyY = 0;

    private double lastX = 0;
    private double lastY = 0;


    @Override
    protected void onMousePressed(int x, int y, MouseEvent detail) {
        super.onMousePressed(x, y, detail);

        if (detail.getButton() == MouseEvent.BUTTON1) {

            if (clickCounter == 1) {
                Turtle fr = new Turtle();
                this.add(fr);
                fr.setPosition(x, y);
                prvyX = x;
                prvyY = y;
                lastX = x;
                lastY = y;
                fr.dot(10);
                fr.setDirection(90);
                fr.printCenter(Integer.toString(clickCounter));
                clickCounter++;
                this.remove(fr);
            } else {
                Turtle fr = new Turtle();
                this.add(fr);
                fr.setPosition(lastX, lastY);
                fr.setDirectionTowards(x, y);
                double vzdialenost = fr.distanceTo(x, y);

                if () {
                    fr.penUp();
                    fr.step(10);
                    fr.penDown();
                    fr.step(vzdialenost - 20);
                    fr.penUp();
                    fr.step(10);
                    fr.dot(10);
                    fr.setDirection(90);
                    fr.printCenter(Integer.toString(clickCounter));
                    clickCounter++;
                    this.remove(fr);
                    lastX = x;
                    lastY = y;
                }

            }
        }
    }
}

