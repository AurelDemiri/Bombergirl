package be.ucll.bombergirl.components;

import com.badlogic.ashley.core.Component;

public class StateComponent implements Component {
    private float stateTime;
    private String currentState;

    public StateComponent(String state) {
        currentState = state;
        stateTime = 0;
    }

    public void resetStateTime() {
        stateTime = 0;
    }

    public String getCurrentState() {
        return currentState;
    }

    public void setCurrentState(String currentState) {
        if (this.currentState.equals(currentState)) {
            return;
        }

        this.currentState = currentState;
        resetStateTime();
    }

    public float getStateTime() {
        return stateTime;
    }

    public void addStateTime(float delta) {
        stateTime += delta;
    }
}