def procedimiento(list):
    for item in list:
        cad = ""
        while item > 0:
            cad += '*'
            item -= 1
        print(cad)


procedimiento([4,7,5,1])