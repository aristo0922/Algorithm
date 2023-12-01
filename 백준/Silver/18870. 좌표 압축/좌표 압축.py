import sys


N = int(sys.stdin.readline())
line_words = list(map(int, sys.stdin.readline().rstrip().split(" ")))
sorted_word = sorted(list(set(line_words)))

dic = {sorted_word[i] :i for i in range(len(sorted_word))}

for i in line_words:
    print(dic[i], end=" ")