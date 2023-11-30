/*
This program is used to find sum of permuntation possiblities of given target using recursion
input:
4
output:
[1, 1, 1, 1]
[1, 1, 2]
[1, 2, 1]
[1, 3]
[2, 1, 1]
[2, 2]
[3, 1]
[4]
*/
import java.util.ArrayList;
public class Sumofpossibles { 
    public static void main(String[] args) {    
       int target=4;
        possibilities(0,target,new ArrayList<>());      
    }
    static void possibilities(int p,int up,ArrayList<Integer> sum)//p=processed,up=unprocessed
    {        
        if(up==0)
        {
            System.out.println(sum);
          return;
        }
        for(int i=1;i<=up;i++)
        {
            sum.add(i);
            possibilities(i,up-i,sum);          
            sum.remove(sum.size()-1);
        }
    }
}
