package sk.upjs.paz;

import sk.upjs.jpaz2.Turtle;
import sk.upjs.jpaz2.WinPane;

import java.awt.*;
import java.awt.event.MouseEvent;

public class ClickPane extends WinPane {

    Turtle kreslic;

    public ClickPane() {
        kreslic = new Turtle();
        this.add(kreslic);
    }


    int sum = 1;
    double xCoord;
    double yCoord;
    double poslednyX;
    double poslednyY;

    @Override
    protected void onMouseClicked(int x, int y, MouseEvent detail) {
        super.onMouseClicked(x, y, detail);

        if (detail.getButton() == MouseEvent.BUTTON1) {
            if (sum == 1) {
                this.add(kreslic);
                kreslic.setPosition(x, y);
                xCoord = kreslic.getX();
                yCoord = kreslic.getX();
                kreslic.dot(10);
                kreslic.setDirection(90);
                kreslic.printCenter(sum + "");
                sum++;
                poslednyX = x;
                poslednyY = y;
                this.remove(kreslic);
            } else {
                if ((detail.getButton() == MouseEvent.BUTTON1 && sum >= 2) && (Math.sqrt(Math.pow(detail.getX() - xCoord, 2) + Math.pow(detail.getY() - yCoord, 2)) > 10)) {
                    this.add(kreslic);
                    kreslic.setPosition(poslednyX, poslednyY);
                    kreslic.turnTowards(x, y);
                    kreslic.penUp();
                    kreslic.step(10);
                    kreslic.penDown();
                    kreslic.moveTo(x, y);
                    kreslic.dot(10);
                    kreslic.setDirection(90);
                    kreslic.printCenter(sum + "");
                    sum++;
                    poslednyY = y;
                    poslednyX = x;
                    this.remove(kreslic);
                } else {
                    this.add(kreslic);
                    kreslic.setPosition(poslednyX, poslednyY);
                    kreslic.turnTowards(xCoord, yCoord);
                    kreslic.penUp();
                    kreslic.step(10);
                    kreslic.penDown();
                    kreslic.moveTo(x, y);
                    sum = 1;
                    this.remove(kreslic);
                }
            }
        }


    }
}

