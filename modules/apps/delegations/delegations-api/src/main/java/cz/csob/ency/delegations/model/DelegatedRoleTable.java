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
 * The table class for the &quot;delegations_delegatedrole&quot; database table.
 *
 * @author Miroslav Čermák
 * @see DelegatedRole
 * @generated
 */
public class DelegatedRoleTable extends BaseTable<DelegatedRoleTable> {

	public static final DelegatedRoleTable INSTANCE = new DelegatedRoleTable();

	public final Column<DelegatedRoleTable, Long> mvccVersion = createColumn(
		"mvccVersion", Long.class, Types.BIGINT, Column.FLAG_NULLITY);
	public final Column<DelegatedRoleTable, Long> roleId = createColumn(
		"roleId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<DelegatedRoleTable, String> title = createColumn(
		"title", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DelegatedRoleTable, String> code = createColumn(
		"code_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DelegatedRoleTable, String> description = createColumn(
		"description", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DelegatedRoleTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DelegatedRoleTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DelegatedRoleTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DelegatedRoleTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DelegatedRoleTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<DelegatedRoleTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);

	private DelegatedRoleTable() {
		super("delegations_delegatedrole", DelegatedRoleTable::new);
	}

}