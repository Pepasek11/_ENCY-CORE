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

package cz.csob.ency.connection.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

/**
 * The table class for the &quot;ency_connection&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see ConnectionDefinition
 * @generated
 */
public class ConnectionDefinitionTable
	extends BaseTable<ConnectionDefinitionTable> {

	public static final ConnectionDefinitionTable INSTANCE =
		new ConnectionDefinitionTable();

	public final Column<ConnectionDefinitionTable, Long> connectionId =
		createColumn(
			"connectionId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<ConnectionDefinitionTable, String> name = createColumn(
		"name", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ConnectionDefinitionTable, String> driver =
		createColumn(
			"driver", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ConnectionDefinitionTable, String> url = createColumn(
		"url", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ConnectionDefinitionTable, String> serverAddress =
		createColumn(
			"serverAddress", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ConnectionDefinitionTable, String> serverPort =
		createColumn(
			"serverPort", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ConnectionDefinitionTable, String> databaseName =
		createColumn(
			"databaseName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ConnectionDefinitionTable, Boolean> integratedSecurity =
		createColumn(
			"integratedSecurity", Boolean.class, Types.BOOLEAN,
			Column.FLAG_DEFAULT);
	public final Column<ConnectionDefinitionTable, String> username =
		createColumn(
			"username", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ConnectionDefinitionTable, String> password =
		createColumn(
			"password_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ConnectionDefinitionTable, String> additionalParams =
		createColumn(
			"additionalParams", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);

	private ConnectionDefinitionTable() {
		super("ency_connection", ConnectionDefinitionTable::new);
	}

}