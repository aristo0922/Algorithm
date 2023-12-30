import itertools
list=[]

for i in range(9):
    list.append(int(input()))

combi = [combi for combi in itertools.combinations(list, 7) if sum(combi)==100]

for l in sorted(combi[0]):
    print(l)