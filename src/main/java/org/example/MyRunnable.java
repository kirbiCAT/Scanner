package org.example;

public class MyRunnable implements Runnable{
    private final String text;

    public MyRunnable(String text) {
        this.text = text;
    }

    @Override
    public void run() {
        Thread.currentThread().setName(text);
    System.out.println(text);
    System.out.println(Thread.currentThread().getName()+ "let's go bitch");

    }
}
