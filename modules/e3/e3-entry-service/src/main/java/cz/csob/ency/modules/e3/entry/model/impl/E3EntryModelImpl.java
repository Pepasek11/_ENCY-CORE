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

package cz.csob.ency.modules.e3.entry.model.impl;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.ProxyUtil;

import cz.csob.ency.modules.e3.entry.model.E3Entry;
import cz.csob.ency.modules.e3.entry.model.E3EntryModel;
import cz.csob.ency.modules.e3.entry.model.E3EntryVersion;

import java.io.Serializable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;

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
 * The base model implementation for the E3Entry service. Represents a row in the &quot;E3Entry&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>E3EntryModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link E3EntryImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see E3EntryImpl
 * @generated
 */
public class E3EntryModelImpl
	extends BaseModelImpl<E3Entry> implements E3EntryModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a e3 entry model instance should use the <code>E3Entry</code> interface instead.
	 */
	public static final String TABLE_NAME = "E3Entry";

	public static final Object[][] TABLE_COLUMNS = {
		{"mvccVersion", Types.BIGINT}, {"uuid_", Types.VARCHAR},
		{"headId", Types.BIGINT}, {"head", Types.BOOLEAN},
		{"entry_id", Types.BIGINT}, {"groupId", Types.BIGINT},
		{"companyId", Types.BIGINT}, {"entry_modifier_id", Types.BIGINT},
		{"entry_modifier_name", Types.VARCHAR},
		{"entry_created", Types.TIMESTAMP}, {"entry_modified", Types.TIMESTAMP},
		{"entry_author_id", Types.BIGINT}, {"entry_author_name", Types.VARCHAR},
		{"entry_xid", Types.VARCHAR}, {"entry_name", Types.VARCHAR},
		{"app_class", Types.VARCHAR}, {"parent_id", Types.BIGINT},
		{"parent_field", Types.VARCHAR}, {"json_values", Types.CLOB},
		{"status", Types.BIGINT}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("mvccVersion", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("headId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("head", Types.BOOLEAN);
		TABLE_COLUMNS_MAP.put("entry_id", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("entry_modifier_id", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("entry_modifier_name", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("entry_created", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("entry_modified", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("entry_author_id", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("entry_author_name", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("entry_xid", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("entry_name", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("app_class", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("parent_id", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("parent_field", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("json_values", Types.CLOB);
		TABLE_COLUMNS_MAP.put("status", Types.BIGINT);
	}

	public static final String TABLE_SQL_CREATE =
		"create table E3Entry (mvccVersion LONG default 0 not null,uuid_ VARCHAR(75) null,headId LONG,head BOOLEAN,entry_id LONG not null primary key,groupId LONG,companyId LONG,entry_modifier_id LONG,entry_modifier_name VARCHAR(256) null,entry_created DATE null,entry_modified DATE null,entry_author_id LONG,entry_author_name VARCHAR(256) null,entry_xid VARCHAR(256) null,entry_name VARCHAR(256) null,app_class VARCHAR(512) null,parent_id LONG,parent_field VARCHAR(128) null,json_values TEXT null,status LONG)";

	public static final String TABLE_SQL_DROP = "drop table E3Entry";

	public static final String ORDER_BY_JPQL = " ORDER BY e3Entry.name ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY E3Entry.entry_name ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long COMPANYID_COLUMN_BITMASK = 1L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long GROUPID_COLUMN_BITMASK = 2L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long HEAD_COLUMN_BITMASK = 4L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long HEADID_COLUMN_BITMASK = 8L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long PARENTFIELD_COLUMN_BITMASK = 16L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long PARENTID_COLUMN_BITMASK = 32L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long STATUS_COLUMN_BITMASK = 64L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long UUID_COLUMN_BITMASK = 128L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long XID_COLUMN_BITMASK = 256L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *		#getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long NAME_COLUMN_BITMASK = 512L;

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

	public E3EntryModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _entryId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setEntryId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _entryId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return E3Entry.class;
	}

	@Override
	public String getModelClassName() {
		return E3Entry.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<E3Entry, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<E3Entry, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<E3Entry, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName, attributeGetterFunction.apply((E3Entry)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<E3Entry, Object>> attributeSetterBiConsumers =
			getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<E3Entry, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(E3Entry)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<E3Entry, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<E3Entry, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, E3Entry>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			E3Entry.class.getClassLoader(), E3Entry.class, ModelWrapper.class);

		try {
			Constructor<E3Entry> constructor =
				(Constructor<E3Entry>)proxyClass.getConstructor(
					InvocationHandler.class);

			return invocationHandler -> {
				try {
					return constructor.newInstance(invocationHandler);
				}
				catch (ReflectiveOperationException
							reflectiveOperationException) {

					throw new InternalError(reflectiveOperationException);
				}
			};
		}
		catch (NoSuchMethodException noSuchMethodException) {
			throw new InternalError(noSuchMethodException);
		}
	}

	private static final Map<String, Function<E3Entry, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<E3Entry, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<E3Entry, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<E3Entry, Object>>();
		Map<String, BiConsumer<E3Entry, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<E3Entry, ?>>();

		attributeGetterFunctions.put("mvccVersion", E3Entry::getMvccVersion);
		attributeSetterBiConsumers.put(
			"mvccVersion", (BiConsumer<E3Entry, Long>)E3Entry::setMvccVersion);
		attributeGetterFunctions.put("uuid", E3Entry::getUuid);
		attributeSetterBiConsumers.put(
			"uuid", (BiConsumer<E3Entry, String>)E3Entry::setUuid);
		attributeGetterFunctions.put("headId", E3Entry::getHeadId);
		attributeSetterBiConsumers.put(
			"headId", (BiConsumer<E3Entry, Long>)E3Entry::setHeadId);
		attributeGetterFunctions.put("entryId", E3Entry::getEntryId);
		attributeSetterBiConsumers.put(
			"entryId", (BiConsumer<E3Entry, Long>)E3Entry::setEntryId);
		attributeGetterFunctions.put("groupId", E3Entry::getGroupId);
		attributeSetterBiConsumers.put(
			"groupId", (BiConsumer<E3Entry, Long>)E3Entry::setGroupId);
		attributeGetterFunctions.put("companyId", E3Entry::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId", (BiConsumer<E3Entry, Long>)E3Entry::setCompanyId);
		attributeGetterFunctions.put("userId", E3Entry::getUserId);
		attributeSetterBiConsumers.put(
			"userId", (BiConsumer<E3Entry, Long>)E3Entry::setUserId);
		attributeGetterFunctions.put("userName", E3Entry::getUserName);
		attributeSetterBiConsumers.put(
			"userName", (BiConsumer<E3Entry, String>)E3Entry::setUserName);
		attributeGetterFunctions.put("createDate", E3Entry::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate", (BiConsumer<E3Entry, Date>)E3Entry::setCreateDate);
		attributeGetterFunctions.put("modifiedDate", E3Entry::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate",
			(BiConsumer<E3Entry, Date>)E3Entry::setModifiedDate);
		attributeGetterFunctions.put("authorId", E3Entry::getAuthorId);
		attributeSetterBiConsumers.put(
			"authorId", (BiConsumer<E3Entry, Long>)E3Entry::setAuthorId);
		attributeGetterFunctions.put("authorName", E3Entry::getAuthorName);
		attributeSetterBiConsumers.put(
			"authorName", (BiConsumer<E3Entry, String>)E3Entry::setAuthorName);
		attributeGetterFunctions.put("xid", E3Entry::getXid);
		attributeSetterBiConsumers.put(
			"xid", (BiConsumer<E3Entry, String>)E3Entry::setXid);
		attributeGetterFunctions.put("name", E3Entry::getName);
		attributeSetterBiConsumers.put(
			"name", (BiConsumer<E3Entry, String>)E3Entry::setName);
		attributeGetterFunctions.put("appClass", E3Entry::getAppClass);
		attributeSetterBiConsumers.put(
			"appClass", (BiConsumer<E3Entry, String>)E3Entry::setAppClass);
		attributeGetterFunctions.put("parentId", E3Entry::getParentId);
		attributeSetterBiConsumers.put(
			"parentId", (BiConsumer<E3Entry, Long>)E3Entry::setParentId);
		attributeGetterFunctions.put("parentField", E3Entry::getParentField);
		attributeSetterBiConsumers.put(
			"parentField",
			(BiConsumer<E3Entry, String>)E3Entry::setParentField);
		attributeGetterFunctions.put("values", E3Entry::getValues);
		attributeSetterBiConsumers.put(
			"values",
			(BiConsumer<E3Entry, Map<String, Serializable>>)E3Entry::setValues);
		attributeGetterFunctions.put("status", E3Entry::getStatus);
		attributeSetterBiConsumers.put(
			"status", (BiConsumer<E3Entry, Long>)E3Entry::setStatus);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@Override
	public void populateVersionModel(E3EntryVersion e3EntryVersion) {
		e3EntryVersion.setUuid(getUuid());
		e3EntryVersion.setGroupId(getGroupId());
		e3EntryVersion.setCompanyId(getCompanyId());
		e3EntryVersion.setUserId(getUserId());
		e3EntryVersion.setUserName(getUserName());
		e3EntryVersion.setCreateDate(getCreateDate());
		e3EntryVersion.setModifiedDate(getModifiedDate());
		e3EntryVersion.setAuthorId(getAuthorId());
		e3EntryVersion.setAuthorName(getAuthorName());
		e3EntryVersion.setXid(getXid());
		e3EntryVersion.setName(getName());
		e3EntryVersion.setAppClass(getAppClass());
		e3EntryVersion.setParentId(getParentId());
		e3EntryVersion.setParentField(getParentField());
		e3EntryVersion.setValues(getValues());
		e3EntryVersion.setStatus(getStatus());
	}

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

	@Override
	public long getHeadId() {
		return _headId;
	}

	@Override
	public void setHeadId(long headId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		if (headId >= 0) {
			setHead(false);
		}
		else {
			setHead(true);
		}

		_headId = headId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalHeadId() {
		return GetterUtil.getLong(this.<Long>getColumnOriginalValue("headId"));
	}

	public boolean getHead() {
		return _head;
	}

	@Override
	public boolean isHead() {
		return _head;
	}

	public void setHead(boolean head) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_head = head;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public boolean getOriginalHead() {
		return GetterUtil.getBoolean(
			this.<Boolean>getColumnOriginalValue("head"));
	}

	@Override
	public long getEntryId() {
		return _entryId;
	}

	@Override
	public void setEntryId(long entryId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_entryId = entryId;
	}

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

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalCompanyId() {
		return GetterUtil.getLong(
			this.<Long>getColumnOriginalValue("companyId"));
	}

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

	@Override
	public long getAuthorId() {
		return _authorId;
	}

	@Override
	public void setAuthorId(long authorId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_authorId = authorId;
	}

	@Override
	public String getAuthorName() {
		if (_authorName == null) {
			return "";
		}
		else {
			return _authorName;
		}
	}

	@Override
	public void setAuthorName(String authorName) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_authorName = authorName;
	}

	@Override
	public String getXid() {
		if (_xid == null) {
			return "";
		}
		else {
			return _xid;
		}
	}

	@Override
	public void setXid(String xid) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_xid = xid;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalXid() {
		return getColumnOriginalValue("entry_xid");
	}

	@Override
	public String getName() {
		if (_name == null) {
			return "";
		}
		else {
			return _name;
		}
	}

	@Override
	public void setName(String name) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_name = name;
	}

	@Override
	public String getAppClass() {
		if (_appClass == null) {
			return "";
		}
		else {
			return _appClass;
		}
	}

	@Override
	public void setAppClass(String appClass) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_appClass = appClass;
	}

	@Override
	public long getParentId() {
		return _parentId;
	}

	@Override
	public void setParentId(long parentId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_parentId = parentId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalParentId() {
		return GetterUtil.getLong(
			this.<Long>getColumnOriginalValue("parent_id"));
	}

	@Override
	public String getParentField() {
		if (_parentField == null) {
			return "";
		}
		else {
			return _parentField;
		}
	}

	@Override
	public void setParentField(String parentField) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_parentField = parentField;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalParentField() {
		return getColumnOriginalValue("parent_field");
	}

	@Override
	public Map<String, Serializable> getValues() {
		return _values;
	}

	@Override
	public void setValues(Map<String, Serializable> values) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_values = values;
	}

	@Override
	public long getStatus() {
		return _status;
	}

	@Override
	public void setStatus(long status) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_status = status;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalStatus() {
		return GetterUtil.getLong(this.<Long>getColumnOriginalValue("status"));
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(
			PortalUtil.getClassNameId(E3Entry.class.getName()));
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
			getCompanyId(), E3Entry.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public E3Entry toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, E3Entry>
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
		E3EntryImpl e3EntryImpl = new E3EntryImpl();

		e3EntryImpl.setMvccVersion(getMvccVersion());
		e3EntryImpl.setUuid(getUuid());
		e3EntryImpl.setHeadId(getHeadId());
		e3EntryImpl.setEntryId(getEntryId());
		e3EntryImpl.setGroupId(getGroupId());
		e3EntryImpl.setCompanyId(getCompanyId());
		e3EntryImpl.setUserId(getUserId());
		e3EntryImpl.setUserName(getUserName());
		e3EntryImpl.setCreateDate(getCreateDate());
		e3EntryImpl.setModifiedDate(getModifiedDate());
		e3EntryImpl.setAuthorId(getAuthorId());
		e3EntryImpl.setAuthorName(getAuthorName());
		e3EntryImpl.setXid(getXid());
		e3EntryImpl.setName(getName());
		e3EntryImpl.setAppClass(getAppClass());
		e3EntryImpl.setParentId(getParentId());
		e3EntryImpl.setParentField(getParentField());
		e3EntryImpl.setValues(getValues());
		e3EntryImpl.setStatus(getStatus());

		e3EntryImpl.resetOriginalValues();

		return e3EntryImpl;
	}

	@Override
	public int compareTo(E3Entry e3Entry) {
		int value = 0;

		value = getName().compareTo(e3Entry.getName());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof E3Entry)) {
			return false;
		}

		E3Entry e3Entry = (E3Entry)object;

		long primaryKey = e3Entry.getPrimaryKey();

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
	public CacheModel<E3Entry> toCacheModel() {
		E3EntryCacheModel e3EntryCacheModel = new E3EntryCacheModel();

		e3EntryCacheModel.mvccVersion = getMvccVersion();

		e3EntryCacheModel.uuid = getUuid();

		String uuid = e3EntryCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			e3EntryCacheModel.uuid = null;
		}

		e3EntryCacheModel.headId = getHeadId();

		e3EntryCacheModel.head = isHead();

		e3EntryCacheModel.entryId = getEntryId();

		e3EntryCacheModel.groupId = getGroupId();

		e3EntryCacheModel.companyId = getCompanyId();

		e3EntryCacheModel.userId = getUserId();

		e3EntryCacheModel.userName = getUserName();

		String userName = e3EntryCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			e3EntryCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			e3EntryCacheModel.createDate = createDate.getTime();
		}
		else {
			e3EntryCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			e3EntryCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			e3EntryCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		e3EntryCacheModel.authorId = getAuthorId();

		e3EntryCacheModel.authorName = getAuthorName();

		String authorName = e3EntryCacheModel.authorName;

		if ((authorName != null) && (authorName.length() == 0)) {
			e3EntryCacheModel.authorName = null;
		}

		e3EntryCacheModel.xid = getXid();

		String xid = e3EntryCacheModel.xid;

		if ((xid != null) && (xid.length() == 0)) {
			e3EntryCacheModel.xid = null;
		}

		e3EntryCacheModel.name = getName();

		String name = e3EntryCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			e3EntryCacheModel.name = null;
		}

		e3EntryCacheModel.appClass = getAppClass();

		String appClass = e3EntryCacheModel.appClass;

		if ((appClass != null) && (appClass.length() == 0)) {
			e3EntryCacheModel.appClass = null;
		}

		e3EntryCacheModel.parentId = getParentId();

		e3EntryCacheModel.parentField = getParentField();

		String parentField = e3EntryCacheModel.parentField;

		if ((parentField != null) && (parentField.length() == 0)) {
			e3EntryCacheModel.parentField = null;
		}

		e3EntryCacheModel.values = getValues();

		e3EntryCacheModel.status = getStatus();

		return e3EntryCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<E3Entry, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(4 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<E3Entry, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<E3Entry, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((E3Entry)this));
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
		Map<String, Function<E3Entry, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<E3Entry, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<E3Entry, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((E3Entry)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, E3Entry>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private long _mvccVersion;
	private String _uuid;
	private long _headId;
	private boolean _head;
	private long _entryId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private long _authorId;
	private String _authorName;
	private String _xid;
	private String _name;
	private String _appClass;
	private long _parentId;
	private String _parentField;
	private Map<String, Serializable> _values;
	private long _status;

	public <T> T getColumnValue(String columnName) {
		if (columnName.equals("head")) {
			return (T)(Object)getHead();
		}

		columnName = _attributeNames.getOrDefault(columnName, columnName);

		Function<E3Entry, Object> function = _attributeGetterFunctions.get(
			columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((E3Entry)this);
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
		_columnOriginalValues.put("uuid_", _uuid);
		_columnOriginalValues.put("headId", _headId);
		_columnOriginalValues.put("head", _head);
		_columnOriginalValues.put("entry_id", _entryId);
		_columnOriginalValues.put("groupId", _groupId);
		_columnOriginalValues.put("companyId", _companyId);
		_columnOriginalValues.put("entry_modifier_id", _userId);
		_columnOriginalValues.put("entry_modifier_name", _userName);
		_columnOriginalValues.put("entry_created", _createDate);
		_columnOriginalValues.put("entry_modified", _modifiedDate);
		_columnOriginalValues.put("entry_author_id", _authorId);
		_columnOriginalValues.put("entry_author_name", _authorName);
		_columnOriginalValues.put("entry_xid", _xid);
		_columnOriginalValues.put("entry_name", _name);
		_columnOriginalValues.put("app_class", _appClass);
		_columnOriginalValues.put("parent_id", _parentId);
		_columnOriginalValues.put("parent_field", _parentField);
		_columnOriginalValues.put("json_values", _values);
		_columnOriginalValues.put("status", _status);
	}

	private static final Map<String, String> _attributeNames;

	static {
		Map<String, String> attributeNames = new HashMap<>();

		attributeNames.put("uuid_", "uuid");
		attributeNames.put("entry_id", "entryId");
		attributeNames.put("entry_modifier_id", "userId");
		attributeNames.put("entry_modifier_name", "userName");
		attributeNames.put("entry_created", "createDate");
		attributeNames.put("entry_modified", "modifiedDate");
		attributeNames.put("entry_author_id", "authorId");
		attributeNames.put("entry_author_name", "authorName");
		attributeNames.put("entry_xid", "xid");
		attributeNames.put("entry_name", "name");
		attributeNames.put("app_class", "appClass");
		attributeNames.put("parent_id", "parentId");
		attributeNames.put("parent_field", "parentField");
		attributeNames.put("json_values", "values");

		_attributeNames = Collections.unmodifiableMap(attributeNames);
	}

	private transient Map<String, Object> _columnOriginalValues;

	public static long getColumnBitmask(String columnName) {
		return _columnBitmasks.get(columnName);
	}

	private static final Map<String, Long> _columnBitmasks;

	static {
		Map<String, Long> columnBitmasks = new HashMap<>();

		columnBitmasks.put("mvccVersion", 1L);

		columnBitmasks.put("uuid_", 2L);

		columnBitmasks.put("headId", 4L);

		columnBitmasks.put("head", 8L);

		columnBitmasks.put("entry_id", 16L);

		columnBitmasks.put("groupId", 32L);

		columnBitmasks.put("companyId", 64L);

		columnBitmasks.put("entry_modifier_id", 128L);

		columnBitmasks.put("entry_modifier_name", 256L);

		columnBitmasks.put("entry_created", 512L);

		columnBitmasks.put("entry_modified", 1024L);

		columnBitmasks.put("entry_author_id", 2048L);

		columnBitmasks.put("entry_author_name", 4096L);

		columnBitmasks.put("entry_xid", 8192L);

		columnBitmasks.put("entry_name", 16384L);

		columnBitmasks.put("app_class", 32768L);

		columnBitmasks.put("parent_id", 65536L);

		columnBitmasks.put("parent_field", 131072L);

		columnBitmasks.put("json_values", 262144L);

		columnBitmasks.put("status", 524288L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private E3Entry _escapedModel;

}