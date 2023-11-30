import sys

N = int(sys.stdin.readline())
arr = []

for _ in range(N):
    x,y = map(str, sys.stdin.readline().rstrip().split(" "))
    arr.append([int(x),y])

arr.sort(key=lambda arr:arr[0])

for _ in range(N):
    print(arr[_][0], arr[_][1])