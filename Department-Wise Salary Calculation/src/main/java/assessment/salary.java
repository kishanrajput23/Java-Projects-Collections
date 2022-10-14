package assessment;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class salary {
    public static void main( String [] args) throws Exception
    {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        HashMap<String,Integer> map=new HashMap<String,Integer>();
        String jsonString;
        FileWriter myWriter = new FileWriter("App.json");

        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc =  builder.parse("assessment.xml");
            NodeList departmentList =doc.getElementsByTagName("Department");
            String dep,s;
            int sal,depsal=0;
            for(int k=0; k<departmentList.getLength();k++)
            {
                Node d = departmentList.item(k);
                if(d.getNodeType()==Node.ELEMENT_NODE)
                {
                    Element department = (Element) d;
                    dep = department.getAttribute("name");
                    NodeList employeeList = department.getChildNodes();
                    for(int i=0; i<employeeList.getLength();i++)
                    {
                        Node e = employeeList.item(i);
                        if(e.getNodeType()==Node.ELEMENT_NODE)
                        {
                            Element employee = (Element) e;
                            NodeList salaryList = employee.getChildNodes();

                            Node n = salaryList.item(1);
                            if(n.getNodeType()==Node.ELEMENT_NODE)
                            {
                                Element salary = (Element) n;
                                s = salary.getAttribute("value");
                                sal = Integer.parseInt(s);
                                depsal += sal;
                            }
                        }
                    }
                    map.put(dep,depsal);
                    depsal=0;
                }
            }
            Gson gson = new GsonBuilder().disableHtmlEscaping().create();
            jsonString= gson.toJson(map);
            System.out.println(jsonString);
            myWriter.write(jsonString);
            myWriter.close();
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}
