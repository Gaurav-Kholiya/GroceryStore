package com.hashmap.dao

import com.hashmap.model.{Item, Stock}

import scala.collection.mutable
import scala.util.Try

trait ItemsDao {

  def getItems:List[Item]

  def getItemStocks:mutable.Map[Item,Int]

  def addItemStock(itemStock:Stock):Unit

  def appendItemStock(item: Item,newStock:Int):Unit

  def updateAfterPurchase(item:Item,purchasedQuantity:Int):Unit

}
