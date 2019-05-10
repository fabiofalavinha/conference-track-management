package com.thoughtworks.codeassignment.conference.conferencetrackmanagement.parser;

import java.util.Optional;

public interface ConferenceParser<T> {

    Optional<T> parse(String text);

}
