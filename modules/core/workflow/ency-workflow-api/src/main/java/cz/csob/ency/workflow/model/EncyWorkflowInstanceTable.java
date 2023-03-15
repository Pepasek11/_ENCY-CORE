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
 * The table class for the &quot;ency_workflowinstance&quot; database table.
 *
 * @author Miroslav Čermák
 * @see EncyWorkflowInstance
 * @generated
 */
public class EncyWorkflowInstanceTable
	extends BaseTable<EncyWorkflowInstanceTable> {

	public static final EncyWorkflowInstanceTable INSTANCE =
		new EncyWorkflowInstanceTable();

	public final Column<EncyWorkflowInstanceTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EncyWorkflowInstanceTable, Long> workflowInstanceId =
		createColumn(
			"workflowInstanceId", Long.class, Types.BIGINT,
			Column.FLAG_PRIMARY);
	public final Column<EncyWorkflowInstanceTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<EncyWorkflowInstanceTable, Long> companyId =
		createColumn(
			"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<EncyWorkflowInstanceTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<EncyWorkflowInstanceTable, String> userName =
		createColumn(
			"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EncyWorkflowInstanceTable, Date> createDate =
		createColumn(
			"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<EncyWorkflowInstanceTable, Date> modifiedDate =
		createColumn(
			"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<EncyWorkflowInstanceTable, Long> workflowId =
		createColumn(
			"workflowId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<EncyWorkflowInstanceTable, Long> workflowVersion =
		createColumn(
			"workflowVersion", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<EncyWorkflowInstanceTable, String> className =
		createColumn(
			"className", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EncyWorkflowInstanceTable, Long> classPK = createColumn(
		"classPK", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<EncyWorkflowInstanceTable, Clob> workflowContext =
		createColumn(
			"workflowContext", Clob.class, Types.CLOB, Column.FLAG_DEFAULT);

	private EncyWorkflowInstanceTable() {
		super("ency_workflowinstance", EncyWorkflowInstanceTable::new);
	}

}