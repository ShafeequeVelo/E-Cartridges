// =============================================================================
// File: WarehousePOKey.java
// Generated by JGen Code Generator from INTERSHOP Communications AG.
// Generator template: ORMKey.xpt(checksum: b5b09bf4e9329db7d7dafe870b159b0d)
// =============================================================================
// The JGen Code Generator software is the property of INTERSHOP Communications AG. 
// Any rights to use are granted under the license agreement.
// =============================================================================
package com.intershop.ts.component.warehouse.orm.internal;

import com.intershop.beehive.core.capi.domain.ExtensibleObjectPOKey;

/**
 * This class represents the primary key for objects of type WarehousePO. The
 * key objects can be used for lookup operations in the database.
 * 
 * @author root
 * 
 * @generated
 */
public class WarehousePOKey extends ExtensibleObjectPOKey
{
    /**
     * Useless constant to make compiler happy.
     * 
     * @generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * Creates an empty primary key. After creation of a new key object you must
     * call the corresponding set<i>Attribute</i> method(s) to set the value(s)
     * of the primary key.
     * 
     * @generated
     */
    public WarehousePOKey()
    {
    }

    /**
     * Creates a primary key with the specified value(s).
     * 
     * @generated
     */
    public WarehousePOKey(String UUID)
    {
        super(UUID);
    }

}