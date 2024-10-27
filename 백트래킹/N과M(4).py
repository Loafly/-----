N, M = map(int, input().split())

def backtrack(n, m, start, sequence):
    # 길이가 m인 수열을 찾으면 출력
    if len(sequence) == m:
        print(" ".join(map(str, sequence)))
        return
    
    # start부터 n까지의 숫자를 순회
    for i in range(start, n + 1):
        # 현재 선택한 숫자를 수열에 추가하고, 다음 단계로 이동
        sequence.append(i)
        backtrack(n, m, i, sequence)
        # 백트래킹 단계: 마지막으로 추가한 숫자를 제거
        sequence.pop()


backtrack(N, M, 1, [])