N = int(input())
result = N


def check_str(line):
    if len(line) == 1: return True
    if len(line) == 0: return True
    if line[0] == line[len(line) - 1]:
        line = line[1:-1]
        return check_str(line)
    else:
        return False


def check_prime(num):
    index = 2
    while True:
        if index == num:
            break
        if num % index == 0:
            return False
        index += 1
    return True


while True:
    if result == 1:
        result = 2
        break
    if check_str(str(result)) == True:
        if check_prime(result) == True:
            break
    result += 1
print(result)
