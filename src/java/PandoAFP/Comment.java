/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PandoAFP;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;

/**
 *
 * @author ajmiro
 */
public class Comment {
    
    private int id;
    private int score;
    private int user;
    private int candidateID;
    private Timestamp timeStamp;
    private String review;

    public Comment(int id, int score, int user, int candidateID, Timestamp timeStamp, String review) {
        this.id = id;
        this.score = score;
        this.user = user;
        this.candidateID = candidateID;
        this.timeStamp = timeStamp;
        this.review = review;
    }
    
    
 
    public static int getCommentCountForCandidate(Candidate c){
        Connection connection = null;
        int commentCount = -2;
        try {            
            connection = getDBConnection();
            String sql = "SELECT COUNT(ID) as 'count' FROM CandidateRanking WHERE Candidate = " + c.getId();
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
    
    public static int getPositiveCommentCountForCandidate(Candidate c) {
        Connection connection = null;
        int commentCount = -2;
        try {            
            connection = getDBConnection();
            String sql = "SELECT COUNT(ID) as 'count' FROM CandidateRanking WHERE Candidate = " + c.getId() + " AND score = 1";
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
    
    public static int getNegativeCommentCountForCandidate(Candidate c) {
        Connection connection = null;
        int commentCount = -2;
        try {            
            connection = getDBConnection();
            String sql = "SELECT COUNT(ID) as 'count' FROM CandidateRanking WHERE Candidate = " + c.getId() + " AND score = 0";
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

    public static Comment[] getCommentsForCandidate(Candidate c){

        String sql = "SELECT * FROM CandidateRanking WHERE Candidate = " + c.getId();
        Connection connection = null;
        Comment[] comments = new Comment[0];
        ArrayList<Comment> arrComments = null;
        try {
            connection = getDBConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            arrComments = new ArrayList<Comment>();
            while (rs.next()) {
                int id = rs.getInt("ID");
                int score = rs.getInt("Score");
                int user = rs.getInt("User");
                int candidateID = rs.getInt("Candidate");
                Timestamp timeStamp = rs.getTimestamp("TimeStamp");
                String review = rs.getString("review");
                arrComments.add(new Comment(id, score, user, candidateID, timeStamp, review));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Comment.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Comment.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        if (arrComments != null) {
            comments = arrComments.toArray(comments);    
        }
        return comments;
    }
    
    public static int getCommentEmotion(int commentID) {
        return 1;
    }
    
    private static Connection getDBConnection() {
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

    /**
     * @return the score
     */
    public int getScore() {
        return score;
    }

    /**
     * @return the user
     */
    public User getUser() {
        //return user;
        User u = new User();
        return u;
    }

    /**
     * @return the candidateID
     */
    public int getCandidateID() {
        return candidateID;
    }

    /**
     * @return the timeStamp
     */
    public Timestamp getTimeStamp() {
        return timeStamp;
    }

    /**
     * @return the review
     */
    public String getReview() {
        return review;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }
}
