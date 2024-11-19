import func

x = float(input("Введіть значення x(у градусах): "))
result = func.calculate(x)
print(f"Result is: {result}")
try:
    func.writeResTxt("textRes.txt", result)
    func.writeResBin("binRes.bin", result)
    print("Result is: {0}".format(func.readResBin("binRes.bin")))
    print("Result is: {0}".format(func.readResTxt("textRes.txt")))
except FileNotFoundError as e:
    print (e)