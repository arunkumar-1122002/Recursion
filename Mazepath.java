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

INPUT:
{0,0}
{2,2}
OUTPUT:
[DDRR, DRDR, DRRD, RDDR, RDRD, RRDD]

This program find answer by void and return ArrayList
*/
import java.util.ArrayList;
public class Mazepath { 
    public static void main(String[] args) {   
      int[] current={0,0};  
      int[] target={2,2};
      pathString("",current,target);
     pathbypoint(current,target);
     System.out.println(returnpathString("",current,target));
    }
    static void pathString(String str,int[] cur,int[] tar)
    {
        if(cur[0]==tar[0] && cur[1]==tar[1])
        {
            System.out.println(str);
          return;  
        }    
        if(cur[0]!=tar[0])
        pathString(str+"D",new int[]{cur[0]+1,cur[1]},tar);
        if(cur[1]!=tar[1])
        pathString(str+"R",new int[]{cur[0],cur[1]+1},tar);
    }
    static void pathbypoint(int[] cur,int[] tar)
    {
        if(cur[0]==tar[0] && cur[1]==tar[1])
        {
            System.out.println(Arrays.toString(cur));
            System.out.println();
          return;  
        }    
        if(cur[0]!=tar[0])
        {
            System.out.println(Arrays.toString(cur));
        pathbypoint(new int[]{cur[0]+1,cur[1]},tar);
        }
        if(cur[1]!=tar[1])
        {
            System.out.println(Arrays.toString(cur));
            pathbypoint(new int[]{cur[0],cur[1]+1},tar);
        }
    }
    static ArrayList<String> returnpathString(String str,int[] cur,int[] tar)
    {
        if(cur[0]==tar[0] && cur[1]==tar[1])
          return new ArrayList<String>(){{add(str);}};   
        ArrayList<String> ans = new ArrayList<>();
        if(cur[0]!=tar[0])
        ans.addAll(returnpathString(str+"D",new int[]{cur[0]+1,cur[1]},tar));
        if(cur[1]!=tar[1])
            ans.addAll(returnpathString(str+"R",new int[]{cur[0],cur[1]+1},tar));   
        return ans;
    }
}
