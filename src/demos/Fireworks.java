package demos;

import cyclone.Vector2D;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class Fireworks {
    public static ArrayList<Explodable>explodables = new ArrayList();
    public static int numPayloads =5;

    public Fireworks(){

    }



    public static void updateAll(){
        for(int i = 0 ; i<explodables.size();i++){
            explodables.get(i).update();
        }
    }

    public static void drawAll(Graphics g){
        for(int i = 0 ; i<explodables.size();i++){
            explodables.get(i).draw(g);
            System.out.println("firework number: "+i);
        }
    }


    public static void addExplodable(Explodable explodable){
        explodables.add(explodable);
    }

    // as soon as spawned in all new explodables have different velocity and speed
    public static void addE(ArrayList<Explodable> explodabless){
        explodables.addAll(explodabless);
    }

    public static void removeExplodable(Explodable explodable){
        explodables.remove(explodable);

    }


}
