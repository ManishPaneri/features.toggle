package com.feature.toggle.services;

import com.feature.toggle.dto.FeatureRequestParameters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.togglz.core.manager.FeatureManager;
import org.togglz.core.repository.FeatureState;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Service
public class FeatureToggleService {

    @Autowired
    private FeatureManager featureManager;

    public Set<FeatureState> getFeatureStates() {
        Set<FeatureState> featureStates = new HashSet<>();
        this.featureManager.getFeatures().forEach(feature -> {
            featureStates.add(featureManager.getFeatureState(feature));
        });
        return featureStates;
    }

    public Map<String, Boolean> toggleFeature(String featureName) {
        Map<String, Boolean> featureToggleMap = new HashMap<>();
        this.featureManager.getFeatures().forEach(feature -> {
            if (feature.name().equalsIgnoreCase(featureName)) {
                FeatureState oldFeatureState = this.featureManager.getFeatureState(feature);
                if (oldFeatureState.isEnabled()) {
                    oldFeatureState.disable();
                } else {
                    oldFeatureState.enable();
                }

                this.featureManager.setFeatureState(oldFeatureState);
            }
            featureToggleMap.put(feature.name(), featureManager.isActive(feature));
        });
        return featureToggleMap;
    }

    public FeatureState setFeatureStateParameter(String featureName, FeatureRequestParameters featureRequest) {
        FeatureStateStrategies FeatureStateStrategies = new FeatureStateStrategies(featureName,
                featureRequest.getParameters(), featureManager);
        FeatureState featureState = FeatureStateStrategies.build();
        if (null == featureState) return featureState;
        this.featureManager.setFeatureState(featureState);
        return featureState;
    }

}
