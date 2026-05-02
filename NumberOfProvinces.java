import java.util.LinkedList;
import java.util.Queue;

public class NumberOfProvinces {
    
    public static void main(String[] args) {
        int[][] isConnected= {{1,1,0},{1,1,0},{0,0,1}};
        System.out.println("Number of provinces in the city are:"+findProvinces(isConnected));

    }

    private static  int findProvinces(int[][] isConnected){
      
       int n= isConnected.length;
       boolean[] isVisited= new boolean[n];
       int province=0;
       for(int i=0;i<n;i++){
         if(!isVisited[i]){  //since we do not know which node belongs to a province, we loop through out all the nodes and call bfs function on the not visited nodes
            bfs(isConnected, isVisited, i);
            province++;
         }
       }
       return province;
    }

    private static void bfs(int[][] arr, boolean[] isVisited, int start){
         Queue<Integer> qt= new LinkedList<>();
         qt.add(start);
         isVisited[start]=true;
         while(!qt.isEmpty()){
             int node= qt.poll();
             for(int i=0;i<arr.length;i++){
                 if(arr[node][i]==1 && !isVisited[i]){
                     isVisited[i]=true;
                     qt.add(i);
                 }
             }
         }
    }
}
