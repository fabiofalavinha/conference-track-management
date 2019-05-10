package com.thoughtworks.codeassignment.conference.conferencetrackmanagement.parser;

import com.thoughtworks.codeassignment.conference.conferencetrackmanagement.model.Talk;

public class TalkParserFactory implements ConferenceParserFactory<Talk> {

    @Override
    public ConferenceParser<Talk> createParser() {
        return new TalkParser();
    }

}
