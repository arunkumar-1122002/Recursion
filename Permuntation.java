/*
This program gives you permuntaions of a string in 2 different ways
  1.using void and print the permuntation value
  2.return all permuntation value as ArrayList
Output:
cba
bca
bac
cab
acb
abc
[cba, bca, bac, cab, acb, abc]
*/
import java.util.ArrayList;
public class Permuntation
{
    public static void main(String[] args) {
   String str="abc";
   permuntation("",str);
  System.out.println(permuntationreturn("",str));
}
    static void permuntation(String left,String right)
    {
        if(right.isEmpty())
        {
            System.out.println(left);
        return;
        }
        for(int i=0;i<=left.length();i++)
        {
            String st=left.substring(0, i);
            char ch=right.charAt(0);
            String fn=left.substring(i,left.length());
            permuntation(st+ch+fn,right.substring(1));
        }
    }
    static ArrayList<String> permuntationreturn(String left,String right)
    {
        
       if(right.isEmpty())
       {
        return new ArrayList<String>(){{add(left);}};
       }
       ArrayList<String> ans=new ArrayList<>();
       for(int i=0;i<=left.length();i++)
       {
           String st=left.substring(0, i);
            char ch=right.charAt(0);
            String fn=left.substring(i,left.length());
           ans.addAll(permuntationreturn(st+ch+fn,right.substring(1)));
       }
       return ans;
    }
}
