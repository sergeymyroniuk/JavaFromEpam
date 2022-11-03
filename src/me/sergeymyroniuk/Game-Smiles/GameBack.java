import javax.swing.*;
import java.awt.*;

public class GameBack {
    //public boolean pl=false;
    private Color color;

    Image img = new ImageIcon("images/Sky.jpg").getImage();//загрузка картинки из папки images

    public GameBack() {
        color = Color.BLUE;

    }

    public void update() {  //обновление

    }

    public void draw(Graphics2D g) {  //прорисовка в Graphics2D
        /*g.setColor(color);//отправляем цвет
        g.fillRect(0,0,GamePanel.WIDTH, GamePanel.HEIGHT);//рисуем прямоугольник*/
        g.drawImage(img, 0,0, null);

    }
}
