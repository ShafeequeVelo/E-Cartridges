package com.intershop.ts.component.warehouse.orm.internal;

import com.intershop.beehive.businessobject.capi.BusinessObjectExtension;
import com.intershop.component.repository.capi.AbstractDomainRepositoryBOExtensionFactory;
import com.intershop.component.repository.capi.RepositoryBO;
import com.intershop.ts.component.warehouse.capi.WarehouseBORepository;

public class ORMWarehouseBORepositoryImplFactory extends AbstractDomainRepositoryBOExtensionFactory
{

    @Override
    public BusinessObjectExtension<RepositoryBO> createExtension(RepositoryBO object)
    {
        return new ORMWarehouseBORepositoryImpl(WarehouseBORepository.EXTENSION_ID, object);
    }

    @Override
    public String getExtensionID()
    {
        return WarehouseBORepository.EXTENSION_ID;
    }

}
