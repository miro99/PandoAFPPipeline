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
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ajmiro
 */
public class ThumbImageServlet extends HttpServlet {

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
        //PrintWriter out = response.getWriter();
        FileInputStream fis;
        BufferedInputStream bis = null;
        BufferedOutputStream bos = new BufferedOutputStream(response.getOutputStream());
        try {            
            int commentID = Integer.parseInt(request.getParameter("score"));
            File imgFile = GetImageFromStore(commentID);
            fis = new FileInputStream(imgFile);
            bis = new BufferedInputStream(fis);
            
            response.setContentType("image/png");
            response.setContentLength((int) imgFile.length());
            response.setHeader("Content-Disposition", "inline;filename=\"" + imgFile.getName() + "\"");
            
            byte[] buffer = new byte[1024];
            for (int length; (length = bis.read(buffer)) > -1;) {
                bos.write(buffer, 0, length);
            }  
        } finally {            
            //out.close();
            bos.close();
            if (bis != null) {
                bis.close();
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

    private File GetImageFromStore(int score) {
         File imgFile = null;
        if (score == 1) {            
            String relativeWebPath = "Images\\thumb up.png";
            String absoluteDiskpath = getServletContext().getRealPath(relativeWebPath);
            imgFile = new File(absoluteDiskpath);
        }
        
        if (score == 0) {
            String relativeWebPath = "Images\\thumb down.png";
            String absoluteDiskpath = getServletContext().getRealPath(relativeWebPath);
            imgFile = new File(absoluteDiskpath);            
        }
        return imgFile;
    }
}
