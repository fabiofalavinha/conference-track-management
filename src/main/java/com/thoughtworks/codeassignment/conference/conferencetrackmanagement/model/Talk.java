package com.thoughtworks.codeassignment.conference.conferencetrackmanagement.model;

import org.joda.time.DateTime;

public class Talk {

    public static final String LIGHTNING = "lightning";
    private static final int  LIGHTNING_LENGTH = 5;

    private final String name;
    private final int length; // in minutes

    private DateTime startTime;
    private DateTime endTime;

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

    public String getLengthText() {
        return length == LIGHTNING_LENGTH ? LIGHTNING : String.format("%dmin", length);
    }

    public void setStartTime(DateTime startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(DateTime endTime) {
        this.endTime = endTime;
    }

    public DateTime getStartTime() {
        return startTime;
    }

    public DateTime getEndTime() {
        return endTime;
    }

    public String getStartTimeText() {
        return getStartTime().toString("HH:mma");
    }
}
