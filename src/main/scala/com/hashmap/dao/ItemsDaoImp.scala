package com.hashmap.dao


import com.hashmap.model.{Item, Stock}
import com.hashmap.repository.ItemStockImp

import scala.collection.mutable


class ItemsDaoImp extends ItemsDao {

  override def getItems: List[Item] = {
    ItemStockImp.getAllItems
  }

  override def getItemStocks: mutable.Map[Item,Int] ={
    ItemStockImp.getAllItemStock
  }

  override def addItemStock(itemStock:Stock): Unit = {
    ItemStockImp.addToItemStock(itemStock)
  }

  override def appendItemStock(item: Item, newStock:Int): Unit = {
    ItemStockImp.appendItemStock(item,newStock)
  }

  override def updateAfterPurchase(item: Item, purchasedQuantity: Int): Unit ={
    ItemStockImp.updateStock(item,purchasedQuantity)
  }


}

