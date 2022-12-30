package demos;

import cyclone.Particle;
import cyclone.Vector2D;

import java.awt.*;
import java.util.Random;

public class Payload extends Particle implements Explodable{

    private int radius;
    private Color color;
    private double lifetime;
    int max = 10;
    int min = -10;

    public Payload(Vector2D startingPosition){
       this.radius=4;
       this.color = Color.red;
       this.lifetime =5.0;
       super.setPosition(startingPosition);

       double rXVel = (Math.random() * (max - min) + min);
       double rYVel = (Math.random() * (max - min) + min);
       color = new Color((int) (Math.random() * 0x1000000));
       super.setVelocity(new Vector2D(rXVel,rYVel));
       super.setAcceleration(new Vector2D(0,0));
       super.setMass(1);
       super.setDamping(0.99);
    }

    public void draw(Graphics g){
        g.setColor(color);
        g.fillOval((int)super.getPosition().getX(),(int)super.getPosition().getY(),radius,radius);
    }

    public void update() {
        System.out.println("update run");
        //System.out.println("lifetime is "+ lifeTime);
        //before running the update checking if the fireworks lifetime is over
        if (!(lifetime <= 0)) {
            //System.out.println("removed from firework");
            integrate(0.033333333);
            lifetime = lifetime - 0.03333333;
        } else {
            Fireworks.removeExplodable(this);
        }
    }
}
