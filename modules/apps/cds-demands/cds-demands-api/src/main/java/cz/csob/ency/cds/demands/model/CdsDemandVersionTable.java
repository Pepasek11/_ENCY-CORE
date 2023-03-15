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
 * The table class for the &quot;CdsDemands_CdsDemandVersion&quot; database table.
 *
 * @author Miroslav Čermák
 * @see CdsDemandVersion
 * @generated
 */
public class CdsDemandVersionTable extends BaseTable<CdsDemandVersionTable> {

	public static final CdsDemandVersionTable INSTANCE =
		new CdsDemandVersionTable();

	public final Column<CdsDemandVersionTable, Long> cdsDemandVersionId =
		createColumn(
			"cdsDemandVersionId", Long.class, Types.BIGINT,
			Column.FLAG_PRIMARY);
	public final Column<CdsDemandVersionTable, Integer> version = createColumn(
		"version", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<CdsDemandVersionTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CdsDemandVersionTable, Long> demandId = createColumn(
		"demandId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<CdsDemandVersionTable, String> title = createColumn(
		"title", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CdsDemandVersionTable, String> description =
		createColumn(
			"description", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CdsDemandVersionTable, Integer> type = createColumn(
		"type_", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<CdsDemandVersionTable, Integer> priority = createColumn(
		"priority", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<CdsDemandVersionTable, Date> requestedDelivery =
		createColumn(
			"requestedDelivery", Date.class, Types.TIMESTAMP,
			Column.FLAG_DEFAULT);
	public final Column<CdsDemandVersionTable, Boolean> isGDPR = createColumn(
		"isGDPR", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<CdsDemandVersionTable, String> gdprInfo = createColumn(
		"gdprInfo", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CdsDemandVersionTable, String> fiveTracks =
		createColumn(
			"fiveTracks", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CdsDemandVersionTable, Long> requestorId = createColumn(
		"requestorId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<CdsDemandVersionTable, String> requestorName =
		createColumn(
			"requestorName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CdsDemandVersionTable, Long> requestedForId =
		createColumn(
			"requestedForId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<CdsDemandVersionTable, String> requestedForName =
		createColumn(
			"requestedForName", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<CdsDemandVersionTable, Long> contactId = createColumn(
		"contactId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<CdsDemandVersionTable, String> contactName =
		createColumn(
			"contactName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CdsDemandVersionTable, Long> domainId = createColumn(
		"domainId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<CdsDemandVersionTable, String> domainName =
		createColumn(
			"domainName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CdsDemandVersionTable, Long> banId = createColumn(
		"banId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<CdsDemandVersionTable, String> banName = createColumn(
		"banName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CdsDemandVersionTable, Long> spocId = createColumn(
		"spocId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<CdsDemandVersionTable, String> spocName = createColumn(
		"spocName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CdsDemandVersionTable, String> usReasoning =
		createColumn(
			"usReasoning", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CdsDemandVersionTable, Integer> usFrequencyOut =
		createColumn(
			"usFrequencyOut", Integer.class, Types.INTEGER,
			Column.FLAG_DEFAULT);
	public final Column<CdsDemandVersionTable, Boolean> usAccessDPM =
		createColumn(
			"usAccessDPM", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<CdsDemandVersionTable, String> usFolderDPM =
		createColumn(
			"usFolderDPM", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CdsDemandVersionTable, Boolean> usCreateFolderDPM =
		createColumn(
			"usCreateFolderDPM", Boolean.class, Types.BOOLEAN,
			Column.FLAG_DEFAULT);
	public final Column<CdsDemandVersionTable, Long> usGestorFolderDPMId =
		createColumn(
			"usGestorFolderDPMId", Long.class, Types.BIGINT,
			Column.FLAG_DEFAULT);
	public final Column<CdsDemandVersionTable, String> usGestorFolderDPMName =
		createColumn(
			"usGestorFolderDPMName", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<CdsDemandVersionTable, String> usDPMNotificationMail =
		createColumn(
			"usDPMNotificationMail", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<CdsDemandVersionTable, String> bioeId = createColumn(
		"bioeId", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CdsDemandVersionTable, Short> bioeStateId =
		createColumn(
			"bioeStateId", Short.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<CdsDemandVersionTable, String> bioeStateName =
		createColumn(
			"bioeStateName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CdsDemandVersionTable, Double> workEstimate =
		createColumn(
			"workEstimate", Double.class, Types.DOUBLE, Column.FLAG_DEFAULT);
	public final Column<CdsDemandVersionTable, Double> acceptedWorkEstimate =
		createColumn(
			"acceptedWorkEstimate", Double.class, Types.DOUBLE,
			Column.FLAG_DEFAULT);
	public final Column<CdsDemandVersionTable, Date> expectedDelivery =
		createColumn(
			"expectedDelivery", Date.class, Types.TIMESTAMP,
			Column.FLAG_DEFAULT);
	public final Column<CdsDemandVersionTable, Date> acceptedDelivery =
		createColumn(
			"acceptedDelivery", Date.class, Types.TIMESTAMP,
			Column.FLAG_DEFAULT);
	public final Column<CdsDemandVersionTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<CdsDemandVersionTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<CdsDemandVersionTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<CdsDemandVersionTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CdsDemandVersionTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<CdsDemandVersionTable, Date> modifiedDate =
		createColumn(
			"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<CdsDemandVersionTable, String> urlTitle = createColumn(
		"urlTitle", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CdsDemandVersionTable, String> state = createColumn(
		"state_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CdsDemandVersionTable, Long> stateByUserId =
		createColumn(
			"stateByUserId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<CdsDemandVersionTable, String> stateByUserName =
		createColumn(
			"stateByUserName", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<CdsDemandVersionTable, Date> stateDate = createColumn(
		"stateDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);

	private CdsDemandVersionTable() {
		super("CdsDemands_CdsDemandVersion", CdsDemandVersionTable::new);
	}

}