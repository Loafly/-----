n = int(input())

array = []
dp = dict()

for i in range(n):
    value = int(input())
    array.append(value)


def answer(index):
    
    array[index]

    dp[index] = max(dp[index - 1], dp[index - 2] + dp[index - 3]) + array[index]