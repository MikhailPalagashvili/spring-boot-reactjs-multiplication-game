package com.grantcs.springbootreactjsmultiplicationgame.model.dto;

import lombok.Value;

@Value
public class ChallengeSolvedEvent {

    long attemptId;
    boolean correct;
    int factorA;
    int factorB;
    long userId;
    String userAlias;

}