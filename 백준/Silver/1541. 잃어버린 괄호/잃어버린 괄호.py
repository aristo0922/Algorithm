import sys, re

line = sys.stdin.readline().strip()

pattern1, pattern2 = "[\d]+", "[+|-]"

p1 = re.compile(pattern1)
p2 = re.compile(pattern2)

nums = p1.findall(line)
expression = p2.findall(line)

answer = 0
sums = [0 for _ in range(len(nums))]
answer = int(nums[0])
sums[0] = answer


def set_sums(sums):
    for i in range(1, len(nums)):
        if expression[i - 1] == '-':
            sums[i] = int(nums[i])
        if expression[i - 1] == '+':
            sums[i] += sums[i - 1] + int(nums[i])
            sums[i - 1] = 0
    max_index = sums.index(max(sums))
    try:
        return (sums.index(0), max_index)
    except: return (0, max_index)


result = set_sums(sums)
i=1
while True:
    if i == len(nums): break
    if expression[i - 1] == '+':
        answer += int(nums[i])
    if expression[i - 1] == '-':
        while True:
            if sums[i]!=0:
                break
            i+=1
        answer -= sums[i]
    i +=1

print(answer)
