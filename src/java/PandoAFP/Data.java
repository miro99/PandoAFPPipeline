/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PandoAFP;

import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author ajmiro
 */
public class Data {

    protected Connection createDbConnection() throws SQLException, NamingException {
        //Open a connection to the data store
        Context initialContext = new InitialContext();
        Context context = (Context) initialContext.lookup("java:comp/env");
        DataSource dataSource = (DataSource) context.lookup("jdbc/pando_afp");
        Connection connection = (Connection) dataSource.getConnection();
        return connection;
    }
    
}
