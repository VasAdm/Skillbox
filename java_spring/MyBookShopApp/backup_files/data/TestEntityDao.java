package com.example.MyBookShopApp.data;

import org.springframework.stereotype.Repository;

@Repository
public class TestEntityDao extends AbstractHibernateDAO<TestEntity>{
	public TestEntityDao() {
		super();
		setClazz(TestEntity.class);
	}
}
