package interfaces;

import dto.AttributeDto;
import entities.Attribute;

public interface AttributeService {

    Attribute add(String attributeName);

    AttributeDto getById(Long id);

    //TODO: check
    Attribute getEntityById(Long id);

}