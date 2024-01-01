import sys

N = int(input())
connected_sum = int(input())
networks = [ [0 for _ in range(N)] for row in range(N)]

for i in range(connected_sum):
    a, b =map(int, sys.stdin.readline().split(" "))
    networks[a-1][b-1]=1
    networks[b-1][a-1]=1

connected_arr= [0]*N
def find_connection(i, networks, arr):
    count =0
    for _ in range(N):
        if arr[_]==1:
            continue
        if networks[i][_] ==1:
            arr[_]=1
            count +=1
            count += find_connection(_, networks, arr)
    return count

connected_arr[0]=1
count = find_connection(0, networks, connected_arr)

print(count)