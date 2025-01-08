
def capital_count(user_string):
    capitals = 0
    for c in user_string:
        if "A" <= c <= "Z":
            capitals += 1
    return capitals



user_string = input( "Introduce a string to count capital letter on it\n" )

print( capital_count(user_string) )