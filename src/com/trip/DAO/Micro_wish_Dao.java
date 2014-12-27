package com.trip.DAO;

import java.util.List;

import com.trip.bean.Micro_wish;

public interface Micro_wish_Dao {
	
    public void removeMicro_wish(Micro_wish micro_wish);//从数据库删除某个微心愿
	
	public void savaMicro_wish(Micro_wish micro_wish);//将微心愿存入到数据库中
	
	public List<Micro_wish> allMicro_wish();//从数据库中查询出所有微心愿信息
	
	public Micro_wish findMicro_wishByID(int id);//按照微心愿ID查询微心愿
	
	public void updateMicro_wish(Micro_wish micro_wish);//更新微心愿信息


}
