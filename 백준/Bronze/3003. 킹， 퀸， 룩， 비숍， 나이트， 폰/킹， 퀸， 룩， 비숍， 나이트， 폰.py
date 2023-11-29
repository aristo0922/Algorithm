chess = [1, 1, 2, 2, 2, 8]

line = input()
input = line.split(" ")
length = len(input)

for i in range(length):
    input_num = int(input[i])
    chess[i] = chess[i] - input_num

for i in range(length):
    print(chess[i], end=" ")
