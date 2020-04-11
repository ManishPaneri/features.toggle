package com.feature.toggle.services;

import org.togglz.core.Feature;
import org.togglz.core.manager.FeatureManager;
import org.togglz.core.repository.FeatureState;

import java.util.Map;

public class FeatureStateStrategies {

    private String featureName;
    private Map<String, String> parameter;
    private FeatureManager featureManager;

    public FeatureStateStrategies(String featureName, Map<String, String> parameter, FeatureManager featureManager) {
        this.featureName = featureName;
        this.parameter = parameter;
        this.featureManager = featureManager;
    }

    public FeatureState build() {
        for (Feature feature : this.featureManager.getFeatures()) {
            if (feature.name().equalsIgnoreCase(this.featureName)) {
                return setFeatureStateConfigurations(feature);
            }
        }
        return null;
    }

    private FeatureState setFeatureStateConfigurations(Feature feature) {
        FeatureState oldFeatureState = this.featureManager.getFeatureState(feature);
        for (Map.Entry<String, String> entry : parameter.entrySet()) {
            oldFeatureState.setParameter(entry.getKey(), entry.getValue());
        }
        return oldFeatureState;
    }

}
