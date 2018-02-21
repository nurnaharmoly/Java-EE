package com.coderbd.thymeleafmongodbboot.controller;

import com.coderbd.thymeleafmongodbboot.model.Car;
import com.coderbd.thymeleafmongodbboot.repository.CarMongoRepository;
import com.coderbd.thymeleafmongodbboot.repository.CarSearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.expression.Lists;

import java.util.List;
import java.util.function.Predicate;


@Controller
public class CarController {

	@Autowired
	CarMongoRepository carRepository;
	
	@Autowired
	CarSearchRepository carSearchRepository;

	@RequestMapping("/index")
	public String home(Model model) {
		model.addAttribute("carList", carRepository.findAll());
		return "index";
	}

	@RequestMapping(value = "/addCar", method = RequestMethod.POST)
	public String addCar(@ModelAttribute Car car) {
		carRepository.save(car);
		return "redirect:index";
	}
	
	@RequestMapping(value = "/search")
	public String search(Model model, @RequestParam String search) {
		model.addAttribute("carList", carSearchRepository.searchCars(search));
		model.addAttribute("search", search);
		return "index";
	}


}

