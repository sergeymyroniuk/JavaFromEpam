import javax.swing.*;
import java.awt.*;

public class Player {

    //Fields
    private double x;//координа х героя
    private double y;//координа y героя
    private double w ; //ширина обьекта
    private double h ; // высота объекта
    private double dx;// смещение по диагонали (коэфициент смещения)
    private double dy;// смещение по диагонали (коэфициент смещения)
    private int speed;// скорость
    public static boolean up;
    public static boolean down;
    public static boolean left;
    public static boolean right;
    public static boolean isFiring;
    public double health;// здоровье

    Image img = new ImageIcon("images/MySmile.png").getImage();//загрузка картинки

    //private Color color1;// цвет


    //Constructor
    public Player(){
        w = 76;
        h = 76;
        x = GamePanel.WIDTH / 2 - (w/2);// нач координаты героя (переменная глобальная которая отвечает за ширину экрана)
        y = GamePanel.HEIGHT / 2 - (h/2);// нач координаты героя (переменная глобальная которая отвечает за высоту экрана)

        speed = 5;

        dx = 0;
        dy = 0;
        health = 3;
        up = false;
        down = false;
        left = false;
        right = false;

        isFiring = false;
    }

    public void hit() {
        health--;
    }
    public Rectangle getRect() { // получение прямоугоьников
        return new Rectangle((int) x, (int) y, 76, 76); //возвращаем конструктор с размером объекта
    }
    public double getX(){
        return  x;
    }
    public double getY(){
        return  y;
    }

    //Functions
    public void update(){

        if (up && y > 2){
            dy -= speed;
        }
        if (down && y <GamePanel.HEIGHT - h){
            dy += speed;
        }
        if (left && x >0){
            dx -= speed;
        }
        if (right && x <GamePanel.WIDTH - w){
            dx += speed;
        }
        if(up && left || up && right || down && left || down && right){
            dy = dy * Math.sin(Math.toRadians(45));
            dx = dx * Math.cos(Math.toRadians(45));
        }
        y += dy;    // обновление координат
        x += dx;    // обновление координат

        // чтобы останавливался надо обнулить смещения
        dy = 0;
        dx = 0;

        if(isFiring){
            GamePanel.bombs.add(new Bomb());
        }
    }


    public void draw(Graphics2D g){
        //g.setColor(color1);
        g.drawImage(img, (int)x,(int)y, null);

        Color bacColor = new Color(255, 0,0 );//созд обьект клсса цвет
        g.setColor(bacColor);// передаём цвет граф объекту
        g.fillRect(45, 0, 110, 20);//рисуем прямоугольную область
        g.fillRect(245, 0, 190, 20);//рисуем прямоугольную область
        g.fillRect(495, 0, 100, 20);//рисуем прямоугольную область


    }
}
