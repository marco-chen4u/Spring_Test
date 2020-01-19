package com.marco.petclinic.utils.impl;

import com.marco.petclinic.utils.Model;

import java.util.HashMap;
import java.util.Map;

public class ModelMapImpl implements Model {
    // field
    private Map<String, Object> map = new HashMap<>();

    @Override
    public void addAttribute(String key, Object object) {
        map.put(key, object);
    }

    @Override
    public void addAttribute(Object o) {
        // do nothing
    }
}
