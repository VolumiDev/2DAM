def string_length(message):
    charNumber: int = 0
    for char in message:
        charNumber += 1

    return charNumber

#main_message = input("Enter de message you want to count letters\n")
main_message = [1, 2, 3, 4]
print(f"La longitud es de: {string_length(main_message)}")

