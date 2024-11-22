from queue import PriorityQueue

n = int(input())

cards = PriorityQueue()

for _ in range(n):
    card = int(input())
    cards.put(card)


answer = 0

while(True):
    card1 = cards.get()

    if(cards.empty()):
        print(answer)
        break

    card2 = cards.get()

    sum_card = card1 + card2

    cards.put(sum_card)
    answer += sum_card
