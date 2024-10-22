import sys

N, M = input().split()
trees = list(map(int, sys.stdin.readline().split()))

min_value = 0 
max_value = max(trees)

while min_value <= max_value:
    mid_value = (max_value + min_value) // 2
    current_sum_value = 0
    for tree in trees:
        if tree > mid_value:
            current_sum_value += tree - mid_value

    if current_sum_value >= int(M):
        min_value = mid_value + 1
    else:
        max_value = mid_value - 1

print(max_value)