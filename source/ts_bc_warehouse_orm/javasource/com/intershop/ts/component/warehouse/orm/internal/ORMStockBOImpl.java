package com.intershop.ts.component.warehouse.orm.internal;

import com.intershop.beehive.businessobject.capi.AbstractBusinessObject;
import com.intershop.beehive.businessobject.capi.BusinessObjectContext;
import com.intershop.ts.component.warehouse.capi.StockBO;

public class ORMStockBOImpl extends AbstractBusinessObject implements StockBO
{

    private StockPO stockPO;
   
    public ORMStockBOImpl(StockPO stockPO, BusinessObjectContext context)
    {
        super(stockPO.getPrimaryKey().toString(), context);
        this.stockPO = stockPO;
    }

    @Override
    public int getCount()
    {
        return stockPO.getCount();
    }

    @Override
    public void setCount(int count)
    {
        stockPO.setCount(count);
    }

    @Override
    public String getProductID()
    {
        return stockPO.getProductID();
    }

    @Override
    public String getWarehouseID()
    {
        return stockPO.getWarehouseID();
    }

    @Override
    public String getWarehouseName()
    {
        return stockPO.getWarehousePO().getName();
    }

    @Override
    public String getWarehouseByProductID(String productID)
    {
        // TODO Auto-generated method stub
        return null;
    }

}
