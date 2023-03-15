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
 * The table class for the &quot;MetaCds_TableEntry&quot; database table.
 *
 * @author "Miroslav Čermák"
 * @see TableEntry
 * @generated
 */
public class TableEntryTable extends BaseTable<TableEntryTable> {

	public static final TableEntryTable INSTANCE = new TableEntryTable();

	public final Column<TableEntryTable, Long> mvccVersion = createColumn(
		"mvccVersion", Long.class, Types.BIGINT, Column.FLAG_NULLITY);
	public final Column<TableEntryTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<TableEntryTable, Long> tableEntryId = createColumn(
		"tableEntryId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<TableEntryTable, String> tableName = createColumn(
		"tableName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<TableEntryTable, String> tableFullName = createColumn(
		"tableFullName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<TableEntryTable, String> tableType = createColumn(
		"tableType", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<TableEntryTable, String> tableDatabase = createColumn(
		"tableDatabase", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<TableEntryTable, Long> systemEntryId = createColumn(
		"systemEntryId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<TableEntryTable, String> systemName = createColumn(
		"systemName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<TableEntryTable, Clob> description = createColumn(
		"description", Clob.class, Types.CLOB, Column.FLAG_DEFAULT);
	public final Column<TableEntryTable, String> dsaUrl = createColumn(
		"dsaUrl", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<TableEntryTable, String> contactPersonName =
		createColumn(
			"contactPersonName", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<TableEntryTable, String> contactPersonId = createColumn(
		"contactPersonId", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<TableEntryTable, String> specificationOwnerName =
		createColumn(
			"specificationOwnerName", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<TableEntryTable, String> specificationOwnerId =
		createColumn(
			"specificationOwnerId", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<TableEntryTable, Clob> unstructuredClause =
		createColumn(
			"unstructuredClause", Clob.class, Types.CLOB, Column.FLAG_DEFAULT);
	public final Column<TableEntryTable, Boolean> isActive = createColumn(
		"isActive", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<TableEntryTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<TableEntryTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<TableEntryTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<TableEntryTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<TableEntryTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<TableEntryTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<TableEntryTable, String> urlTitle = createColumn(
		"urlTitle", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<TableEntryTable, Integer> status = createColumn(
		"status", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<TableEntryTable, Long> statusByUserId = createColumn(
		"statusByUserId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<TableEntryTable, String> statusByUserName =
		createColumn(
			"statusByUserName", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<TableEntryTable, Date> statusDate = createColumn(
		"statusDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);

	private TableEntryTable() {
		super("MetaCds_TableEntry", TableEntryTable::new);
	}

}