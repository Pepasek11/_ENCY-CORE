package cz.csob.ency.cds.demands.configuration;

import com.liferay.configuration.admin.category.ConfigurationCategory;
import org.osgi.service.component.annotations.Component;

@Component(service = ConfigurationCategory.class)
public class CdsDemandsConfigurationCategory
        implements ConfigurationCategory {

    @Override
    public String getCategoryIcon() {
        return "shopping-cart";
    }

    @Override
    public String getCategoryKey() {
        return "cdsdemands";
    }

    @Override
    public String getCategorySection() {
        return "other";
    }

}