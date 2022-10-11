import java.io.*;
public class reservation
{
InputStreamReader isr=new InputStreamReader (System.in);
BufferedReader br=new BufferedReader (isr);
//System.out.print("Please enter a word");
int pno[]=new int[275];
String name[]=new String[275];
String phno[]=new String[275];
int age[]=new int[275];
int cl[]=new int[275];
int pcount=0;
int pnum=1;
int max1=75;
int max2=125;
int max3=175;
 public void doMenu() throws Exception
{
int cho=0;
do
{
System.out.println("\f");
doHeading();
System.out.println("1.Book ticket");
System.out.println("2.Cancel ticket");
System.out.println("3.Search passenger");
System.out.println("4.Reservation chart");
System.out.println("5.Display unbooked tickets");
System.out.println("6.Exit");
System.out.println("Please enter your choice");
cho=Integer.parseInt(br.readLine());
switch(cho)
{
case 1:doBook();
break;
case 2:doCancel();
break;
case 3:doSearch();
break;
case 4:doDispList();
break;
case 5:doDispUnbooked();
break;
case 6:doExit();
break;
default :System.out.println("Invalid choice");
}
char e=(char)br.read();
}while(cho!=6);
}
private void doHeading()throws Exception
{
System.out.println("#########################################################");
System.out.println("*********Railway Reservation For Kabul Express***********");
System.out.println("#########################################################");
}
private void doBook()throws Exception
{
System.out.println("Please enter the class of ticket");
System.out.println("1. AC\t 2. First\t 3. Sleeper\t");
int c=Integer.parseInt(br.readLine());
System.out.println("Please enter no. of tickets");
int t=Integer.parseInt(br.readLine());
int ticketAvailable=0;
if(c==1 && max1>=t)
{
ticketAvailable=1;
}
if(c==2 && max2>=t)
{
ticketAvailable=1;
}
if(c==3 && max3>=t)
{
ticketAvailable=1;
}
if(ticketAvailable==1)
{
for(int i=0;i<t;i++)
{
pno[pcount]=pnum;
System.out.println("Please enter your name");
name[pcount]=br.readLine();
System.out.println("Please enter your age");
age[pcount]=Integer.parseInt(br.readLine());
cl[pcount]=c;
System.out.println("Please enter your phno");
phno[pcount]=br.readLine();
pcount++;
pnum++;
System.out.println("Ticket successfully booked");
}//for
if(c==1)
{
max1-=t;
System.out.println("Please pay Rs."+t*1500);
}
if(c==2)
{
max2-=t;
System.out.println("Please pay Rs."+t*1200);
}
if(c==3)
{
max3-=t;
System.out.println("Please pay Rs."+t*1000);
}
}
}
private void doCancel()throws Exception
{
int t_pno[]=new int[275];
String t_name[]=new String[275];
String t_phno[]=new String[275];
int t_age[]=new int[275];
int t_cl[]=new int[275];
int t_pcount=0;
int passengerFound=0;
System.out.println("Please enter your passenger no.");
int p=Integer.parseInt(br.readLine());
for(int i=0;i<pcount;i++)
{
if(pno[i]!=p)
{//transfer
t_pno[t_pcount]=pno[i];
t_name[t_pcount]=name[i];
t_phno[t_pcount]=phno[i];
t_age[t_pcount]=age[i];
t_cl[t_pcount]=cl[i];
t_pcount++;
}
else
{
passengerFound=1;
if(cl[i]==1)
{
max1++;
System.out.println("Please collect refund of Rs."+1800);
}
if(cl[i]==2)
{
 max2++;
System.out.println("Please collect refund of Rs."+1500);
}
 if(cl[i]==3)
 {
 max3++;
System.out.println("Please collect refund of Rs."+1000);
}//else
}//if
}
if(passengerFound==1)
{
pno=t_pno;
name=t_name;
age=t_age;
cl=t_cl;
phno=t_phno;
pcount=t_pcount;
System.out.println("ticket successfully cancelled");
 }
}//method
private void doDispList()throws Exception
{
System.out.println("Passenger list in AC class");
System.out.println("pno \t name \t\t age \t phno");
for(int i=0;i<pcount;i++)
{
if(cl[i]==1)
{
System.out.println(pno[i]+"\t"+name[i]+"\t\t"+age[i]+"\t"+phno[i]);
}
}
System.out.println("Passenger list in First class");
System.out.println("pno \t name \t\t age \t phno");
 for(int i=0;i<pcount;i++)
 {
if(cl[i]==2)
{
System.out.println(pno[i]+"\t"+name[i]+"\t\t"+age[i]+"\t"+phno[i]);
}
}
System.out.println("Passenger list in Sleeper class");
System.out.println("pno \t name \t\t age \t phno");
 for(int i=0;i<pcount;i++)
 {
if(cl[i]==3)
{
System.out.println(pno[i]+"\t"+name[i]+"\t\t"+age[i]+"\t"+phno[i]);
}
}
}
private void doSearch()throws Exception
{
int passengerFound=0;
System.out.println("Please enter passenger no. to search");
int p=Integer.parseInt(br.readLine());
for(int i=0;i<pcount;i++)
{
if(pno[i]==p)
{
System.out.println("Detail found");
passengerFound=1;
 System.out.println("passenger no.="+pno[i]); 
 System.out.println("name="+name[i]);
 System.out.println("class="+cl[i]); 
 System.out.println("phno="+phno[i]);
System.out.println("age="+age[i]);
}
}//for
if(passengerFound==0)
System.out.println("No such passenger");
}//method
private void doDispUnbooked()throws Exception
{
System.out.println("No. of booked tickets status");
System.out.println("AC class"+max1);
System.out.println("First class"+max2);
System.out.println("Sleeper class"+max3);
}
private void doExit()
{
System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
System.out.println("Project done by: Nikhil Falke");
System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
}
}