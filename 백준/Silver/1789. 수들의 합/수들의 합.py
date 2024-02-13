import sys

S = int(sys.stdin.readline())
count = 0
result = 0
while True:
    count +=1
    result +=count
    if count >= S-result : break

print(count)