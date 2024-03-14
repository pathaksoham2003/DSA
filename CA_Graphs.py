class Edge:
    def __init__(self,s,d,w):
        self.src = s
        self.dest = d
        self.wt = w

class Graph:
    def __init__(self,graph):
        self.graph = graph
    def allNeighboursOf(self,v):
        tempGraph = self.graph
        for i in range(0,len(tempGraph[v])):
            print(tempGraph[v][i].dest)
    def BFS(self):
        graph = self.graph
        visited = []
        for _ in graph:
            visited.append(False)
        q = []
        q.append(graph[0][0].src)
        while(q):
            print(q)
            curr = q.pop(0)
            print(curr)
            visited[curr] = True
            for i in graph[curr]:
                print(visited)
                if not visited[i.dest] and i.dest not in q:
                    q.append(i.dest)    
    def DFS(self,vertex,visited):
        if visited[vertex]:
            return
        visited[vertex] = True
        print(vertex)
        for i in self.graph[vertex]:
            if not visited[i.dest]:
                self.DFS(i.dest,visited)
    def hasPath(self,v1,v2,visited):
        if v1 == v2:
            return True
        if visited[v1]:
            return False
        visited[v1] = True
        for i in graph[v1]:
            if not visited[i.dest] and self.hasPath(i.dest,v2,visited):
                return True
        return False
    
    def connectedDFS(self):
        visited = []
        for _ in graph:
            visited.append(False)
        for i in range(0,len(graph)):
            self.dfsUtil(i,visited)
    
    def dfsUtil(self,vertex,visited):
        if visited[vertex]:
            return
        print(vertex)
        visited[vertex] = True
        for i in graph[vertex]:
            self.dfsUtil(i.dest,visited)
    
"""
       {5}
   0 ------ 1
           / \
      {1} /   \ {3}
         /     \
        2 ----- 3
        |  {1}
    {2} |
        |
        4
        
       {2}     {4}
    5 ----- 6 ---- 7 
            |      |
         {1}|  {2} |{1}
            9 -----8
            |     /
        {3} |    / {1}
            |   /
             10
"""
V = 11
graph = []
for _ in range(V):
    graph.append([])
##    FOR VERTEX 1    FOR VERTEX 2
## [ [Edge1,Edge2] , [Edge1,Edge2] ]
# FIRST COMPONENT OF GRAPH
graph[0].append(Edge(0,1,5))
graph[1].append(Edge(1,0,5))
graph[1].append(Edge(1,2,1))
graph[1].append(Edge(1,3,3))
graph[2].append(Edge(2,1,1))
graph[2].append(Edge(2,3,1))
graph[2].append(Edge(2,4,2))
graph[3].append(Edge(3,1,3))
graph[3].append(Edge(3,2,1))
graph[4].append(Edge(4,2,2))
# SECOND COMPONENT OF GRAPH
graph[5].append(Edge(5,6,2))
graph[6].append(Edge(6,5,2))
graph[6].append(Edge(6,7,4))
graph[6].append(Edge(6,9,1))
graph[7].append(Edge(7,6,4))
graph[7].append(Edge(7,8,1))
graph[8].append(Edge(8,7,1))
graph[8].append(Edge(8,9,2))
graph[8].append(Edge(8,10,1))
graph[9].append(Edge(9,6,1))
graph[9].append(Edge(9,8,2))
graph[9].append(Edge(9,10,3))
graph[10].append(Edge(10,9,3))
graph[10].append(Edge(10,8,1))

gh = Graph(graph)
gh.allNeighboursOf(1)
gh.BFS()
gh.DFS(0,[False,False,False,False,False])
print(gh.hasPath(0,4,[False,False,False,False,False]))
gh.connectedDFS()