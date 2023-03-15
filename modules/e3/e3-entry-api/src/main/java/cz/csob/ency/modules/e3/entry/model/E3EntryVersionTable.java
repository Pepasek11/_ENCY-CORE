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

package cz.csob.ency.modules.e3.entry.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Clob;
import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;E3EntryVersion&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see E3EntryVersion
 * @generated
 */
public class E3EntryVersionTable extends BaseTable<E3EntryVersionTable> {

	public static final E3EntryVersionTable INSTANCE =
		new E3EntryVersionTable();

	public final Column<E3EntryVersionTable, Long> e3EntryVersionId =
		createColumn(
			"e3EntryVersionId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<E3EntryVersionTable, Integer> version = createColumn(
		"version", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<E3EntryVersionTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<E3EntryVersionTable, Long> entryId = createColumn(
		"entry_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<E3EntryVersionTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<E3EntryVersionTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<E3EntryVersionTable, Long> userId = createColumn(
		"entry_modifier_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<E3EntryVersionTable, String> userName = createColumn(
		"entry_modifier_name", String.class, Types.VARCHAR,
		Column.FLAG_DEFAULT);
	public final Column<E3EntryVersionTable, Date> createDate = createColumn(
		"entry_created", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<E3EntryVersionTable, Date> modifiedDate = createColumn(
		"entry_modified", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<E3EntryVersionTable, Long> authorId = createColumn(
		"entry_author_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<E3EntryVersionTable, String> authorName = createColumn(
		"entry_author_name", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<E3EntryVersionTable, String> xid = createColumn(
		"entry_xid", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<E3EntryVersionTable, String> name = createColumn(
		"entry_name", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<E3EntryVersionTable, String> appClass = createColumn(
		"app_class", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<E3EntryVersionTable, Long> parentId = createColumn(
		"parent_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<E3EntryVersionTable, String> parentField = createColumn(
		"parent_field", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<E3EntryVersionTable, Clob> values = createColumn(
		"json_values", Clob.class, Types.CLOB, Column.FLAG_DEFAULT);
	public final Column<E3EntryVersionTable, Long> status = createColumn(
		"status", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	private E3EntryVersionTable() {
		super("E3EntryVersion", E3EntryVersionTable::new);
	}

}