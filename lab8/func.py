import os
import struct
import math

class CalcException(Exception):
    pass

def writeResTxt(fName, result):
    with open(fName, 'w') as f:
        f.write(str(result))

def readResTxt(fName):
    result = 0.0
    try:
        if os.path.exists(fName):
            with open(fName, 'r') as f:
                result = f.read()
        else:
            raise FileNotFoundError(f"File {fName} not found.")
    except FileNotFoundError as e:
        print(e)
    return result

def writeResBin(fName, result):
     with open(fName, 'wb') as f:
        f.write(struct.pack('f', result))

def readResBin(fName):
    result = 0.0
    try:
        if os.path.exists(fName):
            with open(fName, 'rb') as f:
                result = struct.unpack('f', f.read())[0]
        else:
            raise FileNotFoundError(f"File {fName} not found.")
    except FileNotFoundError as e:
        print(e)
    return result

def calculate(x):
    rad = math.radians(x)
    try:
        sin7x_minus_1 = math.sin(7.0 * rad - 1.0)
        ctgx = math.cos(rad) / math.sin(rad)
        y = ctgx / sin7x_minus_1
        
        if math.isnan(y) or math.isinf(y) or x % 180 == 0:
            raise ArithmeticError()

    except ArithmeticError:
        if x % 180 == 0:
            raise CalcException("Причина виключення: ctg(x) не існує.")
        elif math.sin(7.0 * rad - 1.0) == 0:
            raise CalcException("Причина виключення: sin(7x-1)=0, що є неможливим при діленні.")
        else:
            raise CalcException("Невідома причина виключення.")
    
    return y