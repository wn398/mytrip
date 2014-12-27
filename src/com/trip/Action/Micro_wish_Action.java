package com.trip.Action;

import com.opensymphony.xwork2.ActionSupport;
import com.trip.bean.Micro_wish;
import com.trip.service.Micro_wish_service;

@SuppressWarnings("serial")
public class Micro_wish_Action extends ActionSupport {
	
	private Micro_wish micro_wish;
	
	private Micro_wish_service micro_wish_service;

	public Micro_wish getMicro_wish() {
		return micro_wish;
	}

	public void setMicro_wish(Micro_wish microWish) {
		micro_wish = microWish;
	}

	public Micro_wish_service getMicro_wish_service() {
		return micro_wish_service;
	}

	public void setMicro_wish_service(Micro_wish_service microWishService) {
		micro_wish_service = microWishService;
	}

}
