package io.pivotal.inventory.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "catalog")
@Data
public class Catalog {

    @Id
    @GeneratedValue
    private Long id;

    private String productCode;
    private String productName;
    private String description;
    private boolean isAvailable;

}
