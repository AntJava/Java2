package ru.gb.jtwo.blesson.online;

import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

public class Main {

    private interface MouseListener {
        void mouseDown();
    }

    private static void addMouseListener(MouseListener m) {
        m.mouseDown();
    }

    private static int div(int a, int b) throws ArithmeticException { // 5/5
        return a / b;
    }

    private static class IOStream implements Closeable {
        IOStream() throws IOException {
//            throw new IOException("construction failed");
            System.out.println("constructed");
        }
        public void open() throws FileNotFoundException {
            throw new FileNotFoundException("flash drive not found!");
//            System.out.println("open");
        }

        public void doIOthings() throws SQLException {
            throw new SQLException("cannot do io things");
            //System.out.println("do IO things");
        }

        @Override
        public void close() {
            throw new NullPointerException("nothing to close");
//            System.out.println("close");
        }
    }

    public static void main(String[] args) {

        try (IOStream ioStream = new IOStream()) {
            ioStream.open();
            ioStream.doIOthings();
        } catch (FileNotFoundException canvas) {
            throw new RuntimeException(canvas);
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }


        System.out.println("Program finished!");

//        System.out.println(div(1, 5));
//        System.out.println(div(5, 0));
    }

    private static void anonymousExample() {
        class MouseAdapter implements MouseListener {
            @Override
            public void mouseDown() {

            }
        }
        MouseAdapter h = new MouseAdapter();
        addMouseListener(h);
        addMouseListener(new MouseAdapter());
        addMouseListener(new MouseListener() {
            @Override
            public void mouseDown() {

            }
        });
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseDown() {

            }
        });
        addMouseListener(() -> {

        });
    }

    private static void interfaceExamples() {
        Cat c = new Cat();
        c.breathe();

        Animal a = new Cat();
        a.breathe();

        Minotaur m = new Minotaur();
        m.walk();
        m.voice();
        Human[] city = {m, new Man()};
        for (int i = 0; i < city.length; i++) {
            city[i].walk();
        }
        Human h = m;
        h.walk();
//        h.voice();
        Bull b = m;
        b.walk();
        b.voice();
        Animal z = m;
        z.breathe();
    }
}
