line = input().split(" ")

def set_game(num):
    participates = input().split(" ")
    for i in range(len(participates)):
        participates[i] = int(participates[i])
    participates.sort()
    return participates

def get_result(list, price):
    print(list[-int(price)])

participate=set_game(line[0])
get_result(participate, line[1])