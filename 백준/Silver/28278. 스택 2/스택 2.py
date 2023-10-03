stack = []

def order_1(input_x):
    stack.append(input_x)

def order_2():
    if len(stack)==0:
        print(-1)
    else:
        print(stack.pop())

def order_3():
    print(len(stack))

def order_4():
    if len(stack)==0:
        print(1)
    else:
        print(0)

def order_5():
    if len(stack)==0:
        print(-1)
    else:
        print(stack[len(stack)-1])





import sys
first_input=int(input())

for _ in range(first_input):
    input = sys.stdin.readline()
    order = int(input.split()[0])
    if order ==1:
        order_1(int(input.split()[1]))
    elif order ==2:
        order_2()
    elif order ==3:
        order_3()
    elif order ==4:
        order_4()
    elif order ==5:
        order_5()