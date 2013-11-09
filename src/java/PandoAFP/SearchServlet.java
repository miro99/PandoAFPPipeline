/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PandoAFP;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.lucene.analysis.core.SimpleAnalyzer;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexableField;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopScoreDocCollector;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;

/**
 *
 * @author ajmiro
 */
public class SearchServlet extends HttpServlet {

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
            throws ServletException, IOException, ParseException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        IndexReader reader = null;
        try {
            /* TODO output your page here. You may use following sample code. */
            String searchTerm = "\"" + request.getParameter("txtkeyword") + "\"";
            
            SimpleAnalyzer analyzer = new SimpleAnalyzer(Version.LUCENE_45);                        
            Directory index = FSDirectory.open(new File("C:\\Lucene\\Index"));            
            Query q = new QueryParser(Version.LUCENE_45,"Text", analyzer).parse(searchTerm);
            int hitsPerPage = 10;
            
            reader = IndexReader.open(index);
            IndexSearcher searcher = new IndexSearcher(reader);
            TopScoreDocCollector collector = TopScoreDocCollector.create(hitsPerPage, true);
            searcher.search(q, collector);
            ScoreDoc[] hits = collector.topDocs().scoreDocs;
            
            Pipeline pipeline = (Pipeline)request.getSession().getAttribute("pipeline");
            ArrayList<SearchResult> results = new ArrayList<SearchResult>();
             if (hits.length > 0) {
                for (int i = 0; i < hits.length; i++) {
                    int docID = hits[i].doc;
                    org.apache.lucene.document.Document d = searcher.doc(docID);
                    IndexableField indexableField = d.getField("Candidate");
                    IndexableField indexableField1 = d.getField("DocType");                            
                    Candidate candidate = pipeline.findCandidate(Integer.parseInt(indexableField.stringValue()));
                    DocumentType documentType;
                    documentType = pipeline.getDocTypeByID(Integer.parseInt(indexableField1.stringValue()));
                    SearchResult res = new SearchResult(candidate, documentType, d.getField("DocumentID").stringValue());
                    results.add(res);
//                    out.println("<H1>" + candidate.getLastName() +", " + candidate.getFirstName() + "</H1>");                                     
//                    out.println(documentType.getName());
                }
            }            
             
            SearchResult[] sr = new SearchResult[0];
            sr = results.toArray(sr);
            Results r = new Results(sr);
            request.getSession().setAttribute("results", r);
            request.getSession().setAttribute("documenttype", out);
            request.getRequestDispatcher("SearchResults.jsp?").forward(request, response);            
        } finally {            
            if (reader != null) {
                reader.close();
            }
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
        } catch (ParseException ex) {
            Logger.getLogger(SearchServlet.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (ParseException ex) {
            Logger.getLogger(SearchServlet.class.getName()).log(Level.SEVERE, null, ex);
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
}
