/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bioinformatics1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import javafx.util.Pair;

/**
 *
 * @author Paul
 */
public class Utils {

    public Utils() {
        initBlosum();
    }
    public static HashMap<Character, HashMap<Character, Integer>> blosum62;

    private void initBlosum() {
        blosum62 = new HashMap<>();
        HashMap<Character, Integer> a = new HashMap<>();
        a.put('A', 4);
        a.put('R', -1);
        a.put('N', -2);
        a.put('D', -2);
        a.put('C', 0);
        a.put('Q', -1);
        a.put('E', -1);
        a.put('G', 0);
        a.put('H', -2);
        a.put('I', -1);
        a.put('L', -1);
        a.put('K', -1);
        a.put('M', -1);
        a.put('F', -2);
        a.put('P', -1);
        a.put('S', 1);
        a.put('T', 0);
        a.put('W', -3);
        a.put('Y', -2);
        a.put('V', 0);
        a.put('B', -2);
        a.put('Z', -1);
        a.put('X', 0);
        a.put('*', -4);
        blosum62.put('A', a);
        HashMap<Character, Integer> r = new HashMap<>();
        r.put('A', -1);
        r.put('R', 5);
        r.put('N', 0);
        r.put('D', -2);
        r.put('C', -3);
        r.put('Q', 1);
        r.put('E', 0);
        r.put('G', -2);
        r.put('H', 0);
        r.put('I', -3);
        r.put('L', -2);
        r.put('K', 2);
        r.put('M', -1);
        r.put('F', -3);
        r.put('P', -2);
        r.put('S', -1);
        r.put('T', -1);
        r.put('W', -3);
        r.put('Y', -2);
        r.put('V', -3);
        r.put('B', -1);
        r.put('Z', 0);
        r.put('X', -1);
        r.put('*', -4);
        blosum62.put('R', r);
        HashMap<Character, Integer> n = new HashMap<>();
        n.put('A', -2);
        n.put('R', 0);
        n.put('N', 6);
        n.put('D', 1);
        n.put('C', -3);
        n.put('Q', 0);
        n.put('E', 0);
        n.put('G', 0);
        n.put('H', 1);
        n.put('I', -3);
        n.put('L', -3);
        n.put('K', 0);
        n.put('M', -2);
        n.put('F', -3);
        n.put('P', -2);
        n.put('S', 1);
        n.put('T', 0);
        n.put('W', -4);
        n.put('Y', -2);
        n.put('V', -3);
        n.put('B', 3);
        n.put('Z', 0);
        n.put('X', -1);
        n.put('*', -4);
        blosum62.put('N', n);
        HashMap<Character, Integer> d = new HashMap<>();
        d.put('A', -2);
        d.put('R', -2);
        d.put('N', 1);
        d.put('D', 6);
        d.put('C', -3);
        d.put('Q', 0);
        d.put('E', 2);
        d.put('G', -1);
        d.put('H', -1);
        d.put('I', -3);
        d.put('L', -4);
        d.put('K', -1);
        d.put('M', -3);
        d.put('F', -3);
        d.put('P', -1);
        d.put('S', 0);
        d.put('T', -1);
        d.put('W', -4);
        d.put('Y', -3);
        d.put('V', -3);
        d.put('B', 4);
        d.put('Z', 1);
        d.put('X', -1);
        d.put('*', -4);
        blosum62.put('D', d);
        HashMap<Character, Integer> c = new HashMap<>();
        c.put('A', 0);
        c.put('R', -3);
        c.put('N', -3);
        c.put('D', -3);
        c.put('C', 9);
        c.put('Q', -3);
        c.put('E', -4);
        c.put('G', -3);
        c.put('H', -3);
        c.put('I', -1);
        c.put('L', -1);
        c.put('K', -3);
        c.put('M', -1);
        c.put('F', -2);
        c.put('P', -3);
        c.put('S', -1);
        c.put('T', -1);
        c.put('W', -2);
        c.put('Y', -2);
        c.put('V', -1);
        c.put('B', -3);
        c.put('Z', -3);
        c.put('X', -2);
        c.put('*', -4);
        blosum62.put('C', c);
        HashMap<Character, Integer> q = new HashMap<>();
        q.put('A', -1);
        q.put('R', 1);
        q.put('N', 0);
        q.put('D', 0);
        q.put('C', -3);
        q.put('Q', 5);
        q.put('E', 2);
        q.put('G', -2);
        q.put('H', 0);
        q.put('I', -3);
        q.put('L', -2);
        q.put('K', 1);
        q.put('M', 0);
        q.put('F', -3);
        q.put('P', -1);
        q.put('S', 0);
        q.put('T', -1);
        q.put('W', -2);
        q.put('Y', -1);
        q.put('V', -2);
        q.put('B', 0);
        q.put('Z', 3);
        q.put('X', -1);
        q.put('*', -4);
        blosum62.put('Q', q);
        HashMap<Character, Integer> e = new HashMap<>();
        e.put('A', -1);
        e.put('R', 0);
        e.put('N', 0);
        e.put('D', 2);
        e.put('C', -4);
        e.put('Q', 2);
        e.put('E', 5);
        e.put('G', -2);
        e.put('H', 0);
        e.put('I', -3);
        e.put('L', -3);
        e.put('K', 1);
        e.put('M', -2);
        e.put('F', -3);
        e.put('P', -1);
        e.put('S', 0);
        e.put('T', -1);
        e.put('W', -3);
        e.put('Y', -2);
        e.put('V', -2);
        e.put('B', 1);
        e.put('Z', 4);
        e.put('X', -1);
        e.put('*', -4);
        blosum62.put('E', e);
        HashMap<Character, Integer> g = new HashMap<>();
        g.put('A', 0);
        g.put('R', -2);
        g.put('N', 0);
        g.put('D', -1);
        g.put('C', -3);
        g.put('Q', -2);
        g.put('E', -2);
        g.put('G', 6);
        g.put('H', -2);
        g.put('I', -4);
        g.put('L', -4);
        g.put('K', -2);
        g.put('M', -3);
        g.put('F', -3);
        g.put('P', -2);
        g.put('S', 0);
        g.put('T', -2);
        g.put('W', -2);
        g.put('Y', -3);
        g.put('V', -3);
        g.put('B', -1);
        g.put('Z', -2);
        g.put('X', -1);
        g.put('*', -4);
        blosum62.put('G', g);
        HashMap<Character, Integer> h = new HashMap<>();
        h.put('A', -2);
        h.put('R', 0);
        h.put('N', 1);
        h.put('D', -1);
        h.put('C', -3);
        h.put('Q', 0);
        h.put('E', 0);
        h.put('G', -2);
        h.put('H', 8);
        h.put('I', -3);
        h.put('L', -3);
        h.put('K', -1);
        h.put('M', -2);
        h.put('F', -1);
        h.put('P', -2);
        h.put('S', -1);
        h.put('T', -2);
        h.put('W', -2);
        h.put('Y', 2);
        h.put('V', -3);
        h.put('B', 0);
        h.put('Z', 0);
        h.put('X', -1);
        h.put('*', -4);
        blosum62.put('H', h);
        HashMap<Character, Integer> i = new HashMap<>();
        i.put('A', -1);
        i.put('R', -3);
        i.put('N', -3);
        i.put('D', -3);
        i.put('C', -1);
        i.put('Q', -3);
        i.put('E', -3);
        i.put('G', -4);
        i.put('H', -3);
        i.put('I', 4);
        i.put('L', 2);
        i.put('K', -3);
        i.put('M', 1);
        i.put('F', 0);
        i.put('P', -3);
        i.put('S', -2);
        i.put('T', -1);
        i.put('W', -3);
        i.put('Y', -1);
        i.put('V', 3);
        i.put('B', -3);
        i.put('Z', -3);
        i.put('X', -1);
        i.put('*', -4);
        blosum62.put('I', i);
        HashMap<Character, Integer> l = new HashMap<>();
        l.put('A', -1);
        l.put('R', -2);
        l.put('N', -3);
        l.put('D', -4);
        l.put('C', -1);
        l.put('Q', -2);
        l.put('E', -3);
        l.put('G', -4);
        l.put('H', -3);
        l.put('I', 2);
        l.put('L', 4);
        l.put('K', -2);
        l.put('M', 2);
        l.put('F', 0);
        l.put('P', -3);
        l.put('S', -2);
        l.put('T', -1);
        l.put('W', -2);
        l.put('Y', -1);
        l.put('V', 1);
        l.put('B', -4);
        l.put('Z', -3);
        l.put('X', -1);
        l.put('*', -4);
        blosum62.put('L', l);
        HashMap<Character, Integer> k = new HashMap<>();
        k.put('A', -1);
        k.put('R', 2);
        k.put('N', 0);
        k.put('D', -1);
        k.put('C', -3);
        k.put('Q', 1);
        k.put('E', 1);
        k.put('G', -2);
        k.put('H', -1);
        k.put('I', -3);
        k.put('L', -2);
        k.put('K', 5);
        k.put('M', -1);
        k.put('F', -3);
        k.put('P', -1);
        k.put('S', 0);
        k.put('T', -1);
        k.put('W', -3);
        k.put('Y', -2);
        k.put('V', -2);
        k.put('B', 0);
        k.put('Z', 1);
        k.put('X', -1);
        k.put('*', -4);
        blosum62.put('K', k);
        HashMap<Character, Integer> m = new HashMap<>();
        m.put('A', -1);
        m.put('R', -1);
        m.put('N', -2);
        m.put('D', -3);
        m.put('C', -1);
        m.put('Q', 0);
        m.put('E', -2);
        m.put('G', -3);
        m.put('H', -2);
        m.put('I', 1);
        m.put('L', 2);
        m.put('K', -1);
        m.put('M', 5);
        m.put('F', 0);
        m.put('P', -2);
        m.put('S', -1);
        m.put('T', -1);
        m.put('W', -1);
        m.put('Y', -1);
        m.put('V', 1);
        m.put('B', -3);
        m.put('Z', -1);
        m.put('X', -1);
        m.put('*', -4);
        blosum62.put('M', m);
        HashMap<Character, Integer> f = new HashMap<>();
        f.put('A', -2);
        f.put('R', -3);
        f.put('N', -3);
        f.put('D', -3);
        f.put('C', -2);
        f.put('Q', -3);
        f.put('E', -3);
        f.put('G', -3);
        f.put('H', -1);
        f.put('I', 0);
        f.put('L', 0);
        f.put('K', -3);
        f.put('M', 0);
        f.put('F', 6);
        f.put('P', -4);
        f.put('S', -2);
        f.put('T', -2);
        f.put('W', 1);
        f.put('Y', 3);
        f.put('V', -1);
        f.put('B', -3);
        f.put('Z', -3);
        f.put('X', -1);
        f.put('*', -4);
        blosum62.put('F', f);
        HashMap<Character, Integer> p = new HashMap<>();
        p.put('A', -1);
        p.put('R', -2);
        p.put('N', -2);
        p.put('D', -1);
        p.put('C', -3);
        p.put('Q', -1);
        p.put('E', -1);
        p.put('G', -2);
        p.put('H', -2);
        p.put('I', -3);
        p.put('L', -3);
        p.put('K', -1);
        p.put('M', -2);
        p.put('F', -4);
        p.put('P', 7);
        p.put('S', -1);
        p.put('T', -1);
        p.put('W', -4);
        p.put('Y', -3);
        p.put('V', -2);
        p.put('B', -2);
        p.put('Z', -1);
        p.put('X', -2);
        p.put('*', -4);
        blosum62.put('P', p);
        HashMap<Character, Integer> s = new HashMap<>();
        s.put('A', 1);
        s.put('R', -1);
        s.put('N', 1);
        s.put('D', 0);
        s.put('C', -1);
        s.put('Q', 0);
        s.put('E', 0);
        s.put('G', 0);
        s.put('H', -1);
        s.put('I', -2);
        s.put('L', -2);
        s.put('K', 0);
        s.put('M', -1);
        s.put('F', -2);
        s.put('P', -1);
        s.put('S', 4);
        s.put('T', 1);
        s.put('W', -3);
        s.put('Y', -2);
        s.put('V', -2);
        s.put('B', 0);
        s.put('Z', 0);
        s.put('X', 0);
        s.put('*', -4);
        blosum62.put('S', s);
        HashMap<Character, Integer> t = new HashMap<>();
        t.put('A', 0);
        t.put('R', -1);
        t.put('N', 0);
        t.put('D', -1);
        t.put('C', -1);
        t.put('Q', -1);
        t.put('E', -1);
        t.put('G', -2);
        t.put('H', -2);
        t.put('I', -1);
        t.put('L', -1);
        t.put('K', -1);
        t.put('M', -1);
        t.put('F', -2);
        t.put('P', -1);
        t.put('S', 1);
        t.put('T', 5);
        t.put('W', -2);
        t.put('Y', -2);
        t.put('V', 0);
        t.put('B', -1);
        t.put('Z', -1);
        t.put('X', 0);
        t.put('*', -4);
        blosum62.put('T', t);
        HashMap<Character, Integer> w = new HashMap<>();
        w.put('A', -3);
        w.put('R', -3);
        w.put('N', -4);
        w.put('D', -4);
        w.put('C', -2);
        w.put('Q', -2);
        w.put('E', -3);
        w.put('G', -2);
        w.put('H', -2);
        w.put('I', -3);
        w.put('L', -2);
        w.put('K', -3);
        w.put('M', -1);
        w.put('F', 1);
        w.put('P', -4);
        w.put('S', -3);
        w.put('T', -2);
        w.put('W', 11);
        w.put('Y', 2);
        w.put('V', -3);
        w.put('B', -4);
        w.put('Z', -3);
        w.put('X', -2);
        w.put('*', -4);
        blosum62.put('W', w);
        HashMap<Character, Integer> y = new HashMap<>();
        y.put('A', -2);
        y.put('R', -2);
        y.put('N', -2);
        y.put('D', -3);
        y.put('C', -2);
        y.put('Q', -1);
        y.put('E', -2);
        y.put('G', -3);
        y.put('H', 2);
        y.put('I', -1);
        y.put('L', -1);
        y.put('K', -2);
        y.put('M', -1);
        y.put('F', 3);
        y.put('P', -3);
        y.put('S', -2);
        y.put('T', -2);
        y.put('W', 2);
        y.put('Y', 7);
        y.put('V', -1);
        y.put('B', -3);
        y.put('Z', -2);
        y.put('X', -1);
        y.put('*', -4);
        blosum62.put('Y', y);
        HashMap<Character, Integer> v = new HashMap<>();
        v.put('A', 0);
        v.put('R', -3);
        v.put('N', -3);
        v.put('D', -3);
        v.put('C', -1);
        v.put('Q', -2);
        v.put('E', -2);
        v.put('G', -3);
        v.put('H', -3);
        v.put('I', 3);
        v.put('L', 1);
        v.put('K', -2);
        v.put('M', 1);
        v.put('F', -1);
        v.put('P', -2);
        v.put('S', -2);
        v.put('T', 0);
        v.put('W', -3);
        v.put('Y', -1);
        v.put('V', 4);
        v.put('B', -3);
        v.put('Z', -2);
        v.put('X', -1);
        v.put('*', -4);
        blosum62.put('V', v);
        HashMap<Character, Integer> b = new HashMap<>();
        b.put('A', -2);
        b.put('R', -1);
        b.put('N', 3);
        b.put('D', 4);
        b.put('C', -3);
        b.put('Q', 0);
        b.put('E', 1);
        b.put('G', -1);
        b.put('H', 0);
        b.put('I', -3);
        b.put('L', -4);
        b.put('K', 0);
        b.put('M', -3);
        b.put('F', -3);
        b.put('P', -2);
        b.put('S', 0);
        b.put('T', -1);
        b.put('W', -4);
        b.put('Y', -3);
        b.put('V', -3);
        b.put('B', 4);
        b.put('Z', 1);
        b.put('X', -1);
        b.put('*', -4);
        blosum62.put('B', b);
        HashMap<Character, Integer> z = new HashMap<>();
        z.put('A', -1);
        z.put('R', 0);
        z.put('N', 0);
        z.put('D', 1);
        z.put('C', -3);
        z.put('Q', 3);
        z.put('E', 4);
        z.put('G', -2);
        z.put('H', 0);
        z.put('I', -3);
        z.put('L', -3);
        z.put('K', 1);
        z.put('M', -1);
        z.put('F', -3);
        z.put('P', -1);
        z.put('S', 0);
        z.put('T', -1);
        z.put('W', -3);
        z.put('Y', -2);
        z.put('V', -2);
        z.put('B', 1);
        z.put('Z', 4);
        z.put('X', -1);
        z.put('*', -4);
        blosum62.put('Z', z);
        HashMap<Character, Integer> x = new HashMap<>();
        x.put('A', 0);
        x.put('R', -1);
        x.put('N', -1);
        x.put('D', -1);
        x.put('C', -2);
        x.put('Q', -1);
        x.put('E', -1);
        x.put('G', -1);
        x.put('H', -1);
        x.put('I', -1);
        x.put('L', -1);
        x.put('K', -1);
        x.put('M', -1);
        x.put('F', -1);
        x.put('P', -2);
        x.put('S', 0);
        x.put('T', 0);
        x.put('W', -2);
        x.put('Y', -1);
        x.put('V', -1);
        x.put('B', -1);
        x.put('Z', -1);
        x.put('X', -1);
        x.put('*', -4);
        blosum62.put('X', x);
        HashMap<Character, Integer> astr = new HashMap<>();
        astr.put('A', -4);
        astr.put('R', -4);
        astr.put('N', -4);
        astr.put('D', -4);
        astr.put('C', -4);
        astr.put('Q', -4);
        astr.put('E', -4);
        astr.put('G', -4);
        astr.put('H', -4);
        astr.put('I', -4);
        astr.put('L', -4);
        astr.put('K', -4);
        astr.put('M', -4);
        astr.put('F', -4);
        astr.put('P', -4);
        astr.put('S', -4);
        astr.put('T', -4);
        astr.put('W', -4);
        astr.put('Y', -4);
        astr.put('V', -4);
        astr.put('B', -4);
        astr.put('Z', -4);
        astr.put('X', -4);
        astr.put('*', 1);
        blosum62.put('*', astr);

    }

