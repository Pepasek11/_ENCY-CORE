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

package cz.csob.ency.delegations.model.impl;

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

import cz.csob.ency.delegations.model.Delegation;
import cz.csob.ency.delegations.model.DelegationModel;

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
 * The base model implementation for the Delegation service. Represents a row in the &quot;delegations_delegation&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>DelegationModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link DelegationImpl}.
 * </p>
 *
 * @author Miroslav Čermák
 * @see DelegationImpl
 * @generated
 */
@JSON(strict = true)
public class DelegationModelImpl
	extends BaseModelImpl<Delegation> implements DelegationModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a delegation model instance should use the <code>Delegation</code> interface instead.
	 */
	public static final String TABLE_NAME = "delegations_delegation";

	public static final Object[][] TABLE_COLUMNS = {
		{"mvccVersion", Types.BIGINT}, {"delegationId", Types.BIGINT},
		{"roleId", Types.BIGINT}, {"delegatingUserId", Types.BIGINT},
		{"delegatedUserId", Types.BIGINT}, {"groupId", Types.BIGINT},
		{"note", Types.VARCHAR}, {"companyId", Types.BIGINT},
		{"userId", Types.BIGINT}, {"userName", Types.VARCHAR},
		{"createDate", Types.TIMESTAMP}, {"modifiedDate", Types.TIMESTAMP}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("mvccVersion", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("delegationId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("roleId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("delegatingUserId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("delegatedUserId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("note", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
	}

	public static final String TABLE_SQL_CREATE =
		"create table delegations_delegation (mvccVersion LONG default 0 not null,delegationId LONG not null primary key,roleId LONG,delegatingUserId LONG,delegatedUserId LONG,groupId LONG,note VARCHAR(1024) null,companyId LONG,userId LONG,userName VARCHAR(256) null,createDate DATE null,modifiedDate DATE null)";

	public static final String TABLE_SQL_DROP =
		"drop table delegations_delegation";

	public static final String ORDER_BY_JPQL =
		" ORDER BY delegation.delegationId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY delegations_delegation.delegationId ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long DELEGATEDUSERID_COLUMN_BITMASK = 1L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long DELEGATINGUSERID_COLUMN_BITMASK = 2L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long DELEGATIONID_COLUMN_BITMASK = 4L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long GROUPID_COLUMN_BITMASK = 8L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long ROLEID_COLUMN_BITMASK = 16L;

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

	public DelegationModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _delegationId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setDelegationId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _delegationId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return Delegation.class;
	}

	@Override
	public String getModelClassName() {
		return Delegation.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<Delegation, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<Delegation, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Delegation, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName, attributeGetterFunction.apply((Delegation)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<Delegation, Object>> attributeSetterBiConsumers =
			getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<Delegation, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(Delegation)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<Delegation, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<Delegation, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static final Map<String, Function<Delegation, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<Delegation, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<Delegation, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<Delegation, Object>>();
		Map<String, BiConsumer<Delegation, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<Delegation, ?>>();

		attributeGetterFunctions.put("mvccVersion", Delegation::getMvccVersion);
		attributeSetterBiConsumers.put(
			"mvccVersion",
			(BiConsumer<Delegation, Long>)Delegation::setMvccVersion);
		attributeGetterFunctions.put(
			"delegationId", Delegation::getDelegationId);
		attributeSetterBiConsumers.put(
			"delegationId",
			(BiConsumer<Delegation, Long>)Delegation::setDelegationId);
		attributeGetterFunctions.put("roleId", Delegation::getRoleId);
		attributeSetterBiConsumers.put(
			"roleId", (BiConsumer<Delegation, Long>)Delegation::setRoleId);
		attributeGetterFunctions.put(
			"delegatingUserId", Delegation::getDelegatingUserId);
		attributeSetterBiConsumers.put(
			"delegatingUserId",
			(BiConsumer<Delegation, Long>)Delegation::setDelegatingUserId);
		attributeGetterFunctions.put(
			"delegatedUserId", Delegation::getDelegatedUserId);
		attributeSetterBiConsumers.put(
			"delegatedUserId",
			(BiConsumer<Delegation, Long>)Delegation::setDelegatedUserId);
		attributeGetterFunctions.put("groupId", Delegation::getGroupId);
		attributeSetterBiConsumers.put(
			"groupId", (BiConsumer<Delegation, Long>)Delegation::setGroupId);
		attributeGetterFunctions.put("note", Delegation::getNote);
		attributeSetterBiConsumers.put(
			"note", (BiConsumer<Delegation, String>)Delegation::setNote);
		attributeGetterFunctions.put("companyId", Delegation::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId",
			(BiConsumer<Delegation, Long>)Delegation::setCompanyId);
		attributeGetterFunctions.put("userId", Delegation::getUserId);
		attributeSetterBiConsumers.put(
			"userId", (BiConsumer<Delegation, Long>)Delegation::setUserId);
		attributeGetterFunctions.put("userName", Delegation::getUserName);
		attributeSetterBiConsumers.put(
			"userName",
			(BiConsumer<Delegation, String>)Delegation::setUserName);
		attributeGetterFunctions.put("createDate", Delegation::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate",
			(BiConsumer<Delegation, Date>)Delegation::setCreateDate);
		attributeGetterFunctions.put(
			"modifiedDate", Delegation::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate",
			(BiConsumer<Delegation, Date>)Delegation::setModifiedDate);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public long getMvccVersion() {
		return _mvccVersion;
	}

	@Override
	public void setMvccVersion(long mvccVersion) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_mvccVersion = mvccVersion;
	}

	@JSON
	@Override
	public long getDelegationId() {
		return _delegationId;
	}

	@Override
	public void setDelegationId(long delegationId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_delegationId = delegationId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalDelegationId() {
		return GetterUtil.getLong(
			this.<Long>getColumnOriginalValue("delegationId"));
	}

	@JSON
	@Override
	public long getRoleId() {
		return _roleId;
	}

	@Override
	public void setRoleId(long roleId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_roleId = roleId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalRoleId() {
		return GetterUtil.getLong(this.<Long>getColumnOriginalValue("roleId"));
	}

	@JSON
	@Override
	public long getDelegatingUserId() {
		return _delegatingUserId;
	}

	@Override
	public void setDelegatingUserId(long delegatingUserId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_delegatingUserId = delegatingUserId;
	}

	@Override
	public String getDelegatingUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getDelegatingUserId());

			return user.getUuid();
		}
		catch (PortalException portalException) {
			return "";
		}
	}

	@Override
	public void setDelegatingUserUuid(String delegatingUserUuid) {
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalDelegatingUserId() {
		return GetterUtil.getLong(
			this.<Long>getColumnOriginalValue("delegatingUserId"));
	}

	@JSON
	@Override
	public long getDelegatedUserId() {
		return _delegatedUserId;
	}

	@Override
	public void setDelegatedUserId(long delegatedUserId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_delegatedUserId = delegatedUserId;
	}

	@Override
	public String getDelegatedUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getDelegatedUserId());

			return user.getUuid();
		}
		catch (PortalException portalException) {
			return "";
		}
	}

	@Override
	public void setDelegatedUserUuid(String delegatedUserUuid) {
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalDelegatedUserId() {
		return GetterUtil.getLong(
			this.<Long>getColumnOriginalValue("delegatedUserId"));
	}

	@JSON
	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_groupId = groupId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalGroupId() {
		return GetterUtil.getLong(this.<Long>getColumnOriginalValue("groupId"));
	}

	@JSON
	@Override
	public String getNote() {
		if (_note == null) {
			return "";
		}
		else {
			return _note;
		}
	}

	@Override
	public void setNote(String note) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_note = note;
	}

	@JSON
	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_companyId = companyId;
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
			getCompanyId(), Delegation.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Delegation toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, Delegation>
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
		DelegationImpl delegationImpl = new DelegationImpl();

		delegationImpl.setMvccVersion(getMvccVersion());
		delegationImpl.setDelegationId(getDelegationId());
		delegationImpl.setRoleId(getRoleId());
		delegationImpl.setDelegatingUserId(getDelegatingUserId());
		delegationImpl.setDelegatedUserId(getDelegatedUserId());
		delegationImpl.setGroupId(getGroupId());
		delegationImpl.setNote(getNote());
		delegationImpl.setCompanyId(getCompanyId());
		delegationImpl.setUserId(getUserId());
		delegationImpl.setUserName(getUserName());
		delegationImpl.setCreateDate(getCreateDate());
		delegationImpl.setModifiedDate(getModifiedDate());

		delegationImpl.resetOriginalValues();

		return delegationImpl;
	}

	@Override
	public Delegation cloneWithOriginalValues() {
		DelegationImpl delegationImpl = new DelegationImpl();

		delegationImpl.setMvccVersion(
			this.<Long>getColumnOriginalValue("mvccVersion"));
		delegationImpl.setDelegationId(
			this.<Long>getColumnOriginalValue("delegationId"));
		delegationImpl.setRoleId(this.<Long>getColumnOriginalValue("roleId"));
		delegationImpl.setDelegatingUserId(
			this.<Long>getColumnOriginalValue("delegatingUserId"));
		delegationImpl.setDelegatedUserId(
			this.<Long>getColumnOriginalValue("delegatedUserId"));
		delegationImpl.setGroupId(this.<Long>getColumnOriginalValue("groupId"));
		delegationImpl.setNote(this.<String>getColumnOriginalValue("note"));
		delegationImpl.setCompanyId(
			this.<Long>getColumnOriginalValue("companyId"));
		delegationImpl.setUserId(this.<Long>getColumnOriginalValue("userId"));
		delegationImpl.setUserName(
			this.<String>getColumnOriginalValue("userName"));
		delegationImpl.setCreateDate(
			this.<Date>getColumnOriginalValue("createDate"));
		delegationImpl.setModifiedDate(
			this.<Date>getColumnOriginalValue("modifiedDate"));

		return delegationImpl;
	}

	@Override
	public int compareTo(Delegation delegation) {
		long primaryKey = delegation.getPrimaryKey();

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

		if (!(object instanceof Delegation)) {
			return false;
		}

		Delegation delegation = (Delegation)object;

		long primaryKey = delegation.getPrimaryKey();

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
	public CacheModel<Delegation> toCacheModel() {
		DelegationCacheModel delegationCacheModel = new DelegationCacheModel();

		delegationCacheModel.mvccVersion = getMvccVersion();

		delegationCacheModel.delegationId = getDelegationId();

		delegationCacheModel.roleId = getRoleId();

		delegationCacheModel.delegatingUserId = getDelegatingUserId();

		delegationCacheModel.delegatedUserId = getDelegatedUserId();

		delegationCacheModel.groupId = getGroupId();

		delegationCacheModel.note = getNote();

		String note = delegationCacheModel.note;

		if ((note != null) && (note.length() == 0)) {
			delegationCacheModel.note = null;
		}

		delegationCacheModel.companyId = getCompanyId();

		delegationCacheModel.userId = getUserId();

		delegationCacheModel.userName = getUserName();

		String userName = delegationCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			delegationCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			delegationCacheModel.createDate = createDate.getTime();
		}
		else {
			delegationCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			delegationCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			delegationCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		return delegationCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<Delegation, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<Delegation, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Delegation, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("\"");
			sb.append(attributeName);
			sb.append("\": ");

			Object value = attributeGetterFunction.apply((Delegation)this);

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
		Map<String, Function<Delegation, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<Delegation, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Delegation, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((Delegation)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, Delegation>
			_escapedModelProxyProviderFunction =
				ProxyUtil.getProxyProviderFunction(
					Delegation.class, ModelWrapper.class);

	}

	private long _mvccVersion;
	private long _delegationId;
	private long _roleId;
	private long _delegatingUserId;
	private long _delegatedUserId;
	private long _groupId;
	private String _note;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;

	public <T> T getColumnValue(String columnName) {
		Function<Delegation, Object> function = _attributeGetterFunctions.get(
			columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((Delegation)this);
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

		_columnOriginalValues.put("mvccVersion", _mvccVersion);
		_columnOriginalValues.put("delegationId", _delegationId);
		_columnOriginalValues.put("roleId", _roleId);
		_columnOriginalValues.put("delegatingUserId", _delegatingUserId);
		_columnOriginalValues.put("delegatedUserId", _delegatedUserId);
		_columnOriginalValues.put("groupId", _groupId);
		_columnOriginalValues.put("note", _note);
		_columnOriginalValues.put("companyId", _companyId);
		_columnOriginalValues.put("userId", _userId);
		_columnOriginalValues.put("userName", _userName);
		_columnOriginalValues.put("createDate", _createDate);
		_columnOriginalValues.put("modifiedDate", _modifiedDate);
	}

	private transient Map<String, Object> _columnOriginalValues;

	public static long getColumnBitmask(String columnName) {
		return _columnBitmasks.get(columnName);
	}

	private static final Map<String, Long> _columnBitmasks;

	static {
		Map<String, Long> columnBitmasks = new HashMap<>();

		columnBitmasks.put("mvccVersion", 1L);

		columnBitmasks.put("delegationId", 2L);

		columnBitmasks.put("roleId", 4L);

		columnBitmasks.put("delegatingUserId", 8L);

		columnBitmasks.put("delegatedUserId", 16L);

		columnBitmasks.put("groupId", 32L);

		columnBitmasks.put("note", 64L);

		columnBitmasks.put("companyId", 128L);

		columnBitmasks.put("userId", 256L);

		columnBitmasks.put("userName", 512L);

		columnBitmasks.put("createDate", 1024L);

		columnBitmasks.put("modifiedDate", 2048L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private Delegation _escapedModel;

}