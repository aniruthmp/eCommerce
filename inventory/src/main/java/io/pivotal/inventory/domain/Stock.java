package io.pivotal.inventory.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Stock {

    @Id
    @GeneratedValue
    private Long id;

    private String productCode;
    private short stockRemaining;
}
