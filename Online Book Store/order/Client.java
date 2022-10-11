package st.hello;

import java.rmi.RemoteException;
import java.util.Properties;
import javax.naming.*;
import javax.ejb.*;
import javax.rmi.PortableRemoteObject;

public class Client {
  private static final String JNDI_NAME = "st.hello";

  public static void main(String[] args) throws Exception 
  {
    String url       = "t3://localhost:7001";

    Properties h = new Properties();
    h.put(Context.INITIAL_CONTEXT_FACTORY,
        "weblogic.jndi.WLInitialContextFactory");
    h.put(Context.PROVIDER_URL, url);
    Context ctx = new InitialContext(h);

    // Lookup the beans home using JNDI
 
    Object home = ctx.lookup(JNDI_NAME);
    HelloHome hellohome = (HelloHome) PortableRemoteObject.narrow(home,HelloHome.class);

    Hello hello = hellohome.create();
 
    System.out.println(hello.sayHello("Srikanth"));
    
  }

  
}
