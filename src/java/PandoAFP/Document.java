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
    private static DocumentType[] documentTypes;
      
    /**
     * @return the documentTypes
     */
    public static DocumentType[] getDocumentTypes() {
        //Get document types from data store
        DocumentType[] docTypes = new DocumentType[3];
        docTypes[0] = new DocumentType("Resume", 1);
        docTypes[1] = new DocumentType("Profile", 2);
        docTypes[2] = new DocumentType("Recommendations", 3);
        documentTypes = docTypes;

        return documentTypes;
    }
    
    public static Document[] getDocumentsOfDocumentType(DocumentType documentType){
        //Get documents of specified type from data store.
        Document[] documents = new Document[3];
        documents[0] = new Document(1, "Resume 1");
        documents[1] = new Document(2, "Resume 2");
        documents[2] = new Document(3, "Resume 3");
        
        return documents;
    }

    private Document(int id, String name) {
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
    
    
}
