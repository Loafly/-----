n = int(input())
m = int(input())

arrays = list(map(int, input().split()))

arrays.sort()
answer = 0

s = 0
e = n - 1

while(True):
    if s >= e:
        break

    current_value = arrays[s] + arrays[e]

    if(current_value == m):
        s += 1
        e -= 1
        answer += 1
    elif (current_value > m):
        e -= 1
    elif (current_value < m):
        s += 1

print(answer)