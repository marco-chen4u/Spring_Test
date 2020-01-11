package com.marco.petclinic.model;

import java.io.Serializable;

public class BaseEntity implements Serializable {
    // field
    private Long id;

    // constructor
    public BaseEntity(Long id) {
        this.id = id;
    }

    public BaseEntity() {
    }

    // methods
    public boolean isNew() {
        return id == null;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
