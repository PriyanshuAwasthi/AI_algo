class Graph:
    def __init__(self, adjacency_list):
        self.adjacency_list=adjacency_list
    def get_neighbors(self,v):
        return self.adjacency_list[v]
    def h(self,n):
        H={
            'S':5,
            'A':3,
            'B':4,
            'C':2,
            'D':6,
            'G':0
        }
        return H[n]
    def a_star(self,src,dest):

        open_list = set([src])
        closed_list = set([])
        g = {}
        g[src]=0
        parents={}
        parents[src]=src
        while len(open_list) > 0:
            n = None
            for v in open_list:
                if n == None or g[v] + self.h(v) < g[n] + self.h(n):
                    n = v

            if n == None:
                print('Path does not exist!')
                return None

            if n == dest:
                reconst_path = []

                while parents[n] != n:
                    reconst_path.append(n)
                    n = parents[n]
                reconst_path.append(src)
                reconst_path.reverse()
                print('Path found: {}'.format(reconst_path))
                return reconst_path

            for (m, weight) in self.get_neighbors(n):
                if m not in open_list and m not in closed_list:
                    open_list.add(m)
                    parents[m] = n
                    g[m] = g[n] + weight
                else:
                    if g[m] > g[n] + weight:
                        g[m] = g[n] + weight
                        parents[m] = n

                        if m in closed_list:
                            closed_list.remove(m)
                            open_list.add(m)
            open_list.remove(n)
            closed_list.add(n)

        print('Path does not exist!')
        return None
adjacency_list = {
    'S': [('A', 1), ('G', 10)],
    'A': [('B', 2),('C',1)],
    'B': [('D', 5)],
    'C': [('D', 3),('G',4)],
    'D':[('G',2)]
}
graph1 = Graph(adjacency_list)
graph1.a_star('S', 'G')
