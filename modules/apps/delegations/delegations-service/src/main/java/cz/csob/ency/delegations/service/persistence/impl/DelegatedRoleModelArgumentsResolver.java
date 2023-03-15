/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package cz.csob.ency.delegations.service.persistence.impl;

import com.liferay.portal.kernel.dao.orm.ArgumentsResolver;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.model.BaseModel;

import cz.csob.ency.delegations.model.DelegatedRoleTable;
import cz.csob.ency.delegations.model.impl.DelegatedRoleImpl;
import cz.csob.ency.delegations.model.impl.DelegatedRoleModelImpl;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.osgi.service.component.annotations.Component;

/**
 * The arguments resolver class for retrieving value from DelegatedRole.
 *
 * @author Miroslav Čermák
 * @generated
 */
@Component(
	immediate = true,
	service = {
		DelegatedRoleModelArgumentsResolver.class, ArgumentsResolver.class
	}
)
public class DelegatedRoleModelArgumentsResolver implements ArgumentsResolver {

	@Override
	public Object[] getArguments(
		FinderPath finderPath, BaseModel<?> baseModel, boolean checkColumn,
		boolean original) {

		String[] columnNames = finderPath.getColumnNames();

		if ((columnNames == null) || (columnNames.length == 0)) {
			if (baseModel.isNew()) {
				return new Object[0];
			}

			return null;
		}

		DelegatedRoleModelImpl delegatedRoleModelImpl =
			(DelegatedRoleModelImpl)baseModel;

		long columnBitmask = delegatedRoleModelImpl.getColumnBitmask();

		if (!checkColumn || (columnBitmask == 0)) {
			return _getValue(delegatedRoleModelImpl, columnNames, original);
		}

		Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
			finderPath);

		if (finderPathColumnBitmask == null) {
			finderPathColumnBitmask = 0L;

			for (String columnName : columnNames) {
				finderPathColumnBitmask |=
					delegatedRoleModelImpl.getColumnBitmask(columnName);
			}

			_finderPathColumnBitmasksCache.put(
				finderPath, finderPathColumnBitmask);
		}

		if ((columnBitmask & finderPathColumnBitmask) != 0) {
			return _getValue(delegatedRoleModelImpl, columnNames, original);
		}

		return null;
	}

	@Override
	public String getClassName() {
		return DelegatedRoleImpl.class.getName();
	}

	@Override
	public String getTableName() {
		return DelegatedRoleTable.INSTANCE.getTableName();
	}

	private static Object[] _getValue(
		DelegatedRoleModelImpl delegatedRoleModelImpl, String[] columnNames,
		boolean original) {

		Object[] arguments = new Object[columnNames.length];

		for (int i = 0; i < arguments.length; i++) {
			String columnName = columnNames[i];

			if (original) {
				arguments[i] = delegatedRoleModelImpl.getColumnOriginalValue(
					columnName);
			}
			else {
				arguments[i] = delegatedRoleModelImpl.getColumnValue(
					columnName);
			}
		}

		return arguments;
	}

	private static final Map<FinderPath, Long> _finderPathColumnBitmasksCache =
		new ConcurrentHashMap<>();

}