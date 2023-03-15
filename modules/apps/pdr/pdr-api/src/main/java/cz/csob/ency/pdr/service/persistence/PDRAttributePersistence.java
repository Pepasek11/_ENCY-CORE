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

package cz.csob.ency.pdr.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import cz.csob.ency.pdr.exception.NoSuchPDRAttributeException;
import cz.csob.ency.pdr.model.PDRAttribute;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the pdr attribute service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Miroslav Čermák
 * @see PDRAttributeUtil
 * @generated
 */
@ProviderType
public interface PDRAttributePersistence extends BasePersistence<PDRAttribute> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PDRAttributeUtil} to access the pdr attribute persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the pdr attribute in the entity cache if it is enabled.
	 *
	 * @param pdrAttribute the pdr attribute
	 */
	public void cacheResult(PDRAttribute pdrAttribute);

	/**
	 * Caches the pdr attributes in the entity cache if it is enabled.
	 *
	 * @param pdrAttributes the pdr attributes
	 */
	public void cacheResult(java.util.List<PDRAttribute> pdrAttributes);

	/**
	 * Creates a new pdr attribute with the primary key. Does not add the pdr attribute to the database.
	 *
	 * @param attributeId the primary key for the new pdr attribute
	 * @return the new pdr attribute
	 */
	public PDRAttribute create(long attributeId);

	/**
	 * Removes the pdr attribute with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param attributeId the primary key of the pdr attribute
	 * @return the pdr attribute that was removed
	 * @throws NoSuchPDRAttributeException if a pdr attribute with the primary key could not be found
	 */
	public PDRAttribute remove(long attributeId)
		throws NoSuchPDRAttributeException;

	public PDRAttribute updateImpl(PDRAttribute pdrAttribute);

	/**
	 * Returns the pdr attribute with the primary key or throws a <code>NoSuchPDRAttributeException</code> if it could not be found.
	 *
	 * @param attributeId the primary key of the pdr attribute
	 * @return the pdr attribute
	 * @throws NoSuchPDRAttributeException if a pdr attribute with the primary key could not be found
	 */
	public PDRAttribute findByPrimaryKey(long attributeId)
		throws NoSuchPDRAttributeException;

	/**
	 * Returns the pdr attribute with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param attributeId the primary key of the pdr attribute
	 * @return the pdr attribute, or <code>null</code> if a pdr attribute with the primary key could not be found
	 */
	public PDRAttribute fetchByPrimaryKey(long attributeId);

	/**
	 * Returns all the pdr attributes.
	 *
	 * @return the pdr attributes
	 */
	public java.util.List<PDRAttribute> findAll();

	/**
	 * Returns a range of all the pdr attributes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PDRAttributeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of pdr attributes
	 * @param end the upper bound of the range of pdr attributes (not inclusive)
	 * @return the range of pdr attributes
	 */
	public java.util.List<PDRAttribute> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the pdr attributes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PDRAttributeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of pdr attributes
	 * @param end the upper bound of the range of pdr attributes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of pdr attributes
	 */
	public java.util.List<PDRAttribute> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PDRAttribute>
			orderByComparator);

	/**
	 * Returns an ordered range of all the pdr attributes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PDRAttributeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of pdr attributes
	 * @param end the upper bound of the range of pdr attributes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of pdr attributes
	 */
	public java.util.List<PDRAttribute> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PDRAttribute>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the pdr attributes from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of pdr attributes.
	 *
	 * @return the number of pdr attributes
	 */
	public int countAll();

}