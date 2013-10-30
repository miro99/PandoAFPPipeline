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
    //private static DocumentType[] documentTypes;
    private DocumentType type;
    private Candidate candidate;
              
//    public static Document[] getDocumentsOfDocumentType(){
//        
//        //Uset the variables type and candidate to filter out the returned
//        //documents.
//        
//        //Get documents of specified type from data store.
//        Document[] documents = new Document[3];
//        documents[0] = new Document(1, "Resume 1");
//        documents[1] = new Document(2, "Resume 2");
//        documents[2] = new Document(3, "Resume 3");
//        
//        return documents;
//    }

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
    
    
}
