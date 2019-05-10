package com.thoughtworks.codeassignment.conference.conferencetrackmanagement.model;

import org.joda.time.DateTime;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public abstract class AbstractSession implements TalkSession {

    private final int start;
    private final int end;
    private final int lengthInMinutes;

    private final LinkedList<Talk> talks;

    public AbstractSession(int start, int end) {
        this.start = start;
        this.end = end;
        lengthInMinutes = (end - start) * 60;
        talks = new LinkedList<>();
    }

    protected abstract Talk getLastSessionTalk();

    @Override
    public boolean addTalk(Talk talk) {
        if (!hasAvailableSchedule()) {
            return false;
        }
        final int addedLength = sumTalksLength();
        if (addedLength + talk.getLength() <= lengthInMinutes) {
            if (talks.isEmpty()) {
                talk.setStartTime(DateTime.now().withHourOfDay(start).withMinuteOfHour(0));
                talk.setEndTime(talk.getStartTime().plusMinutes(talk.getLength()));
            } else {
                final Talk lastTalk = talks.getLast();
                talk.setStartTime(lastTalk.getEndTime());
                talk.setEndTime(lastTalk.getEndTime().plusMinutes(talk.getLength()));
            }
            talks.addLast(talk);
            return true;
        }
        return false;
    }

    @Override
    public boolean hasAvailableSchedule() {
        return sumTalksLength() < lengthInMinutes;
    }

    @Override
    public List<Talk> getTalks() {
        final LinkedList<Talk> destinations = new LinkedList<>(talks);
        destinations.addLast(getLastSessionTalk());
        return Collections.unmodifiableList(destinations);
    }

    private int sumTalksLength() {
        return talks.stream().mapToInt(Talk::getLength).sum();
    }
}
