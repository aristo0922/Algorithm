import sys

cases = int(sys.stdin.readline())

arr_zero = [1, 0]
arr_one = [0, 1]


def result(N, arr_zero, arr_one):
    for index in range(len(arr_zero), N+1):
        arr_zero.append(arr_zero[index - 1] + arr_zero[index - 2])
        arr_one.append(arr_one[index - 1] + arr_one[index - 2])
    print(arr_zero[N], end=" ")
    print(arr_one[N])

for _ in range(cases):
    N = int(sys.stdin.readline())
    result(N, arr_zero, arr_one)