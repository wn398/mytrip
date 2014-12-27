package com.trip.service;

import java.util.List;

import com.trip.bean.Micro_wish;

public interface Micro_wish_service {
	
	
	   public void saveMicro_wish(Micro_wish micro_wish);//保存
		
		public void removeMicro_wish(Micro_wish micro_wish);//删除
		
		public List<Micro_wish> allMicro_wish();//返回所有
		
		public Micro_wish findMicro_wishById(int id);//查找
		
		public void updateMicro_wish(Micro_wish micro_wish);//更新

}
