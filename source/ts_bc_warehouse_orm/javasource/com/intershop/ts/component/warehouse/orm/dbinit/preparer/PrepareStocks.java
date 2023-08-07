package com.intershop.ts.component.warehouse.orm.dbinit.preparer;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

import javax.inject.Inject;

import com.intershop.beehive.core.capi.domain.Domain;
import com.intershop.beehive.core.capi.domain.DomainMgr;
import com.intershop.beehive.core.capi.log.Logger;
import com.intershop.beehive.core.dbinit.capi.Preparer;
import com.intershop.beehive.foundation.util.ResettableIteratorImpl;
import com.intershop.beehive.xcs.capi.product.ProductMgr;
import com.intershop.ts.component.warehouse.orm.internal.StockPO;
import com.intershop.ts.component.warehouse.orm.internal.StockPOFactory;
import com.intershop.ts.component.warehouse.orm.internal.StockPOKey;
import com.intershop.ts.component.warehouse.orm.internal.WarehousePO;
import com.intershop.ts.component.warehouse.orm.internal.WarehousePOFactory;

public class PrepareStocks extends Preparer
{
    @Inject private DomainMgr domainMgr;
    @Inject private WarehousePOFactory warehousePOFactory;
    @Inject private StockPOFactory stockPOFactory;
    @Inject ProductMgr productMgr;
    
    
    private String stockProperties;
    private ResourceBundle bundle;    
    
    @Override
    public boolean checkParameters()
    {
        if(getNumberOfParameters() == 1)
        {
            stockProperties = getParameter(0);
            return true;
        }
        else
        {
            return false;
        }
    }
    
    @Override
    public boolean prepare()
    {
        Domain domain;
        String stockSKU;
        int stockMax;
        
        try
        {
            bundle =getResourceBundle(stockProperties);
        }
        catch (MissingResourceException mex)
        {
            Logger.warn(this, "No input file found");
            return false;
        }
        
     
        domain = domainMgr.getDomainByName(bundle.getString("DomainName"));
        stockMax = Integer.parseInt(bundle.getString("StockMax"));
        
        @SuppressWarnings("unchecked")
        ResettableIteratorImpl<WarehousePO> warehousePOs = new ResettableIteratorImpl<WarehousePO> (warehousePOFactory.getObjectsByDomainID(domain.getDomainID()).iterator());
        
        int i = 0;      
        boolean eof = false;
        while (!eof)
        {
            try
            {
                ++i;
                stockSKU = bundle.getString("Stock." + i + ".SKU");
                String productID = productMgr.getProductBySKU(stockSKU, domain).getUUID();
                
                while(warehousePOs.hasNext())
                {                    
                    WarehousePO warehousePO = warehousePOs.next();
                    
                    if (Math.random() < 0.5)
                    {
                        String domainID = domain.getDomainID();
                        
                        if (stockPOFactory.getObjectByPrimaryKey(new StockPOKey(productID, domainID, warehousePO.getUUID())) == null)
                        {                                           
                            StockPO stockPO = stockPOFactory.create(productID, domainID, warehousePO);
                            int stockCount = (int) (Math.random()*stockMax +1);
                            stockPO.setCount(stockCount);                            
                        }
                    }
                }
                warehousePOs.reset();
                
            }
            catch (MissingResourceException ex)
            {
                eof = true;
            }
        }
        
//        try
//        {
//            warehousePOs.close();
//        }
//        catch(Exception e)
//        {
//            e.printStackTrace();
//        }
        
        return true;
    }
}
