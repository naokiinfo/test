









import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class test {
 
  int n, Pre1,Pos1;
  int[] pre,in,pos;
 
  public static void main(String[] args) {
     
    new test().run();
  }
 
  public void run() {
     
    try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
 
      n = Integer.parseInt(br.readLine());
      String[] linesPre =  br.readLine().split(" ");
      String[] linesIn  =  br.readLine().split(" ");
 
      pre  = new int[n];
      in   = new int[n];
      pos = new int[n];
   
      for(int i=0; i<n; i++){
        pre[i] = Integer.parseInt(linesPre[i]);
        in[i]  = Integer.parseInt(linesIn[i] );
      }
 
      solve();
 
    } catch ( IOException e ) {
      System.out.println("IOException!");
    }
  }
   
  void solve() {
    Pre1 = Pos1 = 0;
    StringBuilder buf = new StringBuilder();
 
    tree(0,n);
 
    for (int var : pos) {
      buf.append(var).append(" ");
    }
    buf.setLength(buf.length()-1);
    System.out.println(buf);
  }
 
  void tree(int l, int r) {
    if( l < r ) {
      int root = pre[Pre1++];      
      int m = Dis(0, n, root);      
      tree(l,m);
      tree(m+1,r);  
      pos[Pos1++] = root;
    }
  }
 
  int Dis(int start, int end, int find) {
    int d=start;
    System.out.print(d);
    System.out.print(end);
    System.out.println(find);
    
    
     
    for( ; d<end; d++)
      if( in[d] == find ) break;

      System.out.println(d);
    return d;
  }
}
