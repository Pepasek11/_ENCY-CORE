package cz.csob.ency.cds.demands.configuration;


import aQute.bnd.annotation.metatype.Meta;
import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

@ExtendedObjectClassDefinition(category = "cdsdemands")
@Meta.OCD(
        id = "cz.csob.ency.cds.demands.configuration.CdsDemandsConfiguration",
        localization = "content/Language",
        name = "cds-demands-configuration-name"
)
public interface CdsDemandsConfiguration {
    @Meta.AD(
            deflt = "", name = "history-router-base-path", required = false
    )
    public String historyRouterBasePath();

    @Meta.AD(
            deflt = "jpg,png,gif,doc,docx,xls,xlsx,xlsm,pdf,ppt,pptx,csv",
            name = "allowed-attachments-file-extensions",
            required = false
    )
    public String[] allowedAttachmentsFileExtensions();

    @Meta.AD(
            deflt = "10", name = "max-attachment-size-mb", required = false
    )
    public long maxAttachmentSize();

    @Meta.AD(deflt = "JA21726", name = "us-default-ban-user-config", required = false)
    public String defaultBanUserScreenName();
}
