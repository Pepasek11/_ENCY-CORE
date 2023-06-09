// 
/*  */
/**
*  Copyright (C) 2021 Yasuyuki Takeo All rights reserved.
*
*  This program is free software: you can redistribute it and/or modify
*  it under the terms of the GNU Lesser General Public License as published by
*  the Free Software Foundation, either version 3 of the License, or
*  (at your option) any later version.
*
*  This program is distributed in the hope that it will be useful,
*  but WITHOUT ANY WARRANTY; without even the implied warranty of
*  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
*  GNU Lesser General Public License for more details.
*/
/*  */

package cz.csob.ency.modules.apps.meta.cds.exception;

import com.liferay.portal.kernel.exception.PortalException;

import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Miroslav Čermák
 */
@ProviderType
public class TableEntryValidateException extends PortalException {

	public TableEntryValidateException() {
	}

	public TableEntryValidateException(List<String> errors) {
		_errors = errors;
	}

	public List<String> getErrors() {
		return _errors;
	}

	protected List<String> _errors = null;

}