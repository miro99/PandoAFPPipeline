/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PandoAFP;

/**
 *
 * @author ajmiro
 */
public class Pipeline {
    private String name;
    private int id;    
  
    public Pipeline() {
    }
    
    public void Init(int id){
        this.setId(id);
    }
    
    /**
     * @return the name
     */
    public String getName() {
        if (name == null) {
            //Get the name from the data store
            this.name = getNameFromDataStore();
        }
        return name;
    }

    private String getNameFromDataStore() {
        return "Pipeline 1";
    }
    
    /**
     *
     * @return the candidates for this pipeline
     */
    public Candidate[] getCandidates() {
        //Get candidates for this pipeline from the data store
        Candidate[] candidates = new Candidate[3];
        candidates[0] = new Candidate("AJ", "Miro", 1);
        candidates[1] = new Candidate("Adam", "Dub", 2 );
        candidates[2] = new Candidate("Eitan", "Dub", 3);
        
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
        return new Candidate("AJ", "Miro", 1);
    }
}
