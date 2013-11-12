/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PandoAFP;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;

/**
 *
 * @author ajmiro
 */
public class Candidate {
    
    private String firstName;
    private String lastName;
    private int id;
    private String title;    
    private int commentCount;
    
    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    public Candidate(String firstName, String lastName, String address, int id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.title = address;
        this.id = id;
    }  

    /**
     * @return the address
     */
    public String getTitle() {
        return title;
    }   

    /**
     * @return the commentCount
     */
    public int getCommentCount() {
        Connection connection = null;
        try {            
            connection = getDBConnection();
            String sql = "SELECT COUNT(ID) as 'count' FROM CandidateRanking WHERE Candidate = " + this.id;
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            result.next();
            commentCount = result.getInt("count");
        } catch (SQLException ex) {
            Logger.getLogger(Candidate.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Candidate.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return commentCount;
    }
    
    private Connection getDBConnection() {
        Connection connection = null;
        try {
            Data data = new Data();
            connection = data.createDbConnection();            
        } catch (SQLException ex) {
            Logger.getLogger(Candidate.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(Candidate.class.getName()).log(Level.SEVERE, null, ex);
        }
        return connection;
    }
}
