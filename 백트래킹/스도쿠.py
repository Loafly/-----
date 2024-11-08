x, y = 9, 9

# arrays = [[0 for i in range(x)] for j in range(y)]
arrays = []


# 세로에 중복이 있는지 확인
columns = [set() for i in range(9)]
# 가로에 중복이 있는지 확인
rows = [set() for i in range(9)]
# 3x3 안에 중복 확인
boxes = [set() for i in range(9)]

# 빈 칸 위치 저장 리스트 -> 시간초과 이슈로 추가
empty_cells = []

for i in range(x):
    row = list(map(int, input().split()))
    arrays.append(row)
    rows[i] = set(num for num in row if num != 0)

    for j in range(y):
        if row[j] == 0:
            empty_cells.append((i, j))
        elif row[j] != 0:
            columns[j].add(row[j])
            box_index = (i // 3) * 3 + (j // 3)
            boxes[box_index].add(row[j])
            
    

def backtrack(index):
    if index == len(empty_cells):
            return True
    i, j = empty_cells[index]
    # for i in range(9):
        # for j in range(9):
            # if arrays[i][j] == 0:
                # 1 ~ 9 까지 전부 대입
    for k in range(1, 10):
        box_index = (i // 3) * 3 + (j // 3)
        if k not in columns[j] and k not in rows[i] and k not in boxes[box_index]:
            arrays[i][j] = k
            columns[j].add(k)
            rows[i].add(k)
            boxes[box_index].add(k)

            if backtrack(index + 1):
                return True
            
            arrays[i][j] = 0
            columns[j].remove(k)
            rows[i].remove(k)
            boxes[box_index].remove(k)
    
    return False
    # return True

if backtrack(0):
    for row in arrays:
        print(" ".join(map(str, row)))