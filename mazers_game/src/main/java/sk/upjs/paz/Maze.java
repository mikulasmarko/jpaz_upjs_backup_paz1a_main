package sk.upjs.paz;

import sk.upjs.jpaz2.WinPane;

import java.util.Scanner;

public class Maze extends WinPane {

    private double width = 600;
    private double height = 800;

    public Maze() {
        Scene newScene = new Scene();
        newScene.generateScene();

    }
}
