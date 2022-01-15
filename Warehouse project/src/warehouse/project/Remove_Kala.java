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
public class Remove_Kala {
    
      Scanner input=new Scanner(System.in);
     public String Name_kala_r;
  public int Code_kala_r;
  public int Tadad_kala_r;

    public Scanner getInput() {
        return input;
    }

    public void setInput(Scanner input) {
        this.input = input;
    }

    public String getName_kala_r() {
        return Name_kala_r;
    }

    public void setName_kala_r(String Name_kala_r) {
        this.Name_kala_r = Name_kala_r;
    }

    public int getCode_kala_r() {
        return Code_kala_r;
    }

    public void setCode_kala_r(int Code_kala_r) {
        this.Code_kala_r = Code_kala_r;
    }

    public int getTadad_kala_r() {
        return Tadad_kala_r;
    }

    public void setTadad_kala_r(int Tadad_kala_r) {
        this.Tadad_kala_r = Tadad_kala_r;
    }
  
    public void Delete_menu(){
         System.out.println("------------------------------------------------");
        System.out.println("نام کالا را وارد کنید");
        String name_r=input.next();
        setName_kala_r(name_r);
        System.out.println("کد کالا را وارد کنید");
        int cod_r=input.nextInt();
        setCode_kala_r(cod_r);
        System.out.println("تعداد کالای خروجی را وارد کنید");
        int tadad_r=input.nextInt();
        setTadad_kala_r(tadad_r);
    }
    
    
    
}
