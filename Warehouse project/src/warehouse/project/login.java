
package warehouse.project;
import java.util.Scanner;
/**
 *
 * @author RASHA
 */
public class login {
    
 Scanner input= new Scanner(System.in); 
 public String User_Name;
public String Password;
public String Email_addres;

    public String getEmail_address() {
        return Email_addres;
    }

    public void setEmail_address(String Email_address) {
        this.Email_addres = Email_address;
    }
    public Scanner getInput() {
        return input;
    }

    public void setInput(Scanner input) {
        this.input = input;
    }

    public String getUser_Name() {
        return User_Name;
    }

    public void setUser_Name(String User_Name) {
        this.User_Name = User_Name;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }
 
public void enroll(){
 System.out.println("------------------------------------------------");
        System.out.println("ثبت نام");
        System.out.println("لطفا یک نام کاربری انتخاب کنید");
      String user_name=input.next();
      setUser_Name(user_name);
        System.out.println("لطفا یک کلمه عبور انتخاب کنید"); 
      String pssword=input.next();   
    setPassword(pssword);
    System.out.println("لطفا ایمیل خود را وارد کنید");
    String email_addres=input.next();
    setEmail_address(email_addres);
    System.out.println("لطفا چند لحظه صبر کنید");
    System.out.println("نام کار بری و رمز عبور به ایمیل شما ارسال شد");
}
   


  
     
    
    
    
    
    
}





    
    
    
    
    
    
    
    
