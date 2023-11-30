import sys

num = int(input())
list= [int(sys.stdin.readline()) for i in range(num)]

# for i in range(num):
#     input_num = int(input())
#     list.append(input_num)

list.sort()

for i in range(num):
    print(list[i])