import sys
import collections

N, K = map(int, sys.stdin.readline().split(" "))
todo_que = collections.deque([])

MAX = 10 ** 5 + 1
visited = [0] * MAX
todo_que.append([N])
if N == K :
    print(0)
    exit()
visited[N] = 1


def add_todo(k, list, count):
    arr = find_goal(k)
    if len(arr) != 0:
        visited[arr[0]] = count
        return arr

    if 2 * k <= MAX and visited[2 * k] == 0:
        arr.append(2 * k)
        visited[2 * k] = count
    if k + 1 < MAX and visited[k + 1] == 0:
        arr.append(k + 1)
        visited[k + 1] = count
    if k - 1 >= 0 and visited[k - 1] == 0:
        arr.append(k - 1)
        visited[k - 1] = count
    return list + arr


def find_goal(k):
    if k + 1 == K:
        return [k + 1]
    if k - 1 == K:
        return [k - 1]
    if k * 2 == K:
        return [2 * k]
    return []


count = 1

while True:
    todo_list = todo_que.popleft()
    next_list = []
    for node in todo_list:
        if visited[K] != 0:
            print(visited[K])
            exit()
        next_list = add_todo(node, next_list, count)
    todo_que.append(next_list)
    count += 1
