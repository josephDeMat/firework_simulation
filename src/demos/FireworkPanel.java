package demos;


import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FireworkPanel extends JPanel implements Runnable{

    //settings of the "screen"
    final int WIDTH = 800;
    final int HEIGHT = 800;
    final int FPS = 30;

    //thread that will run the demo
    Thread demoThread;


    //constructor
    FireworkPanel(){
        this.setPreferredSize(new Dimension(WIDTH,HEIGHT));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
    }


    //method to start the firework demo
    public void startFireworkDemo(){
        demoThread = new Thread(this);
        demoThread.start();

        //adding a mouse listener to the demo so that every time screen is clicked a firework starts
        this.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent me) {
                Fireworks.addExplodable(new Firework());
            }
        });
    }


    //simulation thread where the time loop is created
    @Override
    public void run() {

        double drawInterval = 1000000000/FPS;
        double nextDrawTime = System.nanoTime() + drawInterval;

        while (demoThread  != null){
            //update information such as firework time and new particles to be created
            update();
            //repainting the whole screen
            repaint();

            try {
                //how much time remaining till next draw time
                double remainingTime = nextDrawTime - System.nanoTime();
                //converting from nano seconds to milliseconds
                remainingTime = remainingTime/1000000;

                if(remainingTime<0){
                    remainingTime = 0 ;
                }

                Thread.sleep((long) remainingTime);

                nextDrawTime += drawInterval;

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }


    private void update(){
        Fireworks.updateAll();
    }


    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D brush = (Graphics2D)g;
        Fireworks.drawAll(brush);
    }


}
