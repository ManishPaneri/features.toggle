package com.feature.toggle.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.togglz.core.repository.FeatureState;

import java.util.ArrayList;
import java.util.List;

public class FeaturesResponse {

    @JsonProperty("features")
    private List<FeatureResponse> featureResponseList = new ArrayList<>();

    public FeaturesResponse(List<FeatureState> featureStateList) {
        featureStateList.forEach(featureState -> {
            this.featureResponseList.add(new FeatureResponse(featureState));
        });
    }
}
