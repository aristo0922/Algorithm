import sys

t_case = int(input())

def bridge(n,m):
    arr = [[0 for _ in range(m+1)] for _ in range(n+1)]
    for i in range(1, m+1) : arr[1][i] = i # N =1 인 경우

    for i in range(2, n+1):
        for j in range(i, m+1):
            for k in range(j, i-1, -1):
                arr[i][j] += arr[i-1][k-1]
    return arr[n][m]

for _ in range(t_case):
    N, M = map(int, sys.stdin.readline().split(" "))
    print(bridge(N, M))

