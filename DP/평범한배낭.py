# n 개의 물건
# w : 무게, v : 가치
# k : 최대무개
n, k = map(int, input().split())
arrays = []
dp = dict()

for i in range(k + 1):
    dp[i] = 0

for i in range(n):
    w, v = map(int, input().split())
    arrays.append((w, v))

for w, v in arrays:
    for j in range(k, w - 1, -1):
        dp[j] = max(dp[j], dp[j - w] + v)

print(dp[k])