package com.intershop.ts.component.warehouse.pipelet.stock;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.intershop.beehive.core.capi.pipeline.Pipelet;
import com.intershop.beehive.core.capi.pipeline.PipeletExecutionException;
import com.intershop.beehive.core.capi.pipeline.PipelineDictionary;
import com.intershop.component.product.capi.ProductBO;
import com.intershop.ts.component.warehouse.capi.StockBO;
import com.intershop.ts.component.warehouse.capi.WarehouseBO;
import com.intershop.ts.component.warehouse.capi.WarehouseBORepository;

public class GetStockBOByWarehouseBO extends Pipelet
{

    public int execute(PipelineDictionary aPipelineDictionary) throws PipeletExecutionException
    {
        ProductBO productBO = aPipelineDictionary.get("ProductBO");
        WarehouseBORepository warehouseBORepository = aPipelineDictionary.get("WarehouseBORepository");
        Collection<WarehouseBO> warehousebos = warehouseBORepository.getWarehouseBOs();
        List<StockBO> stockBOs = new ArrayList<StockBO>();
        for (WarehouseBO warehouseBO : warehousebos)
        {
            StockBO stockBO = warehouseBO.getStockBO(productBO.getID());
            if (null != stockBO)
            {
                stockBOs.add(stockBO);
            }
        }
        aPipelineDictionary.put("StockBOs", stockBOs);
        return PIPELET_NEXT;
    }

}
