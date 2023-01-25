package com.example.poc.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.poc.entites.Racks;
import com.example.poc.repositories.RackRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("racks")
public class RackController {

	/**
	 * Crud repository for Racks.
	 */
	@Autowired
	private RackRepository repo;

	/**
	 * @param id The entity's primary key.
	 * @throws Exception When id does not correspond to any existing entity.
	 */
	@GetMapping("/{id}")
	public Racks get(@PathVariable int id) throws ResponseStatusException {
		if (id <= 0) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid identifier");
		}
		Optional<Racks> res = this.repo.findById(id);
		if (!res.isPresent()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Non-existing entity");
		}
		return res.get();
	}

	/**
	 * @return
	 */
	@GetMapping
	public List<Racks> get() {
		List<Racks> res = repo.findAll();
		return res;
	}

	/**
	 * @param rack Entity to create.
	 * @return Created Rack.
	 * @throws Exception When the provided entity isn't valid for creation.
	 */
	@PostMapping
	public Racks post(@RequestBody Racks rack) throws ResponseStatusException {
		if (rack == null || rack.getId() != 0) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid entity");
		}
		Racks res = repo.saveAndFlush(rack);
		return res;
	}

	/**
	 * @param rack Entity to modify (warehouse_id excluded)
	 * @return Modified Rack.
	 * @throws Exception When the provided entity isn't valid for creation.
	 */
	@PutMapping
	public Racks put(@RequestBody Racks rack) throws ResponseStatusException {
		if (rack == null || rack.getId() == 0) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid entity");
		}
		Racks res = repo.saveAndFlush(rack);
		return res;
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) throws ResponseStatusException {
		if (id <= 0) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid identifier");
		}
		repo.deleteById(id);
		return;
	}

	@GetMapping("/warehouse/{id}")
	public List<Racks> getByWarehouse(@PathVariable int id) throws ResponseStatusException {
		if (id <= 0) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid identifier");
		}
		List<Racks> res = this.repo.findByWarehouseId(id);
		return res;
	}
}
