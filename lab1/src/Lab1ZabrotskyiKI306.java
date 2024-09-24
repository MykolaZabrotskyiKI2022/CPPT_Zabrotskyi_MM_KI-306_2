// Імпортуємо бібліотеки, які потрібні длля функціонування програми.

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Lab1ZabrotskyiKI306 {
    
    /**
     * Виконання лабораторної роботи №1 Варіант - 7
     * 
     * @author Mykola Zabrotskyi KI-306
     * @param args
     */

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in); // Створюємо об'єкт Scanner, щоб читати дані з консолі.

        System.out.print("\nВведіть розмір зубчастого масиву: ");
        int nRows = in.nextInt(); // Зчитуємо введене користувачем ціле число, яке буде розміром масиву.
        System.out.println("Розмір вашого зубчастого масиву: " + nRows + " x " + nRows);

        System.out.print("\nВведіть символ заповнювач: ");
        in.nextLine(); //Очищуємо буфер перед тим як ввести смвол заповнювач.
        String filler = in.nextLine();
        // Валідація вводу для заповнювача.
        if(filler.length()==0){
            System.out.print("\nНе введено символ заповнювач.\n");
            in.close(); 
            System.exit(0);
        }
        else if(filler.length()>1){
            System.out.print("\nЗабагато сиволів заповнювачів.\n56");
            in.close(); 
            System.exit(0);
        }
        
        in.close(); // Закриваємо об'єкт Scanner, щоб звільнити ресурси.
        System.out.println();

        // Створюємо зубчастий масив.
        char[][] arr = new char[nRows][];
        for (int i = 0; i < nRows; i++) {
            int midPoint = nRows / 2;
            int numSymbols = (i < midPoint) ? i + 1 : nRows - i;
            arr[i] = new char[numSymbols];
        }

        // Заповнюємо зубчастий масив заповнювачем.
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = (char) filler.codePointAt(0);
            }
        }

        // Виводимо масив у консоль та записуємо його у файл Output.txt
        try {
            File dataFile = new File("Output.txt");
            PrintWriter fout = new PrintWriter(dataFile);
            for (char[] row : arr) {
                for (char symbol : row) {
                    System.out.print(symbol);
                    fout.print(symbol);
                }
                System.out.println();
                fout.println(); 
            }
            fout.close(); 
        } catch (FileNotFoundException e) {
            System.out.println("Помилка при записі у файл: " + e.getMessage());
        }

        System.out.println();
    }
}
