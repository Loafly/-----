     # n 개의 물건
# w : 무게, v : 가치
# k : 최대무개


n, k = map(int, input().split())

arrays = []
answers = []

for i in range(n):
    w, k = map(int, input().split())
    arrays.append((w, k))

arrays.sort()

print(arrays)