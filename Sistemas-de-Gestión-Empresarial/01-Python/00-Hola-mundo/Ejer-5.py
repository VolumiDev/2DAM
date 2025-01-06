def addition(numberList):
    total = 0
    for num in numberList:
        total += num

    return total

def multiplication(numberlist):
    product = 1
    for num in numberlist:
        product *= num
    return product


def input_boolan():
    flag = False
    input1 = ""

    while input1 != 's' and input1 != 'n':
        input1 = input("Do you want add other number? s/n\n")

    if input1 == 's':
        return True
    else:
        return False


list = []
flag = True
while flag:
    num = input("Introduce a number which add to the list\n")
    list.append(int(num))
    flag = input_boolan()

print(f"The result of addition is: {sum(list)}\n")
print(f"The result of multiplication is: {multiplication(list)}\n")
