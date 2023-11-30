import sys

N =int(sys.stdin.readline())
arr = []
for _ in range(N):
    x,y = map(int, sys.stdin.readline().rstrip().split(" "))
    arr.append([x,y])

arr.sort(key=lambda arr:(arr[1], arr[0]))

for arr_item in arr:
    print(arr_item[0], arr_item[1])
