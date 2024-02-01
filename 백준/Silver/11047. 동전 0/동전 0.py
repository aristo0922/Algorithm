import sys

N, K = map(int, sys.stdin.readline().split(" "))

coins = []
answer = 0

for _ in range(N):
    coins.append(int(sys.stdin.readline()))

for i in range(N):
    answer += K // coins[N-i-1]
    K = K % coins[N-i-1]

print(answer)