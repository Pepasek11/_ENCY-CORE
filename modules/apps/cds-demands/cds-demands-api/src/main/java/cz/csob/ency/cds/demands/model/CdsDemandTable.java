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
 * The table class for the &quot;CdsDemands_CdsDemand&quot; database table.
 *
 * @author Miroslav Čermák
 * @see CdsDemand
 * @generated
 */
public class CdsDemandTable extends BaseTable<CdsDemandTable> {

	public static final CdsDemandTable INSTANCE = new CdsDemandTable();

	public final Column<CdsDemandTable, Long> mvccVersion = createColumn(
		"mvccVersion", Long.class, Types.BIGINT, Column.FLAG_NULLITY);
	public final Column<CdsDemandTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CdsDemandTable, Long> headId = createColumn(
		"headId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<CdsDemandTable, Boolean> head = createColumn(
		"head", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<CdsDemandTable, Long> demandId = createColumn(
		"demandId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<CdsDemandTable, String> title = createColumn(
		"title", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CdsDemandTable, String> description = createColumn(
		"description", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CdsDemandTable, Integer> type = createColumn(
		"type_", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<CdsDemandTable, Integer> priority = createColumn(
		"priority", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<CdsDemandTable, Date> requestedDelivery = createColumn(
		"requestedDelivery", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<CdsDemandTable, Boolean> isGDPR = createColumn(
		"isGDPR", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<CdsDemandTable, String> gdprInfo = createColumn(
		"gdprInfo", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CdsDemandTable, String> fiveTracks = createColumn(
		"fiveTracks", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CdsDemandTable, Long> requestorId = createColumn(
		"requestorId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<CdsDemandTable, String> requestorName = createColumn(
		"requestorName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CdsDemandTable, Long> requestedForId = createColumn(
		"requestedForId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<CdsDemandTable, String> requestedForName = createColumn(
		"requestedForName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CdsDemandTable, Long> contactId = createColumn(
		"contactId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<CdsDemandTable, String> contactName = createColumn(
		"contactName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CdsDemandTable, Long> domainId = createColumn(
		"domainId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<CdsDemandTable, String> domainName = createColumn(
		"domainName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CdsDemandTable, Long> banId = createColumn(
		"banId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<CdsDemandTable, String> banName = createColumn(
		"banName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CdsDemandTable, Long> spocId = createColumn(
		"spocId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<CdsDemandTable, String> spocName = createColumn(
		"spocName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CdsDemandTable, String> usReasoning = createColumn(
		"usReasoning", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CdsDemandTable, Integer> usFrequencyOut = createColumn(
		"usFrequencyOut", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<CdsDemandTable, Boolean> usAccessDPM = createColumn(
		"usAccessDPM", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<CdsDemandTable, String> usFolderDPM = createColumn(
		"usFolderDPM", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CdsDemandTable, Boolean> usCreateFolderDPM =
		createColumn(
			"usCreateFolderDPM", Boolean.class, Types.BOOLEAN,
			Column.FLAG_DEFAULT);
	public final Column<CdsDemandTable, Long> usGestorFolderDPMId =
		createColumn(
			"usGestorFolderDPMId", Long.class, Types.BIGINT,
			Column.FLAG_DEFAULT);
	public final Column<CdsDemandTable, String> usGestorFolderDPMName =
		createColumn(
			"usGestorFolderDPMName", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<CdsDemandTable, String> usDPMNotificationMail =
		createColumn(
			"usDPMNotificationMail", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<CdsDemandTable, String> bioeId = createColumn(
		"bioeId", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CdsDemandTable, Short> bioeStateId = createColumn(
		"bioeStateId", Short.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<CdsDemandTable, String> bioeStateName = createColumn(
		"bioeStateName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CdsDemandTable, Double> workEstimate = createColumn(
		"workEstimate", Double.class, Types.DOUBLE, Column.FLAG_DEFAULT);
	public final Column<CdsDemandTable, Double> acceptedWorkEstimate =
		createColumn(
			"acceptedWorkEstimate", Double.class, Types.DOUBLE,
			Column.FLAG_DEFAULT);
	public final Column<CdsDemandTable, Date> expectedDelivery = createColumn(
		"expectedDelivery", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<CdsDemandTable, Date> acceptedDelivery = createColumn(
		"acceptedDelivery", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<CdsDemandTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<CdsDemandTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<CdsDemandTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<CdsDemandTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CdsDemandTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<CdsDemandTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<CdsDemandTable, String> urlTitle = createColumn(
		"urlTitle", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CdsDemandTable, String> state = createColumn(
		"state_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CdsDemandTable, Long> stateByUserId = createColumn(
		"stateByUserId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<CdsDemandTable, String> stateByUserName = createColumn(
		"stateByUserName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CdsDemandTable, Date> stateDate = createColumn(
		"stateDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);

	private CdsDemandTable() {
		super("CdsDemands_CdsDemand", CdsDemandTable::new);
	}

}