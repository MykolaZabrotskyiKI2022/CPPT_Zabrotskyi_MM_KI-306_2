# Імпортуємо необхідні модулі
import sys
import func

n_rows = int(input("\nВведіть розмір зубчастого масиву: "))
print(f"Розмір вашого зубчастого масиву: {n_rows} x {n_rows}")

filler = input("\nВведіть символ заповнювач: ")
if len(filler) == 0:
    print("\nНе введено символ заповнювач.\n")
    sys.exit(1)
elif len(filler) > 1:
    print("\nЗабагато символів заповнювачів.\n")
    sys.exit(1)

jagged_array=func.createJagArr(n_rows, filler)

func.fillJagArr(jagged_array, filler)

func.printJagArr(jagged_array)