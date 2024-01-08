import sys
from collections import deque

N, M = map(int, input().split())
graph = []

for _ in range(N):
    graph.append(list(map(int, sys.stdin.readline().rstrip())))


# BFS
def bfs(x, y):
    # 이동 방향 정의 상하좌우
    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]

    queue = deque()
    queue.append((x, y))

    while queue:
        x, y = queue.popleft()
        # 현재 위치에서 4가지 방향으로 위치 확인
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            # 위치를 벗어나지 않도록 조건 추가
            if nx < 0 or nx >=N or ny < 0 or ny >= M:
                continue

            # 지나갈 수 없는 경로
            if graph[nx][ny] ==0 : continue

            if graph[nx][ny]==1:
                graph[nx][ny] = graph[x][y] +1
                queue.append((nx, ny))
    return graph[N-1][M-1]


print(bfs(0,0))