    private String mkAlignmentString(char c, char[] xs, DIRECTION[] dirs) {
        String res = "";
        int i = 0;
        for (DIRECTION dir : dirs) {
            switch (dir) {
                case SOUTH:
                    switch (c) {
                        case 'X':
                            res += '-';
                            break;
                        case 'Y':
                            res += (i < xs.length) ? xs[i++] : '-';
                            break;
                        case '|':
                            res += '*';
                            break;
                        default:
                            throw new AssertionError();
                    }
                    break;
                case EAST:
                    switch (c) {
                        case 'X':
                            res += (i < xs.length) ? xs[i++] : '-';
                            break;
                        case 'Y':
                            res += '-';
                            break;
                        case '|':
                            res += '*';
                            break;
                        default:
                            throw new AssertionError();
                    }
                    break;
                case DIAG:
                    switch (c) {
                        case '|':
                            res += '|';
                            break;
                        default:
                            res += (i < xs.length) ? xs[i++] : '-';
                    }
                    break;
                default:
                    throw new AssertionError();
            }
        }
        return res;
    }

    private int[][][] mkGridCube(char[] xs, char[] ys, int band) {
        //Pair<Integer,DIRECTION>[][][] result = new Pair[3][ys.length + 1][xs.length + 1];
        int[][][] result = new int[3][ys.length + 1][xs.length + 1];

        //we need to initialized things.
        //the top matrix is the -> so along the top row (which is of length band)
        // each j =0 is the gap cost, and initially we are extending the gap, so
        // j = 1 to start there means you are skipping 2, so it's j-1 + extend. 
        // along the first column, we are simply opening the gap for the first time.
        // vise versa for the bottom matrix. 
        //first adjust the band if we need to. it may be unneccessarily big. 
        if (band == -1 || band > result[0].length) {
            band = result[0].length;
        }
        //now fill er up!
        result[UPPER][0][0] = initGapCost;
        result[LOWER][0][0] = initGapCost;
        result[MIDDLE][0][0] = 0;
        for (int j = 1; j < band; j++) {
            //the gap extention cost is added each time for this matrix.
            result[UPPER][0][j] = result[UPPER][0][j - 1] + gapExtentionCost;
            result[UPPER][j][0] = initGapCost;

            result[MIDDLE][0][j] = 0; //maybe?? I think? there is no cost to before, right?
            result[MIDDLE][j][0] = 0;

            //in this matrix, the top row is all initial gaps. 
            result[LOWER][0][j] = initGapCost;
            result[LOWER][j][0] = result[LOWER][j - 1][0] + gapExtentionCost;
        }
        //the matrices have been initialized. we are ready to begin filling with: 
        /*
        ↓
        si,j= max ( ↓si−1,j −σ
                    si−1,j − (ρ + σ)
        →
        s i,j= max ( →s i,j−1 −σ
                      si,j−1 − (ρ + σ)

        si,j = max



si−1,j−1 + δ(vi
, wj )
↓
si,j
→
s i,j
         */

        for (int i = 1; i < result[LOWER].length; i++) {
            LinearEquation diageq = mkDiagEquation(result[MIDDLE]);
            int from = Math.round(diageq.getX(i)) - band;
            if (from < 1) {
                from = 1;
            }
            int to = Math.round(diageq.getX(i)) + band;
            if (to > result[LOWER][0].length) {
                to = result[LOWER][0].length;
            }
            for (int j = from; j < to; j++) {

                result[LOWER][i][j] = Integer.max(
                        result[LOWER][i - 1][j] + gapExtentionCost,
                        result[LOWER][i - 1][j] + initGapCost + gapExtentionCost);

                result[UPPER][i][j] = Integer.max(
                        result[UPPER][i][j - 1] + gapExtentionCost,
                        result[UPPER][i][j - 1] + initGapCost + gapExtentionCost
                );
                result[MIDDLE][i][j] = Integer.max(Integer.max(
                        result[MIDDLE][i - 1][j - 1] + score(ys[i - 1], xs[j - 1]),
                        result[LOWER][i][j]),
                        result[UPPER][i][j]);

            }

        }
        return result;
    }

