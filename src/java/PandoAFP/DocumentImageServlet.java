/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PandoAFP;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ajmiro
 */
public class DocumentImageServlet extends HttpServlet {

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
        BufferedOutputStream outputStream = new BufferedOutputStream(response.getOutputStream());
        BufferedInputStream bis = null;
        File image;
        FileInputStream is = null;
        try {            
            image = loadImage(request);            
            is = new FileInputStream(image);
            bis = new BufferedInputStream(is);
            
            initializeResponse(response, image);
            writeImageToOutputStream(bis, outputStream);
        } finally {                        
            outputStream.close();
            if (bis != null) {
                bis.close();
            }
            if (is != null){
                is.close();
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

    private File getImageFromStore(int candidateID, int documentID, int page) {
        File imgFile;
        String relativeWebPath = "Images\\CandidateFiles\\";
        String absoluteDiskpath = getServletContext().getRealPath(relativeWebPath);        
        StringBuilder sbImageFilePath = new StringBuilder(absoluteDiskpath);
        sbImageFilePath.append("\\").append(candidateID).append("\\");
        sbImageFilePath.append(documentID).append("\\");
        sbImageFilePath.append(page).append(".png");        
        imgFile = new File(sbImageFilePath.toString());
        return imgFile;
    }
    
    private File loadImage(HttpServletRequest request) {
        int page = Integer.parseInt(request.getParameter("page"));
        int documentID = Integer.parseInt(request.getParameter("documentID"));
        Candidate candidate = (Candidate)request.getSession().getAttribute("candidateOBJ");          
        File image = getImageFromStore(candidate.getId(), documentID, page);
        return image;
    }

    private void initializeResponse(HttpServletResponse response, File image) {
        response.setContentType("image/png");
        response.setContentLength((int) image.length());            
        StringBuilder header = new StringBuilder("inline;filename=\"");
        header.append(image.getName()).append("\"");
        response.setHeader("Content-Disposition", header.toString());
    }

    private void writeImageToOutputStream(BufferedInputStream bis, BufferedOutputStream outputStream) throws IOException {
        byte[] buffer = new byte[1024];
        for (int length; (length = bis.read(buffer)) > -1;) {
            outputStream.write(buffer, 0, length);
        }
    }
    
}
