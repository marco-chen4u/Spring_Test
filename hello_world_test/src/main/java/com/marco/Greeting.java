package com.marco;

public class Greeting {
    //fields
    private static final String HELLO = "Hello";
    private static final String WORLD = "World";
    private static final String DELIMTER = " ";

    public String helloWord() {
        return HELLO + DELIMTER + WORLD;
    }

    public String hellowWord(String name) {
        return HELLO + DELIMTER + name;
    }
}
