def solution(x):
    sum=0
    for x_str in str(x):
        sum += int(x_str)
    if x % sum == 0 :
        answer = True
    if x % sum !=0 :
        answer = False
    return answer