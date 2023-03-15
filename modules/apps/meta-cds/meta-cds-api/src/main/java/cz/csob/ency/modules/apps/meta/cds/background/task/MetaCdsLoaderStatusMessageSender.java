package cz.csob.ency.modules.apps.meta.cds.background.task;

import aQute.bnd.annotation.ProviderType;

@ProviderType
public interface MetaCdsLoaderStatusMessageSender {
    void sendStatusMessage(String className, long count, long total);

}
