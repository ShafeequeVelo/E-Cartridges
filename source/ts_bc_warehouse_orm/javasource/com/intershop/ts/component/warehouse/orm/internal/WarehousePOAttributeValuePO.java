// =============================================================================
// File: WarehousePOAttributeValuePO.java
// Generated by JGen Code Generator from INTERSHOP Communications AG.
// Generator template: ORMClass.xpt(checksum: 954aa2b015f6a59dd69d1cff59c8d023)
// =============================================================================
// The JGen Code Generator software is the property of INTERSHOP Communications AG. 
// Any rights to use are granted under the license agreement. 
// =============================================================================
package com.intershop.ts.component.warehouse.orm.internal;

import com.intershop.beehive.core.capi.domain.AttributeValuePO;
import com.intershop.beehive.orm.capi.common.ORMObjectFactory;
import com.intershop.beehive.orm.capi.description.RelationDescription;

/**
 * @generated
 */
public class WarehousePOAttributeValuePO extends AttributeValuePO
{

    /**
     * @generated
     */
    public static RelationDescription ownerRelation = null;

    /**
     * The constructor.
     * 
     * @generated
     */
    public WarehousePOAttributeValuePO(ORMObjectFactory factory, WarehousePOAttributeValuePOKey key)
    {
        super(factory, key);
    }

    /**
     * Returns the name of the factory that manages this type of objects. The
     * name can be used to lookup the factory from the NamingMgr.
     * 
     * @return the factory name
     * @generated
     */
    public String getFactoryName()
    {
        return getClass().getName();
    }

    /**
     * Loads the state of the object from the database.
     * 
     * @deprecated use refresh now
     * @generated
     */
    public void load()
    {
        refresh();
    }

    /**
     * This hook is called whenever the bean has been modified.
     * 
     * @generated modifiable
     */
    public void onChange()
    {
        // {{ bean_onchange
        // put your custom onChange code here
        // }} bean_onchange

        super.onChange();
    }

    /**
     * Returns the object for the relation 'owner'.
     * <p>
     * The relation to the owning extensible object.
     * 
     * @return the object for the relation 'owner'
     * @generated
     */
    public WarehousePO getOwner()
    {
        return (WarehousePO)getRelatedObject(ownerRelation);
    }

}