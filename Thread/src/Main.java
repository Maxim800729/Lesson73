//
//Задание 1:
// Сравнение последовательного и параллельного выполнения
// Создайте программу, которая демонстрирует разницу между
// последовательным и параллельным выполнением двух задач:
//
//Первая задача: подсчет и вывод чисел от 0 до 10000
//Вторая задача: вывод 5000 символов "*"
//
//Измерьте и выведите время выполнения для обоих подходов
// (последовательного и с использованием потоков).






public class Main {
    public static void main(String[] args) throws InterruptedException {
        long startSequential = System.currentTimeMillis();
        countNumbers();
        printXs();
        long endSequential = System.currentTimeMillis();
        System.out.println(" Время последовательного выполнения =" + (endSequential - startSequential) + " mc");
        //Thread
        Thread t1 = new Thread(Main::countNumbers);
        Thread t2 = new Thread(Main::printXs);

        long startParallel = System.currentTimeMillis();
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        long endParallel = System.currentTimeMillis();
        System.out.println("Время параллельного выполнеия =" + (endParallel - startParallel) + " mc");

    }

    private static void printXs() {
        for (int i = 0; i < 5000; i++) {
            System.out.println("*");


        }
    }

    private static void countNumbers() {
        for (int i = 0; i < 10000; i++) {
            System.out.println(i);


        }
    }
}