package demos;

import cyclone.Particle;
import cyclone.Vector2D;

import java.awt.*;

public class Payload extends Particle implements Explodable {

    int max = 10;
    int min = -10;

    //testing random velocity
    private int randomVelocityMagnitude;
    private int radius = 4;
    private Color color;
    private double lifetime = 7.0;


    public Payload(Vector2D startingPosition) {

        super.setPosition(startingPosition);

        //getting random velocities for the payloads
        //getting random angle for payload
        randomVelocityMagnitude = (int)(Math.random()*((10-8)+8));
        double randomAngle = Math.random()*((360-1)+1);
        double rXVel = randomVelocityMagnitude*Math.sin(randomAngle);
        double rYVel = randomVelocityMagnitude*Math.cos(randomAngle);

        //double rXVel = (Math.random() * (max - min) + min);
        //double rYVel = (Math.random() * (max - min) + min);
        //random color for the payload
        color = new Color((int) (Math.random() * 0x1000000));

        super.setVelocity(new Vector2D(rXVel, rYVel));
        super.setAcceleration(new Vector2D(0, 0));
        super.setMass(1);
        super.setDamping(0.99);
    }

    public void draw(Graphics2D g) {
        g.setColor(color);
        g.fillOval((int) super.getPosition().getX(), (int) super.getPosition().getY(), radius, radius);
    }

    public void update() {
        //before running the update checking if the fireworks lifetime is over
        if (!(lifetime <= 0)) {
            integrate(0.033333333);
            lifetime = lifetime - 0.03333333;
        } else {
            Fireworks.removeExplodable(this);
        }
    }
}
