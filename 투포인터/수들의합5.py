n = int(input())

start_num = 1
last_num = 1
count = 0
current_sum = 1


while(True):
    if (current_sum < n and last_num >= n + 1 ):
        break

    if current_sum < n:
        last_num += 1
        current_sum += last_num
    elif current_sum > n:
        current_sum -= start_num
        start_num += 1
    elif current_sum == n:
        count += 1
        current_sum -= start_num
        start_num += 1

print(count)