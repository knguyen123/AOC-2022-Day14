import java.util.*;
import java.io.*;
public class day14P2{
    public static void main(String[] args) throws FileNotFoundException{
      char[][] a = new char[200][1000];
      Scanner f = new Scanner(new File("sand.txt"));
      for(int r = 0; r < a.length; r++){
         for(int c = 0; c < a[0].length; c++){
            a[r][c] = '.';
         }
      }
      int h = 0;
      while(f.hasNextLine()){
         String l = f.nextLine();
         Scanner s = new Scanner(l);
         int c1 = Integer.parseInt(s.next());
         int r1 = Integer.parseInt(s.next());
         while(s.hasNext()){    
            if(r1>h){
               h = r1;
            }
            int c2 = Integer.parseInt(s.next());
            int r2 = Integer.parseInt(s.next());
            
            if(r1==r2){
               int min = Math.min(c1,c2);
               int max = Math.max(c1,c2);
               for(int c = min; c <= max; c++){
                  a[r1][c] = '#';
               }
            }else{
               int min = Math.min(r1,r2);
               int max = Math.max(r1,r2);
               for(int r = min; r <= max; r++){
                  a[r][c1] = '#';
               } 
            }
            c1 = c2;
            r1 = r2;
         }
      }
      for(int c = 0; c < a[0].length; c++){
         a[h+2][c]='#';
      }
      int n = 0;
      while(falling(a, 0, 500)){
         n++;
      }
      System.out.println(n+"");
   }
   
   public static boolean falling(char[][] a, int r, int c){
      if(a[0][500]!='O'){
         if(a[r+1][c]!='#'&&a[r+1][c]!='O'){
            return falling(a, r+1, c);
         }else if(c-1>=0&&(a[r+1][c-1]!='#'&&a[r+1][c-1]!='O')){
            return falling(a, r+1, c-1);
         }else if(c+1<a[0].length&&a[r+1][c+1]!='#'&&a[r+1][c+1]!='O'){
            return falling(a, r+1, c+1);
         }else{
            a[r][c] = 'O';
            return true;
         } 
      }
      return false; 
   }
}
