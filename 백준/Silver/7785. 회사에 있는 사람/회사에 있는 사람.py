import sys

n = int(input())
dict = {}

for _ in range(n):
    line = sys.stdin.readline().strip().split(" ")
    dict[line[0]]=line[1]

name_arr = list(dict.keys())
name_arr.sort()
name_arr.reverse()
for person in name_arr:
    if dict[person] == "enter":
        print(person)