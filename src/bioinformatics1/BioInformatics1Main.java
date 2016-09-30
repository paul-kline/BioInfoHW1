/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bioinformatics1;

import static bioinformatics1.Utils.UPPER;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.util.Pair;

/**
 *
 * @author Paul
 */
public class BioInformatics1Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Utils utils = new Utils();
        File dir = new File("./src/bioinformatics1");
        try {
            File fin1 = new File(dir.getCanonicalPath() + File.separator + "gene1.fasta");
            File fin2 = new File(dir.getCanonicalPath() + File.separator + "gene2.fasta");
            String strx = Utils.getGeneFromFile(fin1);
            String stry = Utils.getGeneFromFile(fin2);
            boolean local = true;

            if (local) {
                LocalAlignment l = new LocalAlignment();
                int[][][] res = l.mk3DMatrix(strx.toCharArray(), stry.toCharArray());//, band);
                System.out.println("UPPER");
                Utils.print2D(res[2]);
                System.out.println("MIDDLE");
                Utils.print2D(res[1]);
                System.out.println("LOWER");
                Utils.print2D(res[0]);

                ArrayList<BacktraceStep> backtrace = l.backtrace(strx.toCharArray(), stry.toCharArray(), res);
                backtrace.stream().forEachOrdered(x -> System.out.print("" + x.getK() + x.getDir() + " "));
                System.out.println("");
                String alignment = l.mkAlignment(strx.toCharArray(), stry.toCharArray(), backtrace, 50);
                System.out.println("alignment: ");
                System.out.println(alignment);
            } else {
                int band = strx.length() / 4;
                GlobalAlignment gl = new GlobalAlignment();
                int[][][] res = gl.mk3DMatrix(strx.toCharArray(), stry.toCharArray(), band);
                System.out.println("UPPER");
                Utils.print2D(res[2]);
                System.out.println("MIDDLE");
                Utils.print2D(res[1]);
                System.out.println("LOWER");
                Utils.print2D(res[0]);

                ArrayList<BacktraceStep> backtrace = gl.backtrace(res);
                backtrace.stream().forEachOrdered(x -> System.out.print("" + x.getK() + x.getDir() + " "));
                System.out.println("");
                String alignment = gl.mkAlignment(strx.toCharArray(), stry.toCharArray(), backtrace, 50);
                System.out.println("alignment: ");
                System.out.println(alignment);
            }

        } catch (IOException ex) {
            Logger.getLogger(BioInformatics1Main.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Oops! There was a problem with the files you specified (see above). Please try again");

        }

    }

}
