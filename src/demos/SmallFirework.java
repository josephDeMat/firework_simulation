package demos;

import java.awt.*;

public class SmallFirework extends Firework{
    //fields of small firework
    int width = 3;
    int height = 12;
    int numberPayloads = 10;
    Color color = Color.PINK;

    public SmallFirework(){
        super();
        super.initiateFirework(width,height,numberPayloads);
        super.color=this.color;
    }
}
