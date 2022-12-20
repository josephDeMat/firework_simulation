package cyclone;

public class Vector3 {

    //stores the x position of the vector
    private double x ;

    //stores the y position of the vector
    private double y;

    //stores the z position of the vector
    private double z;


    //the default constructor creates a vector in position (0,0,0)
    public Vector3(){
        x=0;
        y=0;
        z=0;
    }


    //constructor
    public Vector3(double x,double y, double z){
        this.x = x;
        this.y = y;
        this.z = z;
    }


    //this function returns the square magnitude of a vector it is faster to use this one when
    //comparing two vectors magnitudes because it is faster to calculate than the full magnitude function with sqrt
    public double squareMagnitude(){
        return x*x+y*y+z*z;
    }


    //calculates the magnitude of a vector
    public double magnitude(){
        return Math.sqrt(squareMagnitude());
    }


    //returns the unit vector of a vector following the rule unitVector = vector * 1/magnitude
    public void normalize(){
        //checking if the magnitude is >0 to avoid mathematical problems and errors
        if(magnitude()>0){
            sVMultiplication(1/magnitude());
        }
    }


    //multiplies the vector with a scalar value;
    public void sVMultiplication(double value){
        this.x *= value;
        this.y *= value;
        this.z *= value;
    }


    //adds two vectors together and returns the result;
    public Vector3 add(Vector3 otherVector){
        double newX = this.x + otherVector.x;
        double newY = this.y + otherVector.y;
        double newZ = this.z + otherVector.z;

        return new Vector3(newX,newY,newZ);

    }


    //subtracts a two vectors and returns the result
    public Vector3 subtract(Vector3 otherVector){
        double newX = this.x - otherVector.x;
        double newY = this.y - otherVector.y;
        double newZ = this.z - otherVector.z;

        return new Vector3(newX,newY,newZ);
    }


    //adds scaled vector to this
    public void addScaledVector(Vector3 otherVector,double scale){
        this.x += otherVector.x * scale;
        this.y += otherVector.y * scale;
        this.z += otherVector.z * scale;
    }


    //returns the component product of two vectors
    public Vector3 componentProduct(Vector3 otherVector){
        double newX = this.x * otherVector.x;
        double newY = this.y * otherVector.y;
        double newZ = this.z * otherVector.z;

        return new Vector3(newX,newY,newZ);
    }


    //returns the scalar product of this vector with another
    public double scalarProduct(Vector3 otherVector){
        return(this.x*otherVector.x+this.y*otherVector.y+this.z*otherVector.z);
    }


    //returns the vector product of this vector and another
    public Vector3 vectorProduct(Vector3 otherVector){
        double newX = this.y*otherVector.z - (this.z*otherVector.y);
        double newY = this.z*otherVector.x - (this.x*otherVector.z);
        double newZ = this.x*otherVector.y - (this.y*otherVector.x);

        return new Vector3(newX,newY,newZ);
    }


    //prints out the vector
    public void vectorDescription(){
        System.out.println("vector x: " + this.x +"    y:"+this.y + "    z:"+this.z);
    }
}
