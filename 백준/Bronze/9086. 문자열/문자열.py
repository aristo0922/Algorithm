num_input = int(input())

for i in range(num_input):
    str_input = input()
    str_list = list(str_input)
    str_max = len(str_list)
    print(str_list[0] + str_list[str_max-1])