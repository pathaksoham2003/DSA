class Edge:
    def __init__(self,src,dest,wt):
        self.src = src
        self.dest = dest
        self.wt = wt
        
class Graph:
    def __init__(self,graph):
        self.graph = graph
    
    ## Time : O(V+E)
    def detectCycle(self):
        visited = [False] * len(self.graph)
        for i in range(0,len(self.graph)):
            if not visited[i]:
                if(self.detectCycleUtil(visited,i,-1)):
                    return True
        return False
    
    def detectCycleUtil(self,visited,vertex,par):
        visited[vertex] = True
        for i in self.graph[vertex]:
            if not visited[vertex]:
                if self.detectCycleUtil(visited,i.dest,vertex):
                    return True
            elif visited[i.dest] and i.dest != par:
                return True
    
    ## Cycle Detection with DFS :
"""          Why undirected DFS approach Fails ?
    parent with dfc will fail in a directed graph which is given below
    """        
    ## Time : O(V+E)
    ## Space : O(V)         
    def biPartite(self):
        visited = [-1] * len(self.graph)
        for i in range(0,len(self.graph)):
            if(self.biPartiteUtil(visited,i)):
                return True
        return False
    def biPartiteUtil(self,visited,vertex):
        q = []
        q.append(vertex)
        while len(q):
            vertex = q.pop(0)
            visited[self.graph[vertex][0].src] = 0
            for edge in self.graph[vertex]:
                source = edge.src
                neighbour = edge.dest
                if visited[neighbour] == -1:
                    if visited[source] == 0:
                        visited[neighbour] = 1
                    else:
                        visited[neighbour] = 0
                if visited[source] == visited[neighbour]:
                    return False                
        return True
    ## If we have no cycle or even noded cycle then it is a bipartite
    ## If we have odd nodes cycle then it is not bipartite
    
    ## Cycle d etection in directed graphs :
"""      Hello 
         """
    
V = 5  
"""
   0 -- 3
 / | 
1  |  
 \ |
   2 -- 4
"""      
graph = [[]]*V
graph[0].append(Edge(0,1,1))
graph[0].append(Edge(0,2,1))
graph[0].append(Edge(0,3,1))
graph[1].append(Edge(1,0,1))
graph[1].append(Edge(1,2,1))
graph[2].append(Edge(2,0,1))
graph[2].append(Edge(2,1,1))
graph[2].append(Edge(2,4,1))
graph[3].append(Edge(3,0,1))
graph[4].append(Edge(4,2,1))
graph = Graph(graph)
print(graph.detectCycle())
"""
## BI-PARTITE : FALSE
        0 
      /   \
     /     \
    1       2
    \       /
     3 --- 4
## BI-PARTITE : TRUE    
    0 --- 1
    |     |
    |     |
    2 --- 3
"""
v = 5
graph1 = [[]] * V
graph1[0].append(Edge(0,1,1))
graph1[0].append(Edge(0,2,1))
graph1[1].append(Edge(1,0,1))
graph1[1].append(Edge(1,3,1))
graph1[2].append(Edge(2,0,1))
graph1[2].append(Edge(2,4,1))
graph1[3].append(Edge(3,1,1))
graph1[3].append(Edge(3,4,1))
graph1[4].append(Edge(4,3,1))
graph1[4].append(Edge(4,2,1))
graph = Graph(graph1)
print(graph.biPartite())
V = 4
graph2 = [[]] * V
graph2[0].append(Edge(0,1,1))
graph2[0].append(Edge(0,2,1))
graph2[1].append(Edge(1,0,1))
graph2[1].append(Edge(1,3,1))
graph2[2].append(Edge(2,0,1))
graph2[2].append(Edge(2,3,1))
graph2[3].append(Edge(3,1,1))
graph2[3].append(Edge(3,2,1))
graph = Graph(graph2)
print(graph.biPartite())