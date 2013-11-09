/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PandoAFP;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Set;
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
public class DocumentViewServlet extends HttpServlet {

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
            throws ServletException, IOException, NumberFormatException, SQLException, NamingException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            Document document = getDocumentFromRequest(request);
            setDocumentNextPrevPages(request, document);
            forwardToPage(request, response, document);
        } finally {
            out.close();
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
        try {
            processRequest(request, response);
        } catch (NumberFormatException ex) {
            Logger.getLogger(DocumentViewServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DocumentViewServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(DocumentViewServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (NumberFormatException ex) {
            Logger.getLogger(DocumentViewServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DocumentViewServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(DocumentViewServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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

    private void setDocumentNextPrevPages(HttpServletRequest request, Document document) throws NumberFormatException {
        int currentPage = Integer.parseInt(request.getParameter("page"));
        document.setNextPage(currentPage + 1);                       
        document.setPrevPage(currentPage - 1);
    }

    private Document getDocumentFromRequest(HttpServletRequest request) throws NumberFormatException, SQLException, NamingException {
        int documentID = Integer.parseInt(request.getParameter("document"));
        DocumentType documentType = null;
        try {
            documentType = (DocumentType) request.getSession().getAttribute("documenttype");
        } catch (Exception e) {
            Pipeline p = (Pipeline)request.getSession().getAttribute("pipeline");
            if (documentType == null) {            
                int dtID = Integer.parseInt(request.getParameter("dt"));
                documentType = p.getDocTypeByID(dtID);
            }
            int candidateID = Integer.parseInt(request.getParameter("candidate"));
            Candidate candidate = p.findCandidate(candidateID);
            documentType.initDocuments(p.getId(), candidate);
            Document document = documentType.getDocument(documentID);
            request.getSession().setAttribute("documenttype", documentType);
            request.getSession().setAttribute("candidateOBJ", candidate);
            return document;
        }

        Document document = documentType.getDocument(documentID);
        return document;
    }

    private void forwardToPage(HttpServletRequest request, HttpServletResponse response, Document document) throws IOException, ServletException {
        request.getSession().setAttribute("document", document);
        request.getRequestDispatcher("DocumentView.jsp?").forward(request, response);
    }
}
