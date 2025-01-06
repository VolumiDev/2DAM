 #da la vuelta a una palabra o frase.
def reverse_string(message):
    reverversed_chain = ""
    index = -1

    while index >= len(message) * -1:
        reverversed_chain = reverversed_chain + message[index]
        index -= 1

    return reverversed_chain

def is_palindromo(message):
    if message.replace(" ", "").lower() == reverse_string(message.replace(" ","")).lower():
        return True
    else:
        return False


input1 = input("Introduce a word or a senteces to check if it is a palindromo\n")

if is_palindromo(input1):
    print("Result: It is a palindromo")
else:
    print("Result: It isn't a palindromo")

