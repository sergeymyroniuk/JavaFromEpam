public class Case {
    public static void main(String args[]) throws java.io.IOException {
        char ch;
        int changes = 0;
        System.out.println(" Для остановки введите символ точки . ");
        do{
            ch = (char) System.in.read();
        if (ch >= 'а' & ch <= 'z') {
            ch -= 32;
            changes++;
            System.out.println(ch);
        }
        else if (ch >= 'А' & ch <= 'Z') {
            ch += 32;
            changes++;
            System.out.println(ch);
            }
        } while(ch != '.') ;
        System.out.println("Измeнeниe регистра : " + changes);
    }
}