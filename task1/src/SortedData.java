package task1.src;

import java.util.LinkedList;
import java.util.List;

public class SortedData {
    private String category;
    private String highestRatedApp;
    private String lowestRatedApp;
    private Double highestRating = (double) -1;
    private Double lowestRating = (double) 6;
    private List<Double> allRatings = new LinkedList<>();
    private Integer discard = 0;


    public Integer getDiscard() {
        return discard;
    }

    public void setDiscard(Integer discard) {
        this.discard = discard;
    }

    public SortedData(String category){
        this.category = category;
    }

    public void sorting(GooglePlayStoreData app){
        if(!app.rating().isNaN()){
            allRatings.add(app.rating());

            if (app.rating() < getLowestRating()) {
                setLowestRating(app.rating());
                setLowestRatedApp(app.name());
            }

            if (app.rating() > getHighestRating()) {
                setHighestRating(app.rating());
                setHighestRatedApp(app.name());
            }
        }                    
    }

    public double avgRating(){
        return allRatings.stream().reduce((double) 0, (acc, v) -> acc + v) / allRatings.size();
    }

    public void discarded(GooglePlayStoreData app){
        
        if(app.rating().isNaN()) {
            discard++;
        }
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getHighestRatedApp() {
        return highestRatedApp;
    }

    public void setHighestRatedApp(String highestRatedApp) {
        this.highestRatedApp = highestRatedApp;
    }

    public String getLowestRatedApp() {
        return lowestRatedApp;
    }

    public void setLowestRatedApp(String lowestRatedApp) {
        this.lowestRatedApp = lowestRatedApp;
    }

    public Double getHighestRating() {
        return highestRating;
    }

    public void setHighestRating(Double double1) {
        this.highestRating = double1;
    }

    public Double getLowestRating() {
        return lowestRating;
    }

    public void setLowestRating(Double double1) {
        this.lowestRating = double1;
    }

    public List<Double> getAllRatings() {
        return allRatings;
    }

    public void setAllRatings(List<Double> allRatings) {
        this.allRatings = allRatings;
    }    
}
