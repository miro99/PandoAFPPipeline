/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PandoAFP;

/**
 *
 * @author ajmiro
 */
public class DocumentType {
    private String name;
    private int id;
    private Document documents[];
    private static DocumentType[] types;

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

    public DocumentType(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public DocumentType() {
        types = getDocumentTypesFromDataStore();
    }
    
     public DocumentType[] getDocumentTypes() {
        return types;
    }
    
    public void initDocuments(int pipelineID){      
        //Get documents of specified type from data store.
        Document[] documents = new Document[3];
        documents[0] = new Document(1, "Resume 1");
        documents[1] = new Document(2, "Resume 2");
        documents[2] = new Document(3, "Resume 3");        
        this.documents = documents;                
    }
    
    public Document getDocument(int id) {
        return  documents[id-1];
    }

    /**
     * @return the documents
     */
    public Document[] getDocuments() {
        return documents;
    }

    private DocumentType[] getDocumentTypesFromDataStore() {        
            //Get document types from data store
            DocumentType[] docTypes = new DocumentType[3];
            docTypes[0] = new DocumentType("Resume", 1);
            docTypes[1] = new DocumentType("Profile", 2);
            docTypes[2] = new DocumentType("Recommendations", 3);
            return docTypes;
    }
}
