package com.laptrinhjavaweb.api.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.laptrinhjavaweb.dto.NewDTO;
import com.laptrinhjavaweb.entity.NewEntity;
import com.laptrinhjavaweb.repository.NewRepository;
import com.laptrinhjavaweb.service.INewService;

@RestController(value = "newAPIOfAdmin")
public class NewAPI {
	
	@Autowired
	private INewService newService;
	
	@Autowired
	private NewRepository repository;
	
	@PostMapping("/api/new")
	public NewDTO createNew(@RequestBody NewDTO newDTO) {
		return newService.save(newDTO);
	}
	
//	@PutMapping("/api/new")
//	public NewDTO updateNew(@RequestBody NewDTO updateNew) {
//		return newService.save(updateNew);
//	}
//	
	@PutMapping("/api/new")
	public NewEntity updateNewTest(@RequestBody NewDTO updateNew) {
		return repository.findOne(updateNew.getId());
	}
	
	@DeleteMapping("/api/new")
	public void deleteNew(@RequestBody long[] ids) {
		newService.delete(ids);
	}
}
