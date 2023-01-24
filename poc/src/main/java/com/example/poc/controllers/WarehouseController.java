package com.example.poc.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.poc.entites.Warehouses;
import com.example.poc.repositories.WarehouseRepository;

@RestController
@RequestMapping("warehouses")
@CrossOrigin(origins = "http://localhost:4200")
public class WarehouseController {
	/**
	 * Crud repository for Warehouses.
	 */
	@Autowired
	private WarehouseRepository repo;

	/**
	 * @param id The entity's primary key.
	 * @throws Exception When id does not correspond to any existing entity.
	 */
	@GetMapping("/{id}")
	public Warehouses get(@PathVariable Long id) throws ResponseStatusException {
		if (id <= 0) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid identifier");
		}
		Optional<Warehouses> res = this.repo.findById(id);
		if (!res.isPresent()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Non-existing entity");
		}
		return res.get();
	}

	/**
	 * @return
	 */
	@GetMapping
	public List<Warehouses> get() {
		List<Warehouses> res = repo.findAll();
		return res;
	}

	/**
	 * @param Warehouse Entity to create.
	 * @return Created Warehouse.
	 * @throws Exception When the provided entity isn't valid for creation.
	 */
	@PostMapping
	public Warehouses post(@RequestBody Warehouses warehouse) throws ResponseStatusException {
		if (warehouse == null || warehouse.getId() == null || warehouse.getId() != 0) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid identifier");
		}
		Warehouses res = repo.saveAndFlush(warehouse);
		return res;
	}

	/**
	 * @param Warehouse Entity to modify (warehouse_id excluded)
	 * @return Modified Warehouse.
	 * @throws Exception When the provided entity isn't valid for creation.
	 */
	@PatchMapping
	public Warehouses patch(@RequestBody Warehouses warehouse) throws ResponseStatusException {
		if (warehouse == null || warehouse.getId() == null || warehouse.getId() == 0) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid identifier");
		}
		Warehouses res = repo.saveAndFlush(warehouse);
		return res;
	}
}
