package com.intershop.ts.component.warehouse.pipelet.stock;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.intershop.beehive.core.capi.pipeline.Pipelet;
import com.intershop.beehive.core.capi.pipeline.PipeletExecutionException;
import com.intershop.beehive.core.capi.pipeline.PipelineDictionary;
import com.intershop.beehive.xcs.capi.product.Product;
import com.intershop.component.product.capi.ProductBO;
import com.intershop.ts.component.warehouse.capi.StockBO;
import com.intershop.ts.component.warehouse.capi.WarehouseBO;
import com.intershop.ts.component.warehouse.capi.WarehouseBORepository;

public class GetStockBOs extends Pipelet
{

    public int execute(PipelineDictionary aPipelineDictionary) throws PipeletExecutionException
    {

        WarehouseBORepository warehouseBORepository = aPipelineDictionary.getRequired("WarehouseBORepository");

        // lookup 'Product' in pipeline dictionary
        Product product = (Product)aPipelineDictionary.get("Product");
        if (null == product)
        {
            throw new PipeletExecutionException(
                            "Mandatory input parameter 'Product' not available in pipeline dictionary.");
        }

        Collection<WarehouseBO> warehouseBOs = warehouseBORepository.getWarehouseBOs();
        List<StockBO> stockBOs = new ArrayList<StockBO>();
        for (WarehouseBO warehouseBO : warehouseBOs)
        {
            String pid = product.getUUID();
            StockBO stockBO = warehouseBO.getStockBO(pid);
            if (null != stockBO)
            {
                stockBOs.add(stockBO);
            }
        }

        // store 'Inventories' in pipeline dictionary
        aPipelineDictionary.put("Inventories", stockBOs);
        return PIPELET_NEXT;
    }

}
