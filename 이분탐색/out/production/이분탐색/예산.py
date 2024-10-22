import sys

N = int(input())
array = list(map(int, sys.stdin.readline().split()))
M = int(input())


min_value = 0
max_value = max(array)

while min_value <= max_value:
    mid_value = (min_value + max_value) // 2
    sum_value = 0

    for value in array:
        if value > mid_value:
            sum_value += mid_value
        else:
            sum_value += value
    
    if sum_value > M:
        max_value = mid_value - 1
    else:
        min_value = mid_value + 1

print(max_value)