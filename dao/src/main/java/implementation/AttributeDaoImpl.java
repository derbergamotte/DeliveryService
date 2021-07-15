package implementation;

import entities.Attribute;
import interfaces.AttributeDao;

public class AttributeDaoImpl extends GenericDaoImpl<Attribute> implements AttributeDao {

    private AttributeDaoImpl() {
        super(Attribute.class);
    }

    private static AttributeDaoImpl attributeDao;

    public static AttributeDao getAttributeDao() {
        if (attributeDao == null) {
            attributeDao = new AttributeDaoImpl();
        }
        return attributeDao;
    }

    public Attribute getAttrbuteByName(String attributeName) {
        Attribute attribute = new Attribute();
        for (Attribute attr : getAll()) {
            if (attr.getName().equals(attributeName)) {
                attribute = attr;
            }
        }
        return attribute;
    }
}
