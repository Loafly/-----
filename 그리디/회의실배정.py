n = int(input())

회의리스트 = list()

for i in range(n):
    x, y = map(int, input().split())
    회의리스트.append((x, y))

회의리스트.sort(key= lambda x :(x[1], x[0]))

이전회의끝나는시간 = 0
count = 0

for 시작시간, 종료시간 in 회의리스트:
    if 이전회의끝나는시간 <= 시작시간:
        이전회의끝나는시간 = 종료시간
        count += 1

print(count)