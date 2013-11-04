/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PandoAFP;

/**
 *
 * @author ajmiro
 */
public class Document {
    
    private String name;
    private int id;
    private DocumentType type;
    private Candidate candidate;
    private int nextPage = -1;
    private int prevPage = -1;

    protected Document(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Document() {
    }
    
    

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param type the type to set
     */
    public void setType(DocumentType type) {
        this.type = type;
    }

    /**
     * @param candidate the candidate to set
     */
    public void setCandidate(Candidate candidate) {
        this.candidate = candidate;
    }

    /**
     * @return the nextPage
     */
    public int getNextPage() {
        return nextPage;
    }

    /**
     * @param nextPage the nextPage to set
     */
    public void setNextPage(int nextPage) {
        this.nextPage = nextPage;
    }

    /**
     * @return the prevPage
     */
    public int getPrevPage() {
        return prevPage;
    }

    /**
     * @param prevPage the prevPage to set
     */
    public void setPrevPage(int prevPage) {
        this.prevPage = prevPage;
    }
    
    
}
