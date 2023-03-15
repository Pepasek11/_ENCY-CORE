package cz.csob.ency.cds.demands.cst.service.impl;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.HashMapBuilder;
import cz.csob.ency.cds.demands.cst.service.CstService;
import cz.csob.ency.common.json.response.EncyJsonResponse;
import cz.csob.ency.connection.sql.SqlUtils;
import org.osgi.service.component.annotations.Component;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Component(
        immediate = true,
        property = {
                "json.web.service.context.name=cdsdemand",
                "json.web.service.context.path=cst"
        },
        service = CstService.class
)
public class CstServiceImpl implements CstService {
    private static final Log _log = LogFactoryUtil.getLog(
            CstServiceImpl.class);

    @Override
    public EncyJsonResponse getGdprCategoryOptions() {
        try {
            List<Map<String, Object>> rows = SqlUtils.executeSelect("cst",
                    " SELECT\n" +
                            "[C2050_CODE] as value\n" +
                            ",[C2050_TITLE_CS] as title\n" +
                            "FROM [CSOB_C2050_v1]\n" +
                            "WHERE [C2050_ValidTo] is NULL\n"
            );

            return EncyJsonResponse.success(_rowsToOptions(rows, "value", "title"));

        } catch (Exception ex) {
            return EncyJsonResponse.failure(ex);
        }
    }

    @Override
    public EncyJsonResponse getGdprReasoningOptions() {
        try {
            List<Map<String, Object>> rows = SqlUtils.executeSelect("cst",
                    " SELECT \n" +
                            "[C2049_CODE] as value\n" +
                            ",[C2049_TITLE_CS] as title\n" +
                            "FROM [CSOB_C2049_v1]\n" +
                            "WHERE [C2049_ValidTo] is NULL"
            );

            return EncyJsonResponse.success(_rowsToOptions(rows, "value", "title"));

        } catch (Exception ex) {
            return EncyJsonResponse.failure(ex);
        }
    }

    private List<Map<String, String>> _rowsToOptions(List<Map<String, Object>> rows, String valCol, String titleCol) {
        List<Map<String, String>> result = new LinkedList<>();
        for (Map<String, Object> row : rows) {
            result.add(
                    HashMapBuilder
                            .<String, String>put("value", String.valueOf(row.get(valCol)))
                            .put("label", row.get(valCol) + " - " + row.get(titleCol))
                            .build()
            );
        }
        return result;
    }
}
