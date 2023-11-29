def str_print(n, str):
    for i in range(int(n)):
        print(str, end="")


def line_print(num, str):
    str_list = list(str)
    index_range=len(str_list)
    for i in range(index_range):
        str_print(num, str_list[i])


if __name__ == "__main__":
    case_num = int(input())
    num_list = []
    str_list = []
    for i in range(case_num):
        line = input()
        try_num = line.split(" ")[0]
        str_input = line.split(" ")[1]
        num_list.append(try_num)
        str_list.append(str_input)

    for i in range(len(num_list)):
        line_print(num_list[i], str_list[i])
        print()