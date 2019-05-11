package com.thoughtworks.codeassignment.conference.conferencetrackmanagement.parser;

import com.thoughtworks.codeassignment.conference.conferencetrackmanagement.model.Talk;

import java.util.Optional;

class TalkParser implements ConferenceParser<Talk> {

    @Override
    public Optional<Talk> parse(String text) {
        int lastSpace = text.lastIndexOf(" ");
        if (lastSpace != -1) {
            final String talkLength = text.substring(lastSpace);
            final Optional<Integer> lengthOptional = parseTalkLengthMinutes(talkLength);
            if (!lengthOptional.isPresent()) {
                throw new IllegalArgumentException("Invalid talk length. You must set the talk length in minutes.");
            }
            final String talkName = text.substring(0, lastSpace);
            if (talkName.matches(".*\\d.*")) {
                throw new IllegalArgumentException("Invalid talk name. Talk name can't contains numbers.");
            }
            return Optional.of(new Talk(talkName, lengthOptional.get()));
        }
        return Optional.empty();
    }

    private Optional<Integer> parseTalkLengthMinutes(String talkLength) {
        if (Talk.LIGHTNING.equals(talkLength.trim())) {
            talkLength = "5min";
        }
        final StringBuilder builder = new StringBuilder();
        for (char c : talkLength.toCharArray()) {
            if (Character.isDigit(c)) {
                builder.append(Character.getNumericValue(c));
            }
        }
        return builder.length() > 0 ? Optional.of(Integer.parseInt(builder.toString())) : Optional.empty();
    }
}
