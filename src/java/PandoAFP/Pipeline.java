/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PandoAFP;

//import com.mysql.jdbc.Connection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;

/**
 *
 * @author ajmiro
 */
public class Pipeline extends Data {
    private String name;
    private int id;
    private String note;
    
    private Candidate[] candidates;
    private DocumentType[] documentTypes;
  
    public Pipeline() {           
    }
    
    public Pipeline(int id) throws NamingException, SQLException {                
        this.id = id;
        getCandidatesFromStore();
        getDocumentTypesFromStore();
    }
    
    public void Init(int id){
        this.setId(id);
    }
    
    /**
     * @return the name
     */
    public String getName() throws SQLException, NamingException {
        if (name == null) {
            //Get the name from the data store
            this.name = getNameFromDataStore();
        }
        return name;
    }

    private String getNameFromDataStore() throws SQLException, NamingException {
        Connection connection = null;
        ResultSet resultSet = null;
        try {            
            connection = createDbConnection();
            String sqlStatement = createGetNameSQLStatement();
            Statement statement = connection.createStatement();
            
            resultSet = statement.executeQuery(sqlStatement);
            if (resultSet.next()) {
                return resultSet.getString("Name");
            }
            else {
                return "Unnamed Pipeline";
            }
        } catch (SQLException ex) {
            Logger.getLogger(Pipeline.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        } catch (NamingException ex) {
            Logger.getLogger(Pipeline.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
        finally {
            if (resultSet != null) {
                resultSet.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }
    
    /**
     *
     * @return the candidates for this pipeline
     */
    public Candidate[] getCandidates() {
        //Get candidates for this pipeline from the data store              
        return candidates;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }
    
    public Candidate findCandidate(int id){        
        //return new Candidate("AJ", "Miro", 1);
        return candidates[id - 1];
    }

    private void getCandidatesFromStore() throws NamingException, SQLException {
        //        this.candidates = new Candidate[3];
        //        candidates[0] = new Candidate("AJ", "Miro", "1013 East 156 St <BR/> Bronx NY, 10455", 1);
        //        candidates[1] = new Candidate("Adam", "Dub", "No Address", 2 );
        //        candidates[2] = new Candidate("Eitan", "Dub", "No Address", 3);
        
        Connection connection = null;
        ResultSet resultSet = null;
        try {            
            connection = createDbConnection();
            StringBuilder sbGetCandidateSql = createGetCandidateSQLStatement();

            Statement statement = connection.createStatement();            
            resultSet = statement.executeQuery(sbGetCandidateSql.toString());

            //Get all of the candidates for this pipeline
            ArrayList<Candidate> arrCandidates = new ArrayList<Candidate>();
            while (resultSet.next()) {
                Candidate candidate = new Candidate(resultSet.getString("First"), resultSet.getString("Last"), resultSet.getString("Title"), resultSet.getInt("ID"));
                arrCandidates.add(candidate);
            }
            if (arrCandidates.isEmpty() == false) {
                this.candidates = new Candidate[0];
                this.candidates = arrCandidates.toArray(candidates);                
            }
        } catch (NamingException ex) {
            Logger.getLogger(Pipeline.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        } catch (SQLException ex) {
            Logger.getLogger(Pipeline.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
        finally {
            if (resultSet != null) {
                resultSet.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }
    
    private void getDocumentTypesFromStore() {
        Connection connection = null;
        try {            
            connection = createDbConnection();
            StringBuilder sbSqlStatement = new StringBuilder("SELECT * FROM document_type WHERE pipeline = ");
            sbSqlStatement.append(this.id);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sbSqlStatement.toString());
            
            ArrayList<DocumentType> arrDocTypes = new ArrayList<DocumentType>();
            while (resultSet.next()) {
                String documentTypeName = resultSet.getString("name");
                int documentTypeID = resultSet.getInt("id");
                DocumentType documentType = new DocumentType(documentTypeName, documentTypeID);
                arrDocTypes.add(documentType);
            }
            documentTypes = new DocumentType[0];
            documentTypes = arrDocTypes.toArray(documentTypes);
        } catch (SQLException ex) {
            Logger.getLogger(Pipeline.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(Pipeline.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Pipeline.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }        
    }

    private StringBuilder createGetCandidateSQLStatement() {
        String getCandidateSql = "SELECT * FROM CANDIDATE WHERE PIPELINE = ";
        StringBuilder sbGetCandidateSql = new StringBuilder(getCandidateSql);
        sbGetCandidateSql.append(this.id);
        sbGetCandidateSql.append(" ORDER BY last,first");
        return sbGetCandidateSql;
    }

    private String createGetNameSQLStatement() {
        String getNameSql = "SELECT * FROM PIPELINE WHERE ID = ";
        StringBuilder sbGetNameSql = new StringBuilder(getNameSql);
        sbGetNameSql.append(this.id);
        return sbGetNameSql.toString();
    }
    
    private String createGetNoteSQLStatement() {        
        StringBuilder sbGetNoteSQL = new StringBuilder("SELECT * FROM PIPELINE WHERE ID = ");
        sbGetNoteSQL.append(this.id);
        return sbGetNoteSQL.toString();
    }

    /**
     * @return the documentTypes
     */
    public DocumentType[] getDocumentTypes() {
        getDocumentTypesFromStore();
        return documentTypes;
    }
    
    public DocumentType getDocTypeByID(int id) {
        DocumentType foundDocumentType = null;
        for (int i = 0; i < documentTypes.length; i++) {
            DocumentType documentType = documentTypes[i];
            if (documentType.getId() == id) {
                foundDocumentType = documentType;
                break;
            }
        }
        return foundDocumentType;
    }

    /**
     * @return the note
     */
    public String getNote() throws SQLException, NamingException {
        Connection connection = null;
        ResultSet resultSet = null;
        try {            
            connection = createDbConnection();
            String sqlStatement = createGetNoteSQLStatement();
            Statement statement = connection.createStatement();
            
            resultSet = statement.executeQuery(sqlStatement);
            if (resultSet.next()) {
                return resultSet.getString("Note");
            }
            else {
                return "Unnamed Pipeline";
            }
        } catch (SQLException ex) {
            Logger.getLogger(Pipeline.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        } catch (NamingException ex) {
            Logger.getLogger(Pipeline.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
        finally {
            if (resultSet != null) {
                resultSet.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }    
}
