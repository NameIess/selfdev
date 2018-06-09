package util;

import org.dbunit.DataSourceDatabaseTester;
import org.dbunit.util.fileloader.XlsDataFileLoader;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

@Configuration
@ImportResource("/http-activator/datasource-tx-jpa-context.xml")
@ComponentScan(basePackages = {"remoteproccessing"})
@Profile("test")
public class ServiceTestConfig {

    @Bean
    public DataSource dataSource() {
        EmbeddedDatabaseBuilder databaseBuilder = new EmbeddedDatabaseBuilder();
        databaseBuilder.setType(EmbeddedDatabaseType.H2);
        databaseBuilder.addScript("/data/tableCreation.sql");
        EmbeddedDatabase database = databaseBuilder.build();

        return database;
    }

    @Bean(name = "databaseTester")
    public DataSourceDatabaseTester dataSourceDatabaseTester() {
        DataSourceDatabaseTester databaseTester = new DataSourceDatabaseTester(dataSource());
        return databaseTester;
    }

    @Bean(name = "xlsDataFileLoader")
    public XlsDataFileLoader xlsDataFileLoader() {
        XlsDataFileLoader dataFileLoader = new XlsDataFileLoader();
        return dataFileLoader;
    }
}
