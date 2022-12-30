package cyclone;

public class Vector2D {

    private double x;

    private double y;


    //default constructor will create vector with x = 0 , y = 0;
    public Vector2D(){
        this.x = 0 ;
        this.y = 0 ;
    }

    //constructor
    public Vector2D(double x,double y){
        this.x = x;
        this.y = y;
    }


    //this function will return the square of the coordinates of the vector which are used to
    //then calculate the magnitude
    public double squareCoordinates(){
        return x*x+y*y;
    }


    //this method will return the magnitude of this vector
    public double magnitude(){
        return Math.sqrt(squareCoordinates());
    }


    //this method will do the product of this vector with a given scalar value
    public void scalarVectorProduct(double value){
        this.x *= value;
        this.y *= value;
    }


    //this method will normalize the vector with the formula unitVector = vector * 1/magnitude
    public void normalize(){
        //checking if the magnitude is> 0 to avoid /0 problems
        if(this.magnitude()>0){
            scalarVectorProduct(1/magnitude());
        }
    }


    //adding two vectors together and returning the result
    public Vector2D add(Vector2D otherVector){
        double newX = this.x + otherVector.x;
        double newY = this.y + otherVector.y;

        return new Vector2D(newX,newY);
    }


    //subtracting two vectors and getting the result
    public Vector2D subtract(Vector2D otherVector) {
        double newX = this.x - otherVector.x;
        double newY = this.y - otherVector.y;

        return new Vector2D(newX, newY);
    }


    //adds scaled vector to this
    public void addScaledVector(Vector2D otherVector,double scale){
        this.x += otherVector.x * scale;
        this.y += otherVector.y * scale;
    }


    //returns the component product of two vectors
    public Vector2D componentProduct(Vector2D otherVector){
        double newX = this.x * otherVector.x;
        double newY = this.y * otherVector.y;

        return new Vector2D(newX,newY);
    }


    //returns the scalar product of this vector with another
    public double scalarProduct(Vector2D otherVector){
        return(this.x*otherVector.x+this.y*otherVector.y);
    }


    //returns the vector product of this vector and another
//    public Vector2D vectorProduct(Vector2D otherVector){
//        double newX = this.y*otherVector.z - (this.z*otherVector.y);
//        double newY = this.z*otherVector.x - (this.x*otherVector.z);
//
//        return new Vector2D(newX,newY);
//    }


    //prints out the vector
    public void vectorDescription(){
        System.out.println("vector x: " + this.x +"    y:"+this.y);
    }




    //getters and setters for the vector values
    public double getX(){
        return this.x;
    }

    public double getY(){
        return this.y;
    }
}
