package com.trip.service;

import java.util.List;

import com.trip.bean.Micro_wish;

public interface Micro_wish_service {
	
	
	   public void saveMicro_wish(Micro_wish micro_wish);//����
		
		public void removeMicro_wish(Micro_wish micro_wish);//ɾ��
		
		public List<Micro_wish> allMicro_wish();//��������
		
		public Micro_wish findMicro_wishById(int id);//����
		
		public void updateMicro_wish(Micro_wish micro_wish);//����

}
