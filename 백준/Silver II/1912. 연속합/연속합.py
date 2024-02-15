import sys
import time
# start = time.time()  # 시작 시간 저장


N = int(sys.stdin.readline())

nums = list(map(int, sys.stdin.readline().strip().split(" ")))
sol_arr = []
answer = 0
for num in nums:
    if num < 0:
        if answer + num > 0:
            answer += num
            sol_arr.append(answer)
        else:
            sol_arr.append(num)
            answer = 0
        continue
    answer += num
    sol_arr.append(answer)

print(max(sol_arr))
# print("time :", time.time() - start)  # 현재시각 - 시작시간 = 실행 시간
# 10
# 2 1 -4 3 4 -4 6 5 -5 1
# [3, -4, 7, -4, 11, -5]
# [3, 0, 7, 3, 14, 9]