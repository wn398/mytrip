package com.trip.util;

import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class expotDB {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//Ĭ�϶�ȡhibernate.cfg.xml�ļ�
		Configuration cfg=new Configuration().configure();
		SchemaExport se=new SchemaExport(cfg);
		se.create(true, true);

	}

}
