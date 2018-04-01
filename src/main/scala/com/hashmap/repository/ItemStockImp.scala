package com.hashmap.repository
import com.hashmap.model.{Item, Stock}

import scala.collection.mutable
import scala.collection.mutable.{ListBuffer, Map}




object ItemStockImp extends ItemStock {


  private val itemInventory: ListBuffer[Item] =new ListBuffer[Item]()
  private val stockInventory=Map[Item,Int]()


  override def getAllItems: List[Item] = {
    itemInventory.toList
  }

  override def getAllItemStock: mutable.Map[Item,Int] ={
    stockInventory
  }

  override def addToItemStock(itemStock:Stock):Unit ={
      itemInventory+=itemStock.item
      stockInventory+=(itemStock.item->itemStock.quantity)
  }


  override def appendItemStock(item: Item,newStock:Int): Unit = {

        stockInventory.update(item,stockInventory(item)+newStock)
  }


  override def updateStock(item: Item, purchasedQuantity: Int): Unit = {

        stockInventory.update(item,stockInventory(item)-purchasedQuantity)
  }

}

