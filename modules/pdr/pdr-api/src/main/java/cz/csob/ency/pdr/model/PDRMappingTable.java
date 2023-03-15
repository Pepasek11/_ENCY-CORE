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
 * The table class for the &quot;pdr_mapping&quot; database table.
 *
 * @author Miroslav Čermák
 * @see PDRMapping
 * @generated
 */
public class PDRMappingTable extends BaseTable<PDRMappingTable> {

	public static final PDRMappingTable INSTANCE = new PDRMappingTable();

	public final Column<PDRMappingTable, Long> mvccVersion = createColumn(
		"mvccVersion", Long.class, Types.BIGINT, Column.FLAG_NULLITY);
	public final Column<PDRMappingTable, Long> mappingId = createColumn(
		"mappingId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<PDRMappingTable, String> title = createColumn(
		"title", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<PDRMappingTable, Long> systemId = createColumn(
		"systemId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<PDRMappingTable, Long> tableId = createColumn(
		"tableId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<PDRMappingTable, Long> columnId = createColumn(
		"columnId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<PDRMappingTable, Long> attributeId = createColumn(
		"attributeId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<PDRMappingTable, String> mappingRules = createColumn(
		"mappingRules", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<PDRMappingTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<PDRMappingTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<PDRMappingTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<PDRMappingTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<PDRMappingTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<PDRMappingTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<PDRMappingTable, String> state = createColumn(
		"state_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<PDRMappingTable, Long> stateByUserId = createColumn(
		"stateByUserId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<PDRMappingTable, String> stateByUserName = createColumn(
		"stateByUserName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<PDRMappingTable, Date> stateDate = createColumn(
		"stateDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);

	private PDRMappingTable() {
		super("pdr_mapping", PDRMappingTable::new);
	}

}