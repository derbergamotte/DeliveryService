package com.ak.ds.dao.implement;

import com.ak.ds.dao.interfaces.IAttributeDao;
import com.ak.ds.entities.Attribute;

public class AttributeDao extends AGenericDao<Attribute> implements IAttributeDao{

	private AttributeDao() {
		super(Attribute.class);
	}
	
	private static AttributeDao attributeDao;
	
	public static IAttributeDao getAttributeDao() {
		if (attributeDao == null) {
			attributeDao = new AttributeDao();
		}
		return attributeDao;
	}
	
	public Attribute getAttrbuteByName(String attributeName) {
		Attribute attribute = new Attribute();
		for(Attribute attr : getAll()) {
			if(attr.getName().equals(attributeName)) {
				attribute = attr;
			}
		}
		return attribute;
	}
}
