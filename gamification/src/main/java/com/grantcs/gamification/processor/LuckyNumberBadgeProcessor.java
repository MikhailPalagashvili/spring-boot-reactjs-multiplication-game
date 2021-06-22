package com.grantcs.gamification.processor;

import com.grantcs.gamification.domain.BadgeType;
import com.grantcs.gamification.domain.ScoreCard;
import com.grantcs.gamification.domain.entity.ChallengeSolvedEvent;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
class LuckyNumberBadgeProcessor implements BadgeProcessor {

    private static final int LUCKY_FACTOR = 42;

    @Override
    public Optional<BadgeType> processForOptionalBadge(int currentScore,
                                                       List<ScoreCard> scoreCardList,
                                                       ChallengeSolvedEvent solved) {
        return solved.getFactorA() == LUCKY_FACTOR ||
                solved.getFactorB() == LUCKY_FACTOR ?
                Optional.of(BadgeType.LUCKY_NUMBER) :
                Optional.empty();
    }

    @Override
    public BadgeType badgeType() {
        return BadgeType.LUCKY_NUMBER;
    }
}