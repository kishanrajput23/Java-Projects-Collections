import java.io.*;  
import java.awt.*;  
import java.awt.event.*;  
import javax.swing.*;  
import javax.swing.tree.*;  
/***********************************/  
class Explorer extends JPanel implements ActionListener  
{  
JTextField jtf;  
JTextArea jta;  
JTree tree;  
JButton refresh;  
JTable jtb;  
JScrollPane jsp;  
JScrollPane jspTable;  
  
String currDirectory=null;  
  
final String[] colHeads={"File Name","SIZE(in Bytes)","Read Only","Hidden"};  
String[][]data={{"","","","",""}};  
  
/////////////////////////////////  
Explorer(String path)  
{  
  
jtf=new JTextField();  
jta=new JTextArea(5,30);  
refresh=new JButton("Refresh");  
  
File temp=new File(path);  
DefaultMutableTreeNode top=createTree(temp);  
  
//if(top!=null)  
  
tree=new JTree(top);  
  
jsp=new JScrollPane(tree);  
  
final String[] colHeads={"File Name","SIZE(in Bytes)","Read Only","Hidden"};  
String[][]data={{"","","","",""}};  
jtb=new JTable(data, colHeads);  
jspTable=new JScrollPane(jtb);  
  
setLayout(new BorderLayout());  
add(jtf,BorderLayout.NORTH);  
add(jsp,BorderLayout.WEST);  
add(jspTable,BorderLayout.CENTER);  
add(refresh,BorderLayout.SOUTH);  
  
tree.addMouseListener(  
new MouseAdapter()  
{  
public void mouseClicked(MouseEvent me)  
{  
doMouseClicked(me);  
}  
});  
jtf.addActionListener(this);  
refresh.addActionListener(this);  
}  
///////////////////////////////  
public void actionPerformed(ActionEvent ev)  
{  
File temp=new File(jtf.getText());  
DefaultMutableTreeNode newtop=createTree(temp);  
if(newtop!=null)  
    tree=new JTree(newtop);  
remove(jsp);  
jsp=new JScrollPane(tree);  
setVisible(false);  
add(jsp,BorderLayout.WEST);  
tree.addMouseListener(  
new MouseAdapter()  
{  
public void mouseClicked(MouseEvent me)  
{  
doMouseClicked(me);  
}  
});  
  
setVisible(true);  
}  
//////////////////////////////  
  
DefaultMutableTreeNode createTree(File temp)  
{  
DefaultMutableTreeNode top=new DefaultMutableTreeNode(temp.getPath());  
if(!(temp.exists() && temp.isDirectory()))  
    return top;  
  
fillTree(top,temp.getPath());  
  
return top;  
}  
//////////////////////////////  
void fillTree(DefaultMutableTreeNode root, String filename)  
{  
File temp=new File(filename);  
  
if(!(temp.exists() && temp.isDirectory()))  
    return;  
//System.out.println(filename);  
File[] filelist=temp.listFiles();  
  
for(int i=0; i<filelist.length; i++)  
{  
if(!filelist[i].isDirectory())  
    continue;  
final DefaultMutableTreeNode tempDmtn=new DefaultMutableTreeNode(filelist[i].getName());  
root.add(tempDmtn);  
final String newfilename=new String(filename+"\\"+filelist[i].getName());  
Thread t=new Thread()  
{  
public void run()  
{  
fillTree(tempDmtn,newfilename);  
}//run  
};//thread  
if(t==null)   
    {System.out.println("no more thread allowed "+newfilename);return;}  
t.start();  
}//for  
}//function  
//////////////////////////////  
void doMouseClicked(MouseEvent me)  
{  
TreePath tp=tree.getPathForLocation(me.getX(),me.getY());  
if(tp==null) return;  
//jtf.setText(tp.toString());  
String s=tp.toString();  
s=s.replace("[","");  
s=s.replace("]","");  
s=s.replace(", ","\\");  
//s=s.replace(" ","");  
//int z=s.lastIndexOf("\"\\\"");  
//s="\'"+s; s=s+"\'";  
jtf.setText(s);  
showFiles(s);  
//java.util.StringTokenizer st=new java.util.StringTokenizer(s,",");  
//jtf.setText(jtf.getText()+"="+s);  
  
}  
////////////////////////////////  
void showFiles(String filename)  
{  
File temp=new File(filename);  
data=new String[][]{{"","","",""}};  
remove(jspTable);  
jtb=new JTable(data, colHeads);  
jspTable=new JScrollPane(jtb);  
setVisible(false);  
add(jspTable,BorderLayout.CENTER);  
setVisible(true);  
  
if(!temp.exists()) return;  
if(!temp.isDirectory()) return;  
  
//System.out.println(filename);  
File[] filelist=temp.listFiles();  
int fileCounter=0;  
data=new String[filelist.length][4];  
for(int i=0; i<filelist.length; i++)  
{  
if(filelist[i].isDirectory())  
    continue;  
data[fileCounter][0]=new String(filelist[i].getName());  
data[fileCounter][1]=new String(filelist[i].length()+"");  
data[fileCounter][2]=new String(!filelist[i].canWrite()+"");  
data[fileCounter][3]=new String(filelist[i].isHidden()+"");  
fileCounter++;  
}//for  
  
String dataTemp[][]=new String[fileCounter][4];  
for(int k=0; k<fileCounter; k++)  
    dataTemp[k]=data[k];  
data=dataTemp;  
  
//System.out.println(data);  
remove(jspTable);  
jtb=new JTable(data, colHeads);  
jspTable=new JScrollPane(jtb);  
setVisible(false);  
add(jspTable,BorderLayout.CENTER);  
setVisible(true);  
}  
////////////////////////////////  
///////////////////////////////  
}  
/***********************************/  
class ExplorerTest extends JFrame  
{  
  
ExplorerTest(String path)  
{  
super("Windows Exploder - Javatpoint");  
add(new Explorer(path),"Center");  
setDefaultCloseOperation(EXIT_ON_CLOSE);  
setSize(400,400);  
setVisible(true);  
}  
  
public static void main(String[] args)  
{  
new ExplorerTest(".");  
}  
}  
