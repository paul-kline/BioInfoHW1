/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bioinformatics1;

import java.awt.Point;
import java.util.ArrayList;


/**
 *
 * @author Paul
 */
public class LocalAlignment {

    public final static int L = 0;
    public final static int M = 1;
    public final static int U = 2;
    private Utils utils = new Utils();
    private int INFINITY = 100000;
    private int maxk;
    private Point p;

    public int[][][] mk3DMatrix(char[] xs, char[] ys) {
        int[][][] result = initialize3Dmatrix(xs, ys);
        Pair<Integer, Point> pair = fill3DMatrix(xs, ys, result);
        p = pair.getValue();
        maxk = pair.getKey();
        return result;
    }

    private int adjustband(char[] xs, char[] ys, int band) {

        band = xs.length + 1;
        return band;

    }

    private int[][][] initialize3Dmatrix(char[] xs, char[] ys) {
        int[][][] result = new int[3][ys.length + 1][xs.length + 1];

        //first of all, everyone gets a zero I guess.
        //this happens automatically. 
//        result[L][0][0] =0;
//        result[M][0][0] =0;
//        result[U][0][0] =0;
//        for (int i = 1; i < result[L].length; i++) {
//            //for the first column so j= 0 all the time.
//            result[L][i][0] = utils.OPEN_GAP + i * utils.EXTEND_GAP;
//            //in the upper matrix, I want this inaccessible as a final state because
//            //there is nowhere else to go. 
//            result[U][i][0] = -INFINITY;
//            //in the middle matrix along the side is the cost of opening a gap
//            //along the side only from the lower matrix though. 
////           result[M][i][0] = -INFINITY;          
//        }
//        for (int j = 1; j < result[L][0].length; j++) {
//            //for the first column so j= 0 all the time.
//            result[L][0][j] = -INFINITY;
//            //in the upper matrix, I want this inaccessible as a final state because
//            //there is nowhere else to go. 
//            result[U][0][j] = utils.OPEN_GAP + j * utils.EXTEND_GAP;
//            //in the middle matrix along the side is the cost of opening a gap
//            //along the side only from the lower matrix though. 
////           result[M][0][j] = -INFINITY;       
//        }
        return result;
    }

    public ArrayList<BacktraceStep> backtrace(char[] xs, char[] ys, int[][][] result) {
        ArrayList<BacktraceStep> backtrace = new ArrayList<>();
        //starting at the VERY END OF IT ALL 
        int i = result[0].length - 1;
        int j = result[0][0].length - 1;
        int k = -1; //ending level to start at. 
        //which level should we start at to backtrace?
        if (result[L][i][j] >= result[M][i][j] && result[L][i][j] >= result[U][i][j]) {
            k = L;
        }
        if (result[U][i][j] >= result[M][i][j] && result[U][i][j] >= result[L][i][j]) {
            k = U;
        }
        if (result[M][i][j] >= result[L][i][j] && result[M][i][j] >= result[U][i][j]) {
            k = M;
        }

        while (i > 0 && j > 0) {
            BacktraceStep step = new BacktraceStep();
            //backtrace
            if (k == L) {
                //in the lower matrix where could we have come from? 
                //1. could have jumped from middle i-1 OR
                //2. could have come from myself, me i-1
                if (result[L][i - 1][j] >= result[M][i - 1][j]) {
                    // my own matrix wins!! move on to
                    //k =k

                    i--;
                    step.setK(k);
                    step.setI(i);
                    step.setJ(j);
                    step.setDir(Utils.DIRECTION.NORTH);
                    backtrace.add(step);
                    continue;
                } else {// coming from middle was a better choice

                    k = M;
                    i--;
                    step.setK(k);
                    step.setI(i);
                    step.setJ(j);
                    step.setDir(Utils.DIRECTION.UP_NORTH);
                    backtrace.add(step);
                    continue;
                }
            }
            if (k == M) {
                //I could have come diagonally from myself, or from straight up
                //or straight down.
                if (result[M][i - 1][j - 1] >= result[U][i][j] && result[M][i - 1][j - 1] >= result[L][i][j]) {
                    //diag wins!!!
                    step.setK(k);
                    step.setDir(Utils.DIRECTION.DIAG);
                    step.setI(i);
                    step.setJ(j);
                    backtrace.add(step);
                    i--;
                    j--;

                    continue;
                }
                if (result[U][i][j] >= result[M][i - 1][j - 1] && result[U][i][j] >= result[L][i][j]) {
                    //we should come from UP!!
                    step.setK(k);
                    step.setI(i);
                    step.setJ(j);
                    step.setDir(Utils.DIRECTION.UP);
                    backtrace.add(step);
                    k = U;
                    continue;
                }
                if (result[L][i][j] >= result[M][i - 1][j - 1] && result[L][i][j] >= result[U][i][j]) {
                    //we should come from DOWN!!
                    step.setK(k);
                    step.setI(i);
                    step.setJ(j);
                    step.setDir(Utils.DIRECTION.DOWN);
                    backtrace.add(step);
                    k = L;
                    continue;
                }
            }
            if (k == U) {
                //I could have come from myself to the left. 
                //I could have come from  j-1 in middle.
                if (result[U][i][j - 1] >= result[M][i][j - 1]) {
                    // my own matrix wins!! move on to
                    //k =k

                    j--;
                    step.setK(k);
                    step.setI(i);
                    step.setJ(j);
                    step.setDir(Utils.DIRECTION.WEST);
                    backtrace.add(step);

                    continue;
                } else {// coming from middle was a better choice

                    j--;
                    step.setK(k);
                    step.setI(i);
                    step.setJ(j);
                    step.setDir(Utils.DIRECTION.DOWN_WEST);
                    backtrace.add(step);
                    k = M;
                    continue;
                }
            }
        }
        System.out.println("i: " + i + ", j: " + j);
        while (j > 0) {
            BacktraceStep x = new BacktraceStep(xs[j--], '-', 0);
            x.setDir(Utils.DIRECTION.WEST);
            backtrace.add(x);
        }
        while (i > 0) {
            BacktraceStep x = new BacktraceStep('-', ys[i--], 0);
            x.setDir(Utils.DIRECTION.UP);
            backtrace.add(x);
        }
        backtrace.stream().forEachOrdered(x -> System.out.println(x));
        return backtrace;

    }

