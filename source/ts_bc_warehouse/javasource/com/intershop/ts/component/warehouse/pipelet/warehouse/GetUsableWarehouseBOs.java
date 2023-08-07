package com.intershop.ts.component.warehouse.pipelet.warehouse;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.intershop.beehive.core.capi.pipeline.Pipelet;
import com.intershop.beehive.core.capi.pipeline.PipeletExecutionException;
import com.intershop.beehive.core.capi.pipeline.PipelineDictionary;
import com.intershop.ts.component.warehouse.capi.StockBO;
import com.intershop.ts.component.warehouse.capi.WarehouseBO;
import com.intershop.ts.component.warehouse.capi.WarehouseBORepository;

public class GetUsableWarehouseBOs extends Pipelet
{

    public int execute(PipelineDictionary aPipelineDictionary) throws PipeletExecutionException
    {
        WarehouseBORepository warehouseBORepository = aPipelineDictionary.getRequired("WarehouseBORepository");
        String productUUID = aPipelineDictionary.getRequired("ProductUUID");
        Collection<WarehouseBO> warehouses = warehouseBORepository.getWarehouseBOs();
        List<WarehouseBO> useableWarehouses = new ArrayList<WarehouseBO>();

        for (WarehouseBO warehouseBO : warehouses)
        {
            StockBO stockBO = warehouseBO.getStockBO(productUUID);
            if (null == stockBO)
            {
                useableWarehouses.add(warehouseBO);
            }
        }
        aPipelineDictionary.put("WarehouseBOs", useableWarehouses);
        return PIPELET_NEXT;
    }

}
