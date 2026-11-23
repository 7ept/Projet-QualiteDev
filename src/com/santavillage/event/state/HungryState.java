package com.santavillage.event.state;

public record HungryState(int hungerLevel) implements CharacterState {
    @Override
    public String getSoundEffect() {
        return "Il a bien envie de graille un Tenders .";
    }
}
