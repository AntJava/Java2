package ru.gb.chat.server.core;

import ru.gb.chat.library.Library;
import ru.gb.jtwo.network.SocketThread;
import ru.gb.jtwo.network.SocketThreadListener;
import java.net.Socket;

public class ClientThread extends SocketThread {

    private String nickname;
    private boolean isAuthorized;
    private boolean isReconnecting;

    public ClientThread(String name, SocketThreadListener listener, Socket socket) {
        super(name, listener, socket);
    }

    public boolean isReconnecting() {
        return isReconnecting;
    }

    public String getNickname() {
        return nickname;
    }

    public boolean isAuthorized() {
        return isAuthorized;
    }

    void reconnect() {
        isReconnecting = true;
        close();
    }

    void authAccept(String nickname) {
        isAuthorized = true;
        this.nickname = nickname;
        sendMessage(Library.getAuthAccept(nickname));
    }

    void authFail() {
        sendMessage(Library.getAuthDenied());
        close();
    }

    void msgFormatError(String msg) {
        sendMessage(Library.getMsgFormatError(msg));
        close();
    }

    String authTimeout(){
        Runnable task = () -> {
            try {
                currentThread().sleep(120000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Thread thread = new Thread(task);
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(isAuthorized != true) {
            close();
            return " is not authorized and dropped";
        } else return " is authorized";
    }


}
