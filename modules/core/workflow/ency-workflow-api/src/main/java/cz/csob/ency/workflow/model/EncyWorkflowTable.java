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
 * The table class for the &quot;ency_workflow&quot; database table.
 *
 * @author Miroslav Čermák
 * @see EncyWorkflow
 * @generated
 */
public class EncyWorkflowTable extends BaseTable<EncyWorkflowTable> {

	public static final EncyWorkflowTable INSTANCE = new EncyWorkflowTable();

	public final Column<EncyWorkflowTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EncyWorkflowTable, Long> workflowId = createColumn(
		"workflowId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<EncyWorkflowTable, String> className = createColumn(
		"className", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EncyWorkflowTable, String> title = createColumn(
		"title", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EncyWorkflowTable, Clob> description = createColumn(
		"description", Clob.class, Types.CLOB, Column.FLAG_DEFAULT);
	public final Column<EncyWorkflowTable, String> initialStateName =
		createColumn(
			"initialStateName", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<EncyWorkflowTable, Long> version = createColumn(
		"version", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<EncyWorkflowTable, Boolean> active = createColumn(
		"active_", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<EncyWorkflowTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<EncyWorkflowTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);

	private EncyWorkflowTable() {
		super("ency_workflow", EncyWorkflowTable::new);
	}

}