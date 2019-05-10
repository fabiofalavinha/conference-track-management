package com.thoughtworks.codeassignment.conference.conferencetrackmanagement;

import com.thoughtworks.codeassignment.conference.conferencetrackmanagement.model.Talk;
import com.thoughtworks.codeassignment.conference.conferencetrackmanagement.parser.ConferenceParser;
import com.thoughtworks.codeassignment.conference.conferencetrackmanagement.parser.ConferenceParserFactory;
import com.thoughtworks.codeassignment.conference.conferencetrackmanagement.parser.TalkParserFactory;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ConferenceTrackManagementApplication {

    public static void main(String[] args) {
        final List<String> tasks = Arrays.asList(args);
        if (tasks.isEmpty()) {
            System.out.println("No tasks received! Don't be sad, soon presenters will send their tasks ;)");
            System.exit(0);
        }

        final ConferenceParserFactory<Talk> taskParserFactory = new TalkParserFactory();
        final ConferenceParser<Talk> taskParser = taskParserFactory.createParser();

        tasks.forEach(t -> {
            try {
                final Optional<Talk> talkOptional = taskParser.parse(t);
                talkOptional.ifPresent(System.out::println);
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
            }
        });
	}
}
