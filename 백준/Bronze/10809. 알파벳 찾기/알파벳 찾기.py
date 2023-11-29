STRAT_INDEX = 97
END_INDEX = 122

l = []
def find(s: str, index: int):
    s_list = list(s)
    count = s_list.count(chr(index))
    if count == 0:
        l.append(-1)
    if count != 0:
        s_index = s_list.index(chr(index))
        l.append(s_index)

    return l

def list_print():
    end_index= len(l)
    for i in range(end_index):
        print(str(l[i]), end=" ")

if __name__ == "__main__":
    s_input = input()
    index = STRAT_INDEX
    while True:
        find(s_input, index)
        index += 1
        if index > END_INDEX:
            break

    list_print()

