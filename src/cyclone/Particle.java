package cyclone;

public class Particle {

    private Vector2D position;
    private Vector2D velocity;
    private Vector2D acceleration;

    //this value is to add drag
    private double damping;

    private double mass;

    //this variable holds the 1/m or the inverse mass of a particle to make it easier to integrate
    private double inverseMass;


    //this method will integrate the particle given a time period  it will update the position and the velocity of the
    //particle using the formula position = velocity * time,
    public void  integrate(double duration){

        if(inverseMass <= 0.0f)return;

        assert(duration>0);

        //updating the position using the above formula not using the formula with acceleration because if the time interval is super small
        //it wont count for much

        this.position.addScaledVector(velocity,duration);
        //will be changed later
        Vector2D resultingAcceleration = acceleration;

        //updating the velocity based on the acceleration
        velocity.addScaledVector(resultingAcceleration,duration);

        //adding drag
        velocity.scalarVectorProduct(Math.pow(damping,duration));
    }


    //this method will return the kinetic energy of a particle
    //kinetic energy is = (1/m)*|v|^2
    public double calculateKineticEnergy(){
        return 0.5*Math.pow(inverseMass,-1)*velocity.magnitude()*velocity.magnitude();
    }


    //adding getters and setters
    public void setMass(double mass){
        this.inverseMass= mass;
    }

    public void setPosition(Vector2D position){
        this.position = position;
    }

    public void setVelocity(Vector2D velocity){
        this.velocity = velocity;
    }

    public void setAcceleration(Vector2D acceleration){
        this.acceleration = acceleration;
    }

    public void setDamping(double damping){
        this.damping= damping;
    }

    public Vector2D getPosition() {
        return this.position;
    }

    public Vector2D getVelocity() {
        return velocity;
    }

    public Vector2D getAcceleration() {
        return acceleration;
    }
}
