package com.thoughtworks.codeassignment.conference.conferencetrackmanagement;

import com.thoughtworks.codeassignment.conference.conferencetrackmanagement.model.Conference;
import com.thoughtworks.codeassignment.conference.conferencetrackmanagement.model.Talk;
import com.thoughtworks.codeassignment.conference.conferencetrackmanagement.model.Track;
import com.thoughtworks.codeassignment.conference.conferencetrackmanagement.parser.ConferenceParser;
import com.thoughtworks.codeassignment.conference.conferencetrackmanagement.parser.ConferenceParserFactory;
import com.thoughtworks.codeassignment.conference.conferencetrackmanagement.parser.TalkParserFactory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class ConferenceTrackManagementApplication {

    public static void main(String[] args) {
        List<String> tasks = new ArrayList<>();

        if (args.length == 0) {
            File file = new File(
                Objects.requireNonNull(ConferenceTrackManagementApplication.class.getClassLoader().getResource("talks.txt")).getFile()
            );

            try {
                tasks = Files.readAllLines(Paths.get(file.getPath()));
            } catch (IOException e) {
                System.err.println(e);
                System.exit(0);
            }
        } else {
            tasks = Arrays.asList(args);
        }

        final ConferenceParserFactory<Talk> taskParserFactory = new TalkParserFactory();
        final ConferenceParser<Talk> taskParser = taskParserFactory.createParser();

        final Conference conference = new Conference();

        tasks.forEach(t -> {
            try {
                taskParser.parse(t).ifPresent(conference::addTalk);
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
            }
        });

        for (Track track : conference.getTracks()) {
            System.out.printf("Track %d:\n", track.getIndex());
            for (Talk talk : track.getTalks()) {
                System.out.printf("%s %s %s\n", talk.getStartTimeText(), talk.getName(), talk.getLengthText());
            }
            System.out.println();
        }
	}
}
