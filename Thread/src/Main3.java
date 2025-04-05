

//        Задание 3: Взаимодействие между потоками
//Создайте два потока:
//
//Первый поток генерирует и печатает случайные числа (от 1 до 100) каждую секунду
//Второй поток ожидает, когда будет сгенерировано число больше 90, и останавливает оба потока
//
//Используйте методы join(), sleep() и interrupt() для управления потоками,
// а также продемонстрируйте различные состояния жизненного цикла потока
// (NEW, RUNNABLE, TERMINATED и т.д.).

import java.util.Random;

public class Main3 {
    static volatile boolean running = true;

    public static void main(String[] args) {
        Thread generator = new Thread(() -> {
            Random random = new Random();
            while (running) {
                int num = random.nextInt(100) + 1;
                System.out.println("сгенерировано число: " + num);
                if (num > 90) {
                    System.out.println("число больше 90. останавливаем оба потока");
                    running = false;

                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("Гененратор прерван");
                    break;
                }
            }
        });

        Thread monitor = new Thread(()->{
            while (running){
                System.out.println("монитор следит за потоком. состояние: " +generator.getState());
                try {
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    System.out.println("монитор прерван");
                    break;
                }
            }
        });
        generator.start();
        monitor.start();

        try {
            generator.join();
            monitor.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("Оба потока завершены.");
    }
}
