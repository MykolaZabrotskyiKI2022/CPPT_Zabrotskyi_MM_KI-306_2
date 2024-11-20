from Computer import Computer
import time

class Laptop(Computer):
    def __init__(self, brand, model, processor, memory, battery_life, current_battery_life):
        super().__init__(brand, model, processor, memory)
        self.battery_life = battery_life
        self.current_battery_life = battery_life

    def get_specs(self):
        print ("______________________________________________________________\n")
        print("Характеристики ноутбука:\n\t" + super().get_specs())
        print("\tЧас автономної роботи: " + str(self.battery_life) + " годин")
        print ("\n\n______________________________________________________________")
        time.sleep(2)
    
    def use_battery(self):
        self.current_battery_life-=1
        if (self.current_battery_life==0):
            print ("______________________________________________________________\n\n\n\n")
            print("Батарея розрядженна, завершення роботи.")
            print ("\n\n\n\n______________________________________________________________")
            time.sleep(2)
            super().shut_down()

    def charge_battery(self):
        point = ""
        for i in range(4):
            point = point + "."
            print ("______________________________________________________________\n\n\n\n")
            if (i<3):
                print ("Триває зарядка батареї" + point)
            if (i==3):
                print ("Батарея успішно заряджена.")
            print ("\n\n\n\n______________________________________________________________")
            time.sleep(2)
        self.current_battery_life=self.battery_life