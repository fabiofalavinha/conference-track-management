package com.thoughtworks.codeassignment.conference.conferencetrackmanagement.model;

import org.joda.time.DateTime;

public class MorningSession extends AbstractSession  {

    MorningSession() {
        super(9, 12);
    }

    @Override
    protected Talk getLastSessionTalk() {
        return new LunchTime();
    }

    private class LunchTime extends Talk {

        LunchTime() {
            super("Lunch", 60);
            setStartTime(DateTime.now().withHourOfDay(12).withMinuteOfHour(0));
            setEndTime(DateTime.now().withHourOfDay(13).withMinuteOfHour(0));
        }

        @Override
        public String getLengthText() {
            return "";
        }
    }
}
