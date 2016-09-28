/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bioinformatics1;

import java.util.Arrays;
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
        
        String strx = "AGGCTATCACCTGACCTCCAGGCCGATGCCC";//ATCGTAC";
        String stry = "TAGCTATCACGACCGCGGTCGATTTGCCCGAC";//ATGTTAT";
                
//        int[][] editDistanceGraph = utils.mkEditDistanceGraph(strx, stry, 20);
//        utils.print2D(editDistanceGraph);
//        Utils.DIRECTION[] backtrace = utils.mkBacktrace(editDistanceGraph);
//        System.out.println(Arrays.toString(backtrace));
//        System.out.println(Arrays.toString(utils.reverse(backtrace)));
//        System.out.println(utils.alignment(strx, stry, backtrace));

        int[][][] triad = utils.mkGridCube(strx, stry, 20);
        Pair<Utils.DIRECTION, Integer>[] dirs = utils.mkBacktrace(triad);
        System.out.println(Arrays.toString(dirs));
    }
    
}
