import java.util.Scanner;

public class threader {

    public static void main(String[] args) {
        double x;
        double y;

        while(true) {
            System.out.println("Введите число:");
            Scanner scX = new Scanner(System.in);
            x = scX.nextDouble();

            System.out.println("Введите степень:");
            Scanner scY = new Scanner(System.in);
            y = scY.nextDouble();

            toThread(x,y);

        }

    }

    public synchronized static void toThread(double x, double y){

        Thread tr = new Thread(()->{
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Результат потока "
                    +Thread.currentThread().getName() + " ("+x+"в степени"+y+") = " + Math.pow(x, y));
        });
        System.out.println("Задача решается потоком "+tr.getName());


        tr.start();
    }

}
