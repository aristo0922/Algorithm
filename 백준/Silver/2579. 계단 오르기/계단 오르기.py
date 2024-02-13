import sys

N = int(sys.stdin.readline())
scores = []
for _ in range(N):
    scores.append(int(sys.stdin.readline()))

# 0 -> from -1 stair, 1 -> from -2 stair
stairs = [(0,0)]
stairs.append((scores[0], scores[0]))

for index in range(2, N+1):
    node1=scores[index-1] + stairs[index-1][1]
    node2 = scores[index-1] + max(stairs[index-2])
    stairs.append((node1, node2))
    
print(max(stairs[N]))