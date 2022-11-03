import javax.swing.*;

public class StartGame {
    public static void main(String[] args) {
        GamePanel panel = new GamePanel();
        JFrame startFrame = new JFrame("AAA-Game");
        startFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        startFrame.setContentPane(panel);
        startFrame.pack();
        startFrame.setVisible(true);
        startFrame.setLocationRelativeTo(null);
        panel.start();
    }
}
