// User Bean

package  cs;
import java.sql.*;
import java.util.*;
import javax.naming.*;
import javax.rmi.*;



public class Customer
{
 

    private  String custname;
    private  String password;
    private  String email;
    private  String phoneno;

    private  Context ctx;

    public Context getJNDIContext()
    { 
       return  ctx;
    }

    public Customer() 
    {
       ctx = getInitialContext();
    }

    public  void setCustname(String custname)
    { this.custname = custname; }

    public String getCustname()
    {  return custname; }


    public  void setPhoneno (String phoneno)
    { this.phoneno = phoneno; }

    public String getPhoneno()
    {  return phoneno; }

    public  void setPassword(String password)
    { this.password= password; }

    public String getPassword()
    {  return password; }

    public  void setEmail (String email)
    { this.email = email; }

    public String getEmail()
    {  return email; }

     // returns true if uname and pwd are valid
    public  boolean isValid()
    {
     Connection con = null;
     PreparedStatement ps = null;
     try
     {
      con = getConnection();
      ps = con.prepareStatement("select phoneno, email from customers where custname = ? and pwd= ?");
      ps.setString(1,custname);
      ps.setString(2,password);

      ResultSet rs = ps.executeQuery();
      boolean found = false;

      if ( rs.next())
     {     phoneno = rs.getString("phoneno");
           email = rs.getString("email");
           found = true;
     }
     return found;
  }
  catch(Exception ex)
  {
      System.out.println( ex.getMessage());
      return false;
   }
   finally
  {
       clean(con,ps);
  } 

 } // end of isValid

 public String updatePassword(String newpassword) 
 {
   Connection con = null;
   PreparedStatement ps= null;

   try
   {
     con = getConnection();
     ps = con.prepareStatement("update customers set pwd = ? where custname = ?");
     ps.setString(1,newpassword);
     ps.setString(2,custname);

     int cnt = ps.executeUpdate();
     if ( cnt==1 ) 
        return null;
     else
        return "Invalid Username!";
      
  }
  catch(Exception ex)
  {
      System.out.println( ex.getMessage());
      return ex.getMessage();
  }
  finally
  {
       clean(con,ps);
  } 

 } // end of updatePassword

 public String  registerUser()
 {
    Connection con = null;
    PreparedStatement ps = null;

    try
    {
        con = getConnection();
        ps = con.prepareStatement("insert into customers values (?,?,?,?)");
        ps.setString(1,custname);
        ps.setString(2,password);
        ps.setString(3,email);
        ps.setString(4,phoneno);
        ps.executeUpdate();
        return null;

    }
    catch(Exception ex)
    {
       return ex.getMessage();
    }
    finally
    {  clean(con,ps); }
 }

        


 public  void clean(Connection con, PreparedStatement ps)
 { 
   try
   { if ( ps != null )  ps.close();
     if ( con != null) con.close();
    }
    catch(Exception ex)
    { System.out.println(ex.getMessage()); }
 }

 public Connection getConnection() throws Exception
 {
   Class.forName("oracle.jdbc.driver.OracleDriver"); 
   // connect using Thin driver
   Connection con =   DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:oracle8i",
		"custsup","custsup");

   return con;
 }    

 
 public Context getInitialContext() 
 {
 
  String JNDI_FACTORY="weblogic.jndi.WLInitialContextFactory";

  try
  {
   Hashtable env = new Hashtable();
   env.put(Context.INITIAL_CONTEXT_FACTORY, JNDI_FACTORY);
   env.put(Context.PROVIDER_URL,"t3://localhost:7001");
   return new InitialContext(env);
  }
  catch(Exception ex)
  { 
    System.out.println(ex.getMessage()); 
    return null;
  }

 }
  

} // end of bean
  
       
    
   




