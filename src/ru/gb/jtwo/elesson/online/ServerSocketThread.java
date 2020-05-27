package ru.gb.jtwo.elesson.online;

public class ServerSocketThread extends Thread {

    int port;

    public ServerSocketThread(String name, int port) {
        super(name);
        this.port = port;
        start();
    }

    @Override
    public void run() {
        System.out.println("Server started");
        while (!isInterrupted()) {
            System.out.println("Server socket thread is working");
            try {
                sleep(3000);
            } catch (InterruptedException e) {
                interrupt();
            }
        }
        System.out.println("Server stopped");
    }
}
