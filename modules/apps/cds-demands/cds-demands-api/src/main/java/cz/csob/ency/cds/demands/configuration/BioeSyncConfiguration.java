package cz.csob.ency.cds.demands.configuration;


import aQute.bnd.annotation.metatype.Meta;
import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

@ExtendedObjectClassDefinition(category = "cdsdemands")
@Meta.OCD(
        id = "cz.csob.ency.cds.demands.configuration.BioeSyncConfiguration",
        localization = "content/Language",
        name = "cds-demands-bioe-sync-configuration-name"
)
public interface BioeSyncConfiguration {
    @Meta.AD(deflt = "false", name = "sync-enabled", required = false)
    public boolean syncEnabled();

    @Meta.AD(deflt = "10", name = "sync-interval", required = false)
    public int checkInterval();
}
