import heapq
import sys

heap=[]
N = int(input())

for _ in range(N):
    x = int(sys.stdin.readline())
    if x ==0:
        try:
            print(heapq.heappop(heap))
        except(IndexError):
            print(0)
        continue
    heapq.heappush(heap, x)