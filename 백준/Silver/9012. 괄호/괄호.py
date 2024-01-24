import heapq
import sys

T = int(sys.stdin.readline())

def is_VPS(line):
    line = line
    in_ps = []
    for _ in line:
        if _ == ")":
            try:
                heapq.heappop(in_ps)
                continue
            except:
                print("NO")
                return
        heapq.heappush(in_ps, _)
    if len(in_ps) == 0:
        print("YES")
    else:
        print("NO")

for _ in range(T):
    line = sys.stdin.readline().rstrip()
    is_VPS(line)