/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PandoAFP;

/**
 *
 * @author ajmiro
 */
public class Candidate {
    
    private String firstName;
    private String lastName;
    private int id;
    private String title;    
    private int commentCount;
    private int positiveCommentCount;
    private int negativeCommentCount;
    private Comment[] comments;
    private int rank;
    
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

    public Candidate(String firstName, String lastName, String address, int rank, int id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.title = address;
        this.id = id;
        this.rank = rank;
    }  

    /**
     * @return the address
     */
    public String getTitle() {
        return title;
    }   

    /**
     * @return the commentCount
     */
    public int getCommentCount() {
        commentCount = Comment.getCommentCountForCandidate(this);
        return commentCount;
    }    

    /**
     * @return the comments
     */
    public Comment[] getComments() {
        comments = Comment.getCommentsForCandidate(this);
        return comments;
    }

    /**
     * @return the positiveCommentCount
     */
    public int getPositiveCommentCount() {
        positiveCommentCount = Comment.getPositiveCommentCountForCandidate(this);
        return positiveCommentCount;
    }

    /**
     * @return the negativeCommentCount
     */
    public int getNegativeCommentCount() {
        negativeCommentCount = Comment.getNegativeCommentCountForCandidate(this);
        return negativeCommentCount;
    }

    /**
     * @return the rank
     */
    public int getRank() {
        return rank;
    }
}
