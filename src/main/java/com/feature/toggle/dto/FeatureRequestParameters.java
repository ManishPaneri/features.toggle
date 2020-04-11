package com.feature.toggle.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;


public class FeatureRequestParameters {

    @JsonProperty("parameters")
    private Map<String, String> parameters;

    public Map<String, String> getParameters() {
        return parameters;
    }

    public void setParameters(Map<String, String> parameters) {
        this.parameters = parameters;
    }
}
