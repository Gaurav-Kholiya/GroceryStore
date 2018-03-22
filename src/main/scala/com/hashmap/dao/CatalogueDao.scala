package com.hashmap.dao

import com.hashmap.model.{Item, ItemStock}

import scala.collection.mutable.ListBuffer

trait CatalogueDao {

  def getItems:ListBuffer[Item]
  def getItemStock:ListBuffer[ItemStock]
  def addItem(item:Item):Unit
  def addItemStock(item:ItemStock):Unit
  def update(i:Int,item: Item):Unit
  def updateStock(i:Int,itemStock: ItemStock):Unit

}
