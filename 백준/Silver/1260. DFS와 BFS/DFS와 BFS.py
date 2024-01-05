import sys
import collections

N, M, V = map(int, sys.stdin.readline().split(" "))


class Graph():
    def __init__(self, n: int):
        self.N = n  # 노드의 개수
        self.adj = [[] for _ in range(n)]

    def set_adj(self, m: int):
        for i in range(m):
            node1, node2 = map(int, sys.stdin.readline().split(" "))

            self.adj[node1 - 1].append(node2)
            self.adj[node2 - 1].append(node1)
            self.adj[node1 - 1].sort()
            self.adj[node2 - 1].sort()

    def get_dfs(self, v: int, Visited: []):  # v: 시작점
        visited = Visited
        print(v, end=" ")
        visited.append(v)
        for node in self.adj[v - 1]:
            if node not in visited:
                visited = self.get_dfs(node, visited)
        return visited

    def get_bfs(self, v: int, Visited: []):
        visited = Visited
        todo_queue = collections.deque([])
        todo_queue.extend(self.adj[v - 1])
        print(v, end=" ")
        visited.append(v)

        while len(todo_queue) != 0:
            node = todo_queue.popleft()
            if node in visited:
                continue
            visited.append(node)
            todo_queue.extend(self.adj[node - 1])
            print(node, end=" ")

        return visited


graph = Graph(N)
graph.set_adj(M)
graph.get_dfs(V, [])
print()
graph.get_bfs(V, [])
