import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class KeysAndRooms {

    public static void main(String[] args) {
        List<List<Integer>> adj=new ArrayList<>();
        adj.add(Arrays.asList(1, 3));
        adj.add(Arrays.asList(3, 0, 1));
        adj.add(Arrays.asList(2));
        adj.add(Arrays.asList(0));
        System.out.println(KeysAndRooms(adj));
    }

    private static boolean KeysAndRooms(List<List<Integer>> rooms){
          
           int n= rooms.size();
            boolean[] isVisited= new boolean[n];
          isVisited[0]=true; //as given in the question-- room 0 us always unlocked
           for(int i=0;i<n;i++){
             if(isVisited[i]){
                bfs(rooms, isVisited, i);
             }else if(!isVisited[i]){
                  return false;
             }
           }
           return true;
    }


    private static void bfs(List<List<Integer>> adj, boolean[] isVisited, int start){
         Queue<Integer> qt= new LinkedList<>();
         qt.add(start);
         isVisited[start]=true;
         while(!qt.isEmpty()){
             int node= qt.poll();

              for(int neighbour: adj.get(node)){
                if(!isVisited[neighbour]){
                    isVisited[neighbour]=true;
                    qt.add(neighbour);
                }
              }
         }
    }
      
    
}
