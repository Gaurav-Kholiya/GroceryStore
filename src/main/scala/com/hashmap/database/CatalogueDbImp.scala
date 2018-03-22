package com.hashmap.database

import com.hashmap.model.ItemStock
import model.Item

import scala.collection.mutable.ListBuffer


object CatalogueDbImp extends CatalogueDB {

  val items: ListBuffer[Item] = new ListBuffer[Item]()
  val itemsStock: ListBuffer[ItemStock] =new ListBuffer[ItemStock]()

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
}

