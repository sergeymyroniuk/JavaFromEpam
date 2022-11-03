import java.awt.*;

public class Wave {
    private int waveNumber;//номер волны
    private int waveMultiplier;//кол врагов в волне
    private long waveTimer;// таймер
    private long waveDelay;// время между волнами
    private long waveTimerDiff;// разница врем
    private String waveText;// сообщ волны
    public int magazine;// количество патронов

    // Constructor

    public Wave (){
        waveNumber = 1;
        waveMultiplier = 5;
        waveTimer = 0;
        waveDelay = 5000;
        waveTimerDiff = 0;
        waveText = "ATTACK";

    }

    //Создание врагов
    public void createBadSmiles(){
        int badSmileCount = waveNumber * waveMultiplier;// колич врагов
        if (waveNumber < 10){
            while (badSmileCount > 0){// пока
                int type = 1;//
                int rank = 1;//
                GamePanel.badSmiles.add(new BadSmile(type,rank));//
                badSmileCount -= type * rank;// конец цикла создания врагов
            }
        }
        waveNumber++;
        magazine = 10 * waveNumber;// количество патронов
    }

    public void update(){
        //обновление таймера
        if(GamePanel.badSmiles.size() == 0 && waveTimer == 0){//если нет врагов и таймер=0
            waveTimer = System.nanoTime();//= текущее время
        }
        // проверка на создание врагов
        if (waveTimer > 0){//если таймер больше времени задержки
            waveTimerDiff += (System.nanoTime() - waveTimer)/1000000;// разница времени
            waveTimer = System.nanoTime();// время

        }
        if(waveTimerDiff > waveDelay){//если пауза закончилась
            createBadSmiles(); // создаём врагов
            waveTimer = 0;// таймер
            waveTimerDiff = 0;

        }
    }

    //показ надписи
    public boolean showWave(){
        if (waveTimer != 0){// если таймер не равен нулю
            return true; //  возвращ - правда
        }else return false; //
    }

    // отрисовка
    public void draw(Graphics2D g){
        // закон изменения прозрачности
        double divider = waveDelay / 180; //сколько вемени прийдется на 1 градус изменения цвеа
        double alpha = waveTimerDiff/divider;// показатель прозрачности в опреденный момент паузы
        alpha = 255 * Math.sin(Math.toRadians(alpha)); //переводим прозрачн в радианы и определ синус и умнож на уровень прозррачности
        if (alpha < 0 ) alpha = 0;
        if (alpha > 255) alpha = 255;
        g.setFont(new Font("consolas",Font.PLAIN,60));//передаём шрифт
        g.setColor(new Color(255,0,0,(int)alpha ));//полная строка
        String s = waveNumber + " " + waveText; //полная строка
        long length = (int) g.getFontMetrics().getStringBounds(s,g).getWidth();// длина надписи (текста) в пиксилях
        g.drawString(s,GamePanel.WIDTH/2 - (int)(length / 2),GamePanel.HEIGHT - 200);// рисуем строчку в центре панели

    }
}
