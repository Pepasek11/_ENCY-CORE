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

package cz.csob.ency.modules.apps.meta.cds.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Clob;
import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;MetaCds_SystemEntry&quot; database table.
 *
 * @author "Miroslav Čermák"
 * @see SystemEntry
 * @generated
 */
public class SystemEntryTable extends BaseTable<SystemEntryTable> {

	public static final SystemEntryTable INSTANCE = new SystemEntryTable();

	public final Column<SystemEntryTable, Long> mvccVersion = createColumn(
		"mvccVersion", Long.class, Types.BIGINT, Column.FLAG_NULLITY);
	public final Column<SystemEntryTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<SystemEntryTable, Long> systemEntryId = createColumn(
		"systemEntryId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<SystemEntryTable, Long> systemCode = createColumn(
		"systemCode", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<SystemEntryTable, String> systemName = createColumn(
		"systemName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<SystemEntryTable, String> systemTitle = createColumn(
		"systemTitle", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<SystemEntryTable, String> systemType = createColumn(
		"systemType", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<SystemEntryTable, Clob> description = createColumn(
		"description", Clob.class, Types.CLOB, Column.FLAG_DEFAULT);
	public final Column<SystemEntryTable, String> stewardName = createColumn(
		"stewardName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<SystemEntryTable, String> stewardId = createColumn(
		"stewardId", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<SystemEntryTable, String> stewardDepartment =
		createColumn(
			"stewardDepartment", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<SystemEntryTable, String> businessOwnerName =
		createColumn(
			"businessOwnerName", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<SystemEntryTable, String> businessOwnerId =
		createColumn(
			"businessOwnerId", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<SystemEntryTable, String> contactPersonName =
		createColumn(
			"contactPersonName", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<SystemEntryTable, String> contactPersonId =
		createColumn(
			"contactPersonId", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<SystemEntryTable, String> sandboxName = createColumn(
		"sandboxName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<SystemEntryTable, String> gestorDepartmentId =
		createColumn(
			"gestorDepartmentId", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<SystemEntryTable, String> gestorDepartmentName =
		createColumn(
			"gestorDepartmentName", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<SystemEntryTable, String> role = createColumn(
		"role_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<SystemEntryTable, String> snowAssetTagId = createColumn(
		"snowAssetTagId", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<SystemEntryTable, String> snowAssetTagName =
		createColumn(
			"snowAssetTagName", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<SystemEntryTable, Boolean> isSlaSigned = createColumn(
		"isSlaSigned", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<SystemEntryTable, Boolean> isSelfBi = createColumn(
		"isSelfBi", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<SystemEntryTable, Boolean> isActive = createColumn(
		"isActive", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<SystemEntryTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<SystemEntryTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<SystemEntryTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<SystemEntryTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<SystemEntryTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<SystemEntryTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<SystemEntryTable, String> urlTitle = createColumn(
		"urlTitle", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<SystemEntryTable, Integer> status = createColumn(
		"status", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<SystemEntryTable, Long> statusByUserId = createColumn(
		"statusByUserId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<SystemEntryTable, String> statusByUserName =
		createColumn(
			"statusByUserName", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<SystemEntryTable, Date> statusDate = createColumn(
		"statusDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);

	private SystemEntryTable() {
		super("MetaCds_SystemEntry", SystemEntryTable::new);
	}

}