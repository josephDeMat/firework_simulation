package demos;

import java.awt.*;

public class MediumFirework extends Firework{
    //fields of a medium firework
    int width =5;
    int height = 15;
    int numberOfPayloads = 50;
    Color color = Color.orange;

    public MediumFirework(){
        super();
        initiateFirework(width,height,numberOfPayloads);
        super.color = color;
    }
}
