n, s = map(int, input().split())

arrays = list(map(int, input().split()))

start_index = 0
current_sum = 0
answer = float('inf')

for end_index in range(n):
    current_sum += arrays[end_index]

    while current_sum >= s:
        length = end_index - start_index + 1
        answer = min(answer, length)
        current_sum -= arrays[start_index]
        start_index += 1

print(answer if answer != float('inf') else 0)