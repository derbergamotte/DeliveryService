package com.ak.ds.services.implement;

import java.util.HashSet;
import java.util.Optional;

import com.ak.ds.api.dto.AttributeDto;
import com.ak.ds.api.mappers.AttributeMapper;
import com.ak.ds.dao.factory.DaoFactory;
import com.ak.ds.dao.factory.IDaoFactory;
import com.ak.ds.dao.interfaces.IAttributeDao;
import com.ak.ds.entities.Attribute;
import com.ak.ds.entities.Product;
import com.ak.ds.services.interfaces.IAttributeService;

public class AttributeService implements IAttributeService {

	private AttributeService() {
	}

	private static IAttributeService attributeService;

	public static IAttributeService getAttributeService() {
		if (attributeService == null) {
			attributeService = new AttributeService();
		}
		return attributeService;
	}

	private IDaoFactory daoFactory = new DaoFactory();
	private IAttributeDao attributeDao = daoFactory.getAttributeDao();

	public Attribute addAttribute(String attributeName) {
		Attribute attribute = attributeDao.getAttrbuteByName(attributeName);
		if (attribute.getId() == null) {
			attribute = attributeDao.add(new Attribute(attributeName, new HashSet<Product>()));
		}
		return attribute;
	}
	
	public AttributeDto getAttributeById(Long id) {
		return AttributeMapper.entityToDto(getAttributeEntityById(id));
	}
	
	public Attribute getAttributeEntityById(Long id) {
		return Optional.ofNullable(Optional.ofNullable(this.attributeDao.get(id)).orElse(new Attribute())).get();
	}
}
