package interfaces;

import dto.AttributeDto;
import entities.Attribute;

public interface AttributeService {

    AttributeDto add(AttributeDto attributeDto);

    AttributeDto getById(Long id);

    Attribute getEntityById(Long id);

    AttributeDto getElseAdd(AttributeDto attributeDto);
}