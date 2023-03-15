package cz.csob.ency.modules.e3.entry.internal.search.spi.model.index.contributor;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.search.spi.model.index.contributor.ModelDocumentContributor;
import cz.csob.ency.modules.e3.app.model.E3App;
import cz.csob.ency.modules.e3.app.service.E3AppLocalServiceUtil;
import cz.csob.ency.modules.e3.entry.internal.search.E3SearchField;
import cz.csob.ency.modules.e3.entry.model.E3Entry;
import cz.csob.ency.modules.e3.entry.utils.E3EntryIndexer;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.Date;
import java.util.Locale;

@Component(
        immediate = true,
        property = "indexer.class.name=cz.csob.ency.modules.e3.entry.model.E3Entry",
        service = ModelDocumentContributor.class
)
public class E3EntryDocumentContributor implements ModelDocumentContributor<E3Entry> {
    private static final Log _log = LogFactoryUtil.getLog(E3EntryDocumentContributor.class);

    @Override
    public void contribute(Document document, E3Entry entry) {
        //_log.info("Index document contributed for " + entry);
        try {
            E3App app = E3AppLocalServiceUtil.getApp(entry);

            document.addText(E3SearchField.NAME, entry.getName());
            document.addText(E3SearchField.EXTENDED_NAME, app.getEntryExtendedName(entry));
            document.addText(E3SearchField.APP_CLASS, entry.getAppClass());
            document.addText(E3SearchField.APP_CODE, entry.getAppCode());

            document.addText(E3SearchField.CREATEDBY_USER_NAME, entry.getAuthorName());
            document.addText(E3SearchField.MODIFIEDBY_USER_NAME, entry.getUserName());

            Locale defaultLocale = PortalUtil.getSiteDefaultLocale(entry.getGroupId());

            document.addText(Field.CONTENT,
                    entryIndexer.extractIndexableContent(entry, defaultLocale));

            entryIndexer
                    .getIndexableFieldsValues(entry, defaultLocale)
                    .forEach((fieldName, serializableValue) -> {
                        if (serializableValue != null) {
                            //     _log.info("Processing indexable field " + fieldName + " value " + serializableValue);
                            if (serializableValue instanceof Date) {
                                document.addDate(_getFieldName(fieldName), (Date) serializableValue);
                            } else if (serializableValue instanceof Date[]) {
                                document.addDate(_getFieldName(fieldName), (Date[]) serializableValue);
                            } else if (serializableValue instanceof Boolean) {
                                document.addText(_getFieldName(fieldName), serializableValue.toString());
                            } else if (serializableValue instanceof Long) {
                                document.addNumber(_getFieldName(fieldName), (Long) serializableValue);
                            } else if (serializableValue instanceof Double) {
                                document.addNumber(_getFieldName(fieldName), (Double) serializableValue);
                            } else if (serializableValue instanceof Float) {
                                document.addNumber(_getFieldName(fieldName), (Float) serializableValue);
                            } else if (serializableValue instanceof Integer) {
                                document.addNumber(_getFieldName(fieldName), (Integer) serializableValue);
                            } else {
                                document.addText(_getFieldName(fieldName), serializableValue.toString());
                            }
                        }
                    });

        } catch (PortalException pe) {
            if (_log.isWarnEnabled()) {
                _log.warn(
                        "Unable to index Entry " + entry.getEntryId(), pe);
            }
        }
    }

    private String _getFieldName(String fieldName) {
        return "E3FIELD" + StringPool.UNDERLINE + fieldName;
    }

    @Reference
    protected E3EntryIndexer entryIndexer;
}