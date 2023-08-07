package com.intershop.ts.component.warehouse.pipelet.warehouse;

import com.intershop.beehive.core.capi.pipeline.Pipelet;
import com.intershop.beehive.core.capi.pipeline.PipeletExecutionException;
import com.intershop.beehive.core.capi.pipeline.PipelineDictionary;
import com.intershop.ts.component.warehouse.capi.WarehouseBO;
import com.intershop.ts.component.warehouse.capi.WarehouseBORepository;

public class RemoveWarehouseBO extends Pipelet
{

    @Override
    public int execute(PipelineDictionary dict) throws PipeletExecutionException 
    {        
        // lookup 'WarehouseBORepository' in pipeline dictionary
        WarehouseBORepository warehouseBORepository = dict.getRequired("WarehouseBORepository");
        
        // lookup 'WarehouseBO' in pipeline dictionary
        WarehouseBO warehouseBO = (WarehouseBO)dict.get("WarehouseBO");
        if (null == warehouseBO)
        {
            throw new PipeletExecutionException("Mandatory input parameter 'Warehouse' not available in pipeline dictionary.");
        }
        
        warehouseBORepository.removeWarehouseBO(warehouseBO.getID());

        return PIPELET_NEXT;
    }


}