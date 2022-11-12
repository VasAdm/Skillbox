package com.example.MyBookShopApp.data;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "test_entities")
public class TestEntity
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String data;

	@Override
	public String toString()
	{
		return "TestEntity{" +
				"id=" + id +
				", data='" + data + '\'' +
				'}';
	}
}
