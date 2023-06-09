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

package cz.csob.ency.workflow.model.impl;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringUtil;

import cz.csob.ency.workflow.model.EncyWorkflowTransition;
import cz.csob.ency.workflow.model.EncyWorkflowTransitionModel;

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
 * The base model implementation for the EncyWorkflowTransition service. Represents a row in the &quot;ency_workflowtransition&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>EncyWorkflowTransitionModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link EncyWorkflowTransitionImpl}.
 * </p>
 *
 * @author Miroslav Čermák
 * @see EncyWorkflowTransitionImpl
 * @generated
 */
public class EncyWorkflowTransitionModelImpl
	extends BaseModelImpl<EncyWorkflowTransition>
	implements EncyWorkflowTransitionModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a ency workflow transition model instance should use the <code>EncyWorkflowTransition</code> interface instead.
	 */
	public static final String TABLE_NAME = "ency_workflowtransition";

	public static final Object[][] TABLE_COLUMNS = {
		{"uuid_", Types.VARCHAR}, {"transitionId", Types.BIGINT},
		{"stateId", Types.BIGINT}, {"workflowId", Types.BIGINT},
		{"version", Types.BIGINT}, {"name", Types.VARCHAR},
		{"title", Types.VARCHAR}, {"description", Types.CLOB},
		{"targetStateName", Types.VARCHAR}, {"targetStateId", Types.BIGINT},
		{"cssIcon", Types.VARCHAR}, {"cssIconColor", Types.VARCHAR},
		{"active_", Types.BOOLEAN}, {"createDate", Types.TIMESTAMP},
		{"modifiedDate", Types.TIMESTAMP}, {"order_", Types.BIGINT}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("transitionId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("stateId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("workflowId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("version", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("name", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("title", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("description", Types.CLOB);
		TABLE_COLUMNS_MAP.put("targetStateName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("targetStateId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("cssIcon", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("cssIconColor", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("active_", Types.BOOLEAN);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("order_", Types.BIGINT);
	}

	public static final String TABLE_SQL_CREATE =
		"create table ency_workflowtransition (uuid_ VARCHAR(75) null,transitionId LONG not null primary key,stateId LONG,workflowId LONG,version LONG,name VARCHAR(200) null,title VARCHAR(1000) null,description TEXT null,targetStateName VARCHAR(200) null,targetStateId LONG,cssIcon VARCHAR(100) null,cssIconColor VARCHAR(10) null,active_ BOOLEAN,createDate DATE null,modifiedDate DATE null,order_ LONG)";

	public static final String TABLE_SQL_DROP =
		"drop table ency_workflowtransition";

	public static final String ORDER_BY_JPQL =
		" ORDER BY encyWorkflowTransition.transitionId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY ency_workflowtransition.transitionId ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long ACTIVE_COLUMN_BITMASK = 1L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long NAME_COLUMN_BITMASK = 2L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long STATEID_COLUMN_BITMASK = 4L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long UUID_COLUMN_BITMASK = 8L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long WORKFLOWID_COLUMN_BITMASK = 16L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *		#getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long TRANSITIONID_COLUMN_BITMASK = 32L;

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

	public EncyWorkflowTransitionModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _transitionId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setTransitionId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _transitionId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return EncyWorkflowTransition.class;
	}

	@Override
	public String getModelClassName() {
		return EncyWorkflowTransition.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<EncyWorkflowTransition, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		for (Map.Entry<String, Function<EncyWorkflowTransition, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<EncyWorkflowTransition, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((EncyWorkflowTransition)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<EncyWorkflowTransition, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<EncyWorkflowTransition, Object>
				attributeSetterBiConsumer = attributeSetterBiConsumers.get(
					attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(EncyWorkflowTransition)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<EncyWorkflowTransition, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<EncyWorkflowTransition, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static final Map<String, Function<EncyWorkflowTransition, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<EncyWorkflowTransition, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<EncyWorkflowTransition, Object>>
			attributeGetterFunctions =
				new LinkedHashMap
					<String, Function<EncyWorkflowTransition, Object>>();
		Map<String, BiConsumer<EncyWorkflowTransition, ?>>
			attributeSetterBiConsumers =
				new LinkedHashMap
					<String, BiConsumer<EncyWorkflowTransition, ?>>();

		attributeGetterFunctions.put("uuid", EncyWorkflowTransition::getUuid);
		attributeSetterBiConsumers.put(
			"uuid",
			(BiConsumer<EncyWorkflowTransition, String>)
				EncyWorkflowTransition::setUuid);
		attributeGetterFunctions.put(
			"transitionId", EncyWorkflowTransition::getTransitionId);
		attributeSetterBiConsumers.put(
			"transitionId",
			(BiConsumer<EncyWorkflowTransition, Long>)
				EncyWorkflowTransition::setTransitionId);
		attributeGetterFunctions.put(
			"stateId", EncyWorkflowTransition::getStateId);
		attributeSetterBiConsumers.put(
			"stateId",
			(BiConsumer<EncyWorkflowTransition, Long>)
				EncyWorkflowTransition::setStateId);
		attributeGetterFunctions.put(
			"workflowId", EncyWorkflowTransition::getWorkflowId);
		attributeSetterBiConsumers.put(
			"workflowId",
			(BiConsumer<EncyWorkflowTransition, Long>)
				EncyWorkflowTransition::setWorkflowId);
		attributeGetterFunctions.put(
			"version", EncyWorkflowTransition::getVersion);
		attributeSetterBiConsumers.put(
			"version",
			(BiConsumer<EncyWorkflowTransition, Long>)
				EncyWorkflowTransition::setVersion);
		attributeGetterFunctions.put("name", EncyWorkflowTransition::getName);
		attributeSetterBiConsumers.put(
			"name",
			(BiConsumer<EncyWorkflowTransition, String>)
				EncyWorkflowTransition::setName);
		attributeGetterFunctions.put("title", EncyWorkflowTransition::getTitle);
		attributeSetterBiConsumers.put(
			"title",
			(BiConsumer<EncyWorkflowTransition, String>)
				EncyWorkflowTransition::setTitle);
		attributeGetterFunctions.put(
			"description", EncyWorkflowTransition::getDescription);
		attributeSetterBiConsumers.put(
			"description",
			(BiConsumer<EncyWorkflowTransition, String>)
				EncyWorkflowTransition::setDescription);
		attributeGetterFunctions.put(
			"targetStateName", EncyWorkflowTransition::getTargetStateName);
		attributeSetterBiConsumers.put(
			"targetStateName",
			(BiConsumer<EncyWorkflowTransition, String>)
				EncyWorkflowTransition::setTargetStateName);
		attributeGetterFunctions.put(
			"targetStateId", EncyWorkflowTransition::getTargetStateId);
		attributeSetterBiConsumers.put(
			"targetStateId",
			(BiConsumer<EncyWorkflowTransition, Long>)
				EncyWorkflowTransition::setTargetStateId);
		attributeGetterFunctions.put(
			"cssIcon", EncyWorkflowTransition::getCssIcon);
		attributeSetterBiConsumers.put(
			"cssIcon",
			(BiConsumer<EncyWorkflowTransition, String>)
				EncyWorkflowTransition::setCssIcon);
		attributeGetterFunctions.put(
			"cssIconColor", EncyWorkflowTransition::getCssIconColor);
		attributeSetterBiConsumers.put(
			"cssIconColor",
			(BiConsumer<EncyWorkflowTransition, String>)
				EncyWorkflowTransition::setCssIconColor);
		attributeGetterFunctions.put(
			"active", EncyWorkflowTransition::getActive);
		attributeSetterBiConsumers.put(
			"active",
			(BiConsumer<EncyWorkflowTransition, Boolean>)
				EncyWorkflowTransition::setActive);
		attributeGetterFunctions.put(
			"createDate", EncyWorkflowTransition::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate",
			(BiConsumer<EncyWorkflowTransition, Date>)
				EncyWorkflowTransition::setCreateDate);
		attributeGetterFunctions.put(
			"modifiedDate", EncyWorkflowTransition::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate",
			(BiConsumer<EncyWorkflowTransition, Date>)
				EncyWorkflowTransition::setModifiedDate);
		attributeGetterFunctions.put("order", EncyWorkflowTransition::getOrder);
		attributeSetterBiConsumers.put(
			"order",
			(BiConsumer<EncyWorkflowTransition, Long>)
				EncyWorkflowTransition::setOrder);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
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
	public long getTransitionId() {
		return _transitionId;
	}

	@Override
	public void setTransitionId(long transitionId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_transitionId = transitionId;
	}

	@Override
	public long getStateId() {
		return _stateId;
	}

	@Override
	public void setStateId(long stateId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_stateId = stateId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalStateId() {
		return GetterUtil.getLong(this.<Long>getColumnOriginalValue("stateId"));
	}

	@Override
	public long getWorkflowId() {
		return _workflowId;
	}

	@Override
	public void setWorkflowId(long workflowId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_workflowId = workflowId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalWorkflowId() {
		return GetterUtil.getLong(
			this.<Long>getColumnOriginalValue("workflowId"));
	}

	@Override
	public long getVersion() {
		return _version;
	}

	@Override
	public void setVersion(long version) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_version = version;
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

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalName() {
		return getColumnOriginalValue("name");
	}

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

	@Override
	public String getTargetStateName() {
		if (_targetStateName == null) {
			return "";
		}
		else {
			return _targetStateName;
		}
	}

	@Override
	public void setTargetStateName(String targetStateName) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_targetStateName = targetStateName;
	}

	@Override
	public long getTargetStateId() {
		return _targetStateId;
	}

	@Override
	public void setTargetStateId(long targetStateId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_targetStateId = targetStateId;
	}

	@Override
	public String getCssIcon() {
		if (_cssIcon == null) {
			return "";
		}
		else {
			return _cssIcon;
		}
	}

	@Override
	public void setCssIcon(String cssIcon) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_cssIcon = cssIcon;
	}

	@Override
	public String getCssIconColor() {
		if (_cssIconColor == null) {
			return "";
		}
		else {
			return _cssIconColor;
		}
	}

	@Override
	public void setCssIconColor(String cssIconColor) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_cssIconColor = cssIconColor;
	}

	@Override
	public Boolean getActive() {
		return _active;
	}

	@Override
	public void setActive(Boolean active) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_active = active;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public Boolean getOriginalActive() {
		return GetterUtil.getBoolean(
			this.<Boolean>getColumnOriginalValue("active_"));
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
	public long getOrder() {
		return _order;
	}

	@Override
	public void setOrder(long order) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_order = order;
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
			0, EncyWorkflowTransition.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public EncyWorkflowTransition toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, EncyWorkflowTransition>
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
		EncyWorkflowTransitionImpl encyWorkflowTransitionImpl =
			new EncyWorkflowTransitionImpl();

		encyWorkflowTransitionImpl.setUuid(getUuid());
		encyWorkflowTransitionImpl.setTransitionId(getTransitionId());
		encyWorkflowTransitionImpl.setStateId(getStateId());
		encyWorkflowTransitionImpl.setWorkflowId(getWorkflowId());
		encyWorkflowTransitionImpl.setVersion(getVersion());
		encyWorkflowTransitionImpl.setName(getName());
		encyWorkflowTransitionImpl.setTitle(getTitle());
		encyWorkflowTransitionImpl.setDescription(getDescription());
		encyWorkflowTransitionImpl.setTargetStateName(getTargetStateName());
		encyWorkflowTransitionImpl.setTargetStateId(getTargetStateId());
		encyWorkflowTransitionImpl.setCssIcon(getCssIcon());
		encyWorkflowTransitionImpl.setCssIconColor(getCssIconColor());
		encyWorkflowTransitionImpl.setActive(getActive());
		encyWorkflowTransitionImpl.setCreateDate(getCreateDate());
		encyWorkflowTransitionImpl.setModifiedDate(getModifiedDate());
		encyWorkflowTransitionImpl.setOrder(getOrder());

		encyWorkflowTransitionImpl.resetOriginalValues();

		return encyWorkflowTransitionImpl;
	}

	@Override
	public EncyWorkflowTransition cloneWithOriginalValues() {
		EncyWorkflowTransitionImpl encyWorkflowTransitionImpl =
			new EncyWorkflowTransitionImpl();

		encyWorkflowTransitionImpl.setUuid(
			this.<String>getColumnOriginalValue("uuid_"));
		encyWorkflowTransitionImpl.setTransitionId(
			this.<Long>getColumnOriginalValue("transitionId"));
		encyWorkflowTransitionImpl.setStateId(
			this.<Long>getColumnOriginalValue("stateId"));
		encyWorkflowTransitionImpl.setWorkflowId(
			this.<Long>getColumnOriginalValue("workflowId"));
		encyWorkflowTransitionImpl.setVersion(
			this.<Long>getColumnOriginalValue("version"));
		encyWorkflowTransitionImpl.setName(
			this.<String>getColumnOriginalValue("name"));
		encyWorkflowTransitionImpl.setTitle(
			this.<String>getColumnOriginalValue("title"));
		encyWorkflowTransitionImpl.setDescription(
			this.<String>getColumnOriginalValue("description"));
		encyWorkflowTransitionImpl.setTargetStateName(
			this.<String>getColumnOriginalValue("targetStateName"));
		encyWorkflowTransitionImpl.setTargetStateId(
			this.<Long>getColumnOriginalValue("targetStateId"));
		encyWorkflowTransitionImpl.setCssIcon(
			this.<String>getColumnOriginalValue("cssIcon"));
		encyWorkflowTransitionImpl.setCssIconColor(
			this.<String>getColumnOriginalValue("cssIconColor"));
		encyWorkflowTransitionImpl.setActive(
			this.<Boolean>getColumnOriginalValue("active_"));
		encyWorkflowTransitionImpl.setCreateDate(
			this.<Date>getColumnOriginalValue("createDate"));
		encyWorkflowTransitionImpl.setModifiedDate(
			this.<Date>getColumnOriginalValue("modifiedDate"));
		encyWorkflowTransitionImpl.setOrder(
			this.<Long>getColumnOriginalValue("order_"));

		return encyWorkflowTransitionImpl;
	}

	@Override
	public int compareTo(EncyWorkflowTransition encyWorkflowTransition) {
		long primaryKey = encyWorkflowTransition.getPrimaryKey();

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

		if (!(object instanceof EncyWorkflowTransition)) {
			return false;
		}

		EncyWorkflowTransition encyWorkflowTransition =
			(EncyWorkflowTransition)object;

		long primaryKey = encyWorkflowTransition.getPrimaryKey();

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
	public CacheModel<EncyWorkflowTransition> toCacheModel() {
		EncyWorkflowTransitionCacheModel encyWorkflowTransitionCacheModel =
			new EncyWorkflowTransitionCacheModel();

		encyWorkflowTransitionCacheModel.uuid = getUuid();

		String uuid = encyWorkflowTransitionCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			encyWorkflowTransitionCacheModel.uuid = null;
		}

		encyWorkflowTransitionCacheModel.transitionId = getTransitionId();

		encyWorkflowTransitionCacheModel.stateId = getStateId();

		encyWorkflowTransitionCacheModel.workflowId = getWorkflowId();

		encyWorkflowTransitionCacheModel.version = getVersion();

		encyWorkflowTransitionCacheModel.name = getName();

		String name = encyWorkflowTransitionCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			encyWorkflowTransitionCacheModel.name = null;
		}

		encyWorkflowTransitionCacheModel.title = getTitle();

		String title = encyWorkflowTransitionCacheModel.title;

		if ((title != null) && (title.length() == 0)) {
			encyWorkflowTransitionCacheModel.title = null;
		}

		encyWorkflowTransitionCacheModel.description = getDescription();

		String description = encyWorkflowTransitionCacheModel.description;

		if ((description != null) && (description.length() == 0)) {
			encyWorkflowTransitionCacheModel.description = null;
		}

		encyWorkflowTransitionCacheModel.targetStateName = getTargetStateName();

		String targetStateName =
			encyWorkflowTransitionCacheModel.targetStateName;

		if ((targetStateName != null) && (targetStateName.length() == 0)) {
			encyWorkflowTransitionCacheModel.targetStateName = null;
		}

		encyWorkflowTransitionCacheModel.targetStateId = getTargetStateId();

		encyWorkflowTransitionCacheModel.cssIcon = getCssIcon();

		String cssIcon = encyWorkflowTransitionCacheModel.cssIcon;

		if ((cssIcon != null) && (cssIcon.length() == 0)) {
			encyWorkflowTransitionCacheModel.cssIcon = null;
		}

		encyWorkflowTransitionCacheModel.cssIconColor = getCssIconColor();

		String cssIconColor = encyWorkflowTransitionCacheModel.cssIconColor;

		if ((cssIconColor != null) && (cssIconColor.length() == 0)) {
			encyWorkflowTransitionCacheModel.cssIconColor = null;
		}

		Boolean active = getActive();

		if (active != null) {
			encyWorkflowTransitionCacheModel.active = active;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			encyWorkflowTransitionCacheModel.createDate = createDate.getTime();
		}
		else {
			encyWorkflowTransitionCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			encyWorkflowTransitionCacheModel.modifiedDate =
				modifiedDate.getTime();
		}
		else {
			encyWorkflowTransitionCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		encyWorkflowTransitionCacheModel.order = getOrder();

		return encyWorkflowTransitionCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<EncyWorkflowTransition, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<EncyWorkflowTransition, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<EncyWorkflowTransition, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("\"");
			sb.append(attributeName);
			sb.append("\": ");

			Object value = attributeGetterFunction.apply(
				(EncyWorkflowTransition)this);

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
		Map<String, Function<EncyWorkflowTransition, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<EncyWorkflowTransition, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<EncyWorkflowTransition, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(
				attributeGetterFunction.apply((EncyWorkflowTransition)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, EncyWorkflowTransition>
			_escapedModelProxyProviderFunction =
				ProxyUtil.getProxyProviderFunction(
					EncyWorkflowTransition.class, ModelWrapper.class);

	}

	private String _uuid;
	private long _transitionId;
	private long _stateId;
	private long _workflowId;
	private long _version;
	private String _name;
	private String _title;
	private String _description;
	private String _targetStateName;
	private long _targetStateId;
	private String _cssIcon;
	private String _cssIconColor;
	private Boolean _active;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private long _order;

	public <T> T getColumnValue(String columnName) {
		columnName = _attributeNames.getOrDefault(columnName, columnName);

		Function<EncyWorkflowTransition, Object> function =
			_attributeGetterFunctions.get(columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((EncyWorkflowTransition)this);
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
		_columnOriginalValues.put("transitionId", _transitionId);
		_columnOriginalValues.put("stateId", _stateId);
		_columnOriginalValues.put("workflowId", _workflowId);
		_columnOriginalValues.put("version", _version);
		_columnOriginalValues.put("name", _name);
		_columnOriginalValues.put("title", _title);
		_columnOriginalValues.put("description", _description);
		_columnOriginalValues.put("targetStateName", _targetStateName);
		_columnOriginalValues.put("targetStateId", _targetStateId);
		_columnOriginalValues.put("cssIcon", _cssIcon);
		_columnOriginalValues.put("cssIconColor", _cssIconColor);
		_columnOriginalValues.put("active_", _active);
		_columnOriginalValues.put("createDate", _createDate);
		_columnOriginalValues.put("modifiedDate", _modifiedDate);
		_columnOriginalValues.put("order_", _order);
	}

	private static final Map<String, String> _attributeNames;

	static {
		Map<String, String> attributeNames = new HashMap<>();

		attributeNames.put("uuid_", "uuid");
		attributeNames.put("active_", "active");
		attributeNames.put("order_", "order");

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

		columnBitmasks.put("transitionId", 2L);

		columnBitmasks.put("stateId", 4L);

		columnBitmasks.put("workflowId", 8L);

		columnBitmasks.put("version", 16L);

		columnBitmasks.put("name", 32L);

		columnBitmasks.put("title", 64L);

		columnBitmasks.put("description", 128L);

		columnBitmasks.put("targetStateName", 256L);

		columnBitmasks.put("targetStateId", 512L);

		columnBitmasks.put("cssIcon", 1024L);

		columnBitmasks.put("cssIconColor", 2048L);

		columnBitmasks.put("active_", 4096L);

		columnBitmasks.put("createDate", 8192L);

		columnBitmasks.put("modifiedDate", 16384L);

		columnBitmasks.put("order_", 32768L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private EncyWorkflowTransition _escapedModel;

}