package ki306zabrotskyilab4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.util.Scanner;

/**
 * Головний клас програми EquationsApp для обчислення виразу y = ctg(x) / sin(7x-1).
 */
public class EquationsApp {
    /**
     * @param args аргументи командного рядка
     */
    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(System.in);
            PrintWriter fout = new PrintWriter(new File("res"));
            try {
                try {
                    Equations eq = new Equations();
                    out.print("Введіть x(в градусах): ");
                    double x = in.nextDouble();
                    // Обчислення виразу та запис у файл
                    fout.print("Результат: " + eq.calculate(x));
                    out.println("Результат записаний у файл.");
                } finally {
                    // Цей блок виконається за будь-яких обставин
                    fout.flush();
                    fout.close();
                    in.close();
                }
            } catch (CalcException ex) {
                // Блок перехоплює помилки обчислень виразу
                out.println(ex.getMessage());
            }
        } catch (FileNotFoundException ex) {
            out.println("Файл не знайдено.");
        }
    }
}