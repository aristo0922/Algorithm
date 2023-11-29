student_list = [0]*30

SUBMIT_NUM=28

for _ in range(SUBMIT_NUM):
    student_num = int(input())
    student_list[student_num-1]=student_num

for _ in range(30):
    if student_list[_]==0:
        print(_+1)