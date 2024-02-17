def solution(people, limit):
    answer = 0
    people.sort()   
    count = len(people)
    max_index = len(people)-1
    min_index = 0
    while True:
        answer +=1
        
        max_weight = people[max_index]
        max_index -=1
        count -=1
        if count == 0: return answer
    
        if max_weight + people[min_index] > limit: continue
        min_index +=1
        count -=1
        if count == 0: return answer
    return answer