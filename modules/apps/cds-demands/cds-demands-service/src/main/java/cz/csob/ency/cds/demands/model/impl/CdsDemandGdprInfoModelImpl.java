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

package cz.csob.ency.cds.demands.model.impl;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringUtil;

import cz.csob.ency.cds.demands.model.CdsDemandGdprInfo;
import cz.csob.ency.cds.demands.model.CdsDemandGdprInfoModel;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.sql.Blob;
import java.sql.Types;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the CdsDemandGdprInfo service. Represents a row in the &quot;CdsDemands_CdsDemandGdprInfo&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>CdsDemandGdprInfoModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link CdsDemandGdprInfoImpl}.
 * </p>
 *
 * @author Miroslav Čermák
 * @see CdsDemandGdprInfoImpl
 * @generated
 */
@JSON(strict = true)
public class CdsDemandGdprInfoModelImpl
	extends BaseModelImpl<CdsDemandGdprInfo> implements CdsDemandGdprInfoModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a cds demand gdpr info model instance should use the <code>CdsDemandGdprInfo</code> interface instead.
	 */
	public static final String TABLE_NAME = "CdsDemands_CdsDemandGdprInfo";

	public static final Object[][] TABLE_COLUMNS = {
		{"uuid_", Types.VARCHAR}, {"gdprInfoId", Types.BIGINT},
		{"demandId", Types.BIGINT}, {"title", Types.VARCHAR},
		{"description", Types.VARCHAR}, {"isEmployee", Types.BOOLEAN},
		{"employeeCategory", Types.VARCHAR},
		{"employeeReasoning", Types.VARCHAR}, {"isClient", Types.BOOLEAN},
		{"clientCategory", Types.VARCHAR}, {"clientReasoning", Types.VARCHAR},
		{"userId", Types.BIGINT}, {"userName", Types.VARCHAR},
		{"createDate", Types.TIMESTAMP}, {"modifiedDate", Types.TIMESTAMP}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("gdprInfoId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("demandId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("title", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("description", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("isEmployee", Types.BOOLEAN);
		TABLE_COLUMNS_MAP.put("employeeCategory", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("employeeReasoning", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("isClient", Types.BOOLEAN);
		TABLE_COLUMNS_MAP.put("clientCategory", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("clientReasoning", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
	}

	public static final String TABLE_SQL_CREATE =
		"create table CdsDemands_CdsDemandGdprInfo (uuid_ VARCHAR(75) null,gdprInfoId LONG not null primary key,demandId LONG,title VARCHAR(500) null,description TEXT null,isEmployee BOOLEAN,employeeCategory VARCHAR(1024) null,employeeReasoning VARCHAR(1024) null,isClient BOOLEAN,clientCategory VARCHAR(1024) null,clientReasoning VARCHAR(1024) null,userId LONG,userName VARCHAR(256) null,createDate DATE null,modifiedDate DATE null)";

	public static final String TABLE_SQL_DROP =
		"drop table CdsDemands_CdsDemandGdprInfo";

	public static final String ORDER_BY_JPQL =
		" ORDER BY cdsDemandGdprInfo.gdprInfoId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY CdsDemands_CdsDemandGdprInfo.gdprInfoId ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long DEMANDID_COLUMN_BITMASK = 1L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long UUID_COLUMN_BITMASK = 2L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *		#getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long GDPRINFOID_COLUMN_BITMASK = 4L;

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static void setEntityCacheEnabled(boolean entityCacheEnabled) {
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static void setFinderCacheEnabled(boolean finderCacheEnabled) {
	}

	public CdsDemandGdprInfoModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _gdprInfoId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setGdprInfoId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _gdprInfoId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return CdsDemandGdprInfo.class;
	}

	@Override
	public String getModelClassName() {
		return CdsDemandGdprInfo.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<CdsDemandGdprInfo, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		for (Map.Entry<String, Function<CdsDemandGdprInfo, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<CdsDemandGdprInfo, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((CdsDemandGdprInfo)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<CdsDemandGdprInfo, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<CdsDemandGdprInfo, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(CdsDemandGdprInfo)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<CdsDemandGdprInfo, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<CdsDemandGdprInfo, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static final Map<String, Function<CdsDemandGdprInfo, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<CdsDemandGdprInfo, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<CdsDemandGdprInfo, Object>>
			attributeGetterFunctions =
				new LinkedHashMap
					<String, Function<CdsDemandGdprInfo, Object>>();
		Map<String, BiConsumer<CdsDemandGdprInfo, ?>>
			attributeSetterBiConsumers =
				new LinkedHashMap<String, BiConsumer<CdsDemandGdprInfo, ?>>();

		attributeGetterFunctions.put("uuid", CdsDemandGdprInfo::getUuid);
		attributeSetterBiConsumers.put(
			"uuid",
			(BiConsumer<CdsDemandGdprInfo, String>)CdsDemandGdprInfo::setUuid);
		attributeGetterFunctions.put(
			"gdprInfoId", CdsDemandGdprInfo::getGdprInfoId);
		attributeSetterBiConsumers.put(
			"gdprInfoId",
			(BiConsumer<CdsDemandGdprInfo, Long>)
				CdsDemandGdprInfo::setGdprInfoId);
		attributeGetterFunctions.put(
			"demandId", CdsDemandGdprInfo::getDemandId);
		attributeSetterBiConsumers.put(
			"demandId",
			(BiConsumer<CdsDemandGdprInfo, Long>)
				CdsDemandGdprInfo::setDemandId);
		attributeGetterFunctions.put("title", CdsDemandGdprInfo::getTitle);
		attributeSetterBiConsumers.put(
			"title",
			(BiConsumer<CdsDemandGdprInfo, String>)CdsDemandGdprInfo::setTitle);
		attributeGetterFunctions.put(
			"description", CdsDemandGdprInfo::getDescription);
		attributeSetterBiConsumers.put(
			"description",
			(BiConsumer<CdsDemandGdprInfo, String>)
				CdsDemandGdprInfo::setDescription);
		attributeGetterFunctions.put(
			"isEmployee", CdsDemandGdprInfo::getIsEmployee);
		attributeSetterBiConsumers.put(
			"isEmployee",
			(BiConsumer<CdsDemandGdprInfo, Boolean>)
				CdsDemandGdprInfo::setIsEmployee);
		attributeGetterFunctions.put(
			"employeeCategory", CdsDemandGdprInfo::getEmployeeCategory);
		attributeSetterBiConsumers.put(
			"employeeCategory",
			(BiConsumer<CdsDemandGdprInfo, String>)
				CdsDemandGdprInfo::setEmployeeCategory);
		attributeGetterFunctions.put(
			"employeeReasoning", CdsDemandGdprInfo::getEmployeeReasoning);
		attributeSetterBiConsumers.put(
			"employeeReasoning",
			(BiConsumer<CdsDemandGdprInfo, String>)
				CdsDemandGdprInfo::setEmployeeReasoning);
		attributeGetterFunctions.put(
			"isClient", CdsDemandGdprInfo::getIsClient);
		attributeSetterBiConsumers.put(
			"isClient",
			(BiConsumer<CdsDemandGdprInfo, Boolean>)
				CdsDemandGdprInfo::setIsClient);
		attributeGetterFunctions.put(
			"clientCategory", CdsDemandGdprInfo::getClientCategory);
		attributeSetterBiConsumers.put(
			"clientCategory",
			(BiConsumer<CdsDemandGdprInfo, String>)
				CdsDemandGdprInfo::setClientCategory);
		attributeGetterFunctions.put(
			"clientReasoning", CdsDemandGdprInfo::getClientReasoning);
		attributeSetterBiConsumers.put(
			"clientReasoning",
			(BiConsumer<CdsDemandGdprInfo, String>)
				CdsDemandGdprInfo::setClientReasoning);
		attributeGetterFunctions.put("userId", CdsDemandGdprInfo::getUserId);
		attributeSetterBiConsumers.put(
			"userId",
			(BiConsumer<CdsDemandGdprInfo, Long>)CdsDemandGdprInfo::setUserId);
		attributeGetterFunctions.put(
			"userName", CdsDemandGdprInfo::getUserName);
		attributeSetterBiConsumers.put(
			"userName",
			(BiConsumer<CdsDemandGdprInfo, String>)
				CdsDemandGdprInfo::setUserName);
		attributeGetterFunctions.put(
			"createDate", CdsDemandGdprInfo::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate",
			(BiConsumer<CdsDemandGdprInfo, Date>)
				CdsDemandGdprInfo::setCreateDate);
		attributeGetterFunctions.put(
			"modifiedDate", CdsDemandGdprInfo::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate",
			(BiConsumer<CdsDemandGdprInfo, Date>)
				CdsDemandGdprInfo::setModifiedDate);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public String getUuid() {
		if (_uuid == null) {
			return "";
		}
		else {
			return _uuid;
		}
	}

	@Override
	public void setUuid(String uuid) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_uuid = uuid;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalUuid() {
		return getColumnOriginalValue("uuid_");
	}

	@JSON
	@Override
	public long getGdprInfoId() {
		return _gdprInfoId;
	}

	@Override
	public void setGdprInfoId(long gdprInfoId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_gdprInfoId = gdprInfoId;
	}

	@JSON
	@Override
	public long getDemandId() {
		return _demandId;
	}

	@Override
	public void setDemandId(long demandId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_demandId = demandId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalDemandId() {
		return GetterUtil.getLong(
			this.<Long>getColumnOriginalValue("demandId"));
	}

	@JSON
	@Override
	public String getTitle() {
		if (_title == null) {
			return "";
		}
		else {
			return _title;
		}
	}

	@Override
	public void setTitle(String title) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_title = title;
	}

	@JSON
	@Override
	public String getDescription() {
		if (_description == null) {
			return "";
		}
		else {
			return _description;
		}
	}

	@Override
	public void setDescription(String description) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_description = description;
	}

	@JSON
	@Override
	public boolean getIsEmployee() {
		return _isEmployee;
	}

	@JSON
	@Override
	public boolean isIsEmployee() {
		return _isEmployee;
	}

	@Override
	public void setIsEmployee(boolean isEmployee) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_isEmployee = isEmployee;
	}

	@JSON
	@Override
	public String getEmployeeCategory() {
		if (_employeeCategory == null) {
			return "";
		}
		else {
			return _employeeCategory;
		}
	}

	@Override
	public void setEmployeeCategory(String employeeCategory) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_employeeCategory = employeeCategory;
	}

	@JSON
	@Override
	public String getEmployeeReasoning() {
		if (_employeeReasoning == null) {
			return "";
		}
		else {
			return _employeeReasoning;
		}
	}

	@Override
	public void setEmployeeReasoning(String employeeReasoning) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_employeeReasoning = employeeReasoning;
	}

	@JSON
	@Override
	public boolean getIsClient() {
		return _isClient;
	}

	@JSON
	@Override
	public boolean isIsClient() {
		return _isClient;
	}

	@Override
	public void setIsClient(boolean isClient) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_isClient = isClient;
	}

	@JSON
	@Override
	public String getClientCategory() {
		if (_clientCategory == null) {
			return "";
		}
		else {
			return _clientCategory;
		}
	}

	@Override
	public void setClientCategory(String clientCategory) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_clientCategory = clientCategory;
	}

	@JSON
	@Override
	public String getClientReasoning() {
		if (_clientReasoning == null) {
			return "";
		}
		else {
			return _clientReasoning;
		}
	}

	@Override
	public void setClientReasoning(String clientReasoning) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_clientReasoning = clientReasoning;
	}

	@JSON
	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_userId = userId;
	}

	@Override
	public String getUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getUserId());

			return user.getUuid();
		}
		catch (PortalException portalException) {
			return "";
		}
	}

	@Override
	public void setUserUuid(String userUuid) {
	}

	@JSON
	@Override
	public String getUserName() {
		if (_userName == null) {
			return "";
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_userName = userName;
	}

	@JSON
	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_createDate = createDate;
	}

	@JSON
	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public boolean hasSetModifiedDate() {
		return _setModifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_setModifiedDate = true;

		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_modifiedDate = modifiedDate;
	}

	public long getColumnBitmask() {
		if (_columnBitmask > 0) {
			return _columnBitmask;
		}

		if ((_columnOriginalValues == null) ||
			(_columnOriginalValues == Collections.EMPTY_MAP)) {

			return 0;
		}

		for (Map.Entry<String, Object> entry :
				_columnOriginalValues.entrySet()) {

			if (!Objects.equals(
					entry.getValue(), getColumnValue(entry.getKey()))) {

				_columnBitmask |= _columnBitmasks.get(entry.getKey());
			}
		}

		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			0, CdsDemandGdprInfo.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public CdsDemandGdprInfo toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, CdsDemandGdprInfo>
				escapedModelProxyProviderFunction =
					EscapedModelProxyProviderFunctionHolder.
						_escapedModelProxyProviderFunction;

			_escapedModel = escapedModelProxyProviderFunction.apply(
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		CdsDemandGdprInfoImpl cdsDemandGdprInfoImpl =
			new CdsDemandGdprInfoImpl();

		cdsDemandGdprInfoImpl.setUuid(getUuid());
		cdsDemandGdprInfoImpl.setGdprInfoId(getGdprInfoId());
		cdsDemandGdprInfoImpl.setDemandId(getDemandId());
		cdsDemandGdprInfoImpl.setTitle(getTitle());
		cdsDemandGdprInfoImpl.setDescription(getDescription());
		cdsDemandGdprInfoImpl.setIsEmployee(isIsEmployee());
		cdsDemandGdprInfoImpl.setEmployeeCategory(getEmployeeCategory());
		cdsDemandGdprInfoImpl.setEmployeeReasoning(getEmployeeReasoning());
		cdsDemandGdprInfoImpl.setIsClient(isIsClient());
		cdsDemandGdprInfoImpl.setClientCategory(getClientCategory());
		cdsDemandGdprInfoImpl.setClientReasoning(getClientReasoning());
		cdsDemandGdprInfoImpl.setUserId(getUserId());
		cdsDemandGdprInfoImpl.setUserName(getUserName());
		cdsDemandGdprInfoImpl.setCreateDate(getCreateDate());
		cdsDemandGdprInfoImpl.setModifiedDate(getModifiedDate());

		cdsDemandGdprInfoImpl.resetOriginalValues();

		return cdsDemandGdprInfoImpl;
	}

	@Override
	public CdsDemandGdprInfo cloneWithOriginalValues() {
		CdsDemandGdprInfoImpl cdsDemandGdprInfoImpl =
			new CdsDemandGdprInfoImpl();

		cdsDemandGdprInfoImpl.setUuid(
			this.<String>getColumnOriginalValue("uuid_"));
		cdsDemandGdprInfoImpl.setGdprInfoId(
			this.<Long>getColumnOriginalValue("gdprInfoId"));
		cdsDemandGdprInfoImpl.setDemandId(
			this.<Long>getColumnOriginalValue("demandId"));
		cdsDemandGdprInfoImpl.setTitle(
			this.<String>getColumnOriginalValue("title"));
		cdsDemandGdprInfoImpl.setDescription(
			this.<String>getColumnOriginalValue("description"));
		cdsDemandGdprInfoImpl.setIsEmployee(
			this.<Boolean>getColumnOriginalValue("isEmployee"));
		cdsDemandGdprInfoImpl.setEmployeeCategory(
			this.<String>getColumnOriginalValue("employeeCategory"));
		cdsDemandGdprInfoImpl.setEmployeeReasoning(
			this.<String>getColumnOriginalValue("employeeReasoning"));
		cdsDemandGdprInfoImpl.setIsClient(
			this.<Boolean>getColumnOriginalValue("isClient"));
		cdsDemandGdprInfoImpl.setClientCategory(
			this.<String>getColumnOriginalValue("clientCategory"));
		cdsDemandGdprInfoImpl.setClientReasoning(
			this.<String>getColumnOriginalValue("clientReasoning"));
		cdsDemandGdprInfoImpl.setUserId(
			this.<Long>getColumnOriginalValue("userId"));
		cdsDemandGdprInfoImpl.setUserName(
			this.<String>getColumnOriginalValue("userName"));
		cdsDemandGdprInfoImpl.setCreateDate(
			this.<Date>getColumnOriginalValue("createDate"));
		cdsDemandGdprInfoImpl.setModifiedDate(
			this.<Date>getColumnOriginalValue("modifiedDate"));

		return cdsDemandGdprInfoImpl;
	}

	@Override
	public int compareTo(CdsDemandGdprInfo cdsDemandGdprInfo) {
		long primaryKey = cdsDemandGdprInfo.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof CdsDemandGdprInfo)) {
			return false;
		}

		CdsDemandGdprInfo cdsDemandGdprInfo = (CdsDemandGdprInfo)object;

		long primaryKey = cdsDemandGdprInfo.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isEntityCacheEnabled() {
		return true;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isFinderCacheEnabled() {
		return true;
	}

	@Override
	public void resetOriginalValues() {
		_columnOriginalValues = Collections.emptyMap();

		_setModifiedDate = false;

		_columnBitmask = 0;
	}

	@Override
	public CacheModel<CdsDemandGdprInfo> toCacheModel() {
		CdsDemandGdprInfoCacheModel cdsDemandGdprInfoCacheModel =
			new CdsDemandGdprInfoCacheModel();

		cdsDemandGdprInfoCacheModel.uuid = getUuid();

		String uuid = cdsDemandGdprInfoCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			cdsDemandGdprInfoCacheModel.uuid = null;
		}

		cdsDemandGdprInfoCacheModel.gdprInfoId = getGdprInfoId();

		cdsDemandGdprInfoCacheModel.demandId = getDemandId();

		cdsDemandGdprInfoCacheModel.title = getTitle();

		String title = cdsDemandGdprInfoCacheModel.title;

		if ((title != null) && (title.length() == 0)) {
			cdsDemandGdprInfoCacheModel.title = null;
		}

		cdsDemandGdprInfoCacheModel.description = getDescription();

		String description = cdsDemandGdprInfoCacheModel.description;

		if ((description != null) && (description.length() == 0)) {
			cdsDemandGdprInfoCacheModel.description = null;
		}

		cdsDemandGdprInfoCacheModel.isEmployee = isIsEmployee();

		cdsDemandGdprInfoCacheModel.employeeCategory = getEmployeeCategory();

		String employeeCategory = cdsDemandGdprInfoCacheModel.employeeCategory;

		if ((employeeCategory != null) && (employeeCategory.length() == 0)) {
			cdsDemandGdprInfoCacheModel.employeeCategory = null;
		}

		cdsDemandGdprInfoCacheModel.employeeReasoning = getEmployeeReasoning();

		String employeeReasoning =
			cdsDemandGdprInfoCacheModel.employeeReasoning;

		if ((employeeReasoning != null) && (employeeReasoning.length() == 0)) {
			cdsDemandGdprInfoCacheModel.employeeReasoning = null;
		}

		cdsDemandGdprInfoCacheModel.isClient = isIsClient();

		cdsDemandGdprInfoCacheModel.clientCategory = getClientCategory();

		String clientCategory = cdsDemandGdprInfoCacheModel.clientCategory;

		if ((clientCategory != null) && (clientCategory.length() == 0)) {
			cdsDemandGdprInfoCacheModel.clientCategory = null;
		}

		cdsDemandGdprInfoCacheModel.clientReasoning = getClientReasoning();

		String clientReasoning = cdsDemandGdprInfoCacheModel.clientReasoning;

		if ((clientReasoning != null) && (clientReasoning.length() == 0)) {
			cdsDemandGdprInfoCacheModel.clientReasoning = null;
		}

		cdsDemandGdprInfoCacheModel.userId = getUserId();

		cdsDemandGdprInfoCacheModel.userName = getUserName();

		String userName = cdsDemandGdprInfoCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			cdsDemandGdprInfoCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			cdsDemandGdprInfoCacheModel.createDate = createDate.getTime();
		}
		else {
			cdsDemandGdprInfoCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			cdsDemandGdprInfoCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			cdsDemandGdprInfoCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		return cdsDemandGdprInfoCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<CdsDemandGdprInfo, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<CdsDemandGdprInfo, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<CdsDemandGdprInfo, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("\"");
			sb.append(attributeName);
			sb.append("\": ");

			Object value = attributeGetterFunction.apply(
				(CdsDemandGdprInfo)this);

			if (value == null) {
				sb.append("null");
			}
			else if (value instanceof Blob || value instanceof Date ||
					 value instanceof Map || value instanceof String) {

				sb.append(
					"\"" + StringUtil.replace(value.toString(), "\"", "'") +
						"\"");
			}
			else {
				sb.append(value);
			}

			sb.append(", ");
		}

		if (sb.index() > 1) {
			sb.setIndex(sb.index() - 1);
		}

		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		Map<String, Function<CdsDemandGdprInfo, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<CdsDemandGdprInfo, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<CdsDemandGdprInfo, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((CdsDemandGdprInfo)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, CdsDemandGdprInfo>
			_escapedModelProxyProviderFunction =
				ProxyUtil.getProxyProviderFunction(
					CdsDemandGdprInfo.class, ModelWrapper.class);

	}

	private String _uuid;
	private long _gdprInfoId;
	private long _demandId;
	private String _title;
	private String _description;
	private boolean _isEmployee;
	private String _employeeCategory;
	private String _employeeReasoning;
	private boolean _isClient;
	private String _clientCategory;
	private String _clientReasoning;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;

	public <T> T getColumnValue(String columnName) {
		columnName = _attributeNames.getOrDefault(columnName, columnName);

		Function<CdsDemandGdprInfo, Object> function =
			_attributeGetterFunctions.get(columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((CdsDemandGdprInfo)this);
	}

	public <T> T getColumnOriginalValue(String columnName) {
		if (_columnOriginalValues == null) {
			return null;
		}

		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		return (T)_columnOriginalValues.get(columnName);
	}

	private void _setColumnOriginalValues() {
		_columnOriginalValues = new HashMap<String, Object>();

		_columnOriginalValues.put("uuid_", _uuid);
		_columnOriginalValues.put("gdprInfoId", _gdprInfoId);
		_columnOriginalValues.put("demandId", _demandId);
		_columnOriginalValues.put("title", _title);
		_columnOriginalValues.put("description", _description);
		_columnOriginalValues.put("isEmployee", _isEmployee);
		_columnOriginalValues.put("employeeCategory", _employeeCategory);
		_columnOriginalValues.put("employeeReasoning", _employeeReasoning);
		_columnOriginalValues.put("isClient", _isClient);
		_columnOriginalValues.put("clientCategory", _clientCategory);
		_columnOriginalValues.put("clientReasoning", _clientReasoning);
		_columnOriginalValues.put("userId", _userId);
		_columnOriginalValues.put("userName", _userName);
		_columnOriginalValues.put("createDate", _createDate);
		_columnOriginalValues.put("modifiedDate", _modifiedDate);
	}

	private static final Map<String, String> _attributeNames;

	static {
		Map<String, String> attributeNames = new HashMap<>();

		attributeNames.put("uuid_", "uuid");

		_attributeNames = Collections.unmodifiableMap(attributeNames);
	}

	private transient Map<String, Object> _columnOriginalValues;

	public static long getColumnBitmask(String columnName) {
		return _columnBitmasks.get(columnName);
	}

	private static final Map<String, Long> _columnBitmasks;

	static {
		Map<String, Long> columnBitmasks = new HashMap<>();

		columnBitmasks.put("uuid_", 1L);

		columnBitmasks.put("gdprInfoId", 2L);

		columnBitmasks.put("demandId", 4L);

		columnBitmasks.put("title", 8L);

		columnBitmasks.put("description", 16L);

		columnBitmasks.put("isEmployee", 32L);

		columnBitmasks.put("employeeCategory", 64L);

		columnBitmasks.put("employeeReasoning", 128L);

		columnBitmasks.put("isClient", 256L);

		columnBitmasks.put("clientCategory", 512L);

		columnBitmasks.put("clientReasoning", 1024L);

		columnBitmasks.put("userId", 2048L);

		columnBitmasks.put("userName", 4096L);

		columnBitmasks.put("createDate", 8192L);

		columnBitmasks.put("modifiedDate", 16384L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private CdsDemandGdprInfo _escapedModel;

}