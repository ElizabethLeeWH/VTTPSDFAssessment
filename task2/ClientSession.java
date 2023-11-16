package task2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Console;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class ClientSession {

    private final Socket socket;
    private String request_id;
    private int item_count;
    private Float budget;
    private List<List<String>> myProducts = new ArrayList<List<String>>();
    private List<String> allElements = new LinkedList<>();

    public ClientSession(Socket socket){
        this.socket = socket;
    }

    public void start() throws Exception {

        InputStreamReader isr = new InputStreamReader(socket.getInputStream());
        BufferedReader br = new BufferedReader(isr);
        OutputStreamWriter osw = new OutputStreamWriter(socket.getOutputStream());
        BufferedWriter bw = new BufferedWriter(osw);

        Console cons = System.console();

        boolean stop = false;
        while (!stop) {
            String line = cons.readLine("> ");
            line = line.trim();
            stop = "exit".equals(line);

            bw.write(line + "\n");
            bw.flush();

            if (stop)
                continue;

            line = br.readLine();
            String[] serverInfo = line.split(":  ");
            System.out.printf(">> result: %s\n", line);

            switch(serverInfo[0]){
                case "request_id":
                    request_id = serverInfo[1];
                    break;
                case "item_count":
                    item_count = Integer.parseInt(serverInfo[1]);
                    break;
                case "budget":
                    budget = Float.parseFloat(serverInfo[1]);
                    break;
                case "prod_id":
                    allElements.add(serverInfo[1]);
                    break;
                case "title":
                    allElements.add(serverInfo[1]);
                    break;
                case "price":
                    allElements.add(serverInfo[1]);
                    break;
                case "rating":
                    allElements.add(serverInfo[1]);
                    break;
                default:
                    break;
            }

            myProducts = separate(allElements, 4);

            // System.out.println(allElements.stream().collect(Collectors.groupingBy(allElements.indexOf(s) > 4)).values(););
            // allElements.stream().collect(Collectors.groupingBy(allElements.indexOf(s) > 4)).values();
            // myProducts.sort(Comparator.comparing(Products::getRating).thenComparing(Products::getPrice));

            
            

            
        }
    }

    static <T> List<List<T>> separate(List<T> path, final int size) {
        List<List<T>> separated = new ArrayList<>();
        List<T> temp;
        for (int i = 0; i < path.size(); i += size - 1) {
            temp = (List<T>) path.subList(i, Math.min(path.size(), i + size));
            if (temp.size() == size) {
                separated.add(new ArrayList<T>(temp));
            }
        }
        return separated;
    }
    
}
