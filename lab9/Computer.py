import time
import sys

class Computer:
    def __init__(self, brand, model, processor, memory):
        self.brand = brand
        self.model = model
        self.processor = processor
        self.memory = memory
        self.installed_programs = []

    def get_specs(self):
        return f"Бренд: {self.brand}\n\tМодель: {self.model}\n\tПроцесор: {self.processor.details()}\n\tОперативна пам'ять: {self.memory.details()}"

    def start(self):
        point = ""
        for i in range(4):
            point = point + "."
            print ("______________________________________________________________\n\n\n\n")
            if (i<3):
                print ("Запуск комп'ютера" + point)
            if (i==3):
                print ("Комп'ютер успішно завантажено.")
            print ("\n\n\n\n______________________________________________________________")
            time.sleep(2)

    def shut_down(self):
        point = ""
        for i in range(4):
            point = point + "."
            print ("______________________________________________________________\n\n\n\n")
            if (i<3):
                print ("Завершення роботи" + point)
            if (i==3):
                print ("Комп'ютер успішно завершив роботу.")
            print ("\n\n\n\n______________________________________________________________")
            time.sleep(2)
        sys.exit(1)

    def install(self, program_name):
        self.installed_programs.append(program_name)

    def list_programs(self):
        print ("______________________________________________________________\n")
        print ("Список встановлених програм:\n")
        for i in range(len(self.installed_programs)):
            print(f"{i+1}: {self.installed_programs[i]}")
        print ("\n\n\n\n______________________________________________________________")
        time.sleep(2)