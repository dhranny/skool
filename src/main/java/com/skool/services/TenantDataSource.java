package com.skool.services;

import com.skool.data.DataSourceConfigRepository;
import com.skool.data.LecturerRepo;
import com.skool.models.DataSourceConfig;
import org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionProviderImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import javax.sql.DataSource;
import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

@Component
public class TenantDataSource implements Serializable {

    private Map<String, DataSource> dataSources = new HashMap<>();

    Logger log = LoggerFactory.getLogger(TenantDataSource.class);

    @Autowired
    private DataSourceConfigRepository configRepo;

    @Autowired
    DataSourceBasedMultiTenantConnectionProviderImpl connectionProvider;


    private DataSourceConfig dataSourceConfig(){
        return new DataSourceConfig();
    }

    public DataSource getDataSource(String name) {
        if (dataSources.get(name) != null) {
            return dataSources.get(name);
        }
        DataSource dataSource = createDataSource(name);
        if (dataSource != null) {
            dataSources.put(name, dataSource);
        }
        log.info("We just returned a data source");
        return dataSource;
    }

    @PostConstruct
    public Map<String, DataSource> getAll() {
        List<DataSourceConfig> configList = configRepo.findAll();
        Map<String, DataSource> result = new HashMap<>();
        for (DataSourceConfig config : configList) {
            DataSource dataSource = getDataSource(config.getName());
            connectionProvider.map.put(config.getName(), dataSource);
            result.put(config.getName(), dataSource);
        }
        log.info("Number of data sources at initialization is " + result.size());;
        return result;
    }

    public DataSource createDataSource(String name) {
        try{
            DataSourceConfig config = configRepo.findByName(name);
            if (config != null) {
                DataSourceBuilder factory = DataSourceBuilder
                        .create().driverClassName(config.getDriverClassName())
                        .username(config.getUsername())
                        .password(config.getPassword())
                        .url(config.getUrl());
                DataSource dataSource =  factory.build();
                dataSources.put(name, dataSource);
                connectionProvider.map.put(name, dataSource);
                return dataSource;
            }
            Properties properties = new Properties();
            properties.load(getClass().getResourceAsStream("applications.properties"));
            DriverManagerConnectionProviderImpl connectionProvider
                    = new DriverManagerConnectionProviderImpl();
            connectionProvider.configure(properties);
            return null;
        }
        catch (IOException e){

        }
        return null;
    }

    public DataSourceConfig createNewDataSourceConfig(String name, String password){
        DataSourceConfig dataConfig = new DataSourceConfig();
        dataConfig.setId(name);
        dataConfig.setName(name);
        dataConfig.setPassword(password);
        dataConfig.setDriverClassName("org.h2.Driver");
        dataConfig.setUrl("jdbc:h2:mem:" + name);
        configRepo.save(dataConfig);
        return dataConfig;
    }

    public DataSource createNewDataSource(String name, String password){
        createNewDataSourceConfig(name, password);
        return createDataSource(name);
    }

    public boolean ifDatasourceExist(String name){
        System.out.println(configRepo.count());
        return  configRepo.existsByName(name);
    }

}