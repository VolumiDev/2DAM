def word_filter(word_list, count):
    filtered_words = []
    for word in word_list:
        if len(word) >= count:
            filtered_words.append( word )
    return filtered_words


word_list = ["perro", "poni", "caballlito", "raton"]

print(word_filter( word_list, 6))