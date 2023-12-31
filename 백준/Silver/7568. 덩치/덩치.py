import sys

N = int(input())

people = []
ranks = [1] * N

for _ in range(N):
    [kg, heigh] = map(int, sys.stdin.readline().split(" "))
    people.append([kg, heigh])

for i in range(N - 1):
    for j in range(i + 1, N):
        if people[i][0] > people[j][0]:
            if people[i][1] > people[j][1]:
                ranks[j] += 1
        if people[i][0] < people[j][0]:
            if people[i][1] < people[j][1]:
                ranks[i] += 1

for rank in ranks:
    print(rank, end=" ")
