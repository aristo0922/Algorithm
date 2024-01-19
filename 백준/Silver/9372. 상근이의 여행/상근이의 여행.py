import sys

sys.setrecursionlimit(10 ** 6)


class Graph():
    def __init__(self, n):
        self.adj = [[] for _ in range(n)]
        self.count = n
        self.visited = [False for _ in range(n)]
    def set_adj(self, m):
        for _ in range(m):
            node1, node2 = map(int, sys.stdin.readline().split(" "))
            self.adj[node1 - 1].append(node2)
            self.adj[node2-1].append(node1)

    def get_route(self, node, result):
        self.visited[node-1] = True

        for country in self.adj[node-1]:
            if self.visited[country-1] == False:
                result = self.get_route(country, result +1)

        return result


if __name__ == "__main__":
    T = int(input())
    for _ in range(T):
        n, m = map(int, sys.stdin.readline().split(" "))
        graph = Graph(n)
        graph.set_adj(m)
        print(graph.get_route(1, 0))
