package cz.csob.ency.modules.e3.app.service;

import cz.csob.ency.modules.e3.app.model.E3App;
import cz.csob.ency.modules.e3.entry.model.E3Entry;
import org.osgi.annotation.versioning.ProviderType;

import java.util.Map;
import java.util.Set;

@ProviderType
public interface E3AppLocalService {
    E3App getApp(String clazz);

    E3App getApp(E3Entry entry);

    Map<String, Object> getAppRenderContext(String appClassName);

    Map<String, Object> getAppRenderContext(E3Entry entry);

    Set<E3App> getApps();

    Set<String> getAppsClassNames();

    E3App getFallbackApp();

    boolean isEntryApproved(E3Entry entry);
}
