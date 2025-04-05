
//Задание 2: Использование разных способов создания потоков
//Напишите программу, которая выполняет одну и ту же задачу
// (например, вывод чисел от 1 до 100) тремя разными способами:
//
//Используя наследование от класса Thread (как MyThread в примере)
//Используя интерфейс Runnable (как MyRunnable в примере)
//Используя лямбда-выражение
//
//Для каждого способа выведите имя потока и его приоритет.

public class Main2 {
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        t1.setName("наследование от класса Thread");
        t1.setPriority(Thread.MIN_PRIORITY);
        t1.start();

        Thread t2 = new Thread(new MyRunnable());
        t2.setName("Thread - Runnable");
        t2.setPriority(Thread.NORM_PRIORITY);
        t2.start();

        Thread t3 = new Thread(() -> {
            System.out.println("Имя " + Thread.currentThread().getName());
            System.out.println("Приоритет: " + Thread.currentThread().getPriority());
            for (int i = 1; i <= 100; i++) {
                System.out.println(Thread.currentThread().getName() + ": " + i);

            }

        });
        t3.setName("Thread - Lambda");
        t3.setPriority(Thread.MAX_PRIORITY);
        t3.start();

    }

    static class MyThread extends Thread {
        public void run() {
            System.out.println("Имя:" + getName());
            System.out.println("Приоритет: " + getPriority());
            for (int i = 1; i <= 100; i++) {
                System.out.println(getName() + " :" + i);

            }
        }
    }

    static class MyRunnable implements Runnable {
        public void run() {
            System.out.println("Имя: " + Thread.currentThread().getName());
            System.out.println("Приоритет: " + Thread.currentThread().getPriority());
            for (int i = 1; i < 100; i++) {
                System.out.println(Thread.currentThread().getName() + ": " + i);

            }
        }
    }

}


