package org.academiadecodigo.bravoteam.services.model.challenge;


public enum ChallengeType {
    SQUAT("Have you done your squat today?"),
    AEROBIC("Have you done your aerobic today?"),
    STRETCHING("Have you done your stretching today?"),
    BALANCE("Have you done your balance today?");

    private String exercises;

    ChallengeType(String exercises) {
        this.exercises = exercises;
    }
}



