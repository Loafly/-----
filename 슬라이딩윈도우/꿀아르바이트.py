n, m = map(int, input().split())

arrays = list(map(int, input().split()))

현재월급 = 0
최대월급 = 0

for i in range(m):
    현재월급 += arrays[i]

최대월급 = 현재월급

for i in range(m, len(arrays)):
    현재월급 = 현재월급 + arrays[i] - arrays[i - m]
    최대월급 = max(최대월급, 현재월급)

print(최대월급)