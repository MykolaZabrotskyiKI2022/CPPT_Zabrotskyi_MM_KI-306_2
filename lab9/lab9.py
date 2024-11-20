from Laptop import Laptop
from Memory import Memory
from Processor import Processor

def main():
    print("\n\n\n\n\n")

    # Створення компонентів
    processor = Processor("Intel Core i7", 8, 3.5)
    memory = Memory(16, "DDR4")

    # Створення ноутбука
    laptop = Laptop("Dell", "XPS 15", processor, memory, 10, 10)

    # Запуск
    laptop.start()
    laptop.use_battery()

    # Робота з ноутбуком
    laptop.get_specs()

    laptop.install("Microsoft Word")
    laptop.install("Google Chrome")
    laptop.install("Visual Studio Code")
    laptop.list_programs()

    laptop.charge_battery()

    for i in range(10):
        laptop.use_battery()


if __name__ == "__main__":
    main()
