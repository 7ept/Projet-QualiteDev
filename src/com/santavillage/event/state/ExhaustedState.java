package com.santavillage.event.state;

public record ExhaustedState(int fatigueLevel) implements CharacterState {
    @Override
    public String getSoundEffect() {
        return "bro est épuisé";
    }
}
