import java.util.Scanner;
public class StudentInterface{
   public static void main(String[] args){
      Scanner sc = new Scanner(System.in);
      Student sOne = new Student();
      
      System.out.print("Enter first name: ");
      sOne.setFirstName(sc.nextLine());
      System.out.print("Enter middle name: ");
      sOne.setMiddleName(sc.nextLine());
      System.out.print("Enter last name: ");
      sOne.setLastName(sc.nextLine());
      System.out.print("Enter suffix: ");
      sOne.setSuffix(sc.nextLine());
      
      //System.out.println("\nStudent First Name: " + sOne.getFirstName() + "\nStudent Middle Name: " + sOne.getMiddleName() + "\nStudent Last Name: " + sOne.getLastName() + "\nStudent suffix: " + sOne.getSuffix());
      System.out.println("Student Full Name: " + sOne.getFullName());
   }
}