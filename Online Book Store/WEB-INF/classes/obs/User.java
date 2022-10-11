// User Bean

package  obs;
import java.sql.*;
import java.util.*;


public class User
{
    private  int userid;
    private  String uname;
    private  String pwd;
    private  String email;
    private  String address;
    private  String phone;

    private  boolean logged = false;

    public int getUserid()
    {  return userid; }

    public  void setUname(String uname)
    { this.uname = uname; }

    public String getUname()
    {  return uname; }

    public  void setPwd(String pwd)
    { this.pwd= pwd; }

    public String getPwd()
    {  return pwd; }

    public  void setEmail (String email)
    { this.email = email; }

    public String getEmail()
    {  return email; }

    public  void setAddress(String address)
    { this.address = address; }

    public String getAddress()
    {  return address; }


    public  void setPhone(String phone)
    { this.phone = phone; }

    public String getPhone()
    {  return phone; }


    public void login()
    {
     Connection con = null;
     PreparedStatement ps = null;
     try
     {
      con = getConnection();
      ps = con.prepareStatement("select userid,email,phone,address from users where uname = ? and pwd= ?");
      ps.setString(1,uname);
      ps.setString(2,pwd);

      ResultSet rs = ps.executeQuery();

      logged = false;

      if ( rs.next())
      {    userid = rs.getInt("userid");
           email = rs.getString("email");
           address = rs.getString("address");
           phone = rs.getString("phone");
           logged = true;
     }
   
  }
  catch(Exception ex)
  {
      System.out.println( ex.getMessage());
  }
  finally
  {
       clean(con,ps);
  } 

 } // end of isValid



 public String updateProfile(String newpwd) 
 {
   Connection con = null;
   PreparedStatement ps= null;

   try
   {
     con = getConnection();
     String cmd = "update users set email=?, phone  = ? , address =? ";
 
     if (! newpwd.equals(""))
         cmd += " , pwd = '" + newpwd + "'";
     
     cmd = cmd + " where userid  = ?";

     ps = con.prepareStatement(cmd);
     ps.setString(1,email);
     ps.setString(2,phone);
     ps.setString(3,address);
     ps.setInt(4,userid);

     int cnt = ps.executeUpdate();
     if ( cnt==1 ) 
     {
        if ( ! newpwd.equals("") )
                pwd  = newpwd; 
        return null;
     }
     else
        return "Invalid User. Unable to update profile.";
      
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

 } // end of updateProfile



 public String  registerUser()
 {
    Connection con = null;
    PreparedStatement ps = null;

    try
    {
        con = getConnection();
        userid = getNextUserid(con);
        ps = con.prepareStatement("insert into users values (?,?,?,?,?,?)");
        ps.setInt(1,userid);
        ps.setString(2,uname);
        ps.setString(3,pwd);
        ps.setString(4,email);
        ps.setString(5,address);
        ps.setString(6,phone);
        ps.executeUpdate();
        logged = true;
        return null;
    }
    catch(Exception ex)
    {
       return ex.getMessage();
    }
    finally
    {  clean(con,ps); }
 }

 public boolean isLogged()
 { return logged; }


 public int getNextUserid(Connection con)  throws Exception
 {
    PreparedStatement ps = null;
    ps = con.prepareStatement("select nvl( max(userid),0) + 1 from users");
    ResultSet rs = ps.executeQuery();
    rs.next();
    int nextuserid = rs.getInt(1);
    rs.close();

    return  nextuserid; 
     
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
   Connection con =   DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:oracle9i",
		"obs","obs");
   return con;
 }    

} // end of bean
  
       
    
   




