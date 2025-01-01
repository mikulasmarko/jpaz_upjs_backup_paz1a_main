package sk.upjs.paz;

public class Scene extends Maze {

    /**
     * prve policko je sirka, druhe policko je vyska
     * ak je mazeborder true, tak je tam stena
     */


    mazeBorders =;

    private final int width = 600;
    private final int height = 800;
    private final Boolean[][] mazeBorders = new Boolean[width][height];

    public void generateScene() {
        this.generatePane();
        this.generateBorders(60);
    }

    public void generatePane() {
        this.setHeight(height);
        this.setWidth(width);
    }

    private int x = 0;

    public void generateBorders(int seed) {
        int randomY = (int) (Math.random() * width);
        /**
         * tu pisem random veci lebo proste mozem aby bolo ze robim nieco uzitocen
         * teraz
         */


        for (int i = x; i < width; i++) {
            for (int j = 0; j < height; j++) {
                int trueOrFalse = (int) (Math.random() * 2);
                mazeBorders[i][j] = trueOrFalse == 0;
            }
        }
        mazeBorders[0][randomY] = true;

    }

    public void checkBorders() {

        for (int i = 0; i <= width; i++) {
            for (int j = 0; j <= height; j++) {
                if (mazeBorders[i][j]) {
                    int pocitadlo = 0;
                    if (i == 0) {
                        if (j == 0) {
                            pocitadlo+=checkDOWN(i,j)+checkLEFT(i,j);
                        }
                        if (j == 800) {
                            pocitadlo+=checkUP(i,j)+checkLEFT(i,j);
                        }
                    } else {
                        if (i == 600) {
                            if (j == 0) {
                                pocitadlo+=checkDOWN(i,j)+checkRIGHT(i,j);
                            }
                            if (j == 800) {
                                pocitadlo+=checkUP(i,j)+checkRIGHT(i,j);
                            }

                        } else {
                            pocitadlo=checkUP(i,j)+checkRIGHT(i,j)+checkDOWN(i,j)+checkLEFT(i,j);


                        }

                    }
                }
                if(pocitadlo)

            }


        }
    }

    public int checkUP(int a, int b) {
        if (mazeBorders[a + 1][b]) {
            return 1;
        }
        return 0;
    }

    public int checkDOWN(int a, int b) {
        if (mazeBorders[a - 1][b]) {
            return 1;
        }
        return 0;
    }

    public int checkRIGHT(int a, int b) {
        if (mazeBorders[a][b + 1]) {
            return 1;
        }
        return 0;
    }

    public int checkLEFT(int a, int b) {
        if (mazeBorders[a][b - 1]) {
            return 1;
        }
        return 0;
    }


    public void drawBorders() {

    }

}
