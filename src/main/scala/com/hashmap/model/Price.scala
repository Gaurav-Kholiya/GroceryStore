package com.hashmap.model

import scala.xml.Node

case class Price(unitPrice:Double,currency:String)

object Price {

  //mapping unitPrice to Price
  def toPrice(node:Node):Price={
    val unitPrice=(node\"amount").text.toDouble
    val currency=(node\"currency").text
    Price(unitPrice,currency)
  }
}