    private Pair<Integer, Point> fill3DMatrix(char[] xs, char[] ys, int[][][] result) {

        int mymax = 0;
        int maxk = -1;
        Point p = new Point();
        for (int i = 1; i < result[0].length; i++) {

            for (int j = 1; j < result[0][0].length; j++) {
                result[L][i][j] = Integer.max(
                        result[M][i - 1][j] + Utils.EXTEND_GAP + Utils.OPEN_GAP,
                        result[L][i - 1][j] + Utils.EXTEND_GAP);
                result[U][i][j] = Integer.max(
                        result[U][i][j - 1] + Utils.EXTEND_GAP,
                        result[M][i][j - 1] + Utils.EXTEND_GAP + Utils.OPEN_GAP);
                if (result[L][i][j] > mymax) {
                    p.y = i;
                    p.x = j;
                    maxk = L;
                    mymax = result[L][i][j];
                }
                if (result[U][i][j] > mymax) {
                    p.y = i;
                    p.x = j;
                    maxk = U;
                    mymax = result[U][i][j];
                }
//                result[M][i][j] = Integer.max(Integer.max(Integer.max(
//                        0,
//                        result[M][i-1][j] + ),
//                        ),
//                        );
////                
                result[M][i][j] = Integer.max(Integer.max(Integer.max(
                        result[M][i - 1][j - 1] + Utils.score(xs[j - 1], ys[i - 1]),
                        result[U][i][j]),
                        result[L][i][j]),
                        0);
                if (result[M][i][j] > mymax) {
                    p.y = i;
                    p.x = j;
                    maxk = M;
                    mymax = result[M][i][j];
                }

            }

        }
        System.out.println("mymax: " + mymax + " at: " + p);
        return new Pair<>(maxk, p);
    }

