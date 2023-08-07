package com.intershop.ts.component.warehouse.pipelet.stock;

import com.intershop.beehive.core.capi.pipeline.Pipelet;
import com.intershop.beehive.core.capi.pipeline.PipeletExecutionException;
import com.intershop.beehive.core.capi.pipeline.PipelineDictionary;
import com.intershop.beehive.xcs.capi.product.Product;
import com.intershop.ts.component.warehouse.capi.WarehouseBO;

public class CreateStockBO extends Pipelet
{

    public int execute(PipelineDictionary dict) throws PipeletExecutionException
    {
        // lookup 'Count' in pipeline dictionary
        Integer count = dict.get("Count");
        if (null == count)
        {
            throw new PipeletExecutionException(
                            "Mandatory input parameter 'Count' not available in pipeline dictionary.");
        }
        // lookup 'Product' in pipeline dictionary
        Product product = (Product)dict.get("Product");
        if (null == product)
        {
            throw new PipeletExecutionException(
                            "Mandatory input parameter 'Product' not available in pipeline dictionary.");
        }
        // lookup 'WarehouseBO' in pipeline dictionary
        WarehouseBO warehouseBO = (WarehouseBO)dict.get("WarehouseBO");
        if (null == warehouseBO)
        {
            throw new PipeletExecutionException(
                            "Mandatory input parameter 'Warehouse' not available in pipeline dictionary.");
        }

        warehouseBO.createStockBO(product.getUUID(), count);
        return PIPELET_NEXT;
    }

}
