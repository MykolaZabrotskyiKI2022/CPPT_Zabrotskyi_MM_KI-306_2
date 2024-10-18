package ki306zabrotskyilab2;

import java.io.IOException;
import java.util.Scanner;

/**
 * Клас ComputerApp демонструє роботу з класом Computer, включаючи обчислення виразів,
 * створення та читання файлів.
 */
public class ComputerApp {
    
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        Computer myComputer = new Computer(); // Створення комп'ютера за замовчуванням
        while (true) {
            System.out.println("\nМеню:");
            System.out.println("1. Встановити бренд, рік та ціну комп'ютера");
            System.out.println("2. Показати інформацію про комп'ютер");
            System.out.println("3. Виконати обчислення");
            System.out.println("4. Створити файл");
            System.out.println("5. Прочитати файл");
            System.out.println("6. Вийти");

            System.out.print("Оберіть дію: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Очищення буфера

            switch (choice) {
                case 1 -> {
                    // Введення атрибутів комп'ютера
                    System.out.print("\nВведіть бренд комп'ютера: ");
                    String brand = scanner.nextLine();

                    System.out.print("Введіть рік випуску комп'ютера: ");
                    int year = scanner.nextInt();

                    System.out.print("Введіть ціну комп'ютера: ");
                    int price = scanner.nextInt();
                    scanner.nextLine(); // Очищення буфера

                    myComputer.setBrand(brand);
                    myComputer.setYear(year);
                    myComputer.setPrice(price);
                }
                case 2 -> {
                    // Виведення інформації про комп'ютер
                    System.out.println("\nІнформація про комп'ютер:");
                    System.out.println("Бренд: " + myComputer.getBrand());
                    System.out.println("Рік випуску: " + myComputer.getYear() + " року");
                    System.out.println("Ціна: " + myComputer.getPrice() + " грн");
                }
                case 3 -> {
                    // Обчислення арифметичного виразу
                    System.out.println("\nКалькулятор.");
                    System.out.print("\tВведіть вираз: ");
                    String expression = scanner.nextLine();
                    myComputer.calculate(expression);
                }
                case 4 ->{
                    // Створення файлу
                    System.out.print("\nВведіть ім'я файлу: ");
                    String nameoffile = scanner.nextLine();
        
                    System.out.print("Введіть вміст файлу: ");
                    String contentoffile = scanner.nextLine();

                    myComputer.fileCreate(nameoffile, contentoffile);
                }
                case 5 -> {
                    // Читання файлу
                    myComputer.fileRead();

                    System.out.print("Введіть назву файлу, вміст якого ви хочете прочитати: ");
                    String nameoffile;
                    nameoffile = scanner.nextLine();
                    nameoffile = nameoffile + ".txt";

                    myComputer.fileReadContent(nameoffile);
                }
                case 6 -> {
                    // Вихід з програми
                    System.out.println("Вихід...");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Невірний вибір, спробуйте ще раз.");
            }
        }
    }
}

