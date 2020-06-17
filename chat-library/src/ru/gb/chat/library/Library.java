package ru.gb.chat.library;

public class Library {
    /*
    * /auth_request±login±password
    * /auth_accept±nickname
    * /auth_error
    * /broadcast±msg
    * /msg_format_error
    * /user_list±user1±user2±user3
    * /new_client
    * */

    public static final String DELIMITER = "±";
    public static final String AUTH_REQUEST = "/auth_request";
    public static final String AUTH_ACCEPT = "/auth_accept";
    public static final String AUTH_DENIED = "/auth_denied";
    public static final String MSG_FORMAT_ERROR = "/msg_format_error"; // если мы вдруг не поняли, что за сообщение и не смогли разобрать
    public static final String TYPE_BROADCAST = "/bcast"; // то есть сообщение, которое будет посылаться всем
    public static final String USER_LIST = "/user_list";
    public static final String CLIENT_MSG_BROADCAST = "/client_bcast";
    public static final String NEW_CLIENT = "/new_client";
    public static final String REG_CLIENT = "/new_user";
    public static final String NEW_NICKNAME = "/nickname";
    public static final String BAD_NICKNAME = "/bad_nickname";

    public static String msgBadNickname(String msg) { return BAD_NICKNAME + DELIMITER + msg; }

    public static String msgNewNickname(String oldNick, String newNick) {
        return NEW_NICKNAME + DELIMITER + oldNick + DELIMITER + newNick;
    }

    public static String msgNewClient(String msg) { return NEW_CLIENT + DELIMITER + msg; }

    public static String getTypeBcastClient(String msg) {
        return CLIENT_MSG_BROADCAST + DELIMITER + msg;
    }

    public static String getAuthRequest(String login, String password) {
        return AUTH_REQUEST + DELIMITER + login + DELIMITER + password;
    }

    public static String getAuthAccept(String nickname) {
        return AUTH_ACCEPT + DELIMITER + nickname;
    }

    public static String getAuthDenied() {
        return AUTH_DENIED;
    }

    public static String getMsgFormatError(String message) {
        return MSG_FORMAT_ERROR + DELIMITER + message;
    }

    public static String getTypeBroadcast(String src, String message) {
        return TYPE_BROADCAST + DELIMITER + System.currentTimeMillis() +
                DELIMITER + src + DELIMITER + message;
    }

    public static String getUserList(String users) {
        return USER_LIST + DELIMITER + users;
    }
}
