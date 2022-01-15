package warehouse.project;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author RASHA
 */
public class Database {
  
       private static String sql;
    public static void main(String[] args) throws SQLException {
        Scanner input=new Scanner(System.in);
        try {
            
             Class.forName("org.sqlite.JDBC");

Connection a = DriverManager.getConnection("jdbc:sqlite:Database.db"); 
  Statement statment=a.createStatement();
//   table User_Table
//     String sql18="create table User("
//                    + "user_name varchar(60),"
//                    + "Password varchar(60),"
//                      +  "email varchar(60));";
//           statment.executeUpdate(sql18);
//====================================
////teble Kala
// String sql2="CREATE TABLE Kala_Table("
//                    + "NAME varchar(60),"
//                    + "TADAD_KALA int,"
//                    + "CODE_KALA int);";
//        statment.executeUpdate(sql2);
//=========================================
Time tim=new Time();
Time.show_time(args);
//------------------------------------------------------------------------------
login log=new login();
log.enroll();
String user=log.getUser_Name();
String pasword=log.getPassword();
String email=log.getEmail_address();

 String sql0="INSERT INTO User(user_name,Password,email) VALUES('%s','%s','%s') ";
sql0=String.format(sql0, user,pasword,email);
statment.execute(sql0);
//------------------------------------------------------------------------------
    gmail Gmail=new gmail();
            Gmail.send("enroll gmail",email,"user_name is:"+ user+"\t"+"--"+"pasword is :"+pasword);
//------------------------------------------------------------------------------

Enter enter=new Enter();
enter.log_in();
            if (enter.getUser_n().equalsIgnoreCase(log.getUser_Name())) {
                System.out.println("شما با موفقیت وارد شدید");
            } else {
                System.out.println("نام کار بری یا کلمه عبور اشتباه است ");
                System.out.println("دوباره تلاش کنید");
                enter.log_in();
            }

//------------------------------------------------------------------------------

boolean run_Menu=true;
            do {                
                show_menu();
                int Result=input.nextInt();
                switch(Result){
//------------------------------------------------------------------------------                    
                  case 1:
                          import_kala object=new import_kala();
        System.out.println("------------------------------------------------");                  
                      System.out.println("1)ثبت کالای جدید"); 
                      System.out.println("2)اضافه کردن تعداد کالاهای موجود");
                      int natige=input.nextInt();
                      switch(natige){
//******************************************************************************                          
                       case 1:
                           object.import_kala_Menu();
                           String NAME=object.getName_kala();
                             int TADAD=object.getTadad_kala();
                             int CODE=object.getCode_kala();
   String sql1="INSERT INTO Kala_Table(NAME,TADAD_KALA,CODE_KALA) VALUES('%s','%d','%d') ";
sql1=String.format(sql1, NAME,TADAD,CODE);
statment.execute(sql1);
                          break;
//******************************************************************************                          
                        case 2:
                            object.import_kala_Menu();
                           String Name_kala=object.getName_kala();
                            String sql2="SELECT * FROM Kala_Table WHERE NAME='%s';";
                    sql2=String.format(sql2,Name_kala);
            ResultSet rs1 = statment.executeQuery(sql2);
                     
            while (rs1.next()) {
               int tadad_kala=rs1.getInt("TADAD_KALA");
                tadad_kala=tadad_kala+object.getTadad_kala();

   String sql3="UPDATE Kala_Table SET TADAD_KALA = '%d' WHERE  NAME='%s'; ";
sql3=String.format(sql3, tadad_kala,Name_kala);
statment.executeUpdate(sql3);
            
            }
//******************************************************************************                      
            break;
                          
                      } 
break;
//------------------------------------------------------------------------------
                 case 2:         
                         Remove_Kala rimove=new Remove_Kala();
                         rimove.Delete_menu();
                           String name_kala_r=rimove.getName_kala_r();
                            String sql4="SELECT * FROM Kala_Table WHERE NAME='%s';";
                    sql4=String.format(sql4,name_kala_r);
            ResultSet rs2 = statment.executeQuery(sql4);
                     
            while (rs2.next()) {
               int tadad_kala_r=rs2.getInt("TADAD_KALA");
                tadad_kala_r=tadad_kala_r-rimove.getTadad_kala_r();

   String sql5="UPDATE Kala_Table SET TADAD_KALA = '%d' WHERE  NAME='%s'; ";
sql5=String.format(sql5, tadad_kala_r,rimove.getName_kala_r());
statment.executeUpdate(sql5);
            
            }

               break;
//------------------------------------------------------------------------------                     
                 case 3:
                     String sql6 = "select * from  Kala_Table;";
            ResultSet rs3 = statment.executeQuery(sql6);
                     System.out.println("name"+"\t"+"tadad"+"\t"+"code");
            while (rs3.next()) {
                
                String name_kala = rs3.getString("NAME");
               int tadad_kala=rs3.getInt("TADAD_KALA");
               int code_kala=rs3.getInt("CODE_KALA");
                System.out.println(name_kala + "\t" + tadad_kala + "\t"+code_kala );
            }
            break;
//------------------------------------------------------------------------------            
                 case 4:
                  search Object=new search();
                  Object.search_for_kala_name();
                  String search_natige=Object.getKala_nam();
   String sql7="SELECT * FROM Kala_Table WHERE NAME='%s';";
                    sql7=String.format(sql7,search_natige);
            ResultSet rs4 = statment.executeQuery(sql7);
                     System.out.println("name"+"\t"+"tadad"+"\t"+"code");
            while (rs4.next()) {
                
                String name_kala = rs4.getString("NAME");
               int tadad_kala=rs4.getInt("TADAD_KALA");
               int code_kala=rs4.getInt("CODE_KALA");
                System.out.println(name_kala + "\t" + tadad_kala + "\t"+code_kala );

            }
                  
                    break;
//------------------------------------------------------------------------------                     
                case 5:
                     System.out.println("------------------------------------------------");
                    System.out.println("نام کالا را وارد کنید");
                    String Delete_name=input.next();
                    String sql8="DELETE FROM Kala_Table WHERE Name='%s';";
                    sql8=String.format(sql8,Delete_name);
                    statment.executeUpdate(sql8);
                    break;
//------------------------------------------------------------------------------                    
                 case 6:
                  run_Menu=false;   
                    break;
//------------------------------------------------------------------------------                    
                }
                
                
            } while (run_Menu);


        } catch (Exception e) {
            System.out.println(e);
        }
        
    }
   
    public static void show_menu(){
         System.out.println("------------------------------------------------");
       System.out.println("1)ثبت کالا");   
       System.out.println("2)خارج کردن کالا");
       System.out.println("3)نمایش کلا های موجود");
       System.out.println("4)جستوجوی کالا");
        System.out.println("5)حذف کالا");
       System.out.println("6)خروج از برنامه");
       System.out.print(":"+"لطفا یک گزینه را انتخاب کنید");
     
   }
   
}
