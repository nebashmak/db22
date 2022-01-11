package com.ChaoticChaotic.db2;

import com.ChaoticChaotic.db2.entity.Items;
import com.ChaoticChaotic.db2.entity.Shipping;
import com.ChaoticChaotic.db2.entity.Town;
import com.ChaoticChaotic.db2.repository.ItemsRepository;
import com.ChaoticChaotic.db2.repository.ShippingsRepository;
import com.ChaoticChaotic.db2.repository.TownsRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import java.time.LocalDate;


@SpringBootApplication
public class Db2Application {


	public static void main(String[] args) {
		SpringApplication.run(Db2Application.class, args);
	}


	@Bean
	CommandLineRunner commandLineRunner(ItemsRepository itemsRepository,
										ShippingsRepository shippingsRepository,
										TownsRepository townsRepository) {
		return args -> {

			Items item1 = new Items("Fork", 156L);
			Items item2 = new Items("Scoop", 1563L);
			itemsRepository.save(item1);
			itemsRepository.save(item2);
			Town town1 = new Town("Moscow",850L);
			Town town2 = new Town("Kazan",400L);
			townsRepository.save(town1);
			townsRepository.save(town2);
			LocalDate date = LocalDate.now();
			LocalDate date2 = LocalDate.of(2021,12,21);
			Shipping shipping1 = new Shipping(date,date2,town1,item1);
			Shipping shipping2 = new Shipping(date,date2,town2,item2);
			shippingsRepository.save(shipping1);
			shippingsRepository.save(shipping2);
		};
	}

}


