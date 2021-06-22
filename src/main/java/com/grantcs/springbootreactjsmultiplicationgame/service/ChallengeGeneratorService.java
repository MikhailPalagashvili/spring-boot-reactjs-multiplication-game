package com.grantcs.springbootreactjsmultiplicationgame.service;

import com.grantcs.springbootreactjsmultiplicationgame.model.Challenge;

public interface ChallengeGeneratorService {
    /**
     * @return a randomly-generated challenge with factors between 11 and 99
     */
    Challenge randomChallenge();
}
