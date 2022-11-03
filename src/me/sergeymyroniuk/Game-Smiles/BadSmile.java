import javax.swing.*;
import java.awt.*;

public class BadSmile {
    //  нач координаты и размер объекта
    private double x;
    private double y;
    private double h;
    private double w;
    private double speed;
    private double dx;
    private double dy;
    private double health;  // здоровье
    private int type;   // тип врага
    private int rank;   // ранг

    private Color color;

    Image img = new ImageIcon("images/BadSmile.png").getImage();//загрузка картинки
    public Rectangle getRect() { // получение прямоугоьников
        return new Rectangle((int) x, (int) y, 76, 76); //возвращаем конструктор с размером объекта
    }
    public BadSmile(int type, int rank){
        this.type = type;
        this.rank = rank;

        if (type == 1) {

        } else if (rank == 1) {
            x = Math.random() * GamePanel.WIDTH;
        }

            y = 20;
            w = 72;
            h = 76;
            speed = 5;
            health = 2;
            double angle = Math.toRadians(Math.random()*360);
            dx = Math.sin(angle)*speed;
            dy = Math.cos(angle)*speed;
        }
        /*switch (type){
            case (1):
                switch (rank){
                    case (1):


                }
        }*/
    //}

    public boolean remove_f() {     // удаление врагов из списка
        if (health <= 0) {
            return true;
        }
        return false;
    }
    public double getX() { return x;}
    public double getY() { return y;}
    public double getW() { return w;}
    public double getH() { return h;}
    public void hit(){
        health--;
    }

    public void update(){
        x += dx;
        y += dy;

        if(x < -50 && dx < 0) dx =- dx;
        if(x > GamePanel.WIDTH - 26 && dx>0) dx = -dx;
        if(y < -50 && dy < 0) dy =- dy;
        if(y > GamePanel.HEIGHT - 26 && dy > 0) dy = -dy;
    }

    public void draw(Graphics2D g){
        g.drawImage(img, (int)x,(int)y, null);
        g.setStroke(new BasicStroke());
    }
}
