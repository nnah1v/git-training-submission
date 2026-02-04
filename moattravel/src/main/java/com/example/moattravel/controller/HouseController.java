package com.example.moattravel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.moattravel.repository.HouseRepository;

@Controller
@RequestMapping("/houses")
public class HouseController {
	private final HouseRepository houseRepository;

	public HouseController(HouseRepository houseRepository) {
		this.houseRepository = houseRepository;
	}

}
