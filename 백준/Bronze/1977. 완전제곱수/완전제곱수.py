M = int(input())
N = int(input())
start = 1
result_arr = []
while True:
    if start * start < M:
        start += 1
        continue
    if start * start > N:
        break
    result_arr.append(start * start)
    start += 1

if len(result_arr) > 0:
    print(sum(result_arr))
    print(min(result_arr))

else:
    print(-1)
