/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PandoAFP;

/**
 *
 * @author ajmiro
 */
public class SearchResult {
    private Candidate candidate;
    private DocumentType documentType;
    private String documentID;

    public SearchResult(Candidate candidate, DocumentType documentType, String documentID) {
        this.candidate = candidate;
        this.documentType = documentType;
        this.documentID = documentID;
    }    
    
    /**
     * @return the candidate
     */
    public Candidate getCandidate() {
        return candidate;
    }

    /**
     * @return the documentType
     */
    public DocumentType getDocumentType() {
        return documentType;
    }

    /**
     * @return the documentID
     */
    public String getDocumentID() {
        return documentID;
    }
}
