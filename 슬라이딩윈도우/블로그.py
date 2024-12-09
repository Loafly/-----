n, m = map(int, input().split())
arrays = list(map(int, input().split()))

현재방문자수 = 0
최대방문자수 = 0
최대방문자수반복횟수 = 1

for i in range(m):
    현재방문자수 += arrays[i]

최대방문자수 = 현재방문자수

for i in range(m, len(arrays)):
    현재방문자수 = 현재방문자수 + arrays[i] - arrays[i - m]
    if 최대방문자수 == 현재방문자수:
        최대방문자수반복횟수 += 1
    elif 최대방문자수 < 현재방문자수:
        최대방문자수 = 현재방문자수
        최대방문자수반복횟수 = 1


if 최대방문자수 == 0:
    print("SAD")
else:
    print(최대방문자수)
    print(최대방문자수반복횟수)