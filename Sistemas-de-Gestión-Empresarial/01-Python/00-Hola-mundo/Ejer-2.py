def max_value(n1, n2, n3):
    if n1 > n2 and n1 > n3:
        return n1
    elif n2 > n1 and n2 > n3:
        return n2
    elif n3 > n1 and n3 > n2:
        return n3
    elif n1 == n2 and n2 == n3:
        return "Los numeros son iguales"
    elif n1 == n2:
        if n2 > n3:
            return n2
        else:
            return n3
    elif n2 == n3:
        if n2 > n1:
            return n2
        else:
            return n1
    elif n1 == n3:
        if n3 > n2:
            return n3
        else:
            return n2

flag = True
while(flag):
    exit_key = 'q'
    number1 = int(input("Introduce el primer numero\n"))
    number2 = int(input("Introduce el segundo numero\n"))
    number3 = int(input("Introduce el tercer numero\n"))

    print( max_value(number1, number2, number3) )
    while(exit_key != 's' and exit_key != 'n'):
        exit_key = input("¿Quiere seguir introduciendo numeros? s/n\n")
        if exit_key == 's' : flag = True
        else : flag = False



