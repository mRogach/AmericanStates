package com.test.americanstates.data.states.list.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by
 * Mykhailo on 8/21/2018.
 */
public class StateListResponse {

    @SerializedName("RestResponse")
    private StateList stateList;

    public static class StateList {

        @SerializedName("result")
        private List<State> states;

        public List<State> getStates() {
            return states;
        }
    }

    public StateList getStateList() {
        return stateList;
    }
}
