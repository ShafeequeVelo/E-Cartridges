package com.intershop.ts.component.warehouse.pipelet.warehouse;

import com.intershop.beehive.core.capi.pipeline.Pipelet;
import com.intershop.beehive.core.capi.pipeline.PipeletExecutionException;
import com.intershop.beehive.core.capi.pipeline.PipelineDictionary;
import com.intershop.ts.component.warehouse.capi.WarehouseBO;
import com.intershop.ts.component.warehouse.capi.WarehouseBORepository;

public class GetWarehouseBOByID extends Pipelet
{

    @Override
    public int execute(PipelineDictionary dict) throws PipeletExecutionException 
    {        
        // lookup 'WarehouseBORepository' in pipeline dictionary
        WarehouseBORepository warehouseBORepository = dict.get("WarehouseBORepository");
        
        // lookup 'UUID' in pipeline dictionary
        String warehouseID = (String)dict.get("WarehouseID");
        if (null == warehouseID)
        {
            throw new PipeletExecutionException("Mandatory input parameter 'UUID' not available in pipeline dictionary.");
        }
        
        WarehouseBO warehouseBO = warehouseBORepository.getWarehouseBOByID(warehouseID);               
        
        if (warehouseBO != null)
        {                                  
            // store 'WarehouseBO' in pipeline dictionary
            dict.put("WarehouseBO", warehouseBO);
            return PIPELET_NEXT;
        }
        else
        {        
            return PIPELET_ERROR;
        }
    }
}
