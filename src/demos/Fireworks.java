package demos;


import java.awt.*;
import java.util.ArrayList;


public class Fireworks {
    public static ArrayList<Explodable>explodables = new ArrayList<Explodable>();
    public static int numPayloads =5;


    //go through all the explodable entities and update them all
    public static void updateAll(){
        for(int i = 0 ; i<explodables.size();i++){//cannot change to enhanced for loop or will leave concurrentModification exception
            explodables.get(i).update();
        }
    }


    //go through all the explodable entities and draw them all
    public static void drawAll(Graphics2D g){
        for(int i = 0 ; i<explodables.size();i++){
            explodables.get(i).draw(g);
        }
    }


    //method used add one explodable object to the explodables collection
    public static void addExplodable(Explodable explodable){
        explodables.add(explodable);
    }


    //method for adding and array list of explodables to the explodables collection
    public static void addExplodables(ArrayList<Explodable> explodabless){
        explodables.addAll(explodabless);
    }


    //method used to remove one explodable object from the explodables collection
    public static void removeExplodable(Explodable explodable){
        explodables.remove(explodable);

    }


}
