package com.example.webjsp.handlers;

import org.apache.ibatis.type.*;
import java.sql.*;
import java.util.*;

@MappedJdbcTypes(JdbcType.OTHER)
@MappedTypes(UUID.class)
public class UUIDTypeHandler extends BaseTypeHandler<UUID> {

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, UUID parameter, JdbcType jdbcType) throws SQLException {
        ps.setObject(i, parameter); // no 3rd arg
    }

    @Override
    public UUID getNullableResult(ResultSet rs, String columnName) throws SQLException {
        String val = rs.getString(columnName);
        if (val == null)
            return null;
        return UUID.fromString(val);
    }

    @Override
    public UUID getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        // return rs.getObject(columnIndex, UUID.class);
        String val = rs.getString(columnIndex);
        if (val == null)
            return null;
        return UUID.fromString(val);
    }

    @Override
    public UUID getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        //return cs.getObject(columnIndex, UUID.class);
        String val = cs.getString(columnIndex);
        if (val == null)
            return null;
        return UUID.fromString(val);
    }
}