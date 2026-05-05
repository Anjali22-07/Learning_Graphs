import java.util.*;

public class NumberOfIslands {
    
    public static void main(String[] args) {
         char[][] grid = { {'1','1','0','1','0'},
                           {'1','1','0','1','0'},
                           {'1','1','0','0','0'},
                           {'0','0','0','0','0'}
                         };

       System.out.println(isIslands(grid));
    }

    private static int isIslands(char[][] grid){
         int n= grid.length;
         int m=grid[0].length;
         int count=0; //to count the number of islands
         boolean[][] isVisited= new boolean[n][m];
         for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                 if(!isVisited[i][j] && grid[i][j]=='1'){
                     bfs(grid, isVisited, i, j);
                     count++;
                 }
            }
         }
         return count;
    }

    private static void bfs(char[][] grid, boolean[][] isVisited, int row, int col){

        Queue<int[]> qt= new LinkedList<>();
        int n=grid.length;
        int m=grid[0].length;
        qt.add(new int[]{row, col});
        isVisited[row][col]=true;

        //we need to traverse bfs around 1- up, right, left, right
         int[] dr= {-1,1,0,0};
         int[] dc= {0,0,-1,1};

         while(!qt.isEmpty()){
            int[] node=qt.poll();
            int r= node[0];
            int c= node[1];
            for(int k=0;k<4;k++){
            int newR= r+dr[k];
            int newC= c+dc[k];
             
             //checking the boundary conditions
             if(newR>=0 && newR<n && newC>=0 && newC<m)
                if(grid[newR][newC]=='1' && !isVisited[newR][newC]){
                    isVisited[newR][newC]=true;
                    qt.add(new int[]{newR, newC});
                }
            }
         }

    }
}
