result = 0

for _ in range(10):
    n = int(input())
    distance_result = 100 - result
    distance_plus = (result + n) -100
    if result + n >= 100:
        if distance_result < distance_plus:
            break
        else:
            result += n
            break
    else:
        result += n

print(result)