    private int score(char y, char x) {
        return blosum62.get(y).get(x);
    }

    public enum DIRECTION {
        NORTH, WEST, DIAG, SOUTH, EAST, UP, DOWN, UP_NORTH, DOWN_WEST

    };
    static final int LOWER = 0;
    static final int MIDDLE = 1;
    static final int UPPER = 2;

    static int initGapCost = -11;
    static int gapExtentionCost = -1;

    public int[][][] mkGridCube(String strx, String stry, int band) {
        return mkGridCube(strx.toCharArray(), stry.toCharArray(), band);
    }

    public int[][] mkEditDistanceGraph(String strx, String stry, int band) {
        return mkEditDistanceGraph(strx.toCharArray(), stry.toCharArray(), band);
    }

    private int[][] mkEditDistanceGraph(char[] xs, char[] ys, int band) {

        int[][] result = new int[ys.length + 1][xs.length + 1];
        result = initializeEditDistance(result);
        if (band == -1) {
            band = result[0].length;
        }

        for (int i = 1; i < result.length; i++) {
            LinearEquation diageq = mkDiagEquation(result);
            int from = Math.round(diageq.getX(i)) - band;
            if (from <= 0) {
                from = 1;
            }
            int to = Math.round(diageq.getX(i)) + band;
            if (to > result[0].length) {
                to = result[0].length;
            }
            for (int j = from; j < to; j++) {

                if (xs[j - 1] == ys[i - 1]) {
                    result[i][j] = result[i - 1][j - 1];
                } else {
                    result[i][j] = 1 + min3(result[i - 1][j - 1], result[i - 1][j], result[i][j - 1]);
                }

            }

        }
        return result;
    }

