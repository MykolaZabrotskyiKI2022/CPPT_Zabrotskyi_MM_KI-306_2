package ki306zabrotskyilab3;

import java.awt.datatransfer.SystemFlavorMap;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import ki306zabrotskyilab3.Computer;


interface electricalDevice{
    void useBattery();
    void chargeBattery();
}

/**
 * Клас Laptop представляє ноутбук, що є підкласом Computer, і реалізує інтерфейс electricalDevice.
 * Він має атрибути, такі як модель, розмір екрану, ємність акумулятора та стан батареї.
 */
public class Laptop extends Computer implements electricalDevice {
    private int capacity;
    private double battery;

    // Ім'я файлу журналу
    private static final String LOG_FILE_NAME = "activity_log.txt";

    /**
     * Конструктор за замовчуванням для створення ноутбука з невідомими параметрами.
     */
    public Laptop() {
        this.capacity = 50;
        this.battery = 100;
        log("Створено ноутбук за замовчуванням.");
    }

    /**
     * Конструктор для створення ноутбука з зазначеними параметрами.
     *
     * @param model      модель ноутбука
     * @param screenSize розмір екрана ноутбука в дюймах
     * @param capacity   ємність акумулятора ноутбука у Вт*год
     */
    public Laptop(String model, float screenSize, int capacity) {
        this.capacity = capacity;
        this.battery = 100;
        log("Створено ноутбук: " + "діагональ: " + screenSize + "\", ємність: " + capacity + " Вт*год");
    }

    /**
     * Виводить інформацію про ноутбук, включаючи бренд, рік випуску, ціну та технічні характеристики.
     */
    @Override
    public void displayInfo() {
        log("displayInfo method called.");
        System.out.println(" __________________________________________________________________________________________________");
        System.out.println("|__________________________________________________________________________________________________|\n\n\n\n\n\n\n\n");
        System.out.println("\t\t\t\tХарактеристики цього пк.");
        System.out.println("\tПроцесор: " + processor);
        System.out.println("\tПам'ять: " + memory);
        System.out.println("\tДисплей: " + display);
        System.out.println("\tЄмність акумулятора: " + capacity + " Вт*год");
        System.out.println("\tЗаряд: " + battery + "%");
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n __________________________________________________________________________________________________");
        System.out.println("|__________________________________________________________________________________________________|");
        log("Computer specifications displayed.");

    }

    public void displayKeyboard(){
        System.out.println(" __________________________________________________________________________________________________ ");
        System.out.println("| |                                                                                   |" + battery + "%    | |");
        System.out.println("|  ______________________________________________________________________________________________  |");
        System.out.println("| |  [Esc] [F1] [F2] [F3] [F4] [F5] [F6] [F7] [F8] [F9] [F10] [F11] [F12]  [PrtSc][Del ]         | |");
        System.out.println("| | [~][1][2][3][4][5][6][7][8][9][0][-][=][ Backspace ]                   [ Ins ][Home][PgUp]   | |");
        System.out.println("| | [Tab][Q][W][E][R][T][Y][U][I][O][P][{][}][|][      ]                   [ Del ][End ][PgDn]   | |");
        System.out.println("| | [CapsLock][A][S][D][F][G][H][J][K][L][;]['][ Enter ]                                         | |");
        System.out.println("| | [Shift][Z][X][C][V][B][N][M][,][.][/][    Shift    ]                           [↑]           | |");
        System.out.println("| | [Ctrl][Win][Alt][        Space      ][Alt][Fn][Ctrl]                        [←][↓][→]        | |");
        System.out.println("| |                            __________________________________                                | |");
        System.out.println("| |                           |                                  |                               | |");
        System.out.println("| |                           |                                  |                               | |");
        System.out.println("| |                           |                                  |                               | |");
        System.out.println("| |                           |                                  |                               | |");
        System.out.println("| |                           |                                  |                               | |");
        System.out.println("| |                           |__________________________________|                               | |");
        System.out.println("| |______________________________________________________________________________________________| |");
        System.out.println("|__________________________________________________________________________________________________|");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {

        }
    }

    /**
     * Changes the computer's components to new ones.
     *
     * @param processor the new processor
     * @param memory    the new memory
     * @param display   the new display
     */
    @Override
    public void changeInfo(Processor processor, Memory memory, Display display, int capacity) {
        log("changeInfo method called.");
        this.processor = processor;
        this.memory = memory;
        this.display = display;
        this.capacity = capacity;
        log("Computer specifications updated.");
    } 


    /**
     * Метод для запису повідомлення у файл журналу.
     * 
     * @param message повідомлення для запису в журнал
     */
    private void log(String message) {
        try (PrintWriter logWriter = new PrintWriter(new FileWriter(LOG_FILE_NAME, true))) {
            logWriter.println(System.currentTimeMillis() + ": " + message);
        } catch (IOException e) {
            System.out.println("Помилка при запису в журнал: " + e.getMessage());
        }
    }

