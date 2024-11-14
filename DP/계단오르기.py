n = int(input())

array = [0]
dp = dict()

for i in range(1, n + 1):
    value = int(input())
    array.append(value)

    if i == 1:
        dp[i] = value
    elif i == 2:
        dp[i] = dp[i - 1] + value
    elif i == 3:
        dp[i] = max(dp[i - 2] + value, array[i - 1] + value)


if n > 3:
    for i in range(4, n + 1):
        dp[i] = max(dp[i - 3] + array[i - 1], dp[i - 2]) + array[i]


print(dp[n])