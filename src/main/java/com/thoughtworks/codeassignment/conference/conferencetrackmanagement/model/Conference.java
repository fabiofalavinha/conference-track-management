package com.thoughtworks.codeassignment.conference.conferencetrackmanagement.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Conference {

    private final List<Track> tracks;

    public Conference() {
        tracks = new ArrayList<>();
    }

    public void addTalk(Talk talk) {
        final List<Track> availableTracks = tracks.stream()
            .filter(Track::hasAvailableSchedule)
            .collect(Collectors.toList());
        boolean added = false;
        for (Track track : availableTracks) {
            if (track.addTalk(talk)) {
                added = true;
                break;
            }
        }
        if (!added) {
            final Track newTrack = new Track();
            newTrack.addTalk(talk);
            tracks.add(newTrack);
        }
    }

    public List<Track> getTracks() {
        return Collections.unmodifiableList(tracks);
    }
}
