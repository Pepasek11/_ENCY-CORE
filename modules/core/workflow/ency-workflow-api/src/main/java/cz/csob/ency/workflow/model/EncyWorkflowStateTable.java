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

package cz.csob.ency.workflow.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Clob;
import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;ency_workflowstate&quot; database table.
 *
 * @author Miroslav Čermák
 * @see EncyWorkflowState
 * @generated
 */
public class EncyWorkflowStateTable extends BaseTable<EncyWorkflowStateTable> {

	public static final EncyWorkflowStateTable INSTANCE =
		new EncyWorkflowStateTable();

	public final Column<EncyWorkflowStateTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EncyWorkflowStateTable, Long> stateId = createColumn(
		"stateId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<EncyWorkflowStateTable, Long> workflowId = createColumn(
		"workflowId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<EncyWorkflowStateTable, String> name = createColumn(
		"name", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EncyWorkflowStateTable, String> title = createColumn(
		"title", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EncyWorkflowStateTable, Clob> description =
		createColumn(
			"description", Clob.class, Types.CLOB, Column.FLAG_DEFAULT);
	public final Column<EncyWorkflowStateTable, Long> version = createColumn(
		"version", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<EncyWorkflowStateTable, Boolean> isInitial =
		createColumn(
			"isInitial", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<EncyWorkflowStateTable, Boolean> isFinal = createColumn(
		"isFinal", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<EncyWorkflowStateTable, Boolean> isEditable =
		createColumn(
			"isEditable", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<EncyWorkflowStateTable, Boolean> isSearchable =
		createColumn(
			"isSearchable", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<EncyWorkflowStateTable, Boolean> isPermanent =
		createColumn(
			"isPermanent", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<EncyWorkflowStateTable, String> cssIcon = createColumn(
		"cssIcon", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EncyWorkflowStateTable, String> cssIconColor =
		createColumn(
			"cssIconColor", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EncyWorkflowStateTable, String> cssLabelColor =
		createColumn(
			"cssLabelColor", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EncyWorkflowStateTable, Boolean> active = createColumn(
		"active_", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<EncyWorkflowStateTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<EncyWorkflowStateTable, Date> modifiedDate =
		createColumn(
			"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);

	private EncyWorkflowStateTable() {
		super("ency_workflowstate", EncyWorkflowStateTable::new);
	}

}