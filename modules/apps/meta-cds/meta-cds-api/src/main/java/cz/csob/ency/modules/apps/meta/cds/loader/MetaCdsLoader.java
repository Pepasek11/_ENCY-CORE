package cz.csob.ency.modules.apps.meta.cds.loader;

import com.liferay.portal.kernel.service.ServiceContext;
import org.osgi.annotation.versioning.ProviderType;

@ProviderType
public interface MetaCdsLoader {
    public long loadColumnMeta(ServiceContext serviceContext, String parentTableName);

    public long loadMetaCdsFull(ServiceContext serviceContext);

    public long loadSystemMeta(ServiceContext serviceContext);

    public long loadTableMeta(ServiceContext serviceContext, String parentSystemEntryId);
}
