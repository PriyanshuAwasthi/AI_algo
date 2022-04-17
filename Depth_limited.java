import java.util.*;

class DepthLimitedSearch {
    ArrayList<ArrayList<Integer>> adj;
    Stack<Integer> stack;

    DepthLimitedSearch(int n) {
        adj = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());
        stack = new Stack<>();
    }

    public static void main(String[] args) {
        int n = 11;
        DepthLimitedSearch g = new DepthLimitedSearch(n);
        g.add_edge(0, 1);
        g.add_edge(0, 2);
        g.add_edge(1, 3);
        g.add_edge(1, 4);
        g.add_edge(2, 5);
        g.add_edge(2, 6);
        g.add_edge(3, 7);
        g.add_edge(3, 8);
        g.add_edge(4, 9);
        g.add_edge(5, 10);
        int src = 0;
        int dest = 6;
        int max_depth = 2;
        g.printDLS(src, dest, n, max_depth);
    }

    private void add_edge(int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }
    private void printDLS(int src, int dest, int n,int max_depth)
    {
        Stack<Integer> stack=new Stack<>();
        boolean visited[]=new boolean[n];
        System.out.println("Path from "+src+" to "+dest+" using DLS is ");
        printDLSUtil(stack,visited,src,dest,max_depth,0);
    }
    ArrayList<Integer> list=new ArrayList<>();
    private void printDLSUtil(Stack<Integer> stack, boolean[] visited, int src, int dest,int max_depth,int depth) 
    {
        list.add(src);
        stack.push(src);
        if(src==dest)
        {
            printPath(list);
            return;
        }
        visited[src]=true;
        if(adj.get(src).size()>0)
        {
            for(int j=0;j<adj.get(src).size();j++)
            {
                if(depth<max_depth)
                {
                if(!visited[adj.get(src).get(j)])
                    printDLSUtil(stack,visited,adj.get(src).get(j),dest,max_depth,depth+1);
                }
            }
        }
        stack.remove(stack.size()-1);
    }
    
    private void printPath(ArrayList<Integer> list)
    {
        
        for(int i = 0; i < list.size() - 1; i++)
        {
            System.out.print(list.get(i) + " -> ");
        }
        System.out.println(list.get(list.size() - 1));
    }
}
