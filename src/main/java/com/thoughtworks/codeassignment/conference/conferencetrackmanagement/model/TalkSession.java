package com.thoughtworks.codeassignment.conference.conferencetrackmanagement.model;

import java.util.List;

public interface TalkSession {

    boolean addTalk(Talk talk);
    boolean hasAvailableSchedule();
    List<Talk> getTalks();

}
