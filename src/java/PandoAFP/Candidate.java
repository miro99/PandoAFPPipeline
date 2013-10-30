/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PandoAFP;

import java.awt.Image;

/**
 *
 * @author ajmiro
 */
public class Candidate {
    
    private String firstName;
    private String lastName;
    private int id;
    private String address;           
    
    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    public Candidate(String firstName, String lastName, String address, int id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.id = id;
    }  

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }   
}
