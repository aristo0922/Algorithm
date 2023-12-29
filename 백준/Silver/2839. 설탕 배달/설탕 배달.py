N = int(input())

kg_5 = 0
kg_3 = 0
result = 5000

if N%5 ==0:
    kg_5 = int(N/5)
    print(kg_5)
else:
    while True:
        N-=3
        kg_3 +=1
        if N<0:
            print(-1)
            break
        if N % 5 == 0:
            kg_5 = (N / 5)
            print(int(kg_5+kg_3))
            break
