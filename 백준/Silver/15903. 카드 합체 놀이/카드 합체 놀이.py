import sys
import heapq

n, m =map(int, input().split(" "))
line = list(map(int, sys.stdin.readline().rstrip().split(" ")))
line.sort()


for _ in range(m):
    num1 = heapq.heappop(line)
    num2 = heapq.heappop(line)
    result = num1 + num2
    heapq.heappush(line, result)
    heapq.heappush(line, result)

result =0
for _ in line:
    result += _

print(result)