package com.santavillage.event.state;

public record PranksterState() implements CharacterState {
    @Override
    public String getSoundEffect() {
        return "Rit de manière malicieuse.";
    }
}
