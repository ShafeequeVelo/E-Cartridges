package com.intershop.ts.component.warehouse.pipelet.stock;

import com.intershop.beehive.core.capi.pipeline.Pipelet;
import com.intershop.beehive.core.capi.pipeline.PipeletExecutionException;
import com.intershop.beehive.core.capi.pipeline.PipelineDictionary;
import com.intershop.ts.component.warehouse.capi.StockBO;
import com.intershop.ts.component.warehouse.capi.WarehouseBO;
import com.intershop.ts.component.warehouse.capi.WarehouseBORepository;

public class RemoveStockBO extends Pipelet
{

    public int execute(PipelineDictionary aPipelineDictionary) throws PipeletExecutionException
    {
        WarehouseBORepository warehouseBORepository = aPipelineDictionary.get("WarehouseBORepository");

        StockBO stockBO = aPipelineDictionary.get("StockBO");

        WarehouseBO warehouseBO = warehouseBORepository.getWarehouseBOByID(stockBO.getWarehouseID());

        warehouseBO.removeStockBO(stockBO.getProductID());

        return PIPELET_NEXT;
    }

}
