package com.hashmap.repository

import com.hashmap.model.{Item, Stock}

import scala.collection.mutable

trait ItemStock {

  def getAllItems:List[Item]
  def getAllItemStock:mutable.Map[Item,Int]
  def addToItemStock(itemStock:Stock):Unit
  def appendItemStock(item: Item,newStock:Int):Unit
  def updateStock(item: Item, purchasedQuantity:Int):Unit
}
