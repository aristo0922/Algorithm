import sys

n = int(sys.stdin.readline())
arr = [1, 2, 4]


def get_result(num):
    if num == 1:
        return arr[0]
    if num == 2:
        return arr[1]
    if num == 3:
        return arr[2]

    for i in range(len(arr), num):
        result = arr[i - 3] + arr[i - 2] + arr[i - 1]
        arr.append(result)

    return arr[num - 1]


for _ in range(n):
    print(get_result(int(sys.stdin.readline())))
