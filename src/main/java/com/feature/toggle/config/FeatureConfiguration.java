package com.feature.toggle.config;


import com.feature.toggle.features.MyFeatures;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.togglz.core.manager.EnumBasedFeatureProvider;
import org.togglz.core.repository.StateRepository;
import org.togglz.core.repository.cache.CachingStateRepository;
import org.togglz.core.repository.jdbc.JDBCStateRepository;
import org.togglz.core.repository.util.DefaultMapSerializer;
import org.togglz.core.spi.FeatureProvider;
import org.togglz.spring.boot.autoconfigure.TogglzProperties;

import javax.sql.DataSource;
import java.util.Map;

@Configuration
public class FeatureConfiguration {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private TogglzProperties properties;

    private long expireTimeMs=100000;


    @Bean
    public FeatureProvider featureProvider() {
        return new EnumBasedFeatureProvider(MyFeatures.class);
    }

    @Bean
    public StateRepository getStateRepository() {
        StateRepository jdbcStateRepository = JDBCStateRepository.newBuilder(dataSource)
                .tableName("features")
                .createTable(true)
                .serializer(DefaultMapSerializer.singleline())
                .noCommit(false)
                .build();
        Map<String, TogglzProperties.FeatureSpec> features = properties.getFeatures();
        for (String name : features.keySet()) {
            jdbcStateRepository.setFeatureState(features.get(name).state(name));
        }
        return new CachingStateRepository(jdbcStateRepository, expireTimeMs);
    }
}
