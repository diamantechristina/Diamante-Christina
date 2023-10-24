public class Student{
   //attributes
   String first_Name = "";
   String middle_Name = "";
   String last_Name = "";
   String suffix = "";
   
   //constructor
   public Student(){
   
   }
   
   //getters
   public String getFirstName(){
      return first_Name;
   }
   public String getMiddleName(){
      return middle_Name;
   }
   public String getLastName(){
      return last_Name;
   }
   public String getSuffix(){
      return suffix;
   }
   
   public void setFirstName(String fName){
      first_Name = fName;
   }
   public void setMiddleName(String mName){
      middle_Name = mName;
   }
   public void setLastName(String lName){
      last_Name = lName;
   }
   public void setSuffix(String suffix){
      this.suffix = suffix;
   }
   
   public String getFullName(){
      return first_Name + " " + middle_Name + " " + last_Name + " " + suffix;
   }
}