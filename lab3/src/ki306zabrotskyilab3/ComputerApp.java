package ki306zabrotskyilab3;

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
    private Laptop computer;

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
        this.computer = new Laptop();
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n __________________________________________________________________________________________________");
        System.out.println("|__________________________________________________________________________________________________|");
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\t\t\tДля запуску комп'ютера натисніть на любу клавішу.\n\n\n\n\n\n\n\n\n\n\n\n");
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
                    computer.displayKeyboard();
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
                    int size = 27;
                    System.out.println("\tЄмність акумулятора: ");
                    int akCapacity = 50;
                    System.out.println("\n\n\n\n\n\n\n\n __________________________________________________________________________________________________");
                    System.out.println("|__________________________________________________________________________________________________|");
                    computer.displayKeyboard();
                    Processor newProcessor = new Processor(model, frequency);
                    Memory newMemory = new Memory(capacity, type);
                    Display newDisplay = new Display(resolution, size);
                    computer.changeInfo(newProcessor, newMemory, newDisplay, akCapacity); // Change computer components
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
                    computer.displayKeyboard();
                }
                case '4' -> {
                    computer.showFileWorkMenu(); // Show file work menu
                    computer.displayKeyboard();
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
                        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n __________________________________________________________________________________________________");
                        System.out.println("|__________________________________________________________________________________________________|");
                        computer.displayKeyboard();
                        computer.fileCreate(nameoffile, contentoffile); // Create a file
                    } else if (fwchoice == 2) {
                        computer.fileRead(); // Read the list of files
                        computer.displayKeyboard();
                        System.out.print("Введіть назву файлу, вміст якого ви хочете прочитати: ");
                        String nameoffile = scanner.nextLine();
                        nameoffile = nameoffile + ".txt";
                        computer.fileReadContent(nameoffile); // Read content of the specified file
                        computer.displayKeyboard();
                    }
                }
                case '5' -> {
                    computer.chargeBattery(); // Shut down the computer
                }
                case '6' -> {
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
        computer.displayKeyboard();
        computer.useBattery();
    }

    /**
     * The main method to run the ComputerApp.
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        new ComputerApp(); // Create and run the ComputerApp
    }
}
