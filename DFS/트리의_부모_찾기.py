import sys
sys.setrecursionlimit(10**6)
N = int(input())
 
graph = [[] for _ in range(N+1)]
for i in range(N-1):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)
 
visited = [0]*(N+1) 
 
def dfs(parent):
    for child in graph[parent]: 
        if visited[child] != 0: # 방문한 적이 있다면
            continue
        visited[child] = parent
        dfs(child)
 
dfs(1)
 
for i in range(2, N+1):
    print(visited[i])
