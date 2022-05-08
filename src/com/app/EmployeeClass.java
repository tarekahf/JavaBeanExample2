//import java.io.Serializable;
package com.app;
public class EmployeeClass {
    // public static void  main(String[] args) {
    //     System.out.print("Hello World");
    // }
    private String emplName;
    public EmployeeClass(){

    }
    public EmployeeClass(String prmName) {
        emplName = prmName;
   
     } 

    public String getEmplName() {
        return emplName;
    }

    public void setEmplName(String prmEmplName) {
        emplName = prmEmplName;
    }

}
