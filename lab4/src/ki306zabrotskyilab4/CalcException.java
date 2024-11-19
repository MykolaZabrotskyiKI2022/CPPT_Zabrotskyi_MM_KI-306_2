package ki306zabrotskyilab4;

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

/**
 * Клас Equations реалізує метод для обчислення виразу y = ctg(x) / sin(7x-1).
 */
class Equations {
    /**
     * Метод обчислює вираз y = ctg(x) / sin(7x-1).
     *
     * @param x кут в градусах
     * @return результат обчислення
     * @throws CalcException якщо значення x призводить до невизначеності у виразі
     */
    public double calculate(double x) throws CalcException {
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

        return y;
    }
}
