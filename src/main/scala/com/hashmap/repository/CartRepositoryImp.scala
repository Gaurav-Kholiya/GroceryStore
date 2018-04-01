package com.hashmap.repository
import com.hashmap.model.{Cart, Item, Price, Size}

import scala.collection.mutable

object CartRepositoryImp extends CartRepository{

  private val cartInventory=mutable.Map[Int,Cart]()
  //cartInventory+=111-> Cart(Map(Item(0, "", Size(0, ""), Price(0, "")) -> 0))

  override def getCart(id:Int):Cart={
    cartInventory(id)
  }

  override def addItemToCart(userId: Int,cartItem:(Item,Int)): Unit = {
    var cart=getCart(userId).cart
    cart+=cartItem._1->cartItem._2
    cartInventory+=userId->Cart(cart)
  }

  override def removeItemFromCart(userId: Int, cartItem: (Item, Int)): Unit ={
    var cart=getCart(userId).cart
    cart-=cartItem._1
    cartInventory+=userId->Cart(cart)
  }

  override def updateItem(userId: Int, updatedItem: (Item, Int)): Unit = {
    var cart=getCart(userId).cart
    cart+=updatedItem._1->updatedItem._2
    cartInventory+=userId->Cart(cart)
  }
}
