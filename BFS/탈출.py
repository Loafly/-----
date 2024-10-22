from collections import deque

N, M = map(int, input().split())

graph = [list(input().strip()) for _ in range(N)]
distance = [[0] * M for _ in range(N)]

# 상하좌우
dx, dy = [-1, 1, 0, 0], [0, 0, -1, 1]

queue = deque()

#비버 집, 비버 위치
for i in range(N):
    for j in range(M):
        if graph[i][j]=='D':
            Dx,Dy = i,j
        elif graph[i][j]=='S':
            queue.append((i,j))

#물의 위치
for i in range(N):
    for j in range(M):
        if graph[i][j]=='*':
            queue.append((i,j))

def bfs(Dx,Dy):
    while queue:
        x,y = queue.popleft()

        if graph[Dx][Dy] == 'S':
            return distance[Dx][Dy]
                
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if nx < 0 or nx >= N or ny < 0 or ny >= M:
                continue
        
            if (graph[nx][ny] == '.' or graph[nx][ny] == 'D') and graph[x][y] == 'S':
                distance[nx][ny] = distance[x][y] + 1
                graph[nx][ny]='S'
                queue.append((nx,ny))
            
            elif (graph[nx][ny] == '.' or graph[nx][ny] == 'S') and graph[x][y] == '*':
                graph[nx][ny]='*'
                queue.append((nx,ny))     
    
    return "KAKTUS"


print(bfs(Dx,Dy))