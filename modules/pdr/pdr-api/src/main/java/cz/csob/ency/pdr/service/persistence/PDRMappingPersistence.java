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

import cz.csob.ency.pdr.exception.NoSuchPDRMappingException;
import cz.csob.ency.pdr.model.PDRMapping;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the pdr mapping service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Miroslav Čermák
 * @see PDRMappingUtil
 * @generated
 */
@ProviderType
public interface PDRMappingPersistence extends BasePersistence<PDRMapping> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PDRMappingUtil} to access the pdr mapping persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the pdr mapping in the entity cache if it is enabled.
	 *
	 * @param pdrMapping the pdr mapping
	 */
	public void cacheResult(PDRMapping pdrMapping);

	/**
	 * Caches the pdr mappings in the entity cache if it is enabled.
	 *
	 * @param pdrMappings the pdr mappings
	 */
	public void cacheResult(java.util.List<PDRMapping> pdrMappings);

	/**
	 * Creates a new pdr mapping with the primary key. Does not add the pdr mapping to the database.
	 *
	 * @param mappingId the primary key for the new pdr mapping
	 * @return the new pdr mapping
	 */
	public PDRMapping create(long mappingId);

	/**
	 * Removes the pdr mapping with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param mappingId the primary key of the pdr mapping
	 * @return the pdr mapping that was removed
	 * @throws NoSuchPDRMappingException if a pdr mapping with the primary key could not be found
	 */
	public PDRMapping remove(long mappingId) throws NoSuchPDRMappingException;

	public PDRMapping updateImpl(PDRMapping pdrMapping);

	/**
	 * Returns the pdr mapping with the primary key or throws a <code>NoSuchPDRMappingException</code> if it could not be found.
	 *
	 * @param mappingId the primary key of the pdr mapping
	 * @return the pdr mapping
	 * @throws NoSuchPDRMappingException if a pdr mapping with the primary key could not be found
	 */
	public PDRMapping findByPrimaryKey(long mappingId)
		throws NoSuchPDRMappingException;

	/**
	 * Returns the pdr mapping with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param mappingId the primary key of the pdr mapping
	 * @return the pdr mapping, or <code>null</code> if a pdr mapping with the primary key could not be found
	 */
	public PDRMapping fetchByPrimaryKey(long mappingId);

	/**
	 * Returns all the pdr mappings.
	 *
	 * @return the pdr mappings
	 */
	public java.util.List<PDRMapping> findAll();

	/**
	 * Returns a range of all the pdr mappings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PDRMappingModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of pdr mappings
	 * @param end the upper bound of the range of pdr mappings (not inclusive)
	 * @return the range of pdr mappings
	 */
	public java.util.List<PDRMapping> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the pdr mappings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PDRMappingModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of pdr mappings
	 * @param end the upper bound of the range of pdr mappings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of pdr mappings
	 */
	public java.util.List<PDRMapping> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PDRMapping>
			orderByComparator);

	/**
	 * Returns an ordered range of all the pdr mappings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PDRMappingModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of pdr mappings
	 * @param end the upper bound of the range of pdr mappings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of pdr mappings
	 */
	public java.util.List<PDRMapping> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PDRMapping>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the pdr mappings from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of pdr mappings.
	 *
	 * @return the number of pdr mappings
	 */
	public int countAll();

}