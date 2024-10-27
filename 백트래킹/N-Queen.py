# N 입력 받기
n = int(input().strip())

def backtrack(row):
    # N개의 퀸을 모두 배치한 경우
    if row == n:
        return 1

    count = 0
    for col in range(n):
        if col not in columns and (row - col) not in diag1 and (row + col) not in diag2:
            # 퀸 배치 가능, 위치를 추가
            columns.add(col)
            diag1.add(row - col)
            diag2.add(row + col)
            
            # 다음 행으로 이동
            count += backtrack(row + 1)
            
            # 백트래킹: 현재 위치에서 퀸 제거
            columns.remove(col)
            diag1.remove(row - col)
            diag2.remove(row + col)

    return count

# 퀸 배치를 추적하는 집합
columns = set()  # 같은 열에 퀸이 있는지 확인
diag1 = set()    # 왼쪽 대각선 (\) 확인
diag2 = set()    # 오른쪽 대각선 (/) 확인

# 백트래킹 시작
print(backtrack(0))