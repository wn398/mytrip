package com.trip.DAO;

import java.util.List;

import com.trip.bean.Micro_wish;

public interface Micro_wish_Dao {
	
    public void removeMicro_wish(Micro_wish micro_wish);//�����ݿ�ɾ��ĳ��΢��Ը
	
	public void savaMicro_wish(Micro_wish micro_wish);//��΢��Ը���뵽���ݿ���
	
	public List<Micro_wish> allMicro_wish();//�����ݿ��в�ѯ������΢��Ը��Ϣ
	
	public Micro_wish findMicro_wishByID(int id);//����΢��ԸID��ѯ΢��Ը
	
	public void updateMicro_wish(Micro_wish micro_wish);//����΢��Ը��Ϣ


}
