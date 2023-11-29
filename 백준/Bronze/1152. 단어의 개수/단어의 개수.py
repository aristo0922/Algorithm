str_input = input()

str_split = str_input.split(" ")

count =str_split.count("")
for i in range(count):
    str_split.remove("")

str_len = len(str_split)

print(str_len)