package ru.gb.jtwo.clesson.online;

import java.util.HashMap;

public class PhoneBook {
    private HashMap<String, Person> phoneBook = new HashMap<>();

    public void setPhoneBook(String name, String num, String email){
        Person person = new Person();

        if (!phoneBook.containsKey(name)){
            person.setPersonMail(email);
            person.setPersonNum(num);
            phoneBook.put(name, person);
        } else {
            person = phoneBook.get(name);
            person.setPersonMail(email);
            person.setPersonNum(num);
            phoneBook.put(name, person);
        }
    }

    public void getPhoneBookNum(String name) {
        Person person;
        if (phoneBook.containsKey(name)) {
            person = phoneBook.get(name);
            System.out.println("Номера "+ name + ": "+person.getPersonNum());
        } else System.out.println("Нет такой записи");
    }

    public void getPhoneBookEmail(String name) {
        Person person;
        if (phoneBook.containsKey(name)) {
            person = phoneBook.get(name);
            System.out.println("Почты "+ name + ": "+person.getPersonMail());
        } else System.out.println("Нет такой записи");
    }


}
