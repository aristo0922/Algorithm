import sys

N = int(sys.stdin.readline())
cards = {}
for card in sys.stdin.readline().strip().split(" "):
    if card not in cards.keys() :
        cards[card]=1
        continue
    cards[card] +=1

M = int(sys.stdin.readline())

for question in sys.stdin.readline().strip().split(" "):
    try:
        print(cards[question], end=" ")
    except:
        print(0, end=" ")
