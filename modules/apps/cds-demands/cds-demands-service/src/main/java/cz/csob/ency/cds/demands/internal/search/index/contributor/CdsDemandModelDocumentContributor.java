// 
/*   */
/**
 * Copyright (C) 2021 Yasuyuki Takeo All rights reserved.
 * <p>
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * <p>
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 */
/*  */
package cz.csob.ency.cds.demands.internal.search.index.contributor;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.search.spi.model.index.contributor.ModelDocumentContributor;
import cz.csob.ency.cds.demands.constants.CdsDemandFiveTracks;
import cz.csob.ency.cds.demands.model.CdsDemand;
import org.osgi.service.component.annotations.Component;

import java.util.Arrays;

/**
 * CdsDemand Model Document Contributor
 * <p>
 * This class is used to contribute fields to the document to be indexed.
 *
 * @author Miroslav Čermák
 */
@Component(
        immediate = true,
        property = "indexer.class.name=cz.csob.ency.cds.demands.model.CdsDemand",
        service = ModelDocumentContributor.class
)
public class CdsDemandModelDocumentContributor implements ModelDocumentContributor<CdsDemand> {
    private static final Log _log = LogFactoryUtil.getLog(
            CdsDemandModelDocumentContributor.class);


    @Override
    public void contribute(Document document, CdsDemand entry) {

        // TODO : These fields should be modified according to your requirements.
        try {

            document.addText(Field.CAPTION, entry.getTitle());
            document.addText(
                    Field.CONTENT,
                    HtmlUtil.stripHtml(entry.getDescription()));
            document.addText(Field.DESCRIPTION, entry.getTitle());
            document.addText(Field.SUBTITLE, entry.getBioeId());
            document.addText(Field.TITLE, entry.getTitle());

            document.addDate(Field.MODIFIED_DATE, entry.getModifiedDate());

            document.addNumber("demandId", entry.getDemandId());
            document.addText("description", HtmlUtil.stripHtml(entry.getDescription()));
            document.addText("bioeId", entry.getBioeId());
            document.addText("uuid", entry.getUuid());
            document.addNumber("type", entry.getType());
            document.addNumber("priority_", entry.getPriority());
            document.addNumber("workEstimate", entry.getWorkEstimate());
            document.addNumber("acceptedWorkEstimate", entry.getAcceptedWorkEstimate());
            document.addDate("requestedDelivery", entry.getRequestedDelivery());
            document.addDate("expectedDelivery", entry.getExpectedDelivery());
            document.addDate("acceptedDelivery", entry.getAcceptedDelivery());
            document.addNumber("requestorId", entry.getRequestorId());
            document.addText("requestorName", entry.getRequestorName());
            document.addNumber("requestedForId", entry.getRequestedForId());
            document.addText("requestedForName", entry.getRequestedForName());
            document.addNumber("contactId", entry.getRequestorId());
            document.addText("contactName", entry.getContactName());
            document.addNumber("domainId", entry.getDomainId());
            document.addText("domainName", entry.getDomainName());
            document.addNumber("banId", entry.getBanId());
            document.addText("banName", entry.getBanName());
            document.addNumber("spocId", entry.getSpocId());
            document.addText("spocName", entry.getSpocName());

            // document.addText("gdprInfo", entry.getGdprInfo()); //@todo
            document.addText("fiveTracks",
                    Arrays
                            .stream(entry.getFiveTracksArray())
                            .mapToObj(CdsDemandFiveTracks::getTrackLabel)
                            .reduce((s, s2) -> s + "," + s).orElse(""));
        } catch (Exception e) {
            _log.error(e);
        }
    }
}