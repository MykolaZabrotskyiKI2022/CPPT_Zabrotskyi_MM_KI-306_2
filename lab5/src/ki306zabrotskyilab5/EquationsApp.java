package ki306zabrotskyilab5;

import java.io.FileNotFoundException;
import java.io.IOException;
import static java.lang.System.out;
import java.util.Scanner;

/**
 * Головний клас програми EquationsApp для обчислення виразу y = ctg(x) / sin(7x-1)
 */
public class EquationsApp {
    /**
     * @param args аргументи командного рядка
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        CalcWFio obj = new CalcWFio();
        Scanner s = new Scanner(System.in);
        System.out.print("Введіть значення x(у градусах): ");
        double x = s.nextDouble();
        try {
            obj.calculate(x);
        }
        catch(CalcException ex) {
            out.print(ex.getMessage());
            return;
        }
        System.out.println("Результат, отриманий після обчислень: " + obj.getResult());
        obj.writeResTxt("textRes.txt");
        obj.writeResBin("BinRes.bin");
        obj.readResBin("BinRes.bin");
        System.out.println("Результат, отриманий з бінарного файлу: " + obj.getResult());
        obj.readResTxt("textRes.txt");
        System.out.println("Результат, отриманий з текстового файлу: " + obj.getResult());
    }
}