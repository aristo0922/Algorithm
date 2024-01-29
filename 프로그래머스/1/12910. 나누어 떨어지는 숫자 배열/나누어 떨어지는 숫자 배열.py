def solution(arr, divisor):
    answer = []
    for element in arr:
        temp = element%divisor
        if temp ==0 :
            answer.append(element)
    if len(answer) ==0:
        answer.append(-1)
    else:
        answer.sort()
    return answer