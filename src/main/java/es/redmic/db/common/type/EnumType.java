package es.redmic.db.common.type;

/*-
 * #%L
 * DB
 * %%
 * Copyright (C) 2019 REDMIC Project / Server
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.usertype.EnhancedUserType;
import org.hibernate.usertype.ParameterizedType;
import org.postgresql.util.PGobject;

public class EnumType implements EnhancedUserType, ParameterizedType {
    // Enum  class under observation
    @SuppressWarnings("rawtypes")
	private Class<Enum> enumClass;
 
    @SuppressWarnings({ "rawtypes", "unchecked" })
	public void setParameterValues(Properties parameters) {
        String enumClassName = parameters.getProperty("enumClassName");
        try {
            enumClass = (Class<Enum>) Class.forName(enumClassName);
        } catch (ClassNotFoundException cnfe) {
            throw new HibernateException("Enum class not found", cnfe);
        }
    }
 
    public Object assemble(Serializable cached, Object owner)
            throws HibernateException {
        return cached;
    }
 
    public Object deepCopy(Object value) throws HibernateException {
        return value;
    }
 
    @SuppressWarnings("rawtypes")
	public Serializable disassemble(Object value) throws HibernateException {
        return (Enum) value;
    }
 
    public boolean equals(Object x, Object y) throws HibernateException {
        return x == y;
    }
 
    public int hashCode(Object x) throws HibernateException {
        return x.hashCode();
    }
 
    public boolean isMutable() {
        return false;
    }
 
    public Object replace(Object original, Object target, Object owner)
            throws HibernateException {
        return original;
    }
 
    @SuppressWarnings("rawtypes")
	public Class returnedClass() {
        return enumClass;
    }
 
    public int[] sqlTypes() {
        return new int[] { 1111 };
    }
 
    @SuppressWarnings("unchecked")
	public Object fromXMLString(String xmlValue) {
        return Enum.valueOf(enumClass, xmlValue);
    }
 
    @SuppressWarnings("rawtypes")
	public String objectToSQLString(Object value) {
        return '\'' + ((Enum) value).name() + '\'';
    }
 
    @SuppressWarnings("rawtypes")
	public String toXMLString(Object value) {
        return ((Enum) value).name();
    }

	@SuppressWarnings("unchecked")
	@Override
	public Object nullSafeGet(ResultSet rs, String[] names, SharedSessionContractImplementor session, Object owner)
			throws HibernateException, SQLException {
		Object object = rs.getObject(names[0]);
        if (rs.wasNull()) {
            return null;
        }
 
        // Notice how Object is mapped to PGobject. This makes this implementation Postgres specific
        if (object instanceof PGobject) {
            PGobject pg = (PGobject) object;
            return Enum.valueOf(enumClass, pg.getValue());
        }
        return null;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public void nullSafeSet(PreparedStatement st, Object value, int index, SharedSessionContractImplementor session)
			throws HibernateException, SQLException {
		
		if (value == null) {
			st.setNull(index, 1111); 
        } else {
            // Notice 1111 which java.sql.Type for Postgres Enum
            st.setObject(index, ((Enum)value).name(), 1111);
        }
	}
}
