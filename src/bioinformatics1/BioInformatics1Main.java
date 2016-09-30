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

/**
 *
 * @author Paul
 */
public class BioInformatics1Main {

    public static boolean logging = false;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        if (args.length < 3) {
            System.out.println("Arguments should be:\n"
                    + "-g\tfor global or\n"
                    + "-l\tfor local\n"
                    + "followed by:\n"
                    + "fastafile1\n"
                    + "fastafile2\n"
                    + "optionally you may pass\n"
                    + "'-w50'\tto specific output length to wrap at 50 (could be any integer. -w80, -w74, etc).\n"
                    + "(defaulted to 50)");
            return;
        }
        boolean local = true;
        boolean alignmentset = false;
        int width = 50;
        String file1 = "";
        String file2 = "";
        for (String arg : args) {
            if (arg.startsWith("-w")) {
                try {
                    width = Integer.parseInt(arg.replaceFirst("-w", ""));
                    continue;
                } catch (NumberFormatException numberFormatException) {
                    System.out.println("Failed to parse -w arg as an int");
                    return;
                }
            }
            if (arg.equalsIgnoreCase("-logging")) {
                logging = true;
                continue;
            }
            if (arg.equalsIgnoreCase("-g")) {
                local = false;
                alignmentset = true;
                continue;
            }
            if (arg.equalsIgnoreCase("-l")) {
                local = true;
                alignmentset = true;
                continue;
            }
            //must be file names. 
            if (file1.length() == 0) {
                file1 = arg;
            } else {
                file2 = arg;
            }
        }
        if (file1.length() == 0 || file2.length() == 0) {
            System.out.println("Improper file names:\n"
                    + "file1: " + file1 + "\n"
                    + "file2: " + file2);
            return;
        }
        Utils utils = new Utils();
        //File dir = new File("./src/bioinformatics1");
        String strx = "";
        String stry = "";

        try {
            File fin1 = new File(file1);//dir.getCanonicalPath() + File.separator + "gene1.fasta");
            File fin2 = new File(file2);//dir.getCanonicalPath() + File.separator + "gene2.fasta");
            strx = Utils.getGeneFromFile(fin1);
            stry = Utils.getGeneFromFile(fin2);
        } catch (Exception e) {
            System.out.println("Error reading files: ");
            e.printStackTrace();
            return;
        }

        if (local) {
            LocalAlignment l = new LocalAlignment();
            int[][][] res = l.mk3DMatrix(strx.toCharArray(), stry.toCharArray());//, band);
            if (logging) {
                System.out.println("UPPER");
                Utils.print2D(res[2]);
                System.out.println("MIDDLE");
                Utils.print2D(res[1]);
                System.out.println("LOWER");
                Utils.print2D(res[0]);

            }
//                
            ArrayList<BacktraceStep> backtrace = l.backtrace(strx.toCharArray(), stry.toCharArray(), res);
            if (logging) {
                backtrace.stream().forEachOrdered(x -> System.out.print("" + x.getK() + x.getDir() + " "));
                System.out.println("");
            }

            String alignment = l.mkAlignment(strx.toCharArray(), stry.toCharArray(), backtrace, width);

            System.out.println("alignment: ");
            System.out.println(alignment);
        } else {
            int band = strx.length() / 4;
            GlobalAlignment gl = new GlobalAlignment();
            int[][][] res = gl.mk3DMatrix(strx.toCharArray(), stry.toCharArray(), band);
            if (logging) {
                System.out.println("UPPER");
                Utils.print2D(res[2]);
                System.out.println("MIDDLE");
                Utils.print2D(res[1]);
                System.out.println("LOWER");
                Utils.print2D(res[0]);
            }

            ArrayList<BacktraceStep> backtrace = gl.backtrace(res);
            if (logging) {
                backtrace.stream().forEachOrdered(x -> System.out.print("" + x.getK() + x.getDir() + " "));
                System.out.println("");
            }
            String alignment = gl.mkAlignment(strx.toCharArray(), stry.toCharArray(), backtrace, width);
            System.out.println("alignment: ");
            System.out.println(alignment);
        }

    }

}
