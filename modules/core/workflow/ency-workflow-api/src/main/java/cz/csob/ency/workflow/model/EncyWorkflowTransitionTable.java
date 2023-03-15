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
 * The table class for the &quot;ency_workflowtransition&quot; database table.
 *
 * @author Miroslav Čermák
 * @see EncyWorkflowTransition
 * @generated
 */
public class EncyWorkflowTransitionTable
	extends BaseTable<EncyWorkflowTransitionTable> {

	public static final EncyWorkflowTransitionTable INSTANCE =
		new EncyWorkflowTransitionTable();

	public final Column<EncyWorkflowTransitionTable, String> uuid =
		createColumn("uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EncyWorkflowTransitionTable, Long> transitionId =
		createColumn(
			"transitionId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<EncyWorkflowTransitionTable, Long> stateId =
		createColumn("stateId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<EncyWorkflowTransitionTable, Long> workflowId =
		createColumn(
			"workflowId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<EncyWorkflowTransitionTable, Long> version =
		createColumn("version", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<EncyWorkflowTransitionTable, String> name =
		createColumn("name", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EncyWorkflowTransitionTable, String> title =
		createColumn("title", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EncyWorkflowTransitionTable, Clob> description =
		createColumn(
			"description", Clob.class, Types.CLOB, Column.FLAG_DEFAULT);
	public final Column<EncyWorkflowTransitionTable, String> targetStateName =
		createColumn(
			"targetStateName", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<EncyWorkflowTransitionTable, Long> targetStateId =
		createColumn(
			"targetStateId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<EncyWorkflowTransitionTable, String> cssIcon =
		createColumn(
			"cssIcon", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EncyWorkflowTransitionTable, String> cssIconColor =
		createColumn(
			"cssIconColor", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EncyWorkflowTransitionTable, Boolean> active =
		createColumn(
			"active_", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<EncyWorkflowTransitionTable, Date> createDate =
		createColumn(
			"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<EncyWorkflowTransitionTable, Date> modifiedDate =
		createColumn(
			"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<EncyWorkflowTransitionTable, Long> order = createColumn(
		"order_", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	private EncyWorkflowTransitionTable() {
		super("ency_workflowtransition", EncyWorkflowTransitionTable::new);
	}

}