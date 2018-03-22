package com.hashmap.database

import com.hashmap.model.{Item, ItemStock}

import scala.collection.mutable.ListBuffer

trait DB {

  def getAllItems:ListBuffer[Item]
  def getAllItemsStock:ListBuffer[ItemStock]
  def addToItems(item:Item):Unit
  def addToItemsStock(itemStock:ItemStock):Unit
  def updateItemStock(index:Int,itemStock: ItemStock):Unit
  def updateItem(index:Int,item: Item):Unit
}
