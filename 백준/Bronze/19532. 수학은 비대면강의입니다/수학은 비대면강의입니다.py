import sys

a,b,c,d,e,f = map(int, sys.stdin.readline().rstrip().split(" "))

for x in range(-999, 1000):
    for y in range(-999, 1000):
        if a * x + b * y - c == 0:
            if d * x + e * y - f == 0:
                print(str(x) + " " + str(y))
