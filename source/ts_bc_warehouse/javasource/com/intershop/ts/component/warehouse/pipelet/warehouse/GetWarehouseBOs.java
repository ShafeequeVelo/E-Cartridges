package com.intershop.ts.component.warehouse.pipelet.warehouse;

import java.util.Collection;
import com.intershop.beehive.core.capi.pipeline.Pipelet;
import com.intershop.beehive.core.capi.pipeline.PipeletExecutionException;
import com.intershop.beehive.core.capi.pipeline.PipelineDictionary;
import com.intershop.ts.component.warehouse.capi.WarehouseBO;
import com.intershop.ts.component.warehouse.capi.WarehouseBORepository;

/**
 * Gets all warehouses of the selected site.
 */ 
public class GetWarehouseBOs extends Pipelet {

 
    @Override
    public int execute(PipelineDictionary dict) throws PipeletExecutionException 
    
    {         
        WarehouseBORepository warehouseBORepository = dict.getRequired("WarehouseBORepository");
        Collection<WarehouseBO> warehouseBOs = warehouseBORepository.getWarehouseBOs();
        
        dict.put("WarehouseBOs", warehouseBOs);

        return PIPELET_NEXT;
    }
}