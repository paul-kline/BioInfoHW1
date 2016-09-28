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
    int score;
    
    public BacktraceStep(){
        
    }
    public BacktraceStep(char x, char y, int score) {
        this.x = x;
        this.y = y;
        this.score = score;
    }

    @Override
    public String toString(){
        return "" + x + '\n' +
               ((score> 0)? "|" : "*") + '\n' +
                y + "\n";
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
