package com.hashmap.utility

import com.hashmap.model
import com.hashmap.model._

import scala.xml.Node

object Parsing {


  def toItem(node:Node):Item={
    val id=(node\"id").text.toInt
    val itemName=(node\"name").text
    val itemSize=(node\"size").map(toSize)
    val itemPrice=(node\"unitPrice").map(toPrice)
    model.Item(id,itemName,itemSize.head,itemPrice.head)
  }

  def toSize(node:Node):Size={
    val unitSize=(node\"unitSize").text.toInt
    val unitMeasure=(node\"uom").text
    Size(unitSize,unitMeasure)
  }

  def toPrice(node:Node):Price={
    val unitPrice=(node\"amount").text.toDouble
    val currency=(node\"currency").text
    Price(unitPrice,currency)
  }

  def toItemStock(node:Node):Stock={
    val stock=(node \\"quantity"\"stock").text.toInt
    val item=toItem(node)
    Stock(item,stock)
  }

}
