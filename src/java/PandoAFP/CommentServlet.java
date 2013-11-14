/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PandoAFP;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ajmiro
 */
public class CommentServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        Connection connection = null;
        try {

            String comment = getComment(request);
            String score = getScore(request);            
            connection = createDBConnection();
            Candidate candidate = getCandidate(request);
            saveComment(comment,score, candidate,connection);
            redirectUser(response);
        } catch (SQLException ex) {
            Logger.getLogger(CommentServlet.class.getName()).log(Level.SEVERE, null, ex);
        } finally {            
            out.close();
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CommentServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
          

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private Connection createDBConnection() {
        Connection connection = null;
        try {
            Data data = new Data();            
            connection = data.createDbConnection();            
        } catch (SQLException ex) {
            Logger.getLogger(CommentServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(CommentServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
            return connection;
    }      
    
    private void saveComment(String comment, String score, Candidate candidate, Connection connection) throws SQLException {
        //Write comment and ranking to UserRankingCandidate table
        //We are going to make the User ID static for now
        //This will be made dynamic when login feature is implemented.
        StringBuilder insertStatement = new StringBuilder("INSERT INTO CandidateRanking (Review, Score, Candidate, TimeStamp) VALUES(");
        insertStatement.append("'").append(comment.trim()).append("'").append(",")
                .append(score).append(",");
        insertStatement.append(candidate.getId()).append(",").append("now()").append(")");
        PreparedStatement statement = connection.prepareStatement(insertStatement.toString());
        boolean execute = statement.execute();
    }

    private String getComment(HttpServletRequest request) {
        /* TODO output your page here. You may use following sample code. */
        String comment = (String)request.getParameter("comment");
        return comment;
    }

    private String getScore(HttpServletRequest request) {
        String goodBadValue = (String)request.getParameter("goodBad");
        return goodBadValue;
    }

    private Candidate getCandidate(HttpServletRequest request) {
        Candidate candidate = (Candidate)request.getSession().getAttribute("candidateOBJ");
        return candidate;
    }

    private void redirectUser(HttpServletResponse response) throws IOException {
        //Redirect instead of forward to avoid duplication of data on page refresh.
        String urlWithSessionID = response.encodeRedirectURL("ShowComments.jsp?");
        response.sendRedirect(urlWithSessionID);
    }
}
