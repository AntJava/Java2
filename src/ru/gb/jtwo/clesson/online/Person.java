package ru.gb.jtwo.clesson.online;

import java.util.HashSet;

public class Person {
    private HashSet<String> personNum = new HashSet<>();
    private HashSet<String> personMail = new HashSet<>();

    public void setPersonMail(String mail) {
        this.personMail.add(mail);
    }

    public void setPersonNum(String num) {
        this.personNum.add(num);
    }

    public HashSet<String> getPersonMail() {
        return personMail;
    }

    public HashSet<String> getPersonNum() {
        return personNum;
    }
}
