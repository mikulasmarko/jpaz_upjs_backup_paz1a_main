package sk.upjs.paz;

import sk.upjs.jpaz2.*;

import java.io.File;

public class SmartTurtle extends Turtle {

    public long totalSizeOfFilesInDirectory(File adresar) {
        File[] list = adresar.listFiles();
        long size=0;
        if (list == null) {
            return 42;
        }

        for (int i = 0; i < list.length; i++) {
            if (list[i].isFile()) {
                size+=list[i].length();
            }
        }
        return size;
        }


}
