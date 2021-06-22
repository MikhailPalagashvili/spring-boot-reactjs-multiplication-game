package com.grantcs.gamification.service.impl;

import com.grantcs.gamification.domain.LeaderBoardRow;
import com.grantcs.gamification.repository.BadgeRepository;
import com.grantcs.gamification.repository.ScoreRepository;
import com.grantcs.gamification.service.LeaderBoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
class LeaderBoardServiceImpl implements LeaderBoardService {

    private final ScoreRepository scoreRepository;
    private final BadgeRepository badgeRepository;

    @Override
    public List<LeaderBoardRow> getCurrentLeaderBoard() {
        // Get score only
        List<LeaderBoardRow> scoreOnly = scoreRepository.findFirst10();
        // Combine with badges
        return scoreOnly.stream().map(row -> {
            List<String> badges =
                    badgeRepository.findByUserIdOrderByBadgeTimestampDesc(
                            row.getUserId()).stream()
                            .map(b -> b.getBadgeType().getDescription())
                            .collect(Collectors.toList());
            return row.withBadges(badges);
        }).collect(Collectors.toList());
    }
}