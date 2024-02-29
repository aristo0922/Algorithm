import sys

N = int(sys.stdin.readline())

answer = 0


def get_case(N, k):
    sticks = get_sticks(N, k)
    result = 1
    for i in range(sticks + k, k, -1):
        result = result * i
    for i in range(1, sticks + 1):
        result = result // i
    return result


def get_sticks(N, k):
    return N - k * 2


index = 0
while get_sticks(N, index) >= 0:
    answer += get_case(N, index)
    index += 1

print(answer%10007)
