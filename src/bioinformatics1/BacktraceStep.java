/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bioinformatics1;

/**
 *
 * @author paulkline
 */
public class BacktraceStep {
    char x;
    char y;
    int k;
    int i;
    int j;

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public int getJ() {
        return j;
    }

    public void setJ(int j) {
        this.j = j;
    }

    public int getK() {
        return k;
    }

    public void setK(int k) {
        this.k = k;
    }
    int score;
    Utils.DIRECTION dir;
    public BacktraceStep(){
        
    }

    public Utils.DIRECTION getDir() {
        return dir;
    }

    public void setDir(Utils.DIRECTION dir) {
        this.dir = dir;
    }
    public BacktraceStep(char x, char y, int score) {
        this.x = x;
        this.y = y;
        this.score = score;
    }

    @Override
    public String toString(){
        return "k:" + k + " dir:" + dir;
//        return "" + x + '\n' +
//               ((score> 0)? "|" : "*") + '\n' +
//                y + "\n";
    }
    public char getX() {
        return x;
    }

    public void setX(char x) {
        this.x = x;
    }

    public char getY() {
        return y;
    }

    public void setY(char y) {
        this.y = y;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
    
}
