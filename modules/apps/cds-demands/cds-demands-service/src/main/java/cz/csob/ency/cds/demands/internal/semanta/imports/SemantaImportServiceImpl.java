package cz.csob.ency.cds.demands.internal.semanta.imports;


import com.liferay.admin.kernel.util.Omniadmin;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.HashMapBuilder;
import cz.csob.ency.cds.demands.semanta.imports.SemantaImportService;
import cz.csob.ency.common.json.response.EncyJsonResponse;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.Map;

@Component(
        immediate = true,
        property = {
                "json.web.service.context.name=cdsdemand",
                "json.web.service.context.path=SemantaImports"
        },
        service = SemantaImportService.class
)
public class SemantaImportServiceImpl implements SemantaImportService
        // implements SemantaImportService
{
    private static final Log _log = LogFactoryUtil.getLog(SemantaImportServiceImpl.class);

    //  @Override
    @Override
    public EncyJsonResponse importDemands(
            boolean reimport, long limit, ServiceContext serviceContext)
            throws PortalException {

        if (!omniadmin.isOmniadmin(serviceContext.getUserId())) {
            return EncyJsonResponse.failure("You do not have permission to do this");
        }

        Map<String, Object> syncresult;
        try {
            syncresult = importDemands.importDemands(reimport, limit, serviceContext);
        } catch (Exception e) {
            _log.error(e);
            return EncyJsonResponse.failure(e);
        }
        Map<String, Object> result =
                HashMapBuilder.<String, Object>create(2)
                        .put("message", "sync-run-sucessfully")
                        .put("success", true)
                        .build();
        if (syncresult.containsKey("error")) {
            result.put("message", syncresult.get("error"));
            result.put("success", false);
        }

        return EncyJsonResponse.success("sync-run-sucessfully", "sync-run-sucessfully");
    }

    @Override
    public EncyJsonResponse importExUsers(ServiceContext serviceContext) {
        return importDemands.importExUsers(serviceContext) ?
                EncyJsonResponse.success("OK")
                : EncyJsonResponse.failure("NOK");
    }
    @Reference
    protected ImportDemands importDemands;
    @Reference
    Omniadmin omniadmin;

}
