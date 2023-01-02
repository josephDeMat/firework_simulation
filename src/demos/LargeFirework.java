package demos;

import java.awt.*;

public class LargeFirework extends Firework{

    //fields
    int width = 6;
    int height = 20;
    Color color = Color.red;
    int payloads = 100;

    public LargeFirework(){
        super();
        initiateFirework(width,height,payloads);
        super.color = color;
    }
}
