package com.marco.petclinic.utils.impl;

import com.marco.petclinic.utils.Model;

import java.util.HashMap;
import java.util.Map;

public class ModelImpl implements Model {
    // fields
    private Map<String, Object> attributeMap;
    public ModelImpl() {
        this.attributeMap = new HashMap<>();
    }

    @Override
    public void addAttribute(String key, Object object) {
        this.attributeMap.put(key, object);
    }

    @Override
    public void addAtrribute(Object object) {
        this.attributeMap.put(object.toString(), object);
    }

    public Map<String, Object> getAttributeMap() {
        return attributeMap;
    }
}
