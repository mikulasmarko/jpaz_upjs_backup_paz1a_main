package sk.upjs.paz;

import sk.upjs.jpaz2.Turtle;
import sk.upjs.jpaz2.WinPane;

import java.awt.event.MouseEvent;

public class ClickPane extends WinPane {

    int sum = 1;
    double xCoord;
    double yCoord;
    double poslednyX;
    double poslednyY;

    @Override
    protected void onMousePressed(int x, int y, MouseEvent detail) {
        super.onMouseClicked(x, y, detail);

        if (detail.getButton() == MouseEvent.BUTTON1) {
            if (sum == 1) {
                Turtle fr = new Turtle();
                this.add(fr);
                fr.setPosition(x, y);
                xCoord = x;
                yCoord = y;
                poslednyX = x;
                poslednyY = y;
                fr.dot(10);
                fr.setDirection(90);
                fr.printCenter(Integer.toString(sum));
                sum++;
                this.remove(fr);
            } else {
                Turtle fr = new Turtle();
                this.add(fr);
                fr.setPosition(xCoord, yCoord);
                double vzdialenostOdPrveho = fr.distanceTo(x, y);
                fr.setPosition(poslednyX, poslednyY);
                if (vzdialenostOdPrveho < 10) {
                    fr.setDirectionTowards(xCoord, yCoord);
                    fr.penUp();
                    fr.step(10);
                    fr.penDown();
                    double vzdielenostOdDalsejBodky = fr.distanceTo(xCoord, yCoord);
                    fr.step(vzdielenostOdDalsejBodky - 10);
                    fr.penUp();
                    fr.step(10);
                    sum = 1;
                    this.remove(fr);

                } else {
                    fr.setDirectionTowards(x, y);
                    fr.penUp();
                    fr.step(10);
                    fr.penDown();
                    double vzdialenost = fr.distanceTo(x, y);
                    fr.step(vzdialenost - 10);//zabezpecuje aby som nenakreslil cez bodku ciaru
                    fr.penUp();
                    fr.step(10);
                    fr.dot(10);
                    fr.setDirection(90);
                    fr.printCenter(Integer.toString(sum));
                    sum++;
                    poslednyX = x;
                    poslednyY = y;
                    this.remove(fr);
                }


            }


        }
    }
}

