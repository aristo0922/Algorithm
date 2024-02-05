import sys
N = int(sys.stdin.readline())
answer_arr = []

answer_arr.append(0)
answer_arr.append(1)
answer_arr.append(1)


for n in range(N):
    if n+1 in [1,2,3]:
        continue
    arr = []
    arr.append(answer_arr[n-1]+1)
    if (n+1)%2 ==0:
        part2 = int((n+1)/2)
        arr.append(answer_arr[part2-1]+1)
    if (n+1)%3 ==0:
        part3 = int((n+1)/3)
        arr.append(answer_arr[part3-1]+1)
    answer = min(arr)
    answer_arr.append(answer)


print(answer_arr[N-1])