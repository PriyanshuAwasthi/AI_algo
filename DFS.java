import java.util.*;
public class Graph_DFS {
 
    private int V; 
    private LinkedList<Integer> adj[];
 
    Graph_DFS(int v)
    {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList();
    }
 
   
    void addEdge(int v, int w)
    {
        adj[v].add(w); 
        adj[v].add(w);
    }
 
    void DFSUtil(int v, boolean visited[])
    {
        visited[v] = true;
        System.out.print(v + " ");
 
        Iterator<Integer> i = adj[v].listIterator();
        while (i.hasNext()) {
            int n = i.next();
            if (!visited[n])
                DFSUtil(n, visited);
        }
    }

    void DFS(int v)
    {
   
        boolean visited[] = new boolean[V];
 
      
        DFSUtil(v, visited);
    }
 
    public static void main(String args[])
    {
        Graph_DFS g = new Graph_DFS(6);
 
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(1, 5);
        g.addEdge(2, 4);
 
        System.out.println(
            "Following is Depth First Traversal "
            + "(starting from vertex 2)");
 
        g.DFS(0);
    }
}
