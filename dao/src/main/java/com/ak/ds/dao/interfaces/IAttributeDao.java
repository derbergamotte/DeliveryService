package com.ak.ds.dao.interfaces;

import com.ak.ds.entities.Attribute;

public interface IAttributeDao extends IAGenericDao<Attribute>{

	Attribute getAttrbuteByName(String attributeName);
}
