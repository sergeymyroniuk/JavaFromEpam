import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Iterator;

public class GamePanel extends JPanel implements Runnable {
    public static int WIDTH = 1024;
    public static int HEIGHT = 680;
    private Thread thread = new Thread(this);

    private BufferedImage image;
    private Graphics2D g;
    private GameBack background;
    public static Player player;
    public static ArrayList<Bomb> bombs;
    public static ArrayList<BadSmile> badSmiles;
    public static Wave wave;
    public static Menue menue;

    public static int mouseX;// координаты мышки
    public static int mouseY;
    public static boolean leftMouse;
    public static enum STATES{
        MENUE,PLAY
    } //обьявляем перечсления

    public static STATES state = STATES.MENUE;// переменная меню

    private int FPS;//
    private double millisToFPS;// fps в миллсек
    private long timerFPS;// таймер fps
    private int sleepTime; //сколько он будет спать
    public GamePanel() {
        super();
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setFocusable(true);
        requestFocus();
        addMouseListener(new Listeners());
        addKeyListener(new Listeners());
        addMouseMotionListener(new Listeners());
    }

    public void start() {
        thread = new Thread((Runnable) this);
        thread.start();
    }

    @Override
    public void run() {
        FPS = 30; // задаем желаемый FPS
        millisToFPS = 1000/FPS; //пересчет в миллисек
        sleepTime = 0;

        image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        g = (Graphics2D) image.getGraphics();
        //g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);//сглаживание соседних пиксеей

        leftMouse = false;
        background =  new GameBack();
        player = new Player();
        bombs = new ArrayList<Bomb>();
        badSmiles = new ArrayList<BadSmile>();
        wave = new Wave();
        menue = new Menue();
        /*gameUpdate();
        gameRender();*/

        /*badSmiles.add(new BadSmile(1,1));
        badSmiles.add(new BadSmile(1,1));*/





        while (true) {


            //System.out.println(badSmiles.size());

            if (state.equals(STATES.MENUE)){// если пер state == MENUE
                background.update();// фон обновляем
                background.draw(g);// рисуем фон
                menue.update();//меню обновляем
                menue.draw(g);// рисуем меню
                gameDraw();// перерсовываем на панель
            }
            if (state.equals(STATES.PLAY)){// ира
                gameUpdate(); //обновление
                gameRender(); //перерисовка
                gameDraw(); ////перенос изображения на панель

            }

            timerFPS = System.nanoTime();// присвоим текущ время (передали в таймер работу над системой)

            timerFPS = (System.nanoTime() - timerFPS)/1000000;//сколько прошло миллсек на операции выше
            if(millisToFPS > timerFPS){
                sleepTime = (int)(millisToFPS - timerFPS);
            } else sleepTime = 1;

            try {
                thread.sleep(33);   //(это нужно для того чтобы стабильно работала система чтобы независимо от длительности цикла 30 фотографий в секунду)
                //System.out.println(sleepTime);
            } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            timerFPS = 0;// обнуляем таймер
            sleepTime = 1;// обновляем время сна
        }
    }

    public void gameUpdate(){// обновление данных этого объекта
        background.update();     //   вызов метода для заднего плана
        // Player update
        player.update();

        if (player.health<=0) { // если правдиво
            JOptionPane.showMessageDialog(null, "BOOM! Game over!!");
            System.exit(1); //выход в систему ;// удалить элемент из списка врагов
        }

        //bullets.update
        for (int i = 0; i < bombs.size(); i++) {
            bombs.get(i).update();// обновлям текущую пулю
            boolean remove_p = bombs.get(i).remove_f(); //текущую пулю проверяем где она
            if (remove_p) { // если правдиво(улетела)
                bombs.remove(i);//удаляем пулю которая вылетела
                i--;//
            }
        }

        for (int i = 0; i < badSmiles.size(); i++){
            badSmiles.get(i).update();
        }


        //столкновение пули с врагом
        for (int i = 0; i < badSmiles.size(); i++) {// каждого врвгв из списка
            BadSmile e = badSmiles.get(i); // выделяем элемент списка
            double ex = e.getX();// получаем коорд элемента
            double ey = e.getY();
            double ew = e.getW();
            double eh = e.getH();
            //по списку пуль
            for (int j = 0; j < bombs.size(); j++) {
                Bomb b = bombs.get(j);// выделяем элемент списка
                double bx = b.getX();// получаем коорд элемента
                double by = b.getY();
                double bw = b.getW();
                double bh = b.getH();
                //System.out.println(bw);
                //System.out.println(bh);
                if ((bx>ex-bw) &&(bx<ex+ew) && (by>ey-bh) &&(by<ey+eh) ) { // если расстояние от друг друга меньше двух радиусов
                    e.hit();// метод уменьшения здоровья врага
                    bombs.remove(j); // удаляем пулю из списка
                    //Проверка здоровья врага
                    boolean remove_p = e.remove_f(); // пер присваив значение метода пров здоров врага
                    if (remove_p) { // если правдиво
                        badSmiles.remove(i);// удалить элемент из списка врагов
                        //i--;
                        break;
                    }
                }
            }
        }

        // Столкновение героя с врагом
        Iterator<BadSmile> i = badSmiles.iterator();// итератор по списку соперников
        while (i.hasNext()){
            BadSmile e = i.next(); //
            if (player.getRect().intersects(e.getRect())){ // если плеер столкнулся с элементом списка соперников
                e.hit();
                player.hit();
                //Проверка здоровья врага
                boolean remove_p = e.remove_f(); // пер присваив значение метода пров здоров врага
                if (remove_p) { // если правдиво
                    badSmiles.remove(e);// удалить элемент из списка врагов
                    break;

                }

            }
        }
        wave.update();
    }
    public void gameRender(){
        background.draw(g); // передаем кисточку которую инициализируем в методе run
        player.draw(g);
        for (int i = 0; i < bombs.size(); i++) {
            bombs.get(i).draw(g);
        }

        for (int i = 0; i < badSmiles.size(); i++){
            badSmiles.get(i).draw(g);
        }

        if (wave.showWave()){
            wave.draw(g);// вызов метода перерисовки для волны
        }
    }

    private void gameDraw(){ // метод чтобы передавать изображение
        Graphics g2 = this.getGraphics();       // присоединение
        g2.drawImage(image, 0, 0, null);  // выводим на экран прямоугльник
        g2.dispose();   // команда сборщика к холсту (очищаем буфер)
    }
}
