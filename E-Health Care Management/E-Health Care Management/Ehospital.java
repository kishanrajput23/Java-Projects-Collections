import java.util.*;
import java.lang.String;
import java.io.*;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime; 

class Info
{
Info()
{	
System.out.print("\t\t\t\t\t ___________________________________________________________________________________________\n");
System.out.print("\t\t\t\t\t|                                           		                                    |\n");
System.out.print("\t\t\t\t\t|                                           		                                    |\n");
System.out.print("\t\t\t\t\t|                                           		                                    |\n");
System.out.print("\t\t\t\t\t|                                           		                                    |\n");
System.out.print("\t\t\t\t\t|                                           		                                    |\n");
System.out.print("\t\t\t\t\t|                                           		                                    |\n");
System.out.print("\t\t\t\t\t|                            WELCOME TO E-HEALTH CARE MANAGEMENT SYSTEM                     |\n");
System.out.print("\t\t\t\t\t|                                                                                           |\n");
System.out.print("\t\t\t\t\t|                                                                                           |\n");
System.out.print("\t\t\t\t\t|                                                                                           |\n");
System.out.print("\t\t\t\t\t|                                                                                           |\n");
System.out.print("\t\t\t\t\t|                                                                                           |\n");
System.out.print("\t\t\t\t\t|                                                                                           |\n");
System.out.print("\t\t\t\t\t|                                         -Brought To You by                                |\n");
System.out.print("\t\t\t\t\t|                                      	 Md Fahad,Omer Mohiuddin and Yaseen Hussain         |\n");
System.out.print("\t\t\t\t\t|___________________________________________________________________________________________|\n");
}
//Declaring variales to be used
Scanner scan=new Scanner(System.in);
String name;
String address;
long contact;
int age;
String bg;
String sex;
String disease;
long id;
String dadm;
//To take a pause
private void pressAnyKeyToContinue()
 { 
        System.out.println("Press Enter key to continue...");
        try
        {
            System.in.read();
        }  
        catch(Exception e)
        {
        System.out.println("Press 'Enter' key to continue!");
        }  
 }
 //Taking multiple words
String readString()
{
    Scanner scanner = new Scanner(System.in);
    return scanner.nextLine();
}
//Log in Module
void login()
{
   int a;
   String pass;
   System.out.print("\t\t\t\t\t _______________________________________________________________________________________ \n");
   System.out.print("\n\t\t\t\t\t\t\t\tE-HEALTH CARE MANAGEMENT SYSTEM \n");
   System.out.print("\t\t\t\t\t _______________________________________________________________________________________ \n");
   System.out.println("\n\n\t\t\t\t\t\t\t\t------------------------------");
   System.out.print("\n\t\t\t\t\t\t\t\t\t     LOGIN \n");	
   System.out.print("\t\t\t\t\t\t\t\t------------------------------\n\n");	
   System.out.print("\t\t\t\t\t\t\t\tEnter the Password: ");
   pass=scan.next();
   if(pass.equals("deccan"))
	{
      System.out.print("\n\n\t\t\t\t\t\t\t\tAccess Granted!\n");
      pressAnyKeyToContinue();
  	}
    else
	{
      System.out.print( "\n\n\t\t\t\t\t\t\t\tAccess Aborted...\n\t\t\t\t\t\t\t\t1.Try Again\n\n\t\t\t\t\t\t\t\t2.Exit");
      System.out.print("\n\n\t\t\t\t\t\t\tEnter the option: ");
      try{ 
	a=scan.nextInt(); 
      if(a==1)
          login();
      else if(a==2)
          System.exit(0);
      else
        {
         System.out.print("\n\n\t\t\t\t\t\tInvalid Choice\n");
        }
	}
	catch(InputMismatchException e){
	System.out.println("\n\n\t\t\t\t\t\t\t*Enter the correct option!*\n\n");
	login();
	}
        }
}
//To get Date
 public void getCurrentTimeUsingDate() 
  {
   DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");  
   LocalDateTime now = LocalDateTime.now();  
   dadm=dtf.format(now);  
  
  }

void menu()
{
char k;
//giving option to the user for their choice
System.out.print("\t\t\t\t\t _______________________________________________________________________________________ \n");
System.out.print("\n\n\t\t\t\t\t\t\t\t  E-HEALTH CARE MANAGEMENT SYSTEM \n\n");	
System.out.print("\t\t\t\t\t _______________________________________________________________________________________ \n");
System.out.print("\n\n\t\t\t\t\t\tPlease, Choose from the following Options: \n\n");
System.out.print("\t\t\t\t\t\t _________________________________________________________________ \n");
System.out.print("\t\t\t\t\t\t|                                           	                  |\n");
System.out.print("\t\t\t\t\t\t|             1  >> Add New Patient Record                        |\n");
System.out.print("\t\t\t\t\t\t|             2  >> Add Diagnosis Information                     |\n");
System.out.print("\t\t\t\t\t\t|             3  >> History of the Patient                        |\n");
System.out.print("\t\t\t\t\t\t|             4  >> Bill of the patient                           |\n");
System.out.print("\t\t\t\t\t\t|             5  >> Help				              |\n");
System.out.print("\t\t\t\t\t\t|             6  >> Exit		                          |\n");
System.out.print("\t\t\t\t\t\t|_________________________________________________________________|\n\n");
System.out.print("\t\t\t\t\t\tEnter your choice: ");
k=scan.next().charAt(0);
//if inputed choice is other than given choice
switch(k)
{
case '1': patient();
break;
case '2': diagnos();
break;
case '3': history();
break;
case '4': bill();
break;
case '5': info();
break;
case '6': exit();
break;
default: System.out.print("\n\n\t\t\t\t\t\tInvalid Choice\n");
  System.out.print("\t\t\t\t\t\tTry again...........\n\n");
  menu();
}
menu();
}
void patient()
{
System.out.print("Enter the patient's file name: ");

String fileName =scan.next();
getCurrentTimeUsingDate();  

        try {
            // Assume default encoding.
            FileWriter fileWriter = new FileWriter(fileName+".txt");

            // Always wrap FileWriter in BufferedWriter.
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
	    
            // Note that write() does not automatically
            // append a newline character.
            System.out.print("\n********************************************************************\n");
            bufferedWriter.write("Date of admission: "+dadm);
            bufferedWriter.newLine();
            System.out.print("\nName : ");name=readString();bufferedWriter.write("Name : "+name);
            bufferedWriter.newLine();
            System.out.print("\nAddress : ");address=readString();bufferedWriter.write("Address : "+address);
            bufferedWriter.newLine();
            System.out.print("\nContact Number : ");contact=scan.nextLong();bufferedWriter.write("Contact Number : "+contact);
            bufferedWriter.newLine();
            System.out.print("\nAge : ");age=scan.nextInt();bufferedWriter.write("Age : "+age);
            bufferedWriter.newLine();
            System.out.print("\nSex : ");sex=scan.next();bufferedWriter.write("Sex : "+sex);
            bufferedWriter.newLine();
            System.out.print("\nBlood Group : ");bg=scan.next();bufferedWriter.write("Blood Group : "+bg);
            bufferedWriter.newLine();
            System.out.print("\nAny Major disease suffered earlier : ");disease=readString();bufferedWriter.write("Any Major disease suffered earlier : "+disease);
            bufferedWriter.newLine();
            System.out.print("\nPatient ID : ");id=scan.nextLong();bufferedWriter.write("Patient ID : "+id);
            bufferedWriter.newLine();
            System.out.print("\n********************************************************************\n");
            bufferedWriter.write("\n********************************************************************\n\n");
            bufferedWriter.newLine();System.out.print("\nInformation Saved Successfully\n");

            // Always close files.
            bufferedWriter.close();
        }
        catch(IOException ex) 
	{
            System.out.println("Error writing to file '"+ fileName +"'");
        }
    pressAnyKeyToContinue();
}
void diagnos()
{
    String symptom;
    String diagnosis;
    String medicine;
    String addmission;
    String ward;
    String doctor;
    getCurrentTimeUsingDate();
    System.out.print("\n\nEnter the patient's file name to be opened : ");
    String fileName=scan.next();
             // This will reference one line at a time
    String line = null;
    try {
        // FileReader reads text files in the default encoding.
            FileReader fileReader = new FileReader(fileName+".txt");

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            System.out.println("\n\n\n\n\t\t\t\t........................................ Information about '"+fileName+"' ........................................\n\n\n\n");
            while((line = bufferedReader.readLine()) != null) 
            {
                System.out.println(line);
            }   

            // Always close files.
            bufferedReader.close();         
        //Appending data in file
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(fileName+".txt", true)));
            System.out.print("Adding more information in patient's file................on : "+dadm);
            out.println("Description of the day:"+dadm);
            System.out.print("\nDoctor appointed:");doctor=readString();out.println("Doctor appointed: "+doctor);
            System.out.print("\nSymptoms : ");symptom=readString();out.println("Symptoms : "+symptom);
            System.out.print("\nDiagnosis : "); diagnosis=readString();out.println("Diagnosis : "+diagnosis);
            System.out.print("\nMedicines : ");medicine=readString(); out.println("Medicines : "+medicine);
            System.out.print("\nAddmission Required? : "); 
            addmission=readString();out.println("Addmission Required? : "+addmission); 
            if(addmission.equals("Yes")||addmission.equals("Y"))
            {
              System.out.print("\nType of ward : ");ward=readString(); out.println("Type of ward : "+ward);
              out.println("\n*************************************************************************\n");
            System.out.print(ward+" ward is alloted Successfully\n");
            }
            else
            {out.println("*************************************************************************\n");}
    out.close();
   pressAnyKeyToContinue(); 
        } 
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + fileName + "'");                
        }
        catch (IOException e) {
                System.out.println("Error writing or Reading to file '"+ fileName +"'");
           }
}

