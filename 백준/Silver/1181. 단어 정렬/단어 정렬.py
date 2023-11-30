import sys

N = int(sys.stdin.readline().rstrip())
text_arr = []

for _ in range(N):
    line = sys.stdin.readline().rstrip()
    if text_arr.count(line) == 0:
        text_arr.append(line)
    if text_arr.count(line) > 0:
        pass

text_arr.sort()
text_arr.sort(key=len)

for text in text_arr:
    print(text)
