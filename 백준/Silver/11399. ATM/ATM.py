import sys

N = int(sys.stdin.readline())
time = list(map(int, sys.stdin.readline().split(" ")))
time.sort()

answer = [0 for _ in range(N)]
answer[0] = time[0]
sum = answer[0]

for i in range(1, N):
    answer[i] = answer[i-1]+time[i]
    sum += answer[i]

print(sum)

