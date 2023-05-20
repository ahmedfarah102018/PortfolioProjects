import java.util.DoubleSummaryStatistics;
import java.util.Locale;
import java.util.Scanner;

public class Email {
   private String firstName;
    private String lastName;
    private String password;
    private int defaultPasswordLength = 8;
    private String department;
    private int mailBoxCapacity;
    private String alternateEmail;
    private String companySiffix = "UmbulItConultantFirm.com";
    String email;

    //constructor; ask for first name and last name
    public Email(String firstName, String lastname){
        this.firstName = firstName;
        this.lastName = lastname;
        System.out.println("Email Created: " + this.firstName + "" + this.lastName);

        this.department = setDepartment();
        System.out.println("Department: " + this.department);
        this.password = randomPassword(defaultPasswordLength);
        System.out.println("this is your password: " + this.password);

        //Combine elements to generate Email
         email = firstName.toLowerCase() + "" + lastname.toLowerCase()
                 + "" + "@" + department + "." + companySiffix;
        System.out.println("Your Email is: " + email);
    }

    //ask for the department
    private  String setDepartment(){
        System.out.println("Department Codes:\n1 for Sales\n2 for Development\n3 for Accounting\n0 for none\n Enter department code:");
        Scanner sc = new Scanner(System.in);
        int depChoice = sc.nextInt();
        if(depChoice == 1){
            return "Sales";
        }
        else if(depChoice == 2){
            return "development";
        }
        else if(depChoice == 3){
            return "Accounting";
        }else{
            return " ";
        }
    }
    //Generate random password
    private String randomPassword(int length){
        String passwordSet = "ABDCEFGHIJKLMNOPQRSTUVWX" +
                "YZ123456789!@#$%&";
        char[] password = new char[length];
        for(int i =0; i<length; i++){
            int random = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(random);
        }
        return new String (password);
    }
    //set the mailbox capacity
    public void setMailBoxCapacity(int capacity){
        this.mailBoxCapacity = capacity;
    }
    public void setAlternateEmail(String altEmail){
        this.alternateEmail = altEmail;
    }
    public void changePassword(String pass){
        this.password = pass;
    }
    public int getMailBoxCapacity(){
        return mailBoxCapacity;
    }
    public String getAlternateEmail(){
        return alternateEmail;
    }
    public String getPassword(){
        return password;
    }
    //show the information
    public String showInfo(){
        return"Display Name: " + firstName + " \n" + lastName
                + "\nCompany Email: " + email +
                "\nMailBox Capacity: " + mailBoxCapacity + "mb";
    }
}
