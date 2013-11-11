/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PandoAFP;

/**
 *
 * @author ajmiro
 */
public class Results {
    private SearchResult[] searchResults;    

    public Results(SearchResult[] searchResults) {
        this.searchResults = searchResults;
    }

    public Results() {
    }

    
    /**
     * @return the searchResults
     */
    public SearchResult[] getSearchResults() {
        return searchResults;
    }
}
