# Створення зубчастого масиву
def createJagArr(n_rows, filler):
    arr = [] 
    mid_point = n_rows // 2
    for i in range(n_rows):
        num_symbols = i + 1 if i < mid_point else n_rows - i
        arr.append([None] * num_symbols)
    return arr

def fillJagArr(jagged_array, filler):
    for i in range(len(jagged_array)):
        for j in range(len(jagged_array[i])):
            jagged_array[i][j] = filler

def printJagArr(jagged_array):
    for row in jagged_array:
        line = ''.join(row)
        print(line)