    /**
     * Використовує акумулятор, зменшуючи його заряд, і протоколює стан батареї.
     *
     * @return залишковий заряд акумулятора
     */
    @Override
    public void useBattery() {
        battery -= 10;
        log("Використано 25% батареї, залишок: " + battery + "%");
        if (battery <= 0) {
            System.out.println(" __________________________________________________________________________________________________");
            System.out.println("|__________________________________________________________________________________________________|");
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\t\t\tНоутбук розряджений, завершення роботи...\n\n\n\n\n\n\n\n\n\n\n\n");
            System.out.println(" __________________________________________________________________________________________________");
            System.out.println("|__________________________________________________________________________________________________|");
            System.out.println(" __________________________________________________________________________________________________ ");
            System.out.println("| |                                                                                   |          | |");
            System.out.println("|  ______________________________________________________________________________________________  |");
            System.out.println("| |  [Esc] [F1] [F2] [F3] [F4] [F5] [F6] [F7] [F8] [F9] [F10] [F11] [F12]  [PrtSc][Del ]         | |");
            System.out.println("| | [~][1][2][3][4][5][6][7][8][9][0][-][=][ Backspace ]                   [ Ins ][Home][PgUp]   | |");
            System.out.println("| | [Tab][Q][W][E][R][T][Y][U][I][O][P][{][}][|][      ]                   [ Del ][End ][PgDn]   | |");
            System.out.println("| | [CapsLock][A][S][D][F][G][H][J][K][L][;]['][ Enter ]                                         | |");
            System.out.println("| | [Shift][Z][X][C][V][B][N][M][,][.][/][    Shift    ]                           [↑]           | |");
            System.out.println("| | [Ctrl][Win][Alt][        Space      ][Alt][Fn][Ctrl]                        [←][↓][→]        | |");
            System.out.println("| |                            __________________________________                                | |");
            System.out.println("| |                           |                                  |                               | |");
            System.out.println("| |                           |                                  |                               | |");
            System.out.println("| |                           |                                  |                               | |");
            System.out.println("| |                           |                                  |                               | |");
            System.out.println("| |                           |                                  |                               | |");
            System.out.println("| |                           |__________________________________|                               | |");
            System.out.println("| |______________________________________________________________________________________________| |");
            System.out.println("|__________________________________________________________________________________________________|");
            log("Ноутбук розряджений, завершення роботи.");
            System.exit(0);
        }
    }

    /**
     * Заряджає акумулятор і протоколює процес заряджання.
     *
     * @return новий заряд акумулятора
     */
    @Override
    public void chargeBattery() {
        System.out.println(" __________________________________________________________________________________________________");
        System.out.println("|__________________________________________________________________________________________________|");
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\t\t\t Поточний заряд батареї: " + battery + "%");
        System.out.println("\t\t\tПроцес зарядки:");
        while (battery < 100.0) {
            System.out.print("\tТриває зарядка");
            for (int i = 0; i < 3; i++) {
                System.out.print(".");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
        
                }
            }
            System.out.println();
            battery += 10;
            log("Заряджено 25%, поточний заряд: " + battery + "%");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
    
            }
        }
        System.out.println("\tГотово! Поточний заряд батареї: " + battery + "%\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println(" __________________________________________________________________________________________________");
        System.out.println("|__________________________________________________________________________________________________|");
        System.out.println(" __________________________________________________________________________________________________ ");
        System.out.println("| |                                                                                   |          | |-|____________");
        System.out.println("|  ______________________________________________________________________________________________  |-|           |");
        System.out.println("| |  [Esc] [F1] [F2] [F3] [F4] [F5] [F6] [F7] [F8] [F9] [F10] [F11] [F12]  [PrtSc][Del ]         | |             |");
        System.out.println("| | [~][1][2][3][4][5][6][7][8][9][0][-][=][ Backspace ]                   [ Ins ][Home][PgUp]   | |             |");
        System.out.println("| | [Tab][Q][W][E][R][T][Y][U][I][O][P][{][}][|][      ]                   [ Del ][End ][PgDn]   | |             |");
        System.out.println("| | [CapsLock][A][S][D][F][G][H][J][K][L][;]['][ Enter ]                                         | |             |");
        System.out.println("| | [Shift][Z][X][C][V][B][N][M][,][.][/][    Shift    ]                           [↑]           | |             |");
        System.out.println("| | [Ctrl][Win][Alt][        Space      ][Alt][Fn][Ctrl]                        [←][↓][→]        | |             |");
        System.out.println("| |                            __________________________________                                | |             |");
        System.out.println("| |                           |                                  |                               | |             |");
        System.out.println("| |                           |                                  |                               | |             |");
        System.out.println("| |                           |                                  |                               | |             |");
        System.out.println("| |                           |                                  |                               | |             |");
        System.out.println("| |                           |                                  |                               | |             |");
        System.out.println("| |                           |__________________________________|                               | |             |");
        System.out.println("| |______________________________________________________________________________________________| |             |");
        System.out.println("|__________________________________________________________________________________________________|             |");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {

        }
    }
}
