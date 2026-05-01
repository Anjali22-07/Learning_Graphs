import java.util.*;

public class GraphRepresentation{
    public static void main(String[] args) {
        
        List<List<Integer>> adj= new ArrayList<>();
        int n=5;
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        //undirected Graph
        adj.get(0).add(1);
        adj.get(1).add(0);
        adj.get(0).add(2);
        adj.get(2).add(0);
        adj.get(0).add(3);
        adj.get(3).add(0);
        adj.get(1).add(3);
        adj.get(3).add(1);
        adj.get(3).add(4);
        adj.get(4).add(3);

        //to print the Graph Representation 
        for(int i=0;i<n;i++){
            System.out.print(i+"->");
             for(int j=0;j<adj.get(i).size();j++){
                     System.out.print("{"+adj.get(i).get(j)+"}");
             }
             System.out.println();
        }
    }
}