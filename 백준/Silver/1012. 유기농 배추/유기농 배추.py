import sys

sys.setrecursionlimit(10**6)

def init_farm(N: int, M: int):
    farm = [[0 for i in range(M)] for i in range(N)]
    return farm


def set_farm(K: int, farm):
    count = 0
    for _ in range(K):
        temp = sys.stdin.readline().rstrip().split(" ")
        x, y = map(int, temp)
        farm[y][x] = 1
    return farm


def get_result(farm):
    count = 0

    for index_heigh in range(len(farm)):
        for index_width in range(len(farm[index_heigh])):
            if farm[index_heigh][index_width] != 1 : continue
            farm = get_group(farm, index_heigh, index_width)
            count += 1

    return count


def get_group(farm, x, y):
    if farm[x][y] == 0 or farm[x][y]=='V':
        return farm
    if farm[x][y] == 1:
        farm[x][y] = 'V'
    if x + 1 < N:
        farm = get_group(farm, x + 1, y)
    if y + 1 < M:
        farm = get_group(farm, x, y + 1)
    if x - 1 >= 0:
        farm= get_group(farm, x - 1, y)
    if y - 1 >= 0:
        farm = get_group(farm, x, y - 1)

    return farm


if __name__ == "__main__":
    T = int(sys.stdin.readline().rstrip())  # test case

    for i in range(T):
        M, N, K = map(int, sys.stdin.readline().rstrip().split(" "))
        farm = init_farm(N, M)
        farm = set_farm(K, farm)
        print(get_result(farm))
