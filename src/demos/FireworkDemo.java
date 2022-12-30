package demos;

import javax.swing.*;

public class FireworkDemo {

    public static void main(String[] args) {
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("Firework Demo physics engine");

        FireworkPannel fireworkPannel = new FireworkPannel();
        window.add(fireworkPannel);

        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);

        fireworkPannel.startFireworkDemo();
    }
}
