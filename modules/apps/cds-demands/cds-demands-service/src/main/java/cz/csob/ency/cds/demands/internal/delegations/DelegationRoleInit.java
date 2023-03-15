package cz.csob.ency.cds.demands.internal.delegations;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.service.CompanyLocalService;
import com.liferay.portal.kernel.util.Validator;
import cz.csob.ency.delegations.model.DelegatedRole;
import cz.csob.ency.delegations.service.DelegatedRoleLocalService;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true)
public class DelegationRoleInit {
    private static final Log _log = LogFactoryUtil.getLog(DelegationRoleInit.class);

    @Activate
    public void activate() {
/*
        @todo how to add correct company and group id????

        Company company = companyLocalService.getCompanies().get(0);

        _checkRole(company,
                CdsDemandConstants.DELEGATION_ROLE_BAN_CODE,
                CdsDemandConstants.DELEGATION_ROLE_BAN_CODE,
                "Zástupy BANů v CDS požadavcích"
        );

        _checkRole(company,
                CdsDemandConstants.DELEGATION_ROLE_SPOC_CODE,
                CdsDemandConstants.DELEGATION_ROLE_SPOC_CODE,
                "Zástupy SPOC; v CDS požadavcích"
        );

 */
    }

    private void _checkRole(Company company, String code, String title, String description) {
        DelegatedRole role =
                delegatedRoleLocalService.fetchDelegatedRole(code);

        if (Validator.isNull(role)) {
            role = delegatedRoleLocalService.create();
            role.setTitle(title);
            role.setCode(code);
            role.setDescription(description);
            role = delegatedRoleLocalService.updateDelegatedRole(role);
        }

        if (role.getCompanyId() == 0) {
            role.setCompanyId(company.getCompanyId());
            try {
                role.setGroupId(company.getGroupId());
            } catch (PortalException e) {
                e.printStackTrace();
            }
            role = delegatedRoleLocalService.updateDelegatedRole(role);
        }
    }

    @Reference
    private CompanyLocalService companyLocalService;
    @Reference
    private DelegatedRoleLocalService delegatedRoleLocalService;
}
