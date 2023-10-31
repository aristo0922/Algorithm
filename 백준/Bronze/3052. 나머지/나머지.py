num_lists=[ int(input()) for _ in range(10)]

dummy_list=[]

for _ in range(10):
    dum = num_lists[_]%42
    if dummy_list.count(dum)==0:
        dummy_list.append(dum)

print(len(dummy_list))