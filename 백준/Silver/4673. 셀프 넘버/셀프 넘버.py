MAX = 10000
result = [1] * (MAX+1)

for num in range(MAX):
    str_num = str(num)
    temp = 0
    for _ in range(len(str_num)):
        temp += int(str_num[_])
    temp+= num
    if temp <= MAX:
        result[temp]=0

while True:
    try:
        min_index = result.index(1)
        print(min_index)
        result[min_index]=2
    except:
        break