void history()
   {
           System.out.print("\n\nEnter the patient's file name to be opened : ");
    String fileName=scan.next();
             // This will reference one line at a time
    String line = null;
    try {
        // FileReader reads text files in the default encoding.
            FileReader fileReader = new FileReader(fileName+".txt");

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            System.out.print("\n\n\n\n\t\t\t\t........................................ Full Medical History of '"+fileName+"' ........................................\n\n\n\n");
            while((line = bufferedReader.readLine()) != null) 
            {
                System.out.println(line);
            }   
	   pressAnyKeyToContinue();
            // Always close files.
            bufferedReader.close();         
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + fileName + "'");                
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" + fileName + "'");               
        }  
    }
void bill()
{
 getCurrentTimeUsingDate();
 int days;
 double wcharge;
 double doc;
 double ser;
System.out.println("\t\t\t\t\t\t _________________________________________________________________ ");
 System.out.print("\n\n\t\t\t\t\t\t\t\t  E-HEALTH CARE MANAGEMENT SYSTEM \n\n");
System.out.println("\t\t\t\t\t\t _________________________________________________________________ ");
 System.out.print("Enter the patient's file name to get the Bill: ");
 String fileName=scan.next();
             // This will reference one line at a time
    String line = null;
    try {
        // FileReader reads text files in the default encoding.
            FileReader fileReader = new FileReader(fileName+".txt");
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(fileName+".txt", true)));

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            System.out.print("Date: "+dadm);
            System.out.println("\n\n\n\n\t\t\t\tDetails of the patient:\n\n\n\n");
            while((line = bufferedReader.readLine()) != null) 
            {
                System.out.println(line);
            }   
             System.out.print("\t\t\t\t\t\t _________________________________________________________________ ");
             System.out.println("\n\t\t\t\t\t\t\t\t\tBill of the patient:");
             System.out.print("\t\t\t\t\t\t _________________________________________________________________ \n\n");
             System.out.print("\t\t\t\t\t\tNo.of days patient stayed:");days=scan.nextInt();
             System.out.print("\t\t\t\t\t\tWard charges/day:");wcharge=scan.nextDouble();
             System.out.print("\n\t\t\t\t\t\tTotal ward charges:"+(wcharge*days));
             System.out.print("\n\t\t\t\t\t\tDoctor's fee:");doc=scan.nextDouble();
             System.out.print("\n\t\t\t\t\t\tService charges:");ser=scan.nextDouble();
             System.out.print("\n\t\t\t\t\t\tTOTAL AMOUNT:"+((wcharge*days)+doc+ser));
             out.println("Total Bill:"+((wcharge*days)+doc+ser));
             System.out.print("\n\t\t\t\t\t\t _________________________________________________________________ \n");
            // Always close files.
            out.close();
            bufferedReader.close();         
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + fileName + "'");                
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" + fileName + "'");               
        }
 pressAnyKeyToContinue();
}
void exit()
{
System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\t\t\t\t\t\n");
System.out.print("\t\t\t\t\t _______________________________________________________________________________________ \n");
System.out.print("\t\t\t\t\t|                                           		                                |\n");
System.out.print("\t\t\t\t\t|                                           		                                |\n");
System.out.print("\t\t\t\t\t|                                           		                                |\n");
System.out.print("\t\t\t\t\t|                                           		                                |\n");
System.out.print("\t\t\t\t\t|                                           		                                |\n");
System.out.print("\t\t\t\t\t|                               THANK YOU FOR USING                                     |\n");
System.out.print("\t\t\t\t\t|                                                                                       |\n");
System.out.print("\t\t\t\t\t|                            E-HEALTH CARE MANAGEMENT SYSTEM                            |\n");
System.out.print("\t\t\t\t\t|                                                                                       |\n");
System.out.print("\t\t\t\t\t|                                                                                       |\n");
System.out.print("\t\t\t\t\t|                                                                                       |\n");
System.out.print("\t\t\t\t\t|                                                                                       |\n");
System.out.print("\t\t\t\t\t|                                                                                       |\n");
System.out.print("\t\t\t\t\t|                                              -Brought To You by Fahad,Omer and Yaseen |\n");
System.out.print("\t\t\t\t\t|_______________________________________________________________________________________|\n");
System.out.print("\t\t\t\t\t\n\n\n\n\t\t\t\t\t");
System.exit(0);
}
void info()
{
	System.out.println("\n\nE-Health care management system is command-driven application that helps to manage the record of the patient's as well as generate their hospital bills.");
	System.out.print("\t\t\t\t__________________________________________________________________________________________________________________________________\n");
	System.out.print("\t\t\t\t\tOptions		             | Description\n");
	System.out.print("\t\t\t\t__________________________________________________________________________________________________________________________________\n");
	System.out.println("\t\t\t\t 1 >> Add New Patient Record         | A new patient file can be created by using this module.");
	System.out.println("\t\t\t\t 2 >> Add Diagnosis Information      | Adding day-to-day evaluation of the patient or the diagnosis report in the existing file.");
	System.out.println("\t\t\t\t 3 >> History of the Patient         | Check the previous or existing details of particular patient by using their file name.");
	System.out.println("\t\t\t\t 4 >> Bill of the patient            | Generates the bill of the patient with displaying the details.");        
	System.out.println("\t\t\t\t 5 >> Help			     | Provide the help documentation.");    
	System.out.println("\t\t\t\t 6 >> Exit		             | Exits the application.");
    pressAnyKeyToContinue();
}
}
public class Ehospital
{
public static void main (String args[])
{
  Info i=new Info();
  i.login();
  i.menu();
}
}
