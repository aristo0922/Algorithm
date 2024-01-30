import sys

N, M = map(int, sys.stdin.readline().strip().split(" "))
names = {}
for _ in range(N):
    name = sys.stdin.readline().strip()
    names[name] = 1


answer = {}
for _ in range(M):
    name = sys.stdin.readline().strip()
    if name in names.keys():
        answer[name]=1

print(len(answer))
answers = list(answer.keys())
answers.sort()
for name in answers:
    print(name)