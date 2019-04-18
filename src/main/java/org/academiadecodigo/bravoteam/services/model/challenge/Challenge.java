package org.academiadecodigo.bravoteam.services.model.challenge;

import org.academiadecodigo.bravoteam.services.model.AbstractModel;


public class Challenge extends AbstractModel {

    int random = (int) (Math.random() * ChallengeType.values().length);
    ChallengeType challengeType = ChallengeType.values()[random];



    public ChallengeType mensageChallenge() {
        switch (challengeType) {
            case SQUAT:
                return ChallengeType.SQUAT;
            case AEROBIC:
                return ChallengeType.AEROBIC;
            case STRETCHING:
                return ChallengeType.STRETCHING;
            case BALANCE:
                return ChallengeType.BALANCE;
        }
         return ChallengeType.SQUAT;
    }
}
