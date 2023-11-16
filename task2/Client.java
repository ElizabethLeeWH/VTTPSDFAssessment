package task2;

import java.net.Socket;

public class Client {
    public static void main(String[] args) throws Exception {
        int port = 0;
        String host = null;

        switch (args.length) {
            case 0:
                port = 3000;
                host = "localhost";
                break;

            case 1:
                port = Integer.parseInt(args[0]);
                host = "localhost";
                break;

            case 2:
                port = Integer.parseInt(args[1]);
                host = args[0];
                break;

            default:
                System.out.println("Invalid port input");
                break;
        }
        
        Socket socket = new Socket(host, port);
        ClientSession session = new ClientSession(socket);
        session.start();
    }
}
