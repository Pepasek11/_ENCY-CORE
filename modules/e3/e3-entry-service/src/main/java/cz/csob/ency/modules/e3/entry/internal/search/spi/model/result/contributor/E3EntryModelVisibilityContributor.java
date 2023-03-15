package cz.csob.ency.modules.e3.entry.internal.search.spi.model.result.contributor;

/**
 * @todo implement
 */

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.search.spi.model.result.contributor.ModelVisibilityContributor;

import cz.csob.ency.modules.e3.entry.model.E3Entry;
import cz.csob.ency.modules.e3.entry.service.E3EntryLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
        immediate = true,
        property = "indexer.class.name=cz.csob.ency.modules.e3.entry.model.E3Entry",
        service = ModelVisibilityContributor.class
)
public class E3EntryModelVisibilityContributor implements ModelVisibilityContributor {

    @Override
    public boolean isVisible(long classPK, int status) {
        try {
            _log.info("checking "+classPK+" "+status);
            E3Entry entry = _entryLocalService.getEntry(classPK);
            //@todo
            return true;
            //   return _isVisible(entry.getStatus(), status);
        } catch (PortalException portalException) {
            if (_log.isWarnEnabled()) {
                _log.warn(
                        "Unable to check visibility for blogs entry ",
                        portalException);
            }

            return false;
        }
    }

    private boolean _isVisible(int entryStatus, int queryStatus) {
        // @todo
        if (((queryStatus != WorkflowConstants.STATUS_ANY) &&
                (entryStatus == queryStatus)) ||
                (entryStatus != WorkflowConstants.STATUS_IN_TRASH)) {

            return true;
        }

        return false;
    }

    private static final Log _log = LogFactoryUtil.getLog(
            E3EntryModelVisibilityContributor.class);

    @Reference
    private E3EntryLocalService _entryLocalService;

}
