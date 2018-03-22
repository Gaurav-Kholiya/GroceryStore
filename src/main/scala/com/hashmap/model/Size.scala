package com.hashmap.model

import scala.xml.Node

case class Size(unitSize:Int,unitMeasure:String)

object Size {
  //mapping size node to Size
  def toSize(node:Node):Size={
    val unitSize=(node\"unitSize").text.toInt
    val unitMeasure=(node\"uom").text
    Size(unitSize,unitMeasure)
  }
}
