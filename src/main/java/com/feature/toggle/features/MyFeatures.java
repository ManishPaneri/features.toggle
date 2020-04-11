package com.feature.toggle.features;

import org.togglz.core.Feature;
import org.togglz.core.context.FeatureContext;

public enum MyFeatures implements Feature {

    firstFeature,

    secondFeature;

    public boolean isActive() {
        return FeatureContext.getFeatureManager().isActive(this);
    }
}