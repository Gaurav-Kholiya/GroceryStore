package com.hashmap.model

import model.Item

import scala.xml.Node

case class Stock(stock:Int, measure:String)

object Stock{

  //mapping quantity to Stock
  def toStock(node:Node):Stock={
    val stock=(node\"stock").text.toInt
    val measure=(node\"measure").text
    Stock(stock,measure)
  }
}