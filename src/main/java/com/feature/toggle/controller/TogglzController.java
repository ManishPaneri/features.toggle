package com.feature.toggle.controller;

import com.feature.toggle.dto.FeatureRequestParameters;
import com.feature.toggle.dto.FeatureResponse;
import com.feature.toggle.dto.FeaturesResponse;
import com.feature.toggle.services.FeatureToggleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Map;

@RestController
@RequestMapping("features")
public class TogglzController {

    @Autowired
    private FeatureToggleService featureToggleService;


    @GetMapping("")
    public FeaturesResponse getStatus() {
        return new FeaturesResponse(new ArrayList<>(featureToggleService.getFeatureStates()));
    }

    @PostMapping("/{featureName}/toggle")
    public Map<String, Boolean> featureToggle(@PathVariable final String featureName) {
        return featureToggleService.toggleFeature(featureName);
    }

    @PostMapping("/{featureName}/parameters")
    public FeatureResponse updateFeatureParameter(@PathVariable final String featureName,
                                                  @RequestBody(required = true)
                                                  final FeatureRequestParameters featureRequestParameters) {
        return new FeatureResponse(featureToggleService.setFeatureStateParameter(featureName, featureRequestParameters));
    }

}
