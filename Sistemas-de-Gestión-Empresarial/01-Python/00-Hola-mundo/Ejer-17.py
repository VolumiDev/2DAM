def input_data():
    people = []

def higher_than_20(ages):
    count = 0
    for i in range(len(ages)):
        if ages[i] > 20: count += 1
    return count

my_tuple = [20, 25, 14, 7, 45, 65, 80, 3, 9, 10]

print( f"There are {higher_than_20(my_tuple)} persons with more than 20 years old")