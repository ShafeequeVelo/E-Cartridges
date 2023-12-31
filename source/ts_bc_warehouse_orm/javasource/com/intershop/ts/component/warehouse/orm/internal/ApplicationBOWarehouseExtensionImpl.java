package com.intershop.ts.component.warehouse.orm.internal;

import com.intershop.beehive.businessobject.capi.AbstractBusinessObjectExtension;
import com.intershop.beehive.businessobject.capi.MissingExtensionException;
import com.intershop.component.application.capi.ApplicationBO;
import com.intershop.component.product.capi.ProductBORepository;
import com.intershop.ts.component.warehouse.capi.ApplicationBOWarehouseExtension;
import com.intershop.ts.component.warehouse.capi.WarehouseBORepository;

public class ApplicationBOWarehouseExtensionImpl extends AbstractBusinessObjectExtension<ApplicationBO> implements
                ApplicationBOWarehouseExtension
{

    public ApplicationBOWarehouseExtensionImpl(String extensionID, ApplicationBO extendedObject)
    {
        super(extensionID, extendedObject);
    }

    @Override
    public WarehouseBORepository getBoRepository(String repositoryID)
    {
        WarehouseBORepository repository = (WarehouseBORepository)((ApplicationBO)getExtendedObject()).getRepository(
                        WarehouseBORepository.class, repositoryID);
        if (null == repository)
        {
            throw new MissingExtensionException("repository " + WarehouseBORepository.class + " not found for domain: "+ repositoryID);
        }
        return repository;
    }

}
