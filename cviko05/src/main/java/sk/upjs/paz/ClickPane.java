package sk.upjs.paz;

import sk.upjs.jpaz2.Turtle;
import sk.upjs.jpaz2.WinPane;

import java.awt.event.MouseEvent;

public class ClickPane extends WinPane {

    private int clickCounter = 1;
    private double prvyX = 0;
    private double prvyY = 0;
    private double lastX = 0;
    private double lastY = 0;

    @Override
    protected void onMousePressed(int x, int y, MouseEvent detail) {
        super.onMousePressed(x, y, detail);
        if (detail.getButton() == MouseEvent.BUTTON1) {//zistujem ktore tlacidlo bolo stlacene
            if (clickCounter == 1) { // ak kliknem prvykrat, vytvori len bodku
                Turtle fr = new Turtle();
                this.add(fr);
                fr.setPosition(x, y);
                prvyX = x; //zapamatam si poziciu prveho kliknutia
                prvyY = y;
                lastX = x;//zapamatam si poziciu kliknutia co bolo naposledy=prveho
                lastY = y;
                fr.dot(10);
                fr.setDirection(90);
                fr.printCenter(Integer.toString(clickCounter));
                clickCounter++;
                this.remove(fr);// dam fr prec aby zbytocne nezavadzal
            } else {//to znamena druhe a kazde dalsie kliknutie v ploche
                Turtle fr = new Turtle();
                this.add(fr);
                fr.setPosition(prvyX, prvyY);
                double vzdialenostNaStart = fr.distanceTo(x, y); // zistim si vzdielnost noveho kliknutia od vzdialenosti prveho bez pouzitia vzorca
                fr.setPosition(lastX, lastY); //nastavim sa na poziciu predchadzajuceho kliknutia
                if (vzdialenostNaStart < 10) { // ak bola nova pozicia v mensej vzdialenosti ako je polomer, vykreslim iba ciaru
                    fr.setDirectionTowards(prvyX, prvyY);
                    fr.penUp();
                    fr.step(10);
                    fr.penDown();
                    double vzdialenost = fr.distanceTo(prvyX, prvyY);//zabezpecuje aby som nenakreslil cez bodku ciaru
                    fr.step(vzdialenost - 10);
                    fr.penUp();
                    fr.step(10);
                    clickCounter = 1;//nastavenim counteru na 1 zabezpecim aby mohli bodky vznikat odznova
                    this.remove(fr);
                } else { // vytvorim ciaru medzi predoslou bodkou a novu bodku
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
                    fr.printCenter(Integer.toString(clickCounter));
                    clickCounter++;
                    this.remove(fr);
                    lastX = x;
                    lastY = y;//ulozim si udaje o novej predoslej bodke
                }
            }
        }
    }
}

