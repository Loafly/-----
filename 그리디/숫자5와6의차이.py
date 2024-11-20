a, b =  input().split()

min_a, max_a, min_b, max_b = "", "", "", ""

for ch in a:
    if ch == '5' or ch == '6':
        min_a += '5'
        max_a += '6'
        continue
    
    min_a += ch
    max_a += ch

for ch in b:
    if ch == '5' or ch == '6':
        min_b += '5'
        max_b += '6'
        continue
    
    min_b += ch
    max_b += ch


print(f'{int(min_a) + int(min_b)} {int(max_a) + int(max_b)}')