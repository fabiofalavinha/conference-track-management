package com.thoughtworks.codeassignment.conference.conferencetrackmanagement.model;

import org.joda.time.DateTime;

public class AfternoonSession extends AbstractSession {

    public AfternoonSession() {
        super(13, 17);
    }

    @Override
    protected Talk getLastSessionTalk() {
        return new NetworkingEvent();
    }

    private class NetworkingEvent extends Talk {

        NetworkingEvent() {
            super("Networking Event", 60);
            setStartTime(DateTime.now().withHourOfDay(17).withMinuteOfHour(0));
            setEndTime(DateTime.now().withHourOfDay(18).withMinuteOfHour(0));
        }

        @Override
        public String getLengthText() {
            return "";
        }
    }
}
