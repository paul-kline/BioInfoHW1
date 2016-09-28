/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bioinformatics1;

/**
 *
 * @author Paul
 */
public class LinearEquation {
    private float m;
    private float b;
    
    public LinearEquation(float m, float b){
        this.m = m;
        this.b = b;
        
    }
    
    public float getY(float x){
        return (m*x + b);
    }
    public float getX(float y){
        return (y-b)/m;
    }
}
