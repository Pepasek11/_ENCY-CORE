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

package cz.csob.ency.delegations.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;delegations_delegation&quot; database table.
 *
 * @author Miroslav Čermák
 * @see Delegation
 * @generated
 */
public class DelegationTable extends BaseTable<DelegationTable> {

	public static final DelegationTable INSTANCE = new DelegationTable();

	public final Column<DelegationTable, Long> mvccVersion = createColumn(
		"mvccVersion", Long.class, Types.BIGINT, Column.FLAG_NULLITY);
	public final Column<DelegationTable, Long> delegationId = createColumn(
		"delegationId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<DelegationTable, Long> roleId = createColumn(
		"roleId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DelegationTable, Long> delegatingUserId = createColumn(
		"delegatingUserId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DelegationTable, Long> delegatedUserId = createColumn(
		"delegatedUserId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DelegationTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DelegationTable, String> note = createColumn(
		"note", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DelegationTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DelegationTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DelegationTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DelegationTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<DelegationTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);

	private DelegationTable() {
		super("delegations_delegation", DelegationTable::new);
	}

}