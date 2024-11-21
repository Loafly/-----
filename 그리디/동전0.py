n, k = map(int, input().split())

coins = []

for _ in range(n):
    coins.append(int(input()))


coins.sort(reverse=True)

count = 0

for coin in coins:
    count += k // coin
    k = k % coin 

    if k == 0:
        break

print(count)