package com.trip.service.Impl;

import java.util.List;

import com.trip.DAO.Micro_wish_Dao;
import com.trip.bean.Micro_wish;
import com.trip.service.Micro_wish_service;

public class Micro_wish_service_Impl implements Micro_wish_service {

	
	
	
	 private Micro_wish_Dao  micro_wish_dao;
		
		
		public Micro_wish_Dao getMicro_wish_dao() {
			return micro_wish_dao;
		}

		public void setMicro_wish_dao(Micro_wish_Dao micro_wish_Dao) {
			micro_wish_dao = micro_wish_Dao;
		}

		public void removeMicro_wish(Micro_wish micro_wish) {
			this.micro_wish_dao.removeMicro_wish(micro_wish);

		}

		public void saveMicro_wish(Micro_wish micro_wish) {
			this.micro_wish_dao.savaMicro_wish(micro_wish);

		}

		 public List<Micro_wish> allMicro_wish() {
		
			return this.micro_wish_dao.allMicro_wish();
			
			
		}

		public Micro_wish findMicro_wishById(int id) {
			return this.micro_wish_dao.findMicro_wishByID(id);
		}

		
		public void updateMicro_wish(Micro_wish micro_wish) {
			this.micro_wish_dao.updateMicro_wish(micro_wish);
		}
}
