/**
* 
* 给定一个包含了一些 0 和 1的非空二维数组 grid , 一个 岛屿 是由四个方向 (水平或垂直) 的 1 (代表土地) 构成的组合。
* 你可以假设二维矩阵的四个边缘都被水包围着。
* 找到给定的二维数组中最大的岛屿面积。(如果没有岛屿，则返回面积为0。)
* 
*  
* 
* 分析：
* 十分经典的联通块问题。
* 
* 跟我以前的写法有所不同，这个写法值得学习。
* 
* 这里用grid[i][j]=0，来代替vis[][]数组，简化了空间； 
* 在java中用内部类封装dfs的感觉，也是挺有趣的。
*/


class Solution {
    public int maxAreaOfIsland(int[][] grid) {

        class Dfs{
            int dir[][]={ {1,0},{-1,0},{0,1},{0,-1} };
            boolean judge(int x,int y,int n,int m){
                return x>=0&&x<n&&y>=0&&y<m;
            }

            int dfs(int[][] grid,int x,int y,int n,int m){
                grid[x][y]=0;//防止重访问
                int count=1;

                for(int[] dir: dir){
                    int nx=x+dir[0];
                    int ny=y+dir[1];
                    if( judge(nx,ny,n,m) && grid[nx][ny]==1 ){
                        count+=dfs(grid,nx,ny,n,m);
                    }
                }
                return count;
            }
        }

        int ans=0;
        int n=grid.length;
        int m=grid[0].length;
        Dfs utils=new Dfs();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1) ans=Math.max(ans,utils.dfs(grid,i,j,n,m));
            }
        }
        return ans;

    }
}
