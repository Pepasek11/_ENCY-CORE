package cz.csob.ency.modules.e3.app.impl;

import cz.csob.ency.modules.e3.app.annotation.E3AppDef;
import cz.csob.ency.modules.e3.app.model.E3AppBaseImpl;
import org.osgi.service.component.annotations.Component;

@Component(
        immediate = true,
        service = E3AppBaseImpl.class
)
@E3AppDef(
        name = "Fallback Application",
        fields = {}
)
public class FallbackApp extends E3AppBaseImpl {

    @Override
    public String getAppMainPortletName() {
        return null;
    }
}
