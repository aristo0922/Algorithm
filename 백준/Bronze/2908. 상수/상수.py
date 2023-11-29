def check(num1, num2):
    num1 = list(num1)
    num2 = list(num2)

    index_list = [2, 1, 0]
    for i in index_list:
        if int(num1[i]) > int(num2[i]):
            return 1
        if int(num1[i]) < int(num2[i]):
            return 2

    return False


def main():
    line_input = input()

    first_num = line_input.split(" ")[0]
    second_num = line_input.split(" ")[1]

    check_flag = check(first_num, second_num)

    if check_flag == 1:
        print(first_num[2] + first_num[1] + first_num[0])
        return
    if check_flag == 2:
        print(second_num[2] + second_num[1] + second_num[0])
        return


if __name__ == "__main__":
    main()
