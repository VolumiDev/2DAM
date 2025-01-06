def max_value(n1, n2):
    if n1 > n2:
        print(str(n1) + ": es el mayor")
    elif n2 > n1:
        print(str(n2) + ": es el mayor")
    else:
        print("Los numero son iguales")



flag = True
while(flag):
    exit_key = 'q'
    number1 = int(input("Introduce el primer numero\n"))
    number2 = int(input("Introduce el segundo numero\n"))

    max_value(number1, number2)

    while(exit_key != 's' and exit_key != 'n'):
        exit_key = input("¿Quiere seguir introduciendo numeros? s/n\n")
        if exit_key == 's' : flag = True
        else : flag = False





