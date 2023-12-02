/*
This program is used to find the possible way to reach current position to destination and print the path by String and matrix
basically i am take the matrix as 3x3
In this 3x3 matrix we are going to find the path by
1.using void print path
2.return path as ArrayList
3.print path by matrix

Lets take the below matrix:
_____________
| C | O |   |
|___|___|___|
|   |   |   |
|___|___|___|
|   |   | T |
|___|___|___|

c-current position(0,0)
O-obstacles position(1,0)
T-target position(2,2)

SAMPLE OUTPUT:

RRDLDR
RRDD
RDRD
RDDR
[RRDLDR, RRDD, RDRD, RDDR]
0 1 2 
0 4 3 
0 5 6 
RRDLDR

0 1 2 
0 0 3 
0 0 4 
RRDD

0 1 0 
0 2 3 
0 0 4 
RDRD

0 1 0 
0 2 0 
0 3 4 
RDDR

BUILD SUCCESSFUL (total time: 0 seconds)

*/
import java.util.ArrayList;

public class Pathfinder { 
    public static void main(String[] args) {   
        int[] current={0,0};
        int[] target={2,2};
        int[] obstacle={1,0};
        boolean[][] matrix={{true,true,true},
                            {true,true,true},
                            {true,true,true}};
        matrix[obstacle[0]][obstacle[1]]=false;
        int[][] path=new int[3][3];    
        pathString("",current,target,matrix);
        System.out.println(returnpathString("",current,target,matrix));
        pathMatrix("",current,target,matrix,path); 
    }
    static void pathString(String str,int[] cur,int[] tar,boolean[][] mat)
    {
        if(cur[0]==tar[0] && cur[1]==tar[1])
        {
            System.out.println(str);
          return;  
        }    
        if(!mat[cur[0]][cur[1]])
            return;
        mat[cur[0]][cur[1]]=false;
        if(cur[0]!=0)
        pathString(str+"U",new int[]{cur[0]-1,cur[1]},tar,mat);
        if(cur[1]!=mat.length-1)
        pathString(str+"R",new int[]{cur[0],cur[1]+1},tar,mat);
        if(cur[1]!=0)
        pathString(str+"L",new int[]{cur[0],cur[1]-1},tar,mat);
        if(cur[0]!=mat.length-1)
        pathString(str+"D",new int[]{cur[0]+1,cur[1]},tar,mat);
        
        mat[cur[0]][cur[1]]=true;
    }
    static ArrayList<String> returnpathString(String str,int[] cur,int[] tar,boolean[][] mat)
    {
        if(cur[0]==tar[0] && cur[1]==tar[1])
        {
          return new ArrayList<String>(){{add(str);}};  
        }    
        if(!mat[cur[0]][cur[1]])
            return new ArrayList<>();
        ArrayList<String> ans=new ArrayList<>();
        mat[cur[0]][cur[1]]=false;
        if(cur[0]!=0)
        {
        ans.addAll(returnpathString(str+"U",new int[]{cur[0]-1,cur[1]},tar,mat));
        }
        if(cur[1]!=mat.length-1)
        {
            ans.addAll(returnpathString(str+"R",new int[]{cur[0],cur[1]+1},tar,mat));
        }
        if(cur[1]!=0)
        {
            ans.addAll(returnpathString(str+"L",new int[]{cur[0],cur[1]-1},tar,mat));
        }
        if(cur[0]!=mat.length-1)
        {
            ans.addAll(returnpathString(str+"D",new int[]{cur[0]+1,cur[1]},tar,mat));
        } 
        mat[cur[0]][cur[1]]=true;
        
        return ans;
}
    static void pathMatrix(String str,int[] cur,int[] tar,boolean[][] mat,int[][] path)
    {
        
        if(cur[0]==tar[0] && cur[1]==tar[1])
        {
            path[cur[0]][cur[1]]=str.length();
            for (int i = 0; i < path.length; i++) {
                for (int j = 0; j < path[0].length; j++) {
                    System.out.print(path[i][j]+" ");
                    
                }
                System.out.println();
            }
           System.out.println(str);
            System.out.println();
          return;  
        }    
        if(!mat[cur[0]][cur[1]])
            return;
        mat[cur[0]][cur[1]]=false;
        path[cur[0]][cur[1]]=str.length();
        
        if(cur[0]!=0)
        pathMatrix(str+"U",new int[]{cur[0]-1,cur[1]},tar,mat,path);
        if(cur[1]!=mat.length-1)
        pathMatrix(str+"R",new int[]{cur[0],cur[1]+1},tar,mat,path);
        if(cur[1]!=0)
        pathMatrix(str+"L",new int[]{cur[0],cur[1]-1},tar,mat,path);
        if(cur[0]!=mat.length-1)
        pathMatrix(str+"D",new int[]{cur[0]+1,cur[1]},tar,mat,path);
        
        mat[cur[0]][cur[1]]=true;
        path[cur[0]][cur[1]]=0;
    }
}
