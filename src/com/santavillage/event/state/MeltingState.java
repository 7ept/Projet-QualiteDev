package com.santavillage.event.state;

public record MeltingState() implements CharacterState {
    @Override
    public String getSoundEffect() {
        return "Le pauvre il a un chagrin il pleure .";
    }
}
