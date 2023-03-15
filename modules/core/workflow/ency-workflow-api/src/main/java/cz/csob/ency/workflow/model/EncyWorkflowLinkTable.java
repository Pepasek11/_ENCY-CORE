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

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;ency_workflowlink&quot; database table.
 *
 * @author Miroslav Čermák
 * @see EncyWorkflowLink
 * @generated
 */
public class EncyWorkflowLinkTable extends BaseTable<EncyWorkflowLinkTable> {

	public static final EncyWorkflowLinkTable INSTANCE =
		new EncyWorkflowLinkTable();

	public final Column<EncyWorkflowLinkTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EncyWorkflowLinkTable, Long> workflowLinkId =
		createColumn(
			"workflowLinkId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<EncyWorkflowLinkTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<EncyWorkflowLinkTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<EncyWorkflowLinkTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<EncyWorkflowLinkTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EncyWorkflowLinkTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<EncyWorkflowLinkTable, Date> modifiedDate =
		createColumn(
			"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<EncyWorkflowLinkTable, String> className = createColumn(
		"className", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EncyWorkflowLinkTable, String> folderClassName =
		createColumn(
			"folderClassName", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<EncyWorkflowLinkTable, Long> folderPK = createColumn(
		"folderPK", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<EncyWorkflowLinkTable, Long> workflowId = createColumn(
		"workflowId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	private EncyWorkflowLinkTable() {
		super("ency_workflowlink", EncyWorkflowLinkTable::new);
	}

}