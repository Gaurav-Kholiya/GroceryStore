package model



import com.hashmap.model.{Price, Size}

import scala.xml.Node

case class Item(id:Int,itemName:String,itemSize:Size,price:Price)

object Item{

  def toItem(node:Node):Item={
    val id=(node\"id").text.toInt
    val itemName=(node\"name").text
    val itemSize=(node\"size").map(Size.toSize)
    val itemPrice=(node\"unitPrice").map(Price.toPrice)
    Item(id,itemName,itemSize.head,itemPrice.head)
  }

}