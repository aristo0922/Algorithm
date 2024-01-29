from collections import deque

def solution(N, number):
    if number == 1 : return 1
    set_list = []
    
    for count in range(1, 9):
        partial_set = set()
        partial_set.add(int(str(N) *count))
        for index in range(count -1):
            for op1 in set_list[index]:
                for op2 in set_list[-index-1]:
                    partial_set.add(op1 + op2)
                    partial_set.add(op1 * op2)
                    partial_set.add(op1 - op2)
                    if op2 != 0:
                        partial_set.add(op1/op2)
        if number in partial_set:
            return count
        set_list.append(partial_set)
    return -1