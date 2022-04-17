import java.util.*;
class Node{
    int hv;
    int node;
    Node(int node,int hv){
        this.node=node;
        this.hv=hv;
    }
}
class BestFirst
{
    ArrayList<ArrayList<Integer>> adj;
    PriorityQueue<Node> pq;
    int heuristicValues[];
    BestFirst(int n) {
        adj = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());
        this.pq=new PriorityQueue<>((a,b)->a.hv-b.hv);
    }
    public static void main(String[] args) {
        int n = 10;
        BestFirst g = new BestFirst(n);
        g.add_edge(0, 1);
        g.add_edge(0, 2);
        g.add_edge(1, 3);
        g.add_edge(1, 4);
        g.add_edge(2, 5);
        g.add_edge(2, 6);
        g.add_edge(5, 7);
        g.add_edge(6, 8);
        g.add_edge(6, 9);
        
        int src = 0;
        int dest = 9;
        g.heuristicValues=new int[]{13,12,4,7,3,8,2,4,9,0};
        System.out.println("Path from "+src+" to "+dest+" using Best First Search is");
        g.bestFirstSearch(n,src,dest);
    }
    private void bestFirstSearch(int n,int src, int dest) 
    {
        boolean visited[]=new boolean[n];
        pq.add(new Node(src,heuristicValues[src]));
        visited[src]=true;
        while(!pq.isEmpty())
        {
            int minNode=pq.remove().node;
            System.out.print(minNode+" ");
            if(minNode==dest)
                break;
            for(int i=0;i<adj.get(minNode).size();i++)
            {
                if(!visited[adj.get(minNode).get(i)])
                {
                    visited[adj.get(minNode).get(i)]=true;
                    pq.add(new Node(adj.get(minNode).get(i),heuristicValues[adj.get(minNode).get(i)]));
                }
            }
        }
    }
    private void add_edge(int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }
}
