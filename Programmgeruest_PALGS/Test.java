public class Test {

    /*************************************************************/
    /* WICHTIG: Das bestehen dieser Tests sagt nahezu gar nichts */
    /* ueber das korrekte Funktionieren ihres Programms */
    /* aus. Es dient einzig und allein als Rahmen zur */
    /* leichteren Implementierung eigener Tests! */

    /*
     * Nach Durchfuehrung der Tests startet der Crawler mit GUI. Mit ihm koennen
     * neue LinkMatrizen erstellt werden.
     */
    /*************************************************************/
    public static void main(String[] args) throws Exception {

        System.out
                .println("WICHTIG: Das bestehen dieser Tests sagt nahezu gar nichts "
                        + "ueber das korrekte Funktionieren ihres Programms aus.\n"
                        + "Es dient einzig und allein als Rahmen zurleichteren Implementierung eigener Tests!");

        boolean test_gauss = true;
        boolean test_pagerank = true;
        boolean test_crawler = true;

        double b[] = { 1, 1 };
        double C[][] = { { 1, 0 }, { 0, 1 } };
        double A[][] = { { 1, 1 }, { 1, 1 } };
        double xC[] = { 1, 1 };
        double xA[] = { 1, -1 };
        double x[];

        /******************************/
        /* Test der Klasse Gauss */
        /******************************/
        if (test_gauss) {
            System.out.println("-----------------------------------------");
            System.out
                    .println("primitiver und unvollstaendiger Test der Klasse Gauss");

            System.out
                    .println("  primitiver und unvollstaendiger Test der Methode backSubst");
            x = Gauss.backSubst(C, b);
            if (Util.vectorCompare(x, xC)) {
                System.out.println("    Richtiges Ergebnis");
            } else {
                System.out.println("    FEHLER: falsches Ergebnis:");
                Util.printVector(x);
                System.out.println("            richtiges Ergebnis:");
                Util.printVector(xC);
            }

            System.out
                    .println("  eigener Test der Methode backSubst");
            double matrix[][] = {{ 4, 2, 3}, {0, 1, -0.5}, {0, 0, 1}};
            double v[] = {5, -5.5, 3};
            double[] res = {1, -4, 3};
            x = Gauss.backSubst(matrix, v);
            if (Util.vectorCompare(x, res)) {
                System.out.println("    Richtiges Ergebnis");
            } else {
                System.out.println("    FEHLER: falsches Ergebnis:");
                Util.printVector(x);
                System.out.println("            richtiges Ergebnis:");
                Util.printVector(res);
            }

            // System.out
            //         .println("  eigener Test der Methode backSubst mit eventueller Nulldivision");
            // double[][] matrixWithZero = {{ 2, -1, 3, 2}, {0, -6, 2, 4}, {0, 0, 0, -5}, {0, 0, 1, 8}};
            // double vForZeroTest[] = {-5, -10, 13, -24};
            // double[] resWithZero = {(double)13/(double)6, (double)-17/(double)15, (double)-16/(double)5, (double)-13/(double)5};
            // x = Gauss.backSubst(matrixWithZero, vForZeroTest);
            // if (Util.vectorCompare(x, resWithZero)) {
            //     System.out.println("    Richtiges Ergebnis");
            // } else {
            //     System.out.println("    FEHLER: falsches Ergebnis:");
            //     Util.printVector(x);
            //     System.out.println("            richtiges Ergebnis:");
            //     Util.printVector(resWithZero);
            // }

            System.out
                    .println("  primitiver und unvollstaendiger Test der Methode solve");
            x = Gauss.solve(C, b);
            if (Util.vectorCompare(x, xC)) {
                System.out.println("    Richtiges Ergebnis");
            } else {
                System.out.println("    FEHLER: falsches Ergebnis:");
                Util.printVector(x);
                System.out.println("            richtiges Ergebnis:");
                Util.printVector(xC);
            }

            System.out
                    .println("  eigener Test der Methode solve");
            double[][] cForSolve = {{ 1, 4, 8, 3}, {0, 2, 2, 4}, {0, -3, -7, 2}, {0, 1, 5, 2} };
            double[] bForSolve = {7, 0, 1, 2};
            double[] resultForSolve = {6.875, -1.25, 0.5, 0.375};
            x = Gauss.solve(cForSolve, bForSolve);
            if (Util.vectorCompare(x, resultForSolve)) {
                System.out.println("    Richtiges Ergebnis");
            } else {
                System.out.println("    FEHLER: falsches Ergebnis:");
                Util.printVector(x);
                System.out.println("            richtiges Ergebnis:");
                Util.printVector(resultForSolve);
            }

            System.out
                    .println("  primitiver und unvollstaendiger Test der Methode solveSing");
            x = Gauss.solveSing(A);
            double lambda = xA[0] / x[0];
            for (int i = 0; i < x.length; i++) {
                x[i] *= lambda;
            }
            if (Util.vectorCompare(x, xA)) {
                System.out.println("    Richtiges Ergebnis");
            } else {
                System.out.println("    FEHLER: falsches Ergebnis:");
                Util.printVector(x);
                System.out.println("            richtiges Ergebnis:");
                Util.printVector(xA);
            }
        }

        /******************************/
        /* Test der Klasse PageRank */
        /******************************/
        if (test_pagerank) {
            System.out.println("-----------------------------------------");
            System.out
                    .println("primitiver und unvollstaendiger Test der Klasse PageRank");

            LinkMatrix lm = new LinkMatrix();
            /*
             * Es koennte sein, dass in Eclipse die Datei nicht gefunden wird.
             * Sie muessen entweder den gesamten absoluten Pfad angeben oder die
             * Umgebung entsprechend einrichten.
             */
            lm.read("irgendwo.txt");

            System.out
                    .println("  primitiver und unvollstaendiger Test der Methode buildMatrix");

            A = PageRank.buildProbabilityMatrix(lm.L, 0.15);
            double A0[][] = { { 0.5, 0.5 }, { 0.5, 0.5 } };
            if (Util.matrixCompare(A, A0)) {
                System.out.println("    Richtiges Ergebnis");
            } else {
                System.out.println("    FEHLER: falsches Ergebnis:");
                Util.printMatrix(A);
                System.out.println("            richtiges Ergebnis:");
                Util.printMatrix(A0);
            }

            System.out
                    .println("  primitiver und unvollstaendiger Test der Methode rank");
            String r[] = PageRank.getSortedURLs(lm.urls, lm.L, 0.15);

            String r0[] = { "http://www.irgendwo.de", "http://www.nirgendwo.de" };
            String r1[] = { "http://www.nirgendwo.de", "http://www.irgendwo.de" };
            if (Util.rankingCompare(r, r0)) {
                System.out.println("    Richtiges Ergebnis");
            } else if (Util.rankingCompare(r, r1)) {
                System.out.println("    Richtiges Ergebnis");
            } else {
                System.out.println("    FEHLER: falsches Ergebnis:");
                Util.printStringArray(r);
                System.out.println("            richtiges Ergebnis:");
                Util.printStringArray(r0);
            }
        }

        if (test_crawler) {
            (new GUI()).setVisible(true);
        }
    }
}
