import javax.swing.*;
import java.awt.*;

public class Bomb {
    private double x;
    private double y;
    private double w ; //ширина обьекта
    private double h ; // высота объекта

    private int speed;

    Image img = new ImageIcon("images/Bomb Up.png").getImage();//загрузка картинки

    public Bomb(){
        w = 18;
        h = 53;
        x = ((76-18) / 2) + GamePanel.player.getX();
        y = GamePanel.player.getY() - (76 / 2);

        speed = 10;
    }


    public double getX() { return x;}
    public double getY() { return y;}
    public double getW() { return w;}
    public double getH() { return h;}

    public void update(){
        y -= speed;
    }

    public void draw(Graphics2D g){
        g.drawImage(img, (int)x,(int)y, null);
    }

    public boolean remove_f(){
        if(y < -53 || y > GamePanel.HEIGHT || x < 0 || x > GamePanel.WIDTH) { //если вылетела
            return true;
        }
        return false;

    }
}
