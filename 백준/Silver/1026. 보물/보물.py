import sys

N = int(input())

arr_a = list(map(int, sys.stdin.readline().split(" ")))
arr_b = list(map(int, sys.stdin.readline().split(" ")))

count_zero = arr_a.count(0)
for _ in range(count_zero):
    arr_b.pop(arr_b.index(max(arr_b)))
    arr_a.pop(arr_a.index(0))


arr_a.sort()
arr_b.sort()
arr_b.reverse()

sum =0
for index in range(len(arr_b)):
    sum += arr_b[index] * arr_a[index]

print(sum)

