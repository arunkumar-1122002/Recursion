/*
This program is used to calculate the number of possible way to reach target 
Lets take example (3x3 Matrix):

current position(0,0)
target position(2,2)
_____________
| C |   |   |
|___|___|___|
|   |   |   |
|___|___|___|
|   |   | T |
|___|___|___|

Possible way to reach destination(R-right,D-down):
     1.RRDD
     2.RDRD
     3.DRRD
     4.DDRR
     5.RDDR
     6.DRDR
here i find solution by 2 methods
     *using void
      *return
*/
public class Mazepathcount { 
    public static void main(String[] args) {    
       int[] current={0,0};
        int[] target={2,2};
        System.out.println(returnpathcount(current,target));
        pathcount(current,target);
        System.out.println(count);
    }
    static int returnpathcount(int[] cur,int[] tar)
    {
        if(cur[0]==tar[0] || cur[1]==tar[1])
        {
            return 1;
        }
        int left=returnpathcount(new int[]{cur[0]+1,cur[1]},tar);
        int right=returnpathcount(new int[]{cur[0],cur[1]+1},tar);
        return left+right;
    }
    static int count=0;
     static void pathcount(int[] cur,int[] tar)
    {
        if(cur[0]==tar[0] || cur[1]==tar[1])
        {
            count++;
            return ;
        }
        pathcount(new int[]{cur[0]+1,cur[1]},tar);
        pathcount(new int[]{cur[0],cur[1]+1},tar);
    }
}
