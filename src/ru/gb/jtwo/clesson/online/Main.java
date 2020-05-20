package ru.gb.jtwo.clesson.online;

import java.util.Arrays;
import java.util.HashMap;

public class Main {

    private static void delDuplicate(String[] arr){
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i <arr.length ; i++) {
            if (!map.containsKey(arr[i])){
                map.put(arr[i], 1);
            } else {
                map.put(arr[i], map.get(arr[i]) + 1);
            }
        }
        System.out.println("Слова в массиве: " + map.keySet());
        System.out.println("Количество вхождений слов в массив: " + map.entrySet());
    }

    public static void main(String[] args) {

        String[] letters = {"a", "b", "c"};
        String[] words = new String[30];

        for (int i = 0; i < words.length ; i++) {
            words[i] = letters[(int)(Math.random()*letters.length)] + letters[(int)(Math.random()*letters.length)];
        }
        System.out.println("Массив слов: " + Arrays.toString(words));
        delDuplicate(words);
        System.out.println("_______________________________________________");
        PhoneBook pb = new PhoneBook();
        String[] persons = {"ivanov", "petrov", "sidorov", "lupa", "pupa"};
        String[] emails = {"@gmail.com", "@mail.ru", "@yandex.ru"};
        for (int i = 0; i < 10; i++) {
            int num = (int)(Math.random()*100);
            String person = persons[(int)(Math.random()*persons.length)];
            String mail = emails[(int)(Math.random()*emails.length)];
            String personMail;
            if (person.equals("lupa")) personMail = "pupa" + mail;
            else if (person.equals("pupa")) personMail = "lupa" + mail;
            else personMail = person + mail;
            pb.setPhoneBook(person, "8(903)XXXXX" + num, personMail);
        }

        for (int i = 0; i < persons.length; i++) {
            pb.getPhoneBookNum(persons[i]);
            pb.getPhoneBookEmail(persons[i]);
            System.out.println("_______________________________________");
        }

    }
}
