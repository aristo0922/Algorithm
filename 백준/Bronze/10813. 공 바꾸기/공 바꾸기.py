basket_Num, try_nuM=map(int, input().split())

ball_list=list(range(1, basket_Num+1))

def swap(a: int, b: int):
    ball_list[a-1], ball_list[b-1]= ball_list[b-1], ball_list[a-1]

for i in range(try_nuM):
    basket_a, basket_b = map(int, input().split())
    swap(basket_a, basket_b)

for ball in ball_list:
    print(ball, end=" ")