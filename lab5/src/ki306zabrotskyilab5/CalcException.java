package ki306zabrotskyilab5;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Клас виключення CalcException для обробки помилок обчислень виразу.
 */
class CalcException extends ArithmeticException {
    public CalcException() {
    }

    public CalcException(String cause) {
        super(cause);
    }
}

class CalcWFio extends ArithmeticException {

    private double result;

/*
 * Write data to txt file
 */
public void writeResTxt(String fName) throws FileNotFoundException {
    PrintWriter f = new PrintWriter(fName);
    f.printf("%f ",result);
    f.close();
}

/*
 * Read data from txt file
 */
public void readResTxt(String fName) {
    try {
        File f = new File (fName);
        if (f.exists()) {
            Scanner s = new Scanner(f);
            result = s.nextDouble();
            s.close();
        }
        else
        throw new FileNotFoundException("File " + fName + "not found");
        }
    catch (FileNotFoundException ex) {
        System.out.print(ex.getMessage());
    }
}

/**
 * Write data to bin file
 * @param fName
 * @throws FileNotFoundException
 * @throws IOException
 */
public void writeResBin(String fName) throws FileNotFoundException, IOException {
    DataOutputStream f = new DataOutputStream(new FileOutputStream(fName));
    f.writeDouble(result);
    f.close();
}

/**
 * Read data from bin file
 * @param fName
 * @throws FileNotFoundException
 * @throws IOException
 */
public void readResBin(String fName) throws FileNotFoundException, IOException {
    DataInputStream f = new DataInputStream(new FileInputStream(fName));
    result = f.readDouble();
    f.close();
}


/**
 * Calculate the result
 * @param x
 * @throws CalcException
 */
public void calculate(double x) throws CalcException {
    double y, rad;
    // Перетворення кута з градусів у радіани
    rad = x * Math.PI / 180.0;
    try {
        // Обчислення виразу y = ctg(x) / sin(7x-1)
        double sin7x_1 = Math.sin(7.0 * rad - 1.0);

        double ctgx = Math.cos(rad)/Math.sin(rad);

        y = ctgx / sin7x_1;
        System.out.println(y);
        // Перевірка на невизначеність (NaN або нескінченність)
        if (Double.isNaN(y) || Double.isInfinite(y) || x%180==0) {
            throw new ArithmeticException();
        }

        } catch (ArithmeticException ex) {
            // Створимо виключення вищого рівня з поясненням причини виникнення помилки
            if (Math.sin(7.0 * rad - 1.0)==0) {
                throw new CalcException("Причина виключення: sin(7x-1)=0, що є неможливим при діленні.");
            } else if(x%180==0) {
                throw new CalcException("Причина виключення: ctg(x) не існує.");
            } else {
                throw new CalcException("Невідома причина виключення.");
            }
        }
    result=y;
}

/*
 * Get the result
 */
    public double getResult() {
        return result;
    }
}
