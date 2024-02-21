import sys

SIZE = 6

def lotto(arr, s, index, state):
    if state == SIZE:
        for node in arr:
            print(node, end= " ")
        print()
        return

    for i in range(index, len(s)):
        arr[state] = s[i]
        lotto(arr, s, i+1, state+1)


while True:
    line = list(map(int, sys.stdin.readline().strip().split(" ")))
    if line[0] == 0 : break
    arr = [0] * SIZE
    lotto(arr, line[1:], 0, 0)
    print()