    String mkAlignment(char[] xs, char[] ys, ArrayList<BacktraceStep> backtrace, int width) {
//        backtrace.remove(0);
        Utils.reverseList(backtrace);
//          backtrace.remove(0);
        backtrace.stream().parallel().forEach(st -> {
            st.setDir(Utils.reverse(st.getDir()));
        });
        System.out.println("");
        System.out.println("now here is the correct order:");
        backtrace.stream().forEachOrdered(st -> System.out.println(st));

        if (backtrace.size() > 1 && backtrace.get(0).getDir() == Utils.DIRECTION.DIAG && (backtrace.get(1).getDir() == Utils.DIRECTION.UP_EAST || backtrace.get(1).getDir() == Utils.DIRECTION.DOWN_SOUTH)) {
            backtrace.remove(0);
        }
        int i = 0;
        int j = 0;
        for (BacktraceStep st : backtrace) {
            if (st.getDir() == Utils.DIRECTION.DIAG) {
                try {
                    st.setX(xs[j++]);
                    st.setY(ys[i++]);
                    st.setScore(Utils.score(st.getX(), st.getY()));
                } catch (Exception e) {
                }
            }
            if (st.getDir() == Utils.DIRECTION.EAST) {
                st.setY('-');
                st.setX(xs[j++]);

            }
            if (st.getDir() == Utils.DIRECTION.UP_EAST) {
                st.setY('-');
                st.setX(xs[j++]);
            }
            if (st.getDir() == Utils.DIRECTION.DOWN_SOUTH) {
                System.out.println("down south");
                st.setX('-');
                st.setY(ys[i++]);
            }
            if (st.getDir() == Utils.DIRECTION.SOUTH) {
                st.setX('-');
                st.setY(ys[i++]);
            }
            if (st.getDir() == Utils.DIRECTION.DOWN
                    || st.getDir() == Utils.DIRECTION.UP) {
//              
                st = null;
//                st.setX(xs[j++]);//xs[st.getJ() -1]);
//                st.setY('-');//xs[st.getJ() -1]);
//                st.setY(ys[i++]);//ys[st.getI() -1]);
                // st.setScore(Utils.score(st.getX(), st.getY()));
            }
//            if(st.getK() == U){
//                st.setY('-');
//                st.setX(xs[st.getJ()-1]);
//            }
//            if(st.getK() == L){
//                st.setX('-');
//                st.setY(ys[st.getI()-1]);
//            }
//            if(st.getK() == M){
//                st.setX(xs[st.getJ() -1]);
//                st.setY(ys[st.getI() -1]);
//            }
//        
        };
        backtrace.stream().forEachOrdered(x -> System.out.println(x.getX() + " " + x.getY() + "\t"));
        System.out.println("i:" + i + " j: " + j);
        while (j < xs.length) {
            backtrace.add(new BacktraceStep(xs[j++], '-', -1));
        }
        while (i < ys.length) {
            backtrace.add(new BacktraceStep('-', ys[i++], -1));
        }
        return mkAlignmentHelper(backtrace, width);
    }

    public <T> ArrayList<ArrayList<T>> chunk(ArrayList<T> arr, int size) {
        int chunks = arr.size() / size + 1;

        ArrayList<ArrayList<T>> result = new ArrayList<>(chunks);
        for (int i = 0; i < chunks; i++) {
            result.add(new ArrayList<T>(size));

        }
        for (int i = 0; i < arr.size(); i++) {
            result.get(i / size).add(arr.get(i));
        }
        return result;
    }

    private String mkAlignmentHelper(ArrayList<BacktraceStep> backtrace_, int width) {
        ArrayList<ArrayList<BacktraceStep>> chunks = chunk(backtrace_, width);

        StringBuilder sb = new StringBuilder();
        for (ArrayList<BacktraceStep> backtrace : chunks) {
            for (BacktraceStep st : backtrace) {
                if (!Character.isUpperCase(st.getX()) && !Character.isUpperCase(st.getY())) {
                    System.out.println("continuing:" + st.getX() + " " + st.getY());
                    continue;
                }
                sb.append(st.getX());
                sb.append(' ');
            }
            sb.append('\n');

            for (BacktraceStep st : backtrace) {
                if (!Character.isUpperCase(st.getX()) && !Character.isUpperCase(st.getY())) {
                    continue;
                }
                if (st.getX() != '-' && st.getY() != '-') {
                    System.out.println(st.getX() + " and " + st.getY());
                    sb.append(st.getScore() > 0 ? "| " : "* ");
                } else {
                    sb.append("  ");
                }
            }
            sb.append('\n');
            for (BacktraceStep st : backtrace) {
                if (!Character.isUpperCase(st.getX()) && !Character.isUpperCase(st.getY())) {
                    continue;
                }
                sb.append(st.getY());
                sb.append(' ');
            }
            sb.append("\n\n");
        }

        return sb.toString();
    }

    private int maxcheck(int mymax, int v, Point p) {
        if (v > mymax) {
            return v;
        }
        return mymax;
    }
}
