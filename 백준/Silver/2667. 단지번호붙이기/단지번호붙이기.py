import sys
from collections import deque

N = int(input())
homes = []
towns = []

for _ in range(N):
    homes.append(list(map(int, sys.stdin.readline().strip())))

def visit_node(n, m, homes):
    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]

    todo_queue = deque([])
    todo_queue.append((n, m))
    homes[n][m]='L'
    count = 0

    while todo_queue:
        x, y = todo_queue.popleft()
        count += 1
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if nx < 0 or ny < 0 or nx >= N or ny >= N:
                continue
            if homes[nx][ny] == 1:
                todo_queue.append((nx, ny))
                homes[nx][ny] = 'L'

    return (homes, count)


for n in range(N):
    for m in range(N):
        if homes[n][m] == 1:
            homes, count = visit_node(n, m, homes)
            towns.append(count)

print(len(towns))
for town in sorted(towns):
    print(town)
