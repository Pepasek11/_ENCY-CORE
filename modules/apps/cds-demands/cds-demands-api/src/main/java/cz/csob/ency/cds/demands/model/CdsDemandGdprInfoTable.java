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

package cz.csob.ency.cds.demands.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;CdsDemands_CdsDemandGdprInfo&quot; database table.
 *
 * @author Miroslav Čermák
 * @see CdsDemandGdprInfo
 * @generated
 */
public class CdsDemandGdprInfoTable extends BaseTable<CdsDemandGdprInfoTable> {

	public static final CdsDemandGdprInfoTable INSTANCE =
		new CdsDemandGdprInfoTable();

	public final Column<CdsDemandGdprInfoTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CdsDemandGdprInfoTable, Long> gdprInfoId = createColumn(
		"gdprInfoId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<CdsDemandGdprInfoTable, Long> demandId = createColumn(
		"demandId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<CdsDemandGdprInfoTable, String> title = createColumn(
		"title", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CdsDemandGdprInfoTable, String> description =
		createColumn(
			"description", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CdsDemandGdprInfoTable, Boolean> isEmployee =
		createColumn(
			"isEmployee", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<CdsDemandGdprInfoTable, String> employeeCategory =
		createColumn(
			"employeeCategory", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<CdsDemandGdprInfoTable, String> employeeReasoning =
		createColumn(
			"employeeReasoning", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<CdsDemandGdprInfoTable, Boolean> isClient =
		createColumn(
			"isClient", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<CdsDemandGdprInfoTable, String> clientCategory =
		createColumn(
			"clientCategory", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CdsDemandGdprInfoTable, String> clientReasoning =
		createColumn(
			"clientReasoning", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<CdsDemandGdprInfoTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<CdsDemandGdprInfoTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CdsDemandGdprInfoTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<CdsDemandGdprInfoTable, Date> modifiedDate =
		createColumn(
			"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);

	private CdsDemandGdprInfoTable() {
		super("CdsDemands_CdsDemandGdprInfo", CdsDemandGdprInfoTable::new);
	}

}