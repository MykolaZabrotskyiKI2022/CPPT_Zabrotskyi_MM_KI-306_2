package ki306zabrotskyilab2;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Scanner;
import javax.swing.JFrame;

/**
 * The ComputerApp class extends JFrame and implements KeyListener to create a GUI-based
 * application that responds to key events to simulate various computer operations.
 */
public class ComputerApp extends JFrame implements KeyListener {

    private char choice;
    private int count;
    private Computer computer;

    /**
     * Constructs a new ComputerApp and sets up the initial GUI and listeners.
     */
    public ComputerApp() {
        this.setTitle("Клавіатура");
        this.setSize(400, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.addKeyListener(this);
        this.setVisible(true);
        this.choice = 0;
        this.count = 0;
        this.computer = new Computer();
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n __________________________________________________________________________________________________");
        System.out.println("|__________________________________________________________________________________________________|");
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\t\t\tДля запуску комп'ютера натисніть на любу клавішу.\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println(" __________________________________________________________________________________________________");
        System.out.println("|__________________________________________________________________________________________________|");
    }

    /**
     * Method triggered when a key is typed.
     * @param e KeyEvent triggered when a key is typed
     */
    @Override
    public void keyTyped(KeyEvent e) {
        // This method is called when a key is typed (pressed and released).
    }

    /**
     * Method triggered when a key is pressed.
     * @param e KeyEvent triggered when a key is pressed
     */
    @Override
    public void keyPressed(KeyEvent e) {
        // This method is called when a key is pressed.
    }

    /**
     * Method triggered when a key is released. This method handles the main menu choices and
     * initiates various operations based on the user's input.
     * @param e KeyEvent triggered when a key is released
     */
    @Override
    public void keyReleased(KeyEvent e) {
        Scanner scanner = new Scanner(System.in);
        if (count == 1) {
            choice = e.getKeyChar();
            switch (choice) {
                case '1' -> {
                    computer.displayInfo(); // Display computer information
                }
                case '2' -> {
                    System.out.println(" __________________________________________________________________________________________________");
                    System.out.println("|__________________________________________________________________________________________________|\n\n\n\n\n\n\n\n");
                    System.out.println("\t\t\t\tВвід інформації.");
                    System.out.println("\tМодель процесора: ");
                    String model = "AMD Ryzen";
                    System.out.println("\tЧастота процесора: ");
                    double frequency = 4.0;
                    System.out.println("\tОб'єм ОП: ");
                    int capacity = 32;
                    System.out.println("\tТип ОП: ");
                    String type = "DDR5";
                    System.out.println("\tРозширення екрану: ");
                    String resolution = "4K";
                    System.out.println("\tРозмір екрану: ");
                    System.out.println("\n\n\n\n\n\n\n\n\n __________________________________________________________________________________________________");
                    System.out.println("|__________________________________________________________________________________________________|");
                    int size = 27;
                    Processor newProcessor = new Processor(model, frequency);
                    Memory newMemory = new Memory(capacity, type);
                    Display newDisplay = new Display(resolution, size);
                    computer.changeInfo(newProcessor, newMemory, newDisplay); // Change computer components
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException p) {
                        System.err.println("Помилка: потік перервано.");
                    }
                }
                case '3' -> {
                    System.out.println(" __________________________________________________________________________________________________");
                    System.out.println("|__________________________________________________________________________________________________|\n\n\n\n\n\n\n\n");
                    System.out.println("\t\t\t\t\tКалькулятор.");
                    System.out.print("\t\tВведіть вираз для обчисленн: ");
                    String expression = scanner.nextLine();
                    computer.Calc(expression); // Perform calculation
                    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n __________________________________________________________________________________________________");
                    System.out.println("|__________________________________________________________________________________________________|");
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException p) {
                        System.err.println("Помилка: потік перервано.");
                    }
                }
                case '4' -> {
                    computer.showFileWorkMenu(); // Show file work menu
                    int fwchoice = scanner.nextInt();
                    scanner.nextLine();
                    if (fwchoice == 1) {
                        System.out.println(" __________________________________________________________________________________________________");
                        System.out.println("|__________________________________________________________________________________________________|\n\n\n\n\n\n\n\n");
                        System.out.println("\t\t\t\t\tСтворення файлу.");
                        System.out.print("\t\t\tВведіть ім'я файлу: ");
                        String nameoffile = scanner.nextLine();
                        System.out.print("\t\t\tВведіть вміст файлу: ");
                        String contentoffile = scanner.nextLine();
                        computer.fileCreate(nameoffile, contentoffile); // Create a file
                    } else if (fwchoice == 2) {
                        computer.fileRead(); // Read the list of files
                        System.out.print("Введіть назву файлу, вміст якого ви хочете прочитати: ");
                        try {
                            Thread.sleep(5000);
                        } catch (InterruptedException p) {
                            System.err.println("Помилка: потік перервано.");
                        }
                        String nameoffile = scanner.nextLine();
                        nameoffile = nameoffile + ".txt";
                        computer.fileReadContent(nameoffile); // Read content of the specified file
                        try {
                            Thread.sleep(5000);
                        } catch (InterruptedException p) {
                            System.err.println("Помилка: потік перервано.");
                        }
                    }
                }
                case '5' -> {
                    computer.shutdown(); // Shut down the computer
                    scanner.close();
                    System.exit(0);
                }
                default -> {
                    // Do nothing if the input is not recognized
                }
            }
        } else if (count == 0) {
            computer.start(); // Start the computer on first key press
            count++;
        }
        computer.showMenu(); // Show the main menu after each action
    }

    /**
     * The main method to run the ComputerApp.
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        new ComputerApp(); // Create and run the ComputerApp
    }
}
