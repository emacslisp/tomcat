/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.tomcat.dbcp.dbcp2.cpdsadapter;

import java.util.Arrays;

import org.apache.tomcat.dbcp.dbcp2.PStmtKey;

/**
 * A key uniquely identifying a {@link java.sql.PreparedStatement
 * PreparedStatement}.
 * 
 * @since 2.0
 */
public class PStmtKeyCPDS extends PStmtKey {
	private final Integer _resultSetHoldability;
	private final int _columnIndexes[];
	private final String _columnNames[];

	public PStmtKeyCPDS(final String sql) {
		super(sql);
		_resultSetHoldability = null;
		_columnIndexes = null;
		_columnNames = null;
	}

	public PStmtKeyCPDS(final String sql, final int autoGeneratedKeys) {
		super(sql, null, autoGeneratedKeys);
		_resultSetHoldability = null;
		_columnIndexes = null;
		_columnNames = null;
	}

	public PStmtKeyCPDS(final String sql, final int resultSetType, final int resultSetConcurrency) {
		super(sql, resultSetType, resultSetConcurrency);
		_resultSetHoldability = null;
		_columnIndexes = null;
		_columnNames = null;
	}

	public PStmtKeyCPDS(final String sql, final int resultSetType, final int resultSetConcurrency,
			final int resultSetHoldability) {
		super(sql, resultSetType, resultSetConcurrency);
		_resultSetHoldability = Integer.valueOf(resultSetHoldability);
		_columnIndexes = null;
		_columnNames = null;
	}

	public PStmtKeyCPDS(final String sql, final int columnIndexes[]) {
		super(sql);
		_columnIndexes = Arrays.copyOf(columnIndexes, columnIndexes.length);
		_resultSetHoldability = null;
		_columnNames = null;
	}

	public PStmtKeyCPDS(final String sql, final String columnNames[]) {
		super(sql);
		_columnNames = Arrays.copyOf(columnNames, columnNames.length);
		_resultSetHoldability = null;
		_columnIndexes = null;
	}

	@Override
	public boolean equals(final Object obj)
	{
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final PStmtKeyCPDS other = (PStmtKeyCPDS) obj;
		if (!Arrays.equals(_columnIndexes, other._columnIndexes)) {
			return false;
		}
		if (!Arrays.equals(_columnNames, other._columnNames)) {
			return false;
		}
		if (_resultSetHoldability == null) {
			if (other._resultSetHoldability != null) {
				return false;
			}
		} else if (!_resultSetHoldability.equals(other._resultSetHoldability)) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Arrays.hashCode(_columnIndexes);
		result = prime * result + Arrays.hashCode(_columnNames);
		result = prime * result + (_resultSetHoldability == null ? 0 : _resultSetHoldability.hashCode());
		return result;
	}

	@Override
	public String toString()
	{
		final StringBuffer buf = new StringBuffer();
		buf.append("PStmtKey: sql=");
		buf.append(getSql());
		buf.append(", catalog=");
		buf.append(getCatalog());
		buf.append(", resultSetType=");
		buf.append(getResultSetType());
		buf.append(", resultSetConcurrency=");
		buf.append(getResultSetConcurrency());
		buf.append(", statmentType=");
		buf.append(getStmtType());
		buf.append(", resultSetHoldability=");
		buf.append(_resultSetHoldability);
		buf.append(", columnIndexes=");
		buf.append(Arrays.toString(_columnIndexes));
		buf.append(", columnNames=");
		buf.append(Arrays.toString(_columnNames));
		return buf.toString();
	}
}
