package com.grantcs.springbootreactjsmultiplicationgame.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChallengeAttempt {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    private User user;
    @Min(1)
    @Max(99)
    private int factorA, factorB;
    @Positive(message = "How could you possibly get a negative result here? Try again.")
    private int resultAttempt;
    private boolean correct;
}