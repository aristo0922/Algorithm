N = int(input())

count = 0
start = 0


def count_one(n):
    str_n = str(n)
    distance =0
    if len(str_n) == 1:
        return 1
    if len(str_n) != 1:
        flag =1
        for i in range(len(str_n)-1):
            n1 = int(str_n[i])
            n2 = int(str_n[i+1])
            if flag ==0 :
                if distance != n2 - n1:
                    return 0
            if flag ==1:
                distance = n2-n1
                flag =0
    return 1


while True:
    start += 1
    count += count_one(start)
    if start == N:
        break

print(count)
