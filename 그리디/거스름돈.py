# 잔돈 : 500, 100, 50, 10, 5, 1

n = int(input())
coins = [500, 100, 50, 10, 5, 1]
count = 0

rest = 1000 - n

for coin in coins:
    count += rest // coin
    rest = rest % coin 

print(count)