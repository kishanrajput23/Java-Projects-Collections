public String longestPalindrome(String s) {
        int n=s.length();
        boolean dp[][]=new boolean[n][n];
        int c=0;
        String x="";
        for(int g=0;g<n;g++)
        {
            for(int i=0,j=g;j<n;j++,i++)
            {
                if(g==0)
                    dp[i][j]=true;
                else if(g==1)
                {
                    if(s.charAt(i)==s.charAt(j))
                        dp[i][j]=true;
                }
                else
                {
                    if(s.charAt(i)==s.charAt(j) && dp[i+1][j-1]==true)
                        dp[i][j]=true;
                }
                if(dp[i][j])
                    x=s.substring(i,j+1);
            }
        }
        return x;
    }
