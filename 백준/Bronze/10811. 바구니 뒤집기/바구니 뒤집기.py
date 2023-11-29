N, M = map(int, input().split())
basket_list = [_+1 for _ in range(N)]


for _ in range(M):
    a, b = map(int, input().split())
    temp_list = basket_list[a-1:b]
    temp_list.reverse()
    basket_list[a-1:b]=temp_list


for _ in range(N):
    print(basket_list[_], end=" ")
