package sk.upjs.paz;

import sk.upjs.jpaz2.Turtle;
import sk.upjs.jpaz2.WinPane;

public class Midtermpane extends WinPane {

    public Midtermpane(){
        Turtle[] korytnacky= new Turtle[12];
        for (int i = 0; i < 12; i++) {
            korytnacky[i]= new Turtle();
            this.add(korytnacky[i]);
            korytnacky[i].setPosition(this.getWidth()*Math.random(),this.getHeight()*Math.random()/2);
            korytnacky[i].setDirection((int)(Math.random()*4)*90);


        }



    }



}
