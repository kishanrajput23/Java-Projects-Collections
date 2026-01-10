package obs.order;

import java.rmi.RemoteException;
import javax.ejb.CreateException;
import javax.ejb.EJBHome;

public interface OrderHome extends EJBHome {
   Order create() throws CreateException, RemoteException;
   void backupOrderData() throws RemoteException;

   void restoreOrderData() throws RemoteException;

   void generateAnalyticsReport() throws RemoteException;

}