    private int[][] initializeEditDistance(int[][] result) {
        for (int i = 0; i < result.length; i++) {
            result[i][0] = i;
        }
        for (int i = 0; i < result[0].length; i++) {
            result[0][i] = i;
        }
        return result;
    }

    public <T> LinearEquation mkDiagEquation(T[][] arr) {
        return new LinearEquation(arr.length / (float) arr[0].length, 0);
    }

    public LinearEquation mkDiagEquation(int[][] arr) {
        return new LinearEquation(arr.length / (float) arr[0].length, 0);
    }

    public Pair<DIRECTION, Integer>[] mkBacktrace(int[][][] a3) {
        ArrayList<Pair<DIRECTION, Integer>> directions = new ArrayList<>((a3[LOWER].length + a3[LOWER][0].length) * 2);
        int i = a3[LOWER].length - 1;
        int j = a3[LOWER][0].length - 1;
        int k = MIDDLE;

        while (i > 0 || j > 0) {
            boolean igood = inBounds(a3[LOWER], i - 1, j);
            boolean jgood = inBounds(a3[LOWER], i, j - 1);
            int max;
            DIRECTION dir = null;
            switch (k) {
                case LOWER:
                    //we can jump up 
                    if (igood) {
                        max = Integer.max(//Integer.max(
                                a3[MIDDLE][i - 1][j],
                                a3[LOWER][i - 1][j]);//, 
                        // a3[UPPER][i][j - 1]);
                        if (max == a3[MIDDLE][i - 1][j]) {
                            dir = DIRECTION.UP_NORTH;
                            k=MIDDLE;
                        } else {
                            dir = DIRECTION.NORTH;
                        }
                        i--;
                    } else {
                        throw new AssertionError();
                    }
                    break;
                case MIDDLE:
                    if (igood && jgood) {

                        max = Integer.max(Integer.max(
                                a3[MIDDLE][i - 1][j - 1],
                                a3[LOWER][i][j]),
                                a3[UPPER][i][j]);
                        if (max == a3[MIDDLE][i - 1][j - 1]) {
                            dir = DIRECTION.DIAG;
                            i--;
                            j--;
                        } else if (max == a3[LOWER][i][j]) {
                            dir = DIRECTION.DOWN;
                            k=LOWER;
                        } else if (max == a3[UPPER][i][j]) {
                            dir = DIRECTION.UP;
                            k=UPPER;
                        }
                    } else {
                        max = Integer.max(
                                a3[LOWER][i][j],
                                a3[UPPER][i][j]);
                        if (max == a3[LOWER][i][j]) {
                            dir = DIRECTION.DOWN;
                            k = LOWER;
                        } else if (max == a3[UPPER][i][j]) {
                            dir = DIRECTION.UP;
                            k= UPPER;
                        }
                    }
                    break;
                case UPPER:
                    if (jgood) {
                        max = Integer.max(//Integer.max(
                                a3[MIDDLE][i][j - 1],
                                a3[UPPER][i][j - 1]);//,
                        if (max == a3[MIDDLE][i][j - 1]) {
                            dir = DIRECTION.DOWN_WEST;
                            k = MIDDLE;
                        } else if (max == a3[UPPER][i][j - 1]) {
                            dir = DIRECTION.WEST;
                            
                        }
                        j--;
                    } else {
                        throw new AssertionError(k + ", " + i + ", " + j + ": " + dir);
                    }
                    break;
                default:
                    throw new AssertionError();
            }
            System.out.println(k + ", " + i + ", " + j + ": " + dir);
            directions.add(new Pair(dir, max));
        }
        return directions.toArray(new Pair[directions.size()]);
    }

