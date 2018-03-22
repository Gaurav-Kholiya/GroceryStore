package com.hashmap.model

import model.Item

import scala.xml.Node

case class ItemStock(item:Item, stock:Stock)

object ItemStock{

  def toItemStock(node:Node):ItemStock={
    val itemStock=(node\"quantity").map(Stock.toStock)
    val item=Item.toItem(node)
    ItemStock(item,itemStock.head)
  }
}
