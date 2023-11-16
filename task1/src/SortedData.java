package task1.src;

import java.util.LinkedList;
import java.util.List;

public class SortedData {
    private String category;
    private String highestRatedApp;
    private String lowestRatedApp;
    private float highestRating = -1;
    private float lowestRating = 6;
    private List<Float> allRatings = new LinkedList<>();

    public SortedData(String category){
        this.category = category;
    }

    public void sorting(GooglePlayStoreData app){
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

    public Float avgRating(){
        return allRatings.stream().reduce(0f, (acc, v) -> acc + v) / allRatings.size();
    }

    // public void discarded(GooglePlayStoreData app){
    //     Map<String, Integer> hm = new HashMap<String, Integer>();
    //     hm.put(GooglePlayStoreData)
    // }

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

    public float getHighestRating() {
        return highestRating;
    }

    public void setHighestRating(float highestRating) {
        this.highestRating = highestRating;
    }

    public float getLowestRating() {
        return lowestRating;
    }

    public void setLowestRating(float lowestRating) {
        this.lowestRating = lowestRating;
    }

    public List<Float> getAllRatings() {
        return allRatings;
    }

    public void setAllRatings(List<Float> allRatings) {
        this.allRatings = allRatings;
    }

    
}
