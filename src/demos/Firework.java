package demos;


import cyclone.Particle;
import cyclone.Vector2D;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public abstract class Firework extends Particle implements Explodable {

    Color color = Color.red;
    double lifeTime = 7; //lifetime of the firework
    boolean explosive;
    private int numPayloads = 50;
    Random random;
    private int width;
    private int height;
    double randomXVelocity;
    private double initialY;

    //random comments
    //the firework class will have two constructors one for a standard firework
    public Firework() {
        random = new Random();
        this.setMass(1);//mass is not needed for now as no forces are added but will be used later when calculating force of gravity;
        this.setVelocity(new Vector2D(0, 0));
        this.setAcceleration(new Vector2D(0, -20));
        this.setDamping(0.99);
        explosive = true;
    }


    public void draw(Graphics2D g) {
        g.setColor(color);
        g.fillRect((int) this.getPosition().getX(), (int) this.getPosition().getY(), width, height);
    }


    public void update() {
        if (lifeTime > 0) {
            integrate(0.033333333);
            lifeTime = lifeTime - 0.03333333;
        } else {
            //removing the firework from the objects being updated in the fireworks class
            Fireworks.removeExplodable(this);
            //the firework explodes and releases payloads

            //print firework description
            printDescription();
            spawnPayloads();
        }

    }


    public void initiateFirework(int width,int height,int numPayloads){
        this.width = width;
        this.height = height;
        this.numPayloads = numPayloads;
        this.setPosition(new Vector2D(400 - this.width, 800 - this.height));
        this.initialY=800-this.height;
    }


    public void spawnPayloads() {

        //for every payload create it and add it to Fireworks
        for (int i = 0; i < numPayloads; i++) {
            Fireworks.addExplodable(new Payload(new Vector2D(this.getPosition().getX(), this.getPosition().getY())));
        }

    }

    private void printDescription(){
        System.out.println("the firework in 7 seconds, with an initial velocity of 0 and an acceleration of "+getAcceleration().getY()+"\n travelled: " + Math.abs(initialY - getPosition().getY()));
    }


}
