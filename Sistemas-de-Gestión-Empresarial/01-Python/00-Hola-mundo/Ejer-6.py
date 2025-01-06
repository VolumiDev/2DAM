

def reverse_string(message):
    reverversed_chain = ""
    index = -1

    while index >= len(message) * -1:
        reverversed_chain = reverversed_chain + message[index]
        index -= 1

    return reverversed_chain

message = input("Introduuce the sentece to reverse\n")

print(reverse_string(message))
