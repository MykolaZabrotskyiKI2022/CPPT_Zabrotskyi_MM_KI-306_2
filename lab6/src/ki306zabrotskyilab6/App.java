package ki306zabrotskyilab6;

/**
 * Driver class
 */
public class App {
    public static void main(String[] args) {
        ShipsHold <? super Data> data = new ShipsHold <Data>();
        data.AddData(new Container("Синій контейнер", 1000));
        data.AddData(new Car("Renault Megan", "Легковий автомобіль", 650));
        data.AddData(new Container("Чорний контейнер", 1200));
        data.AddData(new Barrel("Бочка з вином", 150));
        Data res = data.findMax();
        System.out.print("Об'єктом з найбільшим розміром є: \n");
        res.print();
    }
}
