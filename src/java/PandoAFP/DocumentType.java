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
    
    
}
