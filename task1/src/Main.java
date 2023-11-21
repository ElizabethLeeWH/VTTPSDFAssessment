package task1.src;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

public class Main{
    public static void main(String[] args) throws IOException {
        Reader reading = new FileReader("C:/Users/ASUS/VTTPSDFAssessment/task1/src/googleplaystore.csv");
        BufferedReader br = new BufferedReader(reading);

        Map<String, SortedData> data = new HashMap<>();
        AtomicLong lineCounter = new AtomicLong();

        br.lines()
            .skip(1)
            .peek(str -> lineCounter.incrementAndGet())
            // .filter(line -> !line.contains("NaN"))
            .map(line -> line.split(","))
            .map(cols -> new GooglePlayStoreData(cols[0].trim(), cols[1].trim(), Double.parseDouble(cols[2].trim())))
            .collect(Collectors.groupingBy(app -> app.category()))
            .forEach((String category, List<GooglePlayStoreData> app) -> {
                SortedData sort = new SortedData(category);
                for (GooglePlayStoreData i: app){
                    sort.sorting(i);
                    sort.discarded(i);
                }
                data.put(category, sort);    
            });
        
        for (String c: data.keySet()) {
            SortedData s = data.get(c);
            System.out.printf("Category: %s\nHighest: %s, %f\nLowest: %s, %f\nAverage: %f\nDiscarded: %d\n\n", c, 
                s.getHighestRatedApp(), s.getHighestRating(), s.getLowestRatedApp(), s.getLowestRating(), s.avgRating(), s.getDiscard());
        }

        System.out.printf("Total lines in file excl headers: %d\n", lineCounter.intValue());
        br.close();
    }
    
}