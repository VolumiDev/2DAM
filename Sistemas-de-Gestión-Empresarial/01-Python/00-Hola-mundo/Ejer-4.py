def vocal_detector(message):
    if message == 'a' or message =='e' or message =='i' or message =='o' or message =='u':
        return True
    else :
        return False



var = "qwe"
while (len(var) != 1 ):
    var = input("Introduce a letter to test if it is a vowel")

print(vocal_detector(var))

