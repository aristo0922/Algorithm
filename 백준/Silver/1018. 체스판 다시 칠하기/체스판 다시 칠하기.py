import sys

count_result = 0
N, M = map(int, input().split(" "))


def get_line(M):
    origin_arr = []

    for _ in range(N):
        line = sys.stdin.readline().strip()
        origin_arr.append(line)

    return origin_arr


def switch_flag(flag):
    if flag == 'W':
        return 'B'
    if flag == "B":
        return 'W'


def count_controller(arr, n):
    flag_color = 'W'
    count_white = 0
    count_black = 0
    count_result = 0

    for i in range(8):
        line = arr[i]
        for ni in range(n, n+8):
            arr_str = line[ni]
            if flag_color == arr_str:
                count_white += 1
            else:
                count_black += 1
            flag_color = switch_flag(flag_color)
        flag_color = switch_flag(flag_color)
    if count_result < count_white:
        count_result = count_white
    if count_result < count_black:
        count_result = count_black

    return count_result

def main_controller(arr):
    count_result =0
    for i in range(0, N-7):
        for j in range(0, M-7):
            in_arr = arr[i:]
            count_here = count_controller(in_arr, j)
            if count_result <count_here:
                count_result = count_here

    return count_result


origin_arr = get_line(M)
result = main_controller(origin_arr)
print(64- result)
