package demos;


import cyclone.Particle;
import cyclone.Vector2D;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class Firework extends Particle implements Explodable {

    //firework fields
    private int width = 4;
    private int height =15;
    Color color = Color.red;
    double lifeTime ;
    boolean explosive;
    int numPayloads= 50;


    //the firework class will have two constructors one for a standard firework
    public Firework(){
         this.setMass(1);
         this.setPosition(new Vector2D(800/2 - width ,800 - height));
         this.setVelocity(new Vector2D(0,0));
         this.setAcceleration(new Vector2D(0,-20));
         this.setDamping(0.99);
         lifeTime = 7;
         explosive=true;
    }

    //this constructor allows for more customization  setting the starting position
    public Firework(Vector2D position){
        this.setMass(1);
        this.setPosition(position);
        this.setVelocity(new Vector2D(0,0));
        this.setAcceleration(new Vector2D(0,-30));
        this.setDamping(0.99);
        lifeTime = 5;
        explosive=true;
    }

    //this constructor is for creating payloads
    public Firework(Vector2D position,Vector2D velocity,Color color){
        this.setMass(1);
        this.setPosition(position);
        this.setVelocity(velocity);
        this.setAcceleration(new Vector2D(0,0));
        this.setDamping(0.99);
        lifeTime = 4;
        this.color = color;
        explosive=false;
    }


    public void draw(Graphics g){
        g.setColor(color);
        g.fillRect((int)this.getPosition().getX(),(int)this.getPosition().getY(),width,height);
    }

    //something to do with the position
    public void update(){
        System.out.println("update run");
        //System.out.println("lifetime is "+ lifeTime);
        //before running the update checking if the fireworks lifetime is over
        if(!(lifeTime<=0)){
            //System.out.println("removed from firework");
            integrate(0.033333333);
            lifeTime= lifeTime-0.03333333;
        }
        else{
            Fireworks.removeExplodable(this);
            //the firework explodes and releases payloads that are other fireworks with explosive = true
            if(explosive){
                System.out.println("spawnPayloads");
                spawnPayloads();
            }

        }

    }

    public void spawnPayloads(){
        Random random = new Random();
        int max = 20;
        int min = -20;

        ArrayList<Payload> payloads = new ArrayList<Payload>();
        //for every payload create it and add it to Fireworks
        for(int i = 0 ; i<numPayloads;i++) {
//            double rXVel = (Math.random() * (max - min) + min);
//            double rYVel = (Math.random() * (max - min) + min);
//            Color newColor = new Color((int) (Math.random() * 0x1000000));
            Fireworks.addExplodable(new Payload(new Vector2D(this.getPosition().getX(), this.getPosition().getY())));
        }

    }
}
