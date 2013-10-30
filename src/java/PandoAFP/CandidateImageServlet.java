/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PandoAFP;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
public class CandidateImageServlet extends HttpServlet {

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
        BufferedOutputStream bos = new BufferedOutputStream(response.getOutputStream());
        try {            
            String candidateID = (String) request.getParameter("candidateID");            
            /* TODO output your page here. You may use following sample code. */                
            File imgFile = GetImageFromStore(candidateID);

            FileInputStream fis = new FileInputStream(imgFile);
            BufferedInputStream bis = new BufferedInputStream(fis);

            response.setContentType("image/jpg");
            response.setContentLength((int) imgFile.length());
            response.setHeader("Content-Disposition", "inline;filename=\"" + imgFile.getName() + "\"");

            byte[] buffer = new byte[1024];
            for (int length; (length = bis.read(buffer)) > -1;) {
                bos.write(buffer, 0, length);
            }                            
        }
        finally {            
            //out.close();
            bos.close();
        }
    }
    
    public File GetImageFromStore(String id) throws FileNotFoundException{
        File imgFile = null;
        if (id.equals("1")) {
            imgFile = new File("C:\\Users\\ajmiro.DSG\\Documents\\NetBeansProjects\\PandoAFPPipeline\\web\\Images\\code_monkey.jpg");            
        }
        else{
            imgFile = new File("C:\\Users\\ajmiro.DSG\\Documents\\NetBeansProjects\\PandoAFPPipeline\\web\\Images\\Icon-user.png");
        }
        return imgFile;
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
}
