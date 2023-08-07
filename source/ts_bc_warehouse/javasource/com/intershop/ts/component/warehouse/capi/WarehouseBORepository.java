package com.intershop.ts.component.warehouse.capi;

import java.util.Collection;

import com.intershop.beehive.businessobject.capi.BusinessObjectRepository;
import com.intershop.component.product.capi.ProductBO;

public interface WarehouseBORepository extends BusinessObjectRepository
{
    static final String EXTENSION_ID = "WarehouseBORepository";
    WarehouseBO createWarehouseBO(String name);
    void removeWarehouseBO(String id);
    WarehouseBO getWarehouseBOByName(String name);
    WarehouseBO getWarehouseBOByID(String id);
    Collection<WarehouseBO> getWarehouseBOs();
    int getProductStockCount(ProductBO productBO);
    WarehouseBO getWarehouseBOBYProductID(String productID);
   

}