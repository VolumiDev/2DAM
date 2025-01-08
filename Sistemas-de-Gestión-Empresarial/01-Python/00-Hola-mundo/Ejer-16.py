import datetime


def current_year():
    date_year = datetime.datetime.now().year
    current = 0
    while current != date_year:
        current = input( "Introduce current year:" )
    return current


def set_name():
    name = ""
    while name.isnumeric() or name.isspace() or not name:
        name = input("Introduce a name: ")
    return name

def birth_year():
    year = 0
    while year == 0 or year >= datetime.datetime.now().year:
        year = int( input("Introduce the year of birth:") )

    return year



def people(cant):
    people_dic = {}
    for i in range(cant):
        name = set_name()
        year = birth_year()
        people_dic[name] = year
    return people_dic

def age_calculator(number):
    people_dic = people(number)
    now_year = datetime.datetime.now().year
    for name, birth_year in people_dic.items():
        print(f"{name} will have {now_year - birth_year} years.")



age_calculator(3)