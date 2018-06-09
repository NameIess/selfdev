package com.spring.selfdev.demo.jdbc.annotationconfig;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.SqlFunction;

import javax.sql.DataSource;
import java.sql.Types;

public class StoredFunctionFirstNameById extends SqlFunction<String> {
    private static final String FUNCTION_INVOKE = "select getFirstNameById(?)";

    public StoredFunctionFirstNameById(DataSource ds) {
        super(ds, FUNCTION_INVOKE);
        declareParameter(new SqlParameter(Types.INTEGER));
        compile();
    }
}
