package com.intershop.ts.component.warehouse.capi;

import com.intershop.beehive.businessobject.capi.BusinessObjectExtension;
import com.intershop.component.application.capi.ApplicationBO;

public interface ApplicationBOWarehouseExtension extends BusinessObjectExtension<ApplicationBO>
{
    public WarehouseBORepository getBoRepository(String repositoryID);
}
