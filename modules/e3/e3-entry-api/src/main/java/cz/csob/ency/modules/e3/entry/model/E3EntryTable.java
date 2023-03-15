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
 * The table class for the &quot;E3Entry&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see E3Entry
 * @generated
 */
public class E3EntryTable extends BaseTable<E3EntryTable> {

	public static final E3EntryTable INSTANCE = new E3EntryTable();

	public final Column<E3EntryTable, Long> mvccVersion = createColumn(
		"mvccVersion", Long.class, Types.BIGINT, Column.FLAG_NULLITY);
	public final Column<E3EntryTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<E3EntryTable, Long> headId = createColumn(
		"headId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<E3EntryTable, Boolean> head = createColumn(
		"head", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<E3EntryTable, Long> entryId = createColumn(
		"entry_id", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<E3EntryTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<E3EntryTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<E3EntryTable, Long> userId = createColumn(
		"entry_modifier_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<E3EntryTable, String> userName = createColumn(
		"entry_modifier_name", String.class, Types.VARCHAR,
		Column.FLAG_DEFAULT);
	public final Column<E3EntryTable, Date> createDate = createColumn(
		"entry_created", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<E3EntryTable, Date> modifiedDate = createColumn(
		"entry_modified", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<E3EntryTable, Long> authorId = createColumn(
		"entry_author_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<E3EntryTable, String> authorName = createColumn(
		"entry_author_name", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<E3EntryTable, String> xid = createColumn(
		"entry_xid", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<E3EntryTable, String> name = createColumn(
		"entry_name", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<E3EntryTable, String> appClass = createColumn(
		"app_class", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<E3EntryTable, Long> parentId = createColumn(
		"parent_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<E3EntryTable, String> parentField = createColumn(
		"parent_field", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<E3EntryTable, Clob> values = createColumn(
		"json_values", Clob.class, Types.CLOB, Column.FLAG_DEFAULT);
	public final Column<E3EntryTable, Long> status = createColumn(
		"status", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	private E3EntryTable() {
		super("E3Entry", E3EntryTable::new);
	}

}