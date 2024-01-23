def solution(participant, completion):
    participant = sorted(participant)
    completion = sorted(completion)
    answer = "."
    for i in range(len(completion)):
        if participant[i] != completion[i]:
            answer = participant[i]
            return answer
    return participant[len(participant)-1]

participant =["marina", "josipa", "nikola", "vinko", "filipa"]	
completion = ["josipa", "filipa", "marina", "nikola"]	
answer = solution(participant, completion)
print('"{}"'.format(answer))