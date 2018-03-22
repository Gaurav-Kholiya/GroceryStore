package com.hashmap.database

import com.hashmap.model.{Item, ItemStock, Stock}

import scala.collection.mutable.ListBuffer


object DbImp extends DB {

  private val items: ListBuffer[Item] = new ListBuffer[Item]()
  private val itemsStock: ListBuffer[ItemStock] =new ListBuffer[ItemStock]()

  override def getAllItems: ListBuffer[Item] = {
    items
  }

  override def getAllItemsStock: ListBuffer[ItemStock] = {
    itemsStock
  }

  override def addToItems(item: Item): Unit = {
    items += item
  }

  override def addToItemsStock(itemWithStock: ItemStock): Unit ={
    itemsStock+=itemWithStock
  }

  override def updateItemStock(index:Int,itemStock: ItemStock): Unit = {
    val newStock=itemStock.stock.stock+itemsStock(index).stock.stock
    val newItemStock=ItemStock(itemStock.item,Stock(newStock,itemStock.stock.measure))
    itemsStock.update(index,newItemStock)
  }

  override def updateItem(index:Int,item: Item): Unit ={
    items.update(index,item)
  }
}

