package sk.upjs.paz;

import sk.upjs.jpaz2.Turtle;
import sk.upjs.jpaz2.WinPane;

public class GridPane extends WinPane {
    public void drawGrid() {
        double a = 50;
        double numy = (int) (this.getHeight() / a);
        double numx = (int) (this.getWidth() / a);
        double height = this.getHeight();
        double widht = this.getWidth();

        Turtle risiak = new Turtle();
        this.add(risiak);
        for (int i = 0; i <= numx; i++) {
            risiak.setPosition(0, i * a);
            risiak.moveTo(widht, a * i);

        }
        for (int i = 0; i <= numy; i++) {
            risiak.setPosition(a * i, 0);
            risiak.moveTo(a * i, height);
        }
    }
}
