package sk.upjs.paz;

import sk.upjs.jpaz2.Turtle;

import java.awt.*;

public class Midtermarka extends Turtle {

    public void pumpkinsExhibition(int lines, int columns) {
        this.penUp();
        double riadky = lines;
        double stlpce = columns;


        double startX = this.getX();
        double startY = this.getY();
        double startDir = this.getDirection();

        this.step(riadky*6-6);
        this.turn(90);
        this.step(-stlpce / 2 * 12);
        this.step(12 / 2);

        for (int i = 0; i < riadky; i++) {

            for (int j = 0; j < stlpce; j++) {
                if (i == 0 || i == riadky - 1) {
                    this.setFillColor(Color.orange);
                    this.dot(5);
                    this.step(12);
                } else {
                    if ((i == 1 && (j == 1 || j == stlpce - 2) || ((i == riadky - 2)&&(j>0 && j<stlpce-1)))) {
                        this.setFillColor(Color.black);
                        this.dot(4);
                        this.step(12);
                    } else{
                        this.setFillColor(Color.orange);
                        this.dot(5);
                        this.step(12);
                    }

                }


            }
            this.step(-stlpce * 12);
            this.turn(90);
            this.step(12);
            this.turn(-90);
        }
        this.setPosition(startX, startY);
        this.setDirection(startDir);

    }


}
