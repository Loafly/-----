n, m = map(int, input().split())
arrays = list(map(int, input().split()))


start_index = 0
end_index = 0
current_sum = arrays[start_index]
answer = 0

while(True):
    if start_index >= n:
        break

    if arrays[end_index] >= m:
        if arrays[end_index] == m:
            answer += 1

        if end_index < n - 1:
            end_index += 1
            start_index = end_index
            current_sum = arrays[end_index]
            continue
        else:
            break

    if current_sum < m:
        end_index += 1
        if end_index >= n:
            break
        current_sum += arrays[end_index]
    elif current_sum > m:
        current_sum -= arrays[start_index]
        start_index += 1
    elif current_sum == m:
        answer += 1
        current_sum -= arrays[start_index]
        start_index += 1    

print(answer)