def generar_n_caracteres(number, character):
    n = 0
    cad = ""
    while n < number:
        cad += character
        n += 1
    print(cad)


generar_n_caracteres(10, "x")