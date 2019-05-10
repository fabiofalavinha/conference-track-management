package com.thoughtworks.codeassignment.conference.conferencetrackmanagement.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Track {

    private static int ORDER = 1;

    private final int index;
    private final TalkSession morningSession;
    private final TalkSession afternoonSession;

    public Track() {
        index = ORDER++;
        morningSession = new MorningSession();
        afternoonSession = new AfternoonSession();
    }

    public int getIndex() {
        return index;
    }

    public boolean hasAvailableSchedule() {
        return morningSession.hasAvailableSchedule() || afternoonSession.hasAvailableSchedule();
    }

    public boolean addTalk(Talk talk) {
        return morningSession.addTalk(talk) || afternoonSession.addTalk(talk);
    }

    public List<Talk> getTalks() {
        final List<Talk> result = new ArrayList<>();
        result.addAll(morningSession.getTalks());
        result.addAll(afternoonSession.getTalks());
        return Collections.unmodifiableList(result);
    }
}
