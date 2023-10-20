public class TableAndChairs{
   public static void main(String[] args){
      int height = 6, length = 22;
      for(int i = 0; i < height; i++){
         for(int j = 0; j < length; j++){
            if(j==0 || j==length-1 || i==2 && (j>5 && j<16) || i==3 && (j<5 || j>16 || j==6 || j==15) || ((i==4 || i==5) && (j==4 || j==6 || j==15 ||j==17))) {
               System.out.print("X");
            }else{
               System.out.print(" ");
            }
         }
         System.out.println();
      }
   }
}