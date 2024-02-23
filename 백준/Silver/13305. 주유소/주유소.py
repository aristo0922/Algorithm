import sys

cities = int(sys.stdin.readline())
lengths = list(map(int, sys.stdin.readline().split(" ")))
costs = list(map(int, sys.stdin.readline().split(" ")))


min_cost = costs[0]
length = 0
answer = 0

for index in range(1, cities):
    length += lengths[index - 1]
    if costs[index] <= min_cost:
        answer += length * min_cost
        min_cost = costs[index]
        length = 0
        continue
    if index == cities-1:
        answer += length * min_cost

print(answer)
