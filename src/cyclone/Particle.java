package cyclone;

public class Particle {

    private Vector3 position;
    private Vector3 velocity;
    private Vector3 acceleration;

    //this value is to add drag
    private double damping;

    private double mass;

    //this variable holds the 1/m or the inverse mass of a particle to make it easier to integrate
    private double inverseMass;








    //this method will integrate the particle given a time period  it will update the position and the velocity of the
    //particle using the formula position = velocity * time,
    private void  integrate(double duration){
        if(inverseMass <= 0.0f)return;

        assert(duration>0);

        //updating the postion using the above formula not using the formula with acceleration because if the time interval is super small
        //it wont count for much
        position.addScaledVector(velocity,duration);

        //will be changed later
        Vector3 resultingAcceleration = acceleration;

        //updating the velocity based on the acceleration
        velocity.addScaledVector(resultingAcceleration,duration);

        //adding drag
        velocity.sVMultiplication(Math.pow(damping,duration));
    }


    //this method will return the kinetic energy of a particle
    //kinetic energy is = (1/m)*|v|^2
    public double calculateKineticEnergy(){
        return 1/2*Math.pow(inverseMass,-1)*velocity.magnitude()*velocity.magnitude();
    }


    //adding getters and setters
    public void setMass(){

    }

    public void setPosition(Vector3 position){
        this.position = position;
    }

    public void setVelocity(Vector3 velocity){
        this.velocity = velocity;
    }

    public void setAcceleration(Vector3 acceleration){
        this.acceleration = acceleration;
    }

    public void setDamping(double damping){
        this.damping= damping;
    }
}
