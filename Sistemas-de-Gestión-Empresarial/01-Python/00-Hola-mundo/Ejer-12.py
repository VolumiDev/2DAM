def longer_word(word_list):
    longer_word_index = 0
    word_count = 0
    for i in range( len(word_list) ):
        if len( word_list[ i ] ) > word_count:
            word_count = len(word_list[ i ])
            longer_word_index = i

    return word_list[longer_word_index]

word_list = ["caballo", "perro", "esternocleidomastoideo", "Diego"]
print( longer_word( word_list ) )