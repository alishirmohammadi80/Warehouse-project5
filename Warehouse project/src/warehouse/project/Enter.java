/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package warehouse.project;
import java.util.Scanner;
/**
 *
 * @author RASHA
 */
public class Enter {
    Scanner input=new Scanner(System.in);
    public  String user_n;
    public String password_n;

    public String getUser_n() {
        return user_n;
    }

    public void setUser_n(String user_n) {
        this.user_n = user_n;
    }

    public String getPassword_n() {
        return password_n;
    }

    public void setPassword_n(String password_n) {
        this.password_n = password_n;
    }
    
    public void log_in(){
     System.out.println("----------------------------------------------------"); 
        System.out.println("نام کاربری");
     String Get_username=input.next();
        setUser_n(Get_username);
        System.out.println("کلمه عبور");
     String Get_password=input.next();
        setPassword_n(password_n);
        
    }
}
