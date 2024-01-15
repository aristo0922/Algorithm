n, m = map(int, input().split(" "))
participates = [i + 1 for i in range(n)]

first_result = []

for i in participates:
    temp = int(input().rstrip())
    first_result.insert(temp - 1, i)

second_stage = first_result[:m ]
second_stage.reverse()
second_result = []
for participate in second_stage:
    temp = int(input().rstrip())
    second_result.insert(temp - 1, participate)

for i in range(3):
    print(second_result[i])
