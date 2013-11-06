/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PandoAFP;

import com.sun.org.apache.bcel.internal.generic.ARRAYLENGTH;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.naming.NamingException;

/**
 *
 * @author ajmiro
 */
public class DocumentType extends Data{
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
    
    public void initDocuments(int pipelineID) throws SQLException, NamingException{      
        Document[] docs = getDocumentsFromStore(pipelineID);        
        this.documents = docs;                
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

    private Document[] getDocumentsFromStore(int pipelineID) throws SQLException, NamingException {
        //Get documents of specified type from data store.
//        Document[] docs = new Document[3];
//        docs[0] = new Document(1, "Resume 1");
//        docs[1] = new Document(2, "Resume 2");
//        docs[2] = new Document(3, "Resume 3");
//        return docs;
        Connection connection = null;
        Document[] docs;
        try
        {            
            connection = createDbConnection();
            StringBuilder sbSqlGetDocumentsForPipelineAndDocument = new StringBuilder("SELECT * FROM document WHERE pipeline = ");
            sbSqlGetDocumentsForPipelineAndDocument.append(pipelineID).append(" AND document_type = ").append(this.id);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sbSqlGetDocumentsForPipelineAndDocument.toString());            
            docs = new Document[0];
            ArrayList<Document> arrDocuments = new ArrayList<Document>();
            while (resultSet.next()) {
                Document document = new Document(resultSet.getInt("id"), resultSet.getString("name"));
                arrDocuments.add(document);
            }
            docs = arrDocuments.toArray(docs);
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
        return docs;
    }
}
