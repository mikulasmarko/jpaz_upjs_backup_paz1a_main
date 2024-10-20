package sk.upjs.paz;

import sk.upjs.jpaz2.Turtle;
import sk.upjs.jpaz2.WinPane;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class click2 extends WinPane {

    int pocetKliknuti = 1;

    // ulozime si suradnice prvej a poslednej bodky

    double suradnicaPrvehoVrcholaX;
    double suradnicaPrvehoVrcholaY;

    double suradnicaPoslednehoVrcholaX = getX();
    double suradnicaPoslednehoVrcholaY = getY();

    @Override
    protected void onMousePressed(int x, int y, MouseEvent detail) {

        if (detail.getButton() == MouseEvent.BUTTON1) {

            if (pocetKliknuti == 1) {
                Turtle filip = new Turtle();
                this.add(filip);
                filip.penDown();
                filip.setFillColor(Color.orange);
                filip.setPosition(x, y);
                suradnicaPrvehoVrcholaX = x;
                suradnicaPrvehoVrcholaY = y;
                suradnicaPoslednehoVrcholaX = x;
                suradnicaPoslednehoVrcholaY = y;
                filip.dot(10);
                filip.setDirection(90);
                filip.printCenter(Integer.toString(pocetKliknuti));
                pocetKliknuti++;
                this.remove(filip);
            } else {
                Turtle filip = new Turtle();
                this.add(filip);
                filip.setPosition(suradnicaPrvehoVrcholaX, suradnicaPrvehoVrcholaY);
                double vzdialenostOdPrveho = filip.distanceTo(x, y);
                filip.setPosition(suradnicaPoslednehoVrcholaX, suradnicaPoslednehoVrcholaY);
                filip.setDirectionTowards(x, y);
                double vzdialenostOdVrcholov = filip.distanceTo(x, y);


                if (vzdialenostOdPrveho > 10) {
                    filip.penUp();
                    filip.step(10);
                    filip.penDown();
                    filip.step(vzdialenostOdVrcholov - 20);
                    filip.penUp();
                    filip.step(10);
                    filip.dot(10);
                    filip.setDirection(90);
                    filip.printCenter(Integer.toString(pocetKliknuti));
                    pocetKliknuti++;
                    this.remove(filip);

                    suradnicaPoslednehoVrcholaX = x;
                    suradnicaPoslednehoVrcholaY = y;

                } else {
                    this.add(filip);
                    filip.setPosition(suradnicaPoslednehoVrcholaX, suradnicaPoslednehoVrcholaY);
                    filip.setDirectionTowards(suradnicaPrvehoVrcholaX, suradnicaPrvehoVrcholaY);
                    filip.penUp();
                    filip.step(10);
                    filip.penDown();
                    filip.step(filip.distanceTo(suradnicaPrvehoVrcholaX, suradnicaPrvehoVrcholaY) - 10);
                    filip.penUp();
                    filip.step(10);
                    pocetKliknuti = 1;
                    this.remove(filip);
                }


                // Uzavretie mnohouholníka


            }

        }
    }
}
