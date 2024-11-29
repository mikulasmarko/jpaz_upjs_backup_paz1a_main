package sk.upjs.paz;

import java.awt.event.MouseEvent;

public class PlochaTvarov extends ZoznamTvarov {

    private ZoznamTvarov tvary;

    private double dragX;
    private double dragY;
    private boolean tahanie = false;

    public PlochaTvarov() {
        this.tvary = new ZoznamTvarov();
    }

    public void pridajTvar(){
        Tvar[] tvaryNew=new Tvar[this.tvary.lenght() +1];
    }

}
