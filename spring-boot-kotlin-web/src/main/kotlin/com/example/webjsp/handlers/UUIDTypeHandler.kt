package com.example.webjsp.handlers

import org.apache.ibatis.type.BaseTypeHandler
import org.apache.ibatis.type.JdbcType
import org.apache.ibatis.type.MappedJdbcTypes
import org.apache.ibatis.type.MappedTypes
import java.sql.CallableStatement
import java.sql.PreparedStatement
import java.sql.ResultSet
import java.sql.SQLException
import java.util.*


@MappedJdbcTypes(JdbcType.OTHER)
@MappedTypes(UUID::class)
class UUIDTypeHandler: BaseTypeHandler<UUID>() {
    @Throws(SQLException::class)
    override fun setNonNullParameter(ps: PreparedStatement, i: Int, parameter: UUID?, jdbcType: JdbcType?) {
        ps.setObject(i, parameter) // no 3rd arg
    }

    @Throws(SQLException::class)
    override fun getNullableResult(rs: ResultSet, columnName: String?): UUID? {
        val src = rs.getString(columnName) ?: return null
        return UUID.fromString(src)
    }

    @Throws(SQLException::class)
    override fun getNullableResult(rs: ResultSet, columnIndex: Int): UUID? {
        val src = rs.getString(columnIndex) ?: return null
        return UUID.fromString(src)
    }

    @Throws(SQLException::class)
    override fun getNullableResult(cs: CallableStatement, columnIndex: Int): UUID? {
        val src = cs.getString(columnIndex) ?: return null
        return UUID.fromString(src)
    }
}