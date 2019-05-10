package com.thoughtworks.codeassignment.conference.conferencetrackmanagement.model;

public final class Talk {

    private final String name;
    private final int length; // in minutes

    public Talk(String name, int length) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Talk name is required and can not be null, empty or whitespace.");
        }
        if (length <= 0) {
            throw new IllegalArgumentException("Invalid talk length. You must set a valid positive integer as in minutes.");
        }
        this.name = name;
        this.length = length;
    }

    public String getName() {
        return name;
    }

    public int getLength() {
        return length;
    }

    @Override
    public String toString() {
        return String.format("%s %d", name, length);
    }

}