    public DIRECTION[] mkBacktrace(int[][] twoD) {
        ArrayList<DIRECTION> directions = new ArrayList<>(twoD.length + twoD[0].length);
        int i = twoD.length - 1;
        int j = twoD[0].length - 1;
        while (i > 0 || j > 0) {
            boolean igood = inBounds(twoD, i - 1, j);
            boolean jgood = inBounds(twoD, i, j - 1);
            int min;
            if (igood) {
                if (jgood) {
                    min = min3(twoD[i - 1][j - 1], twoD[i - 1][j], twoD[i][j - 1]);
                } else {
                    min = twoD[i - 1][j];
                }
            } else {
                min = twoD[i][j - 1];
            }
            if (inBounds(twoD, i - 1, j - 1) && min == twoD[i - 1][j - 1]) {
                i--;
                j--;
                directions.add(DIRECTION.DIAG);
            } else if (inBounds(twoD, i, j - 1) && min == twoD[i][j - 1]) {
                j--;
                directions.add(DIRECTION.WEST);
            } else if (inBounds(twoD, i - 1, j) && min == twoD[i - 1][j]) {
                i--;
                directions.add(DIRECTION.NORTH);
            }
        }
        return directions.toArray(new DIRECTION[directions.size()]);
    }

    public DIRECTION[] reverse(DIRECTION[] dirs) {
        DIRECTION temp;
        for (int i = 0; i < dirs.length; i++) {
            int rindex = (dirs.length - 1) - i;
            if (Math.abs(rindex - i) < 2) {
                break;
            }

            temp = reverse(dirs[rindex]);
            dirs[rindex] = reverse(dirs[i]);
            dirs[i] = temp;
        }
        return dirs;
    }

