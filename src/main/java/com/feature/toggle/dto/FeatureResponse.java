package com.feature.toggle.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.togglz.core.repository.FeatureState;

import java.util.Map;

public class FeatureResponse {

    @JsonProperty("feature")
    private String feature;

    @JsonProperty("enabled")
    private boolean enabled;

    @JsonProperty("parameters")
    private Map<String, String> parameters;

    public FeatureResponse(FeatureState featureState) {
        if (featureState != null) {
            this.feature = featureState.getFeature().name();
            this.enabled = featureState.isEnabled();
            this.parameters = featureState.getParameterMap();
        }
    }

    public String getFeature() {
        return feature;
    }

    public void setFeature(String feature) {
        this.feature = feature;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Map<String, String> getParameters() {
        return parameters;
    }

    public void setParameters(Map<String, String> parameters) {
        this.parameters = parameters;
    }
}
