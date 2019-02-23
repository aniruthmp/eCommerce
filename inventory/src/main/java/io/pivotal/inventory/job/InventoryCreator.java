package io.pivotal.inventory.job;

import com.github.javafaker.Faker;
import io.pivotal.inventory.domain.Catalog;
import io.pivotal.inventory.domain.Stock;
import io.pivotal.inventory.repository.CatalogRepository;
import io.pivotal.inventory.repository.StockRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class InventoryCreator implements CommandLineRunner {

    @Autowired
    private CatalogRepository catalogRepository;
    @Autowired
    private StockRepository stockRepository;

    private final int MAX_RECORDS = 10;

    @Override
    public void run(String... args) throws Exception {
        log.info("Stock Data getting created..");
        Faker faker = new Faker();

        catalogRepository.deleteAll();
        log.info("Cleared old catalog");
        stockRepository.deleteAll();
        log.info("Cleared old stock");

        for (int i = 0; i < MAX_RECORDS; i++) {
            Catalog catalog = new Catalog();
            catalog.setAvailable(faker.bool().bool());
            catalog.setProductCode(faker.code().ean8());
            catalog.setProductName(faker.medical().medicineName());
            catalog.setDescription(faker.medical().symptoms());
            catalogRepository.save(catalog);

            Stock stock = new Stock();
            stock.setProductCode(catalog.getProductCode());
            stock.setStockRemaining((short) faker.number().numberBetween(0, 100));
            stockRepository.save(stock);
        }
        log.info("Created new catalog");
    }
}
