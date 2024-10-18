package ki306zabrotskyilab2;

import java.io.*;

/**
 * Клас Computer представляє комп'ютер з атрибутами бренду, року випуску та ціни.
 * Він також містить методи для розрахунку арифметичних виразів, створення та читання файлів.
 */
public class Computer {
    private String brand;
    private int year;
    private int price;

    // Ім'я файлу журналу
    private static final String LOG_FILE_NAME = "activity_log.txt";

    public Computer() {
        this.brand = "Невідомий";
        this.year = 0;
        this.price = 0;
        log("Створено комп'ютер за замовчуванням.");
    }

    public Computer(String brand, int year, int price) {
        this.brand = brand;
        this.year = year;
        this.price = price;
        log("Створено комп'ютер з брендом: " + brand + ", роком: " + year + ", ціною: " + price);
    }

    // Метод для запису повідомлень у журнал
    private void log(String message) {
        try (PrintWriter logWriter = new PrintWriter(new FileWriter(LOG_FILE_NAME, true))) {
            logWriter.println(System.currentTimeMillis() + ": " + message);
        } catch (IOException e) {
            System.out.println("Помилка при запису в журнал: " + e.getMessage());
        }
    }

    public void calculate(String expression) {
        String strnum1 = "";
        String strnum2 = "";
        char op = '\0';
        boolean foundOp = false;

        for (char ch : expression.toCharArray()) {
            if ((ch == '+' || ch == '-' || ch == '*' || ch == '/') && !foundOp) {
                op = ch;
                foundOp = true;
            } else if (!foundOp) {
                strnum1 += ch;
            } else {
                strnum2 += ch;
            }
        }

        double dnum1 = Double.parseDouble(strnum1);
        double dnum2 = Double.parseDouble(strnum2);
        double result = 0;

        switch (op) {
            case '+' -> result = dnum1 + dnum2;
            case '-' -> result = dnum1 - dnum2;
            case '*' -> result = dnum1 * dnum2;
            case '/' -> {
                if (dnum2 != 0) {
                    result = dnum1 / dnum2;
                } else {
                    System.out.println("Помилка: Ділення на нуль.");
                    log("Помилка: Ділення на нуль для виразу " + expression);
                    return;
                }
            }
        }

        System.out.println("\t\tРезультат: " + result);
        log("Обчислено: " + expression + " = " + result);
    }

    public void fileCreate(String nameoffile, String contentoffile) {
        try (PrintWriter filecreate = new PrintWriter(new FileWriter("filework.txt", true))) {
            filecreate.println(nameoffile + ".txt");
            filecreate.println("{");
            filecreate.println(contentoffile);
            filecreate.println("}");
            log("Створено файл: " + nameoffile + ".txt з вмістом: " + contentoffile);
        } catch (IOException e) {
            System.out.println("Помилка при створенні файлу: " + e.getMessage());
            log("Помилка при створенні файлу: " + e.getMessage());
        }
    }

    public void fileRead() {
        try (BufferedReader fileread = new BufferedReader(new FileReader("filework.txt"))) {
            String fstr, sstr = "";
            int count = 0;

            System.out.println("\nСписок наявних файлів:");
            while ((fstr = fileread.readLine()) != null) {
                if (fstr.equals("{")) {
                    count++;
                    System.out.println("\t" + count + "." + sstr);
                }
                sstr = fstr;
            }
            log("Список файлів прочитано, знайдено " + count + " файлів.");
        } catch (IOException e) {
            System.out.println("Помилка при читанні файлу: " + e.getMessage());
            log("Помилка при читанні файлу: " + e.getMessage());
        }
    }

    public void fileReadContent(String nameoffile) {
        try (BufferedReader fileread = new BufferedReader(new FileReader("filework.txt"))) {
            String str;
            int success = 0;
            while ((str = fileread.readLine()) != null) {
                if (nameoffile.equals(str)) {
                    success++;
                }
                if (success == 1 && str.equals("{")) {
                    success++;
                }
                if (success == 3) {
                    System.out.println("Вміст файлу: " + str);
                    success++;
                }
                if (success == 2) {
                    success++;
                }
            }
            if (success != 4) {
                System.out.println("Ви ввели ім'я неіснуючого файлу, спробуйте ще раз.");
                log("Помилка: Файл не знайдено: " + nameoffile);
                fileRead();
            }
        } catch (IOException e) {
            System.out.println("Помилка при читанні файлу: " + e.getMessage());
            log("Помилка при читанні файлу: " + e.getMessage());
        }
    }

    // Геттери і сеттери
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
        log("Бренд комп'ютера змінено на: " + brand);
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
        log("Рік випуску комп'ютера змінено на: " + year);
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
        log("Ціна комп'ютера змінено на: " + price);
    }
}
