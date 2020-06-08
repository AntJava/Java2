package ru.gb.jtwo.flesson.online;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    public static void main(String[] args) {
        System.out.println("создаём сервер и ждём клиента");
        try (ServerSocket serverSocket = new ServerSocket(8189);
                Socket currentClient = serverSocket.accept()) {
            System.out.println("к нам подключился клиент");
            DataInputStream in = new DataInputStream(currentClient.getInputStream());
            DataOutputStream out = new DataOutputStream(currentClient.getOutputStream());
            while (true) {
                String b = in.readUTF();
                out.writeUTF("echo: " + b);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
