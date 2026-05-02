import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ValidPath {
    
    public static void main(String[] args) {
        int[][] edges={
            {0,1},
            {0,2},
            {3,5},
            {5,4},
            {4,3}
        };
        int n= 6;
        int source=0;
        int destination=5;
        System.out.println(validPath(n, edges, source, destination));
    }

    private static boolean validPath(int n, int[][] edges,int source, int destination){
         List<List<Integer>> adj= new ArrayList<>();
          boolean[] isVisited= new boolean[n];
           for(int i=0;i<n;i++){
             adj.add(new ArrayList<>());
           }

           for(int[] edge: edges){
             int u= edge[0];
             int v= edge[1];
              
               adj.get(u).add(v);
               adj.get(v).add(u);
           }

         return  bfs(n, adj, isVisited, source, destination);
    }

    private static boolean bfs(int n, List<List<Integer>> adj, boolean[] isVisited ,int source, int destination){
         
         Queue<Integer> qt= new LinkedList<>();
         qt.add(source);
         isVisited[source]=true;
          
           while(!qt.isEmpty()){
            int node= qt.poll();
             
             if(node==destination)  return true;
              for(int neighbour : adj.get(node)){
                 if(!isVisited[neighbour]){
                     isVisited[neighbour]=true;
                      qt.add(neighbour);
                    }
              }
           }
           return false;
    }
}
