import sys

N, K = map(int, sys.stdin.readline().split(" "))

list_N = [0]
if N ==1 :
    list_N.append(1)

for i in range(1, N+1):
    if N % i == 0:
        list_N.append(i)

try:
    print(list_N[K])
except:
    print(list_N[0])
