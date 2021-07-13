package com.ak.ds.services.interfaces;

import com.ak.ds.api.dto.AttributeDto;
import com.ak.ds.entities.Attribute;

public interface IAttributeService {

	Attribute addAttribute(String attributeName);
	public AttributeDto getAttributeById(Long id);
	public Attribute getAttributeEntityById(Long id);

}