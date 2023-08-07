package com.intershop.ts.component.warehouse.pipelet.stock;

import com.intershop.beehive.core.capi.pipeline.Pipelet;
import com.intershop.beehive.core.capi.pipeline.PipeletExecutionException;
import com.intershop.beehive.core.capi.pipeline.PipelineDictionary;
import com.intershop.beehive.xcs.capi.product.Product;
import com.intershop.ts.component.warehouse.capi.StockBO;
import com.intershop.ts.component.warehouse.capi.WarehouseBO;
import com.intershop.ts.component.warehouse.capi.WarehouseBORepository;

public class GetStockBO extends Pipelet
{

    public int execute(PipelineDictionary aPipelineDictionary) throws PipeletExecutionException
    {
        WarehouseBORepository warehouseBORepository = aPipelineDictionary.get("WarehouseBORepository");
        Product product = aPipelineDictionary.get("Product");
        String warehouseID = aPipelineDictionary.get("WarehouseID");

        WarehouseBO warehouseBO = warehouseBORepository.getWarehouseBOByID(warehouseID);
        StockBO stockBO = warehouseBO.getStockBO(product.getUUID());

        aPipelineDictionary.put("StockBO", stockBO);
        return PIPELET_NEXT;
    }

}
