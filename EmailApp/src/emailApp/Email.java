package emailApp;
import java.util.logging.Logger;
import java.util.Scanner;


/*Generate an email with the following syntax: firstname.lastname@department.company.com
Determine the department (sales, development, accounting), if none leave blank
Generate a random String for a password
Have set methods to change the password, set the mailbox capacity, and define an alternate
email address
Have get methods to display the name, email, and mailbox capacity*/

public class Email {

    private final static Logger LOGGER = Logger.getLogger(Thread.currentThread().getStackTrace()[0].getClassName());

    private String firstName;
    private String lastName;
    private String department;
    private String password;
    private String email;
    private int capacity = 500;
    private String alternateEmail;
    private int defaultPasswordLength = 10;
    private String companySuffix = "company.com";

    //Constructor
    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;

        //Call a method asking for department information
        this.department = setDepartment();

        //Call a method to return a random password
        this.password = setPassword(defaultPasswordLength);
        System.out.println("Password: " + this.password);

        //Combine elements to generate email
        this.email = firstName.toLowerCase() + "." +lastName.toLowerCase() + "@" + this.department +  "." + this.companySuffix;
    }


    private String setDepartment(){

        System.out.print("Department codes\n1 for Sales\n2 for Development\n3 for Account\n4 for none\nEnter department codes: ");
        Scanner reader = new Scanner(System.in);
        int depChoice = reader.nextInt();
        if(depChoice == 1){ return "sales";}
        else if(depChoice == 2){ return "development";}
        else if(depChoice == 3){ return "account";}
        else if(depChoice == 4){ return "";}
        else {return "";}
    }

    //generate a random password
    private String setPassword(int length){
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ123456789!@#$%";
        char[] password = new char[length];
        for(int i = 0; i < length; ++i){
            int ran = (int)(Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(ran);
        }

        return new String(password);//important
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setAlternateEmail(String altEmail){
        this.alternateEmail = altEmail;
    }

    public void changePassword(String newPassword){
        this.password = newPassword;
    }

    public int getCapacity(){return this.capacity;}
    public String getAlternateEmail(){return this.alternateEmail;}
    public String getPassword(){return this.password;}

    public void showInfo(){
        System.out.println("Name: " + this.firstName + " " + this.lastName);
        System.out.println("Email: " + this.email);
        System.out.println("Mailbox capacity: " + this.capacity);
    }
}
