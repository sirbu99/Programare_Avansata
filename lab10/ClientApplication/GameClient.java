package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class GameClient {
    public static void main(String[] args) throws IOException {
        String serverAddress = "127.0.0.1"; // The server's IP address
        int PORT = 8100; // The server's port
        while (true) {
            try (Socket socket = new Socket(serverAddress, PORT);
                 PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                 BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                System.out.println("Write your request:");
                //read the input from the keyboard
                String request = br.readLine();
                // Send a request to the server
                out.println(request);
                // Wait the response from the server ("Hello World!")
                String response = in.readLine();
                System.out.println(response);
                if (request.equals("stop")) {
                    break;
                }
            } catch (UnknownHostException e) {
                System.err.println("No server listening... " + e);
            }
        }
    }

}
