import itertools

N,M=map(int,input().split())
card_num = list(map(int, input().split()))

combi_sum = [sum(combi) for combi in itertools.combinations(card_num, 3) if sum(combi)<=M]

print(max(combi_sum))