import sys


def interger_to_binary(number):
    binary_number = []
    while number >= 1:
        binary_number.append( int(number%2) )

        number /= 2
    binary_number.reverse()
    return binary_number

number = input( "Introduce a number to transform it into binary:\n" )
binary_list = interger_to_binary(int(number))
for item in binary_list:
    sys.stdout.write( str(item) + " " )
