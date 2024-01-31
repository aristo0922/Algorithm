import sys

N = int(sys.stdin.readline())
arr = {}
end_arr=set([])

for _ in range(N):
    start_time, end_time = map(int, sys.stdin.readline().split(" "))
    end_arr.add(end_time)
    if end_time in arr.keys():
        arr[end_time].append(start_time)
        continue
    arr[end_time] = [start_time]


start =0
count =0
end_arr=list(end_arr)
end_arr.sort()
for end in end_arr:
    if end < start :
        continue

    list = sorted(arr[end])
    for start_time in list:
        if start <= start_time:
            start = end
            count +=1

print(count)