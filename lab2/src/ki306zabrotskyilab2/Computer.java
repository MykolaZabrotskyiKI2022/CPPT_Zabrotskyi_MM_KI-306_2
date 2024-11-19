package ki306zabrotskyilab2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Represents a computer with a processor, memory, and display.
 * Provides functionality to start, display menu, shutdown, and perform various operations.
 */
public class Computer {
    protected Processor processor;
    protected Memory memory;
    protected Display display;

    /**
     * Default constructor initializing with preset processor, memory, and display.
     */
    public Computer() {
        this.processor = new Processor("Intel", 3.5);
        this.memory = new Memory(16, "DDR4");
        this.display = new Display("Full HD", 24);
        logActivity("Computer created with default specifications.");
    }

    /**
     * Constructs a computer with specified processor, memory, and display.
     *
     * @param processor the processor of the computer
     * @param memory    the memory of the computer
     * @param display   the display of the computer
     */
    public Computer(Processor processor, Memory memory, Display display) {
        this.processor = processor;
        this.memory = memory;
        this.display = display;
        logActivity("Computer created with custom specifications.");
    }

    private void logActivity(String message) {
        try (PrintWriter logWriter = new PrintWriter(new FileWriter("activity_log.txt", true))) {
            logWriter.println(message);
        } catch (IOException e) {
            System.err.println("Error writing to log file: " + e.getMessage());
        }
    }
    
    /**
     * Simulates the starting process of the computer.
     */
    public void start() {
        logActivity("Start method called.");
        System.out.println(" __________________________________________________________________________________________________");
        System.out.println("|__________________________________________________________________________________________________|\n\n\n\n\n\n\n\n\n\n\n\n");
        for (int i = 0; i < 3; i++) {
            if (i == 0) {
                System.out.print("\t\t\t\t\tЗавантаження.");
            }
            if (i > 0) {
                System.out.print(".");
            }
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                logActivity("Error: Thread interrupted during start sequence.");
            }
        }
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n __________________________________________________________________________________________________");
        System.out.println("|__________________________________________________________________________________________________|");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {

        }
        System.out.println("|__________________________________________________________________________________________________|\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.print("\t\t\t\tКомп'ютер успішно завантажено.");
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n __________________________________________________________________________________________________");
        System.out.println("|__________________________________________________________________________________________________|");
        logActivity("Computer successfully started.");
    }

    /**
     * Displays a menu of available operations on the computer.
     */
    public void showMenu() {
        logActivity("showMenu method called.");
        System.out.println(" __________________________________________________________________________________________________");
        System.out.println("|__________________________________________________________________________________________________|");
        System.out.println("\t ___");
        System.out.println("\t| ⎗ |");
        System.out.println("\t ---");
        System.out.println("\t1.Show PC info.exe");
        System.out.println("\t ___");
        System.out.println("\t| ⎘ |");
        System.out.println("\t ---");
        System.out.println("\t2.Change PC info.exe");
        System.out.println("\t ___");
        System.out.println("\t| + |");
        System.out.println("\t ---");
        System.out.println("\t3.Calculator.exe");
        System.out.println("\t ___");
        System.out.println("\t| ⎙ |");
        System.out.println("\t ---");
        System.out.println("\t4.Filework");
        System.out.println("\t ___");
        System.out.println("\t| ⊗ |");
        System.out.println("\t ---");
        System.out.println("\t5.Shutdown");
        System.out.println("\n\n\n\n __________________________________________________________________________________________________");
        System.out.println("|__________________________________________________________________________________________________|");
    }

    /**
     * Simulates shutting down the computer.
     */
    public void shutdown() {
        logActivity("shutdown method called.");
        System.out.println(" __________________________________________________________________________________________________");
        System.out.println("|__________________________________________________________________________________________________|\n\n\n\n\n\n\n\n\n\n\n\n");
        for (int i = 0; i < 3; i++) {
            if (i == 0) {
                System.out.print("\t\t\t\t\tЗавершення роботи.");
            }
            if (i > 0) {
                System.out.print(".");
            }
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {

            }
        }
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n __________________________________________________________________________________________________");
        System.out.println("|__________________________________________________________________________________________________|");
        System.out.println(" __________________________________________________________________________________________________");
        System.out.println("|__________________________________________________________________________________________________|\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.print("\t\t\t\t\tКомп'ютер вимкнено.");
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n __________________________________________________________________________________________________");
        System.out.println("|__________________________________________________________________________________________________|");
        logActivity("Computer successfully shut down.");
    }

    /**
     * Displays information about the computer's components.
     */
    public void displayInfo(){
        logActivity("displayInfo method called.");
        System.out.println(" __________________________________________________________________________________________________");
        System.out.println("|__________________________________________________________________________________________________|\n\n\n\n\n\n\n\n\n");
        System.out.println("\t\t\t\tХарактеристики цього пк.");
        System.out.println("\tПроцесор: " + processor);
        System.out.println("\tПам'ять: " + memory);
        System.out.println("\tДисплей: " + display);
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n __________________________________________________________________________________________________");
        System.out.println("|__________________________________________________________________________________________________|");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {

        }
        logActivity("Computer specifications displayed.");
    }

    /**
     * Changes the computer's components to new ones.
     *
     * @param processor the new processor
     * @param memory    the new memory
     * @param display   the new display
     */
    public void changeInfo(Processor processor, Memory memory, Display display) {
        logActivity("changeInfo method called.");
        this.processor = processor;
        this.memory = memory;
        this.display = display;
        logActivity("Computer specifications updated.");
    } 

    /**
     * Performs a calculation based on the provided expression.
     * @param expression the expression to be calculated
     */
    public void Calc(String expression) {
        logActivity("Calc method called with expression: " + expression);
        Programs calculator = new Programs();
        calculator.Calc(expression);
    }

    /**
     * Displays the file work menu.
     */
    public void showFileWorkMenu() {
        logActivity("showFileWorkMenu method called.");
        Programs showFWM = new Programs();
        showFWM.showFileWorkMenu();
    }

    /**
     * Creates a file with the specified name and content.
     * @param nameoffile the name of the file to create
     * @param contentoffile the content to write in the file
     */
    public void fileCreate(String nameoffile, String contentoffile) {
        logActivity("fileCreate method called with file name: " + nameoffile);
        Programs fileC = new Programs();
        fileC.fileCreate(nameoffile, contentoffile);
    }

    /**
    * Reads and displays the list of files.
    */
    public void fileRead(){
        logActivity("fileRead method called.");
        Programs fileR = new Programs();
        fileR.fileRead();
    }

    /**
     * Reads the content of a specified file.
     * @param nameoffile the name of the file whose content is to be read
     */
    public void fileReadContent(String nameoffile) {
        logActivity("fileReadContent method called with file name: " + nameoffile);
        Programs fileRC = new Programs();
        fileRC.fileReadContent(nameoffile);
    }
}

class Programs {
    public Programs() {
    }
    public void Calc(String expression) {
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
                    return;
                }
            }
        }

        System.out.println("\t\tРезультат: " + result);
    }

    public void showFileWorkMenu() {
        System.out.println(" __________________________________________________________________________________________________");
        System.out.println("|__________________________________________________________________________________________________|");
        System.out.println("\t ___");
        System.out.println("\t| ⎘ |");
        System.out.println("\t ---");
        System.out.println("\t1.Create File.exe");
        System.out.println("\t ___");
        System.out.println("\t|   |");
        System.out.println("\t ---");
        System.out.println("\t2.Created Files(folder)");
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n __________________________________________________________________________________________________");
        System.out.println("|__________________________________________________________________________________________________|");
    }

    public void fileCreate(String nameoffile, String contentoffile) {
        try (PrintWriter filecreate = new PrintWriter(new FileWriter("filework.txt", true))) {
            filecreate.println(nameoffile + ".txt");
            filecreate.println("{");
            filecreate.println(contentoffile);
            filecreate.println("}");
        } catch (IOException e) {
            System.out.println("Помилка при створенні файлу: " + e.getMessage());
        }
    }

    public void fileRead() {
        try (BufferedReader fileread = new BufferedReader(new FileReader("filework.txt"))) {
            String fstr, sstr = "";
            int count = 0;
            System.out.println(" __________________________________________________________________________________________________");
            System.out.println("|__________________________________________________________________________________________________|");
            System.out.println("\n\n\t\t\t\tСписок наявних файлів:");
            while ((fstr = fileread.readLine()) != null) {
                if (fstr.equals("{")) {
                    count++;
                    System.out.println("\t ___");
                    System.out.println("\t|   |");
                    System.out.println("\t ---");
                    System.out.println("\t" + count + "." + sstr);
                }
                sstr = fstr;
            }
        } catch (IOException e) {
            System.out.println("Помилка при читанні файлу: " + e.getMessage());
        }
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n __________________________________________________________________________________________________");
        System.out.println("|__________________________________________________________________________________________________|");
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
                    System.out.println(" __________________________________________________________________________________________________");
                    System.out.println("|__________________________________________________________________________________________________|");
                    System.out.println("\n\n\tФайл: "+nameoffile);
                    System.out.println("\tВміст файлу: " + str);
                    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n __________________________________________________________________________________________________");
                    System.out.println("|__________________________________________________________________________________________________|");
                    success++;
                }
                if (success == 2) {
                    success++;
                }
            }
            if (success != 4) {
                System.out.println("Ви ввели ім'я неіснуючого файлу, спробуйте ще раз.");
                fileRead();
            }
        } catch (IOException e) {
            System.out.println("Помилка при читанні файлу: " + e.getMessage());
        }
    }
}

class Processor {
    protected String model;
    protected double frequency;

    public Processor(String model, double frequency) {
        this.model = model;
        this.frequency = frequency;
    }

    @Override
    public String toString() {
        return model + " " + frequency + " GHz";
    }
}

class Memory {
    protected int capacity;
    protected String type;

    public Memory(int capacity, String type) {
        this.capacity = capacity;
        this.type = type;
    }

    @Override
    public String toString() {
        return capacity + " GB " + type;
    }
}

class Display {
    protected String resolution;
    protected int size;

    public Display(String resolution, int size) {
        this.resolution = resolution;
        this.size = size;
    }

    @Override
    public String toString() {
        return size + " inch " + resolution;
    }
}