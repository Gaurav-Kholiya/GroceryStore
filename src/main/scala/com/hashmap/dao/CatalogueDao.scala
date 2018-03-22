package com.hashmap.dao

import com.hashmap.model.ItemStock
import model.Item

import scala.collection.mutable.ListBuffer

trait CatalogueDao {

  def getItems:ListBuffer[Item]
  def getItemStock:ListBuffer[ItemStock]
  def addItem(item:Item):Unit
  def addItemStock(item:ItemStock):Unit

}