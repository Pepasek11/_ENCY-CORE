package cz.csob.ency.e3.common.js.internal.importmap;


import com.liferay.frontend.js.importmaps.extender.JSImportmapsContributor;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.json.JSONFactory;
import com.liferay.portal.kernel.json.JSONObject;

import javax.servlet.ServletContext;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;


@Component(immediate = true, service = JSImportmapsContributor.class)
public class E3CommonJSJSImportmapsContributor implements JSImportmapsContributor {

    @Override
    public JSONObject getImportmapsJSONObject() {
        return _importmapsJSONObject;
    }

    @Activate
    protected void activate() {
        _importmapsJSONObject = _jsonFactory.createJSONObject();

        String contextPath = _servletContext.getContextPath();

        for (String moduleName : _MODULE_NAMES) {
            _importmapsJSONObject.put(
                    moduleName,
                    StringBundler.concat(
                            contextPath, "/__liferay__/amd2esm/", moduleName, ".js"));
        }
    }

    private static final String[] _MODULE_NAMES = {
            "axios","react-select","react-router","react-router-dom",
            "@material-ui/core", "@material-ui/lab","@material-ui/icons",
            "@material-ui/styles","@material-ui/system","@material-ui/utils",
            "mui-datatables"

    };

    private JSONObject _importmapsJSONObject;

    @Reference
    private JSONFactory _jsonFactory;

    @Reference(
            target = "(osgi.web.symbolicname=cz.csob.ency.e3.common.js)",
            unbind = "-"
    )
    private ServletContext _servletContext;

}