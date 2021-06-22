package com.grantcs.gamification.processor;

import com.grantcs.gamification.domain.BadgeType;
import com.grantcs.gamification.domain.ScoreCard;
import com.grantcs.gamification.domain.entity.ChallengeSolvedEvent;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
class FirstWonBadgeProcessor implements BadgeProcessor {

    @Override
    public Optional<BadgeType> processForOptionalBadge(int currentScore,
                                                       List<ScoreCard> scoreCardList,
                                                       ChallengeSolvedEvent solved) {
        return scoreCardList.size() == 1 ?
                Optional.of(BadgeType.FIRST_WON) : Optional.empty();
    }

    @Override
    public BadgeType badgeType() {
        return BadgeType.FIRST_WON;
    }
}