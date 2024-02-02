import sys

n= int(sys.stdin.readline())
weights = []
for _ in range(n):
    temp = int(sys.stdin.readline())
    weights.append(temp)

weights.sort()

answer_arr = []
for index in range(n):
    answer = weights[index] * (n-index)
    answer_arr.append(answer)

print(max(answer_arr))