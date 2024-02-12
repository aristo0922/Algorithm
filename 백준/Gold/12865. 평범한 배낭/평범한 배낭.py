import sys

N, K = map(int, sys.stdin.readline().split(" "))
things = [(0,0)]

for i in range(N):
    weight, value = map(int, sys.stdin.readline().split(" "))
    things.append((weight, value))

backpack = [[0]*(K+1) for _ in range(N+1)]

for i in range(1, N+1):
    for j in range(1, K+1):
        weight = things[i][0]
        value = things[i][1]

        if j < weight:
            backpack[i][j]=backpack[i-1][j]
        else:
            backpack[i][j]=max(backpack[i-1][j], value+backpack[i-1][j-weight])

print(backpack[N][K])
