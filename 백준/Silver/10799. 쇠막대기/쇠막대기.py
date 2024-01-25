import sys

line = sys.stdin.readline().rstrip()

stack = []
result = 0
flag = True


for _ in line:
    if _ == "(":
        stack.append(_)
        flag = True
    if _ == ")":
        if flag == False:
            result +=1
            stack.pop()
        if flag == True:
            stack.pop()
            result += len(stack)
            flag = False
print(result)
