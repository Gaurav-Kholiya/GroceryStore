package com.hashmap.database

import com.hashmap.model.ItemStock
import model.Item

import scala.collection.mutable.ListBuffer

trait CatalogueDB {

  def getAllItems:ListBuffer[Item]
  def getAllItemsStock:ListBuffer[ItemStock]
  def addToItems(item:Item):Unit
  def addToItemsStock(itemStock:ItemStock):Unit
}
