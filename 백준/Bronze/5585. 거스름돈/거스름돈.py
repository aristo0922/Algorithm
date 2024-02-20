paper = 1000
price = int(input())
changes = paper - price
coins = [500, 100, 50, 10, 5, 1]
answer = 0

for coin in coins:
    answer += changes // coin
    changes = changes % coin

print(answer)