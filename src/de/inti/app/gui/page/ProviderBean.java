package de.inti.app.gui.page;

import de.inti.app.domain.Provider;
import de.inti.app.gui.util.GuiUtil;
import de.inti.app.service.ProviderService;
import org.springframework.context.annotation.Scope;

import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.Min;

@Named("providerBean")
@Scope("view")
public class ProviderBean {

    @Inject
    private ProviderService providerService;

    @Min(value = 0)
    private long id;
    private Provider provider;

    public String loadProvider() {
        provider = providerService.findById(id);
        if (provider == null) {
            GuiUtil.addErrorMessage("error_non_existing_provider", id);
        }
        return null;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Provider getProvider() {
        return provider;
    }

    public String save() {
        return "showProvider?faces-redirect=true&includeViewParams=true";
    }

    @SuppressWarnings("UnusedDeclaration")
    public void setProviderService(ProviderService providerService) {
        this.providerService = providerService;
    }

}
