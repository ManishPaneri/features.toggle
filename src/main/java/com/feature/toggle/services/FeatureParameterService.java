package com.feature.toggle.services;


import com.feature.toggle.services.exception.TogglzException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.togglz.core.Feature;
import org.togglz.core.manager.FeatureManager;

@Service
public class FeatureParameterService {

    @Autowired
    private FeatureManager featureManager;

    public String getValue(String prefix, Feature feature) throws TogglzException {
        if (featureManager.getFeatureState(feature).getParameterMap().containsKey(prefix)) {
            return featureManager.getFeatureState(feature).getParameterMap().get(prefix);
        }
        throw new TogglzException("feature param " + feature.name() + " not found " + prefix);
    }
}
