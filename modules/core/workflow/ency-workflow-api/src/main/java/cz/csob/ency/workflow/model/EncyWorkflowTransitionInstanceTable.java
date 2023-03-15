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
 * The table class for the &quot;ency_workflowtransitioninstance&quot; database table.
 *
 * @author Miroslav Čermák
 * @see EncyWorkflowTransitionInstance
 * @generated
 */
public class EncyWorkflowTransitionInstanceTable
	extends BaseTable<EncyWorkflowTransitionInstanceTable> {

	public static final EncyWorkflowTransitionInstanceTable INSTANCE =
		new EncyWorkflowTransitionInstanceTable();

	public final Column<EncyWorkflowTransitionInstanceTable, String> uuid =
		createColumn("uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EncyWorkflowTransitionInstanceTable, Long>
		transitionInstanceId = createColumn(
			"transitionInstanceId", Long.class, Types.BIGINT,
			Column.FLAG_PRIMARY);
	public final Column<EncyWorkflowTransitionInstanceTable, Long>
		transitionId = createColumn(
			"transitionId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<EncyWorkflowTransitionInstanceTable, Long> stateId =
		createColumn("stateId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<EncyWorkflowTransitionInstanceTable, Long>
		stateInstanceId = createColumn(
			"stateInstanceId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<EncyWorkflowTransitionInstanceTable, Long> workflowId =
		createColumn(
			"workflowId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<EncyWorkflowTransitionInstanceTable, Long>
		workflowInstanceId = createColumn(
			"workflowInstanceId", Long.class, Types.BIGINT,
			Column.FLAG_DEFAULT);
	public final Column<EncyWorkflowTransitionInstanceTable, Long> version =
		createColumn("version", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<EncyWorkflowTransitionInstanceTable, String> comment =
		createColumn(
			"comment_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EncyWorkflowTransitionInstanceTable, Long>
		targetStateId = createColumn(
			"targetStateId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<EncyWorkflowTransitionInstanceTable, Long>
		targetStateInstanceId = createColumn(
			"targetStateInstanceId", Long.class, Types.BIGINT,
			Column.FLAG_DEFAULT);
	public final Column<EncyWorkflowTransitionInstanceTable, Long> groupId =
		createColumn("groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<EncyWorkflowTransitionInstanceTable, Long> companyId =
		createColumn(
			"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<EncyWorkflowTransitionInstanceTable, Long> userId =
		createColumn("userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<EncyWorkflowTransitionInstanceTable, String> userName =
		createColumn(
			"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EncyWorkflowTransitionInstanceTable, Date> createDate =
		createColumn(
			"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<EncyWorkflowTransitionInstanceTable, Clob>
		workflowContext = createColumn(
			"workflowContext", Clob.class, Types.CLOB, Column.FLAG_DEFAULT);

	private EncyWorkflowTransitionInstanceTable() {
		super(
			"ency_workflowtransitioninstance",
			EncyWorkflowTransitionInstanceTable::new);
	}

}