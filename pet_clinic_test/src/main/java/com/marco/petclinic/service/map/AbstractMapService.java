package com.marco.petclinic.service.map;

import com.marco.petclinic.model.BaseEntity;
import org.apache.commons.lang3.RandomUtils;

import java.util.*;

public class AbstractMapService<T extends BaseEntity, ID extends Long> {
    // field
    private final static long DEFAULT_VALUE = RandomUtils.nextLong();
    protected Map<Long, T> map = new HashMap<>();

    Set<T> findAll() {
        return new HashSet<>(map.values());
    }

    T findById(ID id) {
        return map.get(id);
    }

    void deleteById(ID id) {
        map.remove(id);
    }

    void delete(T object) {
        map.entrySet().removeIf(entry -> entry.getValue().equals(object));
    }

    T save(T object) {
        if (object != null) {

            if (object.getId() == null) {
                object.setId(getNextId());
            }

            map.put(object.getId(), object);
        }
        else {
            throw new RuntimeException("Object can not be null");
        }

        return object;
    }

    // helper method
    private Long getNextId() {
        Long nextId = null;

        try{
            nextId = Collections.max(map.keySet()) + 1;
        }
        catch (NoSuchElementException e) {
            nextId = DEFAULT_VALUE;
        }

        return nextId;
    }
}