    private DIRECTION reverse(DIRECTION dir) {
        switch (dir) {
            case NORTH:
                return DIRECTION.SOUTH;
            case SOUTH:
                return DIRECTION.NORTH;
            case EAST:
                return DIRECTION.WEST;
            case WEST:
                return DIRECTION.EAST;
            case DIAG:
                return DIRECTION.DIAG;
            case UP:
                return DIRECTION.DOWN;
            case DOWN:
                return DIRECTION.UP;

            default:
                System.out.println(dir);
                throw new AssertionError();
        }
    }

    private boolean inBounds(int[][] twoD, int i, int j) {
        return i >= 0 && j >= 0 && i < twoD.length && j < twoD[0].length;
    }

    private int min3(int x, int y, int z) {
        return Integer.min(Integer.min(x, y), z);
    }

    public String twoDToString(int[][] twoD) {
        StringBuilder x = new StringBuilder(twoD.length * twoD[0].length * 4 + 5);
        for (int[] row : twoD) {
            x.append(Arrays.toString(row));
            x.append('\n');
        }
        return x.toString();
    }

    public void print2D(int[][] arr) {
        System.out.println(twoDToString(arr));
    }

    public String alignment(String xs, String ys, DIRECTION[] dirs) {
        StringBuilder x = new StringBuilder((Integer.max(xs.length(), ys.length()) + 10) * 3);
        x.append(mkAlignmentString('X', xs.toCharArray(), dirs));
        x.append('\n');
        x.append(mkAlignmentString('|', null, dirs));
        x.append('\n');
        x.append(mkAlignmentString('Y', ys.toCharArray(), dirs));
        return x.toString();
    }
;
}
