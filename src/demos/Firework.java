package demos;


import cyclone.Particle;
import cyclone.Vector2D;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class Firework extends Particle implements Explodable {

    Color color = Color.red;
    double lifeTime = 7; //lifetime of the firework
    boolean explosive;
    int numPayloads = 1000;
    Random random;
    private int width = 4;
    private int height = 15;


    //the firework class will have two constructors one for a standard firework
    public Firework() {
        random = new Random();
        this.setMass(1);//mass is not needed for now as no forces are added but will be used later when calculating force of gravity;
        this.setPosition(new Vector2D(400 - width, 800 - height));
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
            spawnPayloads();
        }

    }


    public void spawnPayloads() {

        int max = 20;
        int min = -20;

        ArrayList<Payload> payloads = new ArrayList<Payload>();
        //for every payload create it and add it to Fireworks
        for (int i = 0; i < numPayloads; i++) {
            Fireworks.addExplodable(new Payload(new Vector2D(this.getPosition().getX(), this.getPosition().getY())));
        }

    }
}
