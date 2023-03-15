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
 * The table class for the &quot;MetaCds_ColumnEntry&quot; database table.
 *
 * @author "Miroslav Čermák"
 * @see ColumnEntry
 * @generated
 */
public class ColumnEntryTable extends BaseTable<ColumnEntryTable> {

	public static final ColumnEntryTable INSTANCE = new ColumnEntryTable();

	public final Column<ColumnEntryTable, Long> mvccVersion = createColumn(
		"mvccVersion", Long.class, Types.BIGINT, Column.FLAG_NULLITY);
	public final Column<ColumnEntryTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ColumnEntryTable, Long> columnEntryId = createColumn(
		"columnEntryId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<ColumnEntryTable, String> columnType = createColumn(
		"columnType", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ColumnEntryTable, String> columnName = createColumn(
		"columnName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ColumnEntryTable, Long> columnPosition = createColumn(
		"columnPosition", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ColumnEntryTable, String> columnFullName = createColumn(
		"columnFullName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ColumnEntryTable, Long> tableEntryId = createColumn(
		"tableEntryId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ColumnEntryTable, String> tableName = createColumn(
		"tableName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ColumnEntryTable, String> systemName = createColumn(
		"systemName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ColumnEntryTable, String> databaseName = createColumn(
		"databaseName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ColumnEntryTable, Clob> description = createColumn(
		"description", Clob.class, Types.CLOB, Column.FLAG_DEFAULT);
	public final Column<ColumnEntryTable, String> dataType = createColumn(
		"dataType", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ColumnEntryTable, Long> dataSize = createColumn(
		"dataSize", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ColumnEntryTable, Boolean> isPrimaryKey = createColumn(
		"isPrimaryKey", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<ColumnEntryTable, Boolean> isNotNull = createColumn(
		"isNotNull", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<ColumnEntryTable, Boolean> isActive = createColumn(
		"isActive", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<ColumnEntryTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ColumnEntryTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ColumnEntryTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ColumnEntryTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ColumnEntryTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<ColumnEntryTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<ColumnEntryTable, String> urlTitle = createColumn(
		"urlTitle", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ColumnEntryTable, Integer> status = createColumn(
		"status", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<ColumnEntryTable, Long> statusByUserId = createColumn(
		"statusByUserId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ColumnEntryTable, String> statusByUserName =
		createColumn(
			"statusByUserName", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<ColumnEntryTable, Date> statusDate = createColumn(
		"statusDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);

	private ColumnEntryTable() {
		super("MetaCds_ColumnEntry", ColumnEntryTable::new);
	}

}