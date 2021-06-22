package com.grantcs.gamification.processor;

import com.grantcs.gamification.domain.BadgeType;
import com.grantcs.gamification.domain.ScoreCard;
import com.grantcs.gamification.domain.entity.ChallengeSolvedEvent;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
class GoldBadgeProcessor implements BadgeProcessor {

    @Override
    public Optional<BadgeType> processForOptionalBadge(int currentScore,
                                                       List<ScoreCard> scoreCardList,
                                                       ChallengeSolvedEvent solved) {
        return currentScore > 400 ?
                Optional.of(BadgeType.GOLD) :
                Optional.empty();
    }

    @Override
    public BadgeType badgeType() {
        return BadgeType.GOLD;
    }
}