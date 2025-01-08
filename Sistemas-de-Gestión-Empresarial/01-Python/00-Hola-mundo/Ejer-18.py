def input_word():
    word = " "
    while word.isspace() or word.isnumeric():
        word = input("Introduce a word to count vowels")
    return word

def count_vowel(character, word):
    count = 0
    for char in word:
        if char == character: count += 1
    return count

word = input_word()

print(f"There are {count_vowel('a', word)} for vowwel 'a'")
print(f"There are {count_vowel('e', word)} for vowwel 'e'")
print(f"There are {count_vowel('i', word)} for vowwel 'i'")
print(f"There are {count_vowel('o', word)} for vowwel 'o'")
print(f"There are {count_vowel('u', word)} for vowwel 'u'")
