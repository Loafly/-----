n = int(input())


dp = {
    0 : 0, 
    1 : 1, 
    2 : 1
    }


def fibonacci(n):
    if n in dp:
        return

    if n - 1 not in dp:
        fibonacci(n - 1)

    dp[n] = dp[n - 1] + dp[n - 2]


fibonacci(n)

print(dp[n])