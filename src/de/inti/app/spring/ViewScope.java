package de.inti.app.spring;

import org.springframework.beans.factory.config.Scope;
import org.springframework.beans.factory.ObjectFactory;

import javax.faces.context.FacesContext;
import java.util.Map;

public class ViewScope implements Scope {

	public Object get(String name, ObjectFactory objectFactory) {
        Map<String, Object> viewMap = getViewMap();
        Object bean = viewMap.get(name);
        if (bean == null) {
            bean = objectFactory.getObject();
            viewMap.put(name, bean);
        }
        return bean;
    }

    public Object remove(String name) {
        Map<String, Object> viewMap = getViewMap();
        Object bean = viewMap.get(name);
        if (bean != null) {
            viewMap.remove(name);
        }
        return bean;
    }

    public void registerDestructionCallback(String name, Runnable callback) {
        // Not implemented yet (optional method)
    }

    public String getConversationId() {
        return null;
    }

    public Object resolveContextualObject(String s) {
        return null;
    }

    private Map<String, Object> getViewMap() {
        return FacesContext.getCurrentInstance().getViewRoot().getViewMap();
    }
}
