package io.pivotal.inventory.job;

import com.github.javafaker.Faker;
import io.pivotal.inventory.domain.Catalog;
import io.pivotal.inventory.repository.CatalogRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class InventoryCreator implements CommandLineRunner {

    @Autowired
    private CatalogRepository catalogRepository;

    private final int MAX_RECORDS = 100;

    @Override
    public void run(String... args) throws Exception {
        log.info("Inventory Data getting created..");
        Faker faker = new Faker();
        catalogRepository.deleteAll();
        log.info("Cleared old catalog");

        for (int i = 0; i < MAX_RECORDS; i++) {
            Catalog catalog = new Catalog();
            catalog.setAvailable(faker.bool().bool());
            catalog.setProductCode(faker.code().ean8());
            catalog.setProductName(faker.medical().medicineName());
            catalog.setDescription(faker.medical().symptoms());
            catalogRepository.save(catalog);
        }
        log.info("Created new catalog");
    }
}
