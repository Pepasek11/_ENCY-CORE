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

package cz.csob.ency.pdr.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;pdr_attribute&quot; database table.
 *
 * @author Miroslav Čermák
 * @see PDRAttribute
 * @generated
 */
public class PDRAttributeTable extends BaseTable<PDRAttributeTable> {

	public static final PDRAttributeTable INSTANCE = new PDRAttributeTable();

	public final Column<PDRAttributeTable, Long> mvccVersion = createColumn(
		"mvccVersion", Long.class, Types.BIGINT, Column.FLAG_NULLITY);
	public final Column<PDRAttributeTable, Long> attributeId = createColumn(
		"attributeId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<PDRAttributeTable, String> fullName = createColumn(
		"fullName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<PDRAttributeTable, Long> parentId = createColumn(
		"parentId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<PDRAttributeTable, String> nameCz = createColumn(
		"nameCz", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<PDRAttributeTable, String> nameEn = createColumn(
		"nameEn", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<PDRAttributeTable, String> nameSk = createColumn(
		"nameSk", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<PDRAttributeTable, Integer> order = createColumn(
		"order_", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<PDRAttributeTable, Integer> level = createColumn(
		"level", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<PDRAttributeTable, String> idsPath = createColumn(
		"idsPath", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<PDRAttributeTable, String> description = createColumn(
		"description", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<PDRAttributeTable, Long> personalDataTypeId =
		createColumn(
			"personalDataTypeId", Long.class, Types.BIGINT,
			Column.FLAG_DEFAULT);
	public final Column<PDRAttributeTable, String> tagName = createColumn(
		"tagName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<PDRAttributeTable, Boolean> isRoA = createColumn(
		"isRoA", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<PDRAttributeTable, Boolean> isRtP = createColumn(
		"isRtP", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<PDRAttributeTable, String> separatorBefore =
		createColumn(
			"separatorBefore", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<PDRAttributeTable, String> separatorAfter =
		createColumn(
			"separatorAfter", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<PDRAttributeTable, Boolean> isMerge = createColumn(
		"isMerge", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<PDRAttributeTable, Boolean> isLabel = createColumn(
		"isLabel", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<PDRAttributeTable, Boolean> isObject = createColumn(
		"isObject", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<PDRAttributeTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<PDRAttributeTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<PDRAttributeTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<PDRAttributeTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<PDRAttributeTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<PDRAttributeTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);

	private PDRAttributeTable() {
		super("pdr_attribute", PDRAttributeTable::new);
	}

}