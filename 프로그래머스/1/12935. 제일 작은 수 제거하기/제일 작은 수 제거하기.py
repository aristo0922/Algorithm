def solution(arr):
    if len(arr)==1 : return [-1]
    min_num = min(arr)
    index = arr.index(min_num)
    arr.pop(index)
    answer = arr
    return answer