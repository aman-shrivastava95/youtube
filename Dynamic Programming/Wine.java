//this is giving the corredt result , let us try to find the beg and selling positions
public class Wine{
   
    static int dp[][] ;
    static int choice[][] ;
    
    private static int profitUtil(int[] wines, int start, int end, int year){
        if(start==end)
            return year*wines[start] ;

        if(dp[start][end]!=-1)
            return dp[start][end] ;
        

        int option1 = year*wines[start] +  profitUtil(wines, start+1, end,year+1) ;
        int option2 = year*wines[end] +profitUtil(wines, start, end-1,year+1) ;

       
        dp[start][end] =  Math.max(option1,option2) ;
        if(option1 >=option2){
            //we made a choice from firts
            choice[start][end] = 0 ;
        }else{
            choice[start][end]  = 1 ;
        }
        return dp[start][end] ;

    }
    public static int profit(int[] wines){
        int n = wines.length ;
        dp = new int[n][n] ;
        
        choice = new int[n][n] ; 
        
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                dp[i][j] = -1 ;

        
        int ans = profitUtil(wines, 0, n-1,1) ; 
        int i = 0,j=n-1 ;
        while(i<=j){
            if(choice[i][j]==0){
                System.out.print("beg" + " ");
                i++ ;
            }else{
                System.out.print("end" + " ");
                j-- ;
            }
        }
        System.out.println();
        return ans ;

    
    }

    public static void main(String[] args) {
        System.out.println(profit(new int[]{2,4,6,2,5}));
    }
}