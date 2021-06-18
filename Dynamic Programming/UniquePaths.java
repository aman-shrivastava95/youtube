//top down
// class Solution{
//     int dp[][] ;
//     public int uniquePaths(int m,int n){
        
//         dp = new int[m+1][n+1] ;
//         for(int[] row:dp)
//             Arrays.fill(row, -1) ;
        
//         return paths(m,n,m,n) ;
//     }
//     private int paths(int x, int y,int m, int n){
//         if(x<1 || x>m || y<1 || y>n) return 0 ;
//         if(x==1 && y==1) return 1 ;
//         //check in the dp table
//         if(dp[x][y]!=-1){
//             return dp[x][y] ;
//         }
//         dp[x][y] = paths(x-1,y,m,n) + paths(x,y-1,m,n) ;
//         return dp[x][y] ;
//     }
// }






//Bottom up
class Solution {
    
    public int uniquePaths(int m, int n) {
        int dp[][] = new int[m][n] ;
        //if only right, one way is there
        for(int i = 0;i<m;i++){
            dp[i][0] = 1 ;
        }
        //if only down one solution is there
        for(int i = 0;i<n;i++){
            dp[0][i] = 1 ;
        }
        //fill the rest of the cells
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                dp[i][j] = dp[i-1][j] + dp[i][j-1] ;
            }
        }
        return dp[m-1][n-1] ;
    }
}