def max_in_list(lista):
    length = len(lista)
    for i in range(length):
        min_index = i
        for j in range(i+1, length):
            if lista[min_index] > lista[j]:
                min_index = j
        lista[i], lista[min_index] = lista[min_index], lista[i]




lista = [ 8, 9, 4, 2 ,8 ,3 ,7]
# list.sort()
max_in_list( lista )
print( lista )

