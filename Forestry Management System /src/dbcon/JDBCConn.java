// Decompiled by DJ v3.5.5.77 Copyright 2003 Atanas Neshkov  Date: 9/18/2008 6:10:33 PM
// Home Page : http://members.fortunecity.com/neshkov/dj.html  - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   JDBCConn.java

package dbcon;

import java.sql.Connection;
import java.sql.DriverManager;

// Referenced classes of package dbcon:
//            JDBCInfo

public class JDBCConn
{

    public JDBCConn()
    {
    }

    public static Connection getConnection()
        throws Exception
    {
        Class.forName(JDBCInfo.DRIVER);
        return DriverManager.getConnection(JDBCInfo.URL, JDBCInfo.USER, JDBCInfo.PASS);
    }
}