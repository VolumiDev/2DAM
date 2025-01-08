def superposition(list_1, list_2):
    flag = False
    for item1 in list_1:
        for item2 in list_2:
            if item1 == item2:
                return True
            else:
                flag = False
    return flag

list_1 = [ "perro", 13, "gato" ]
list_2 = [ "raton", 12, "laia" ]

print(superposition(list_1, list_2))