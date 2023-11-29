words = list(input().upper())
check_table = {}

max_value = 0
max_word = ""


def highest(table, max_value, max_word):
    for key in table.keys():
        if max_value == table[key]:
            max_word += key
    return max_word

for word in words:
    if word in check_table:
        check_table[word] += 1
    else:
        check_table[word] = 1

max_value = max(check_table.values())
max_word=highest(check_table, max_value, max_word)

if len(max_word) == 1:
    print(max_word)
else:
    print("?")
