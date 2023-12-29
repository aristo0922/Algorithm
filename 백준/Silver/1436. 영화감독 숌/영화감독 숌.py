num = int(input())
target_num=666
result_count=0

while True:
    if '666' in str(target_num):
        result_count+=1

    if result_count == num:
        break
    target_num +=1

print(target_num)