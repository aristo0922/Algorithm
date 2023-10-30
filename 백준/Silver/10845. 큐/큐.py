queue=[]

import sys

X = int(sys.stdin.readline())

for i in range(X):
    user_input = sys.stdin.readline().split()

    if user_input[0] =="push":
        queue.insert(len(queue), user_input[1])

    elif user_input[0] == "pop":
        if len(queue) != 0 : print(queue.pop(0))
        else: print(-1)

    elif user_input[0]=="size":
        print(len(queue))

    elif user_input[0] =="empty":
        if len(queue)==0: print(1)
        else: print(0)

    elif user_input[0]=="front":
        if len(queue) ==0 : print(-1)
        else: print(queue[0])

    elif user_input[0]=="back":
        if len(queue) ==0 : print(-1)
        else :print(queue[len(queue)-1])
