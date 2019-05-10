package com.thoughtworks.codeassignment.conference.conferencetrackmanagement.parser;

public interface ConferenceParserFactory<T> {

    ConferenceParser<T> createParser();

}
