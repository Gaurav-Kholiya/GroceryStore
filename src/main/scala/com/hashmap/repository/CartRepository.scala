package com.hashmap.repository

import com.hashmap.model.{Cart, Item}

trait CartRepository {

  def getCart(id:Int):Cart
  def addItemToCart(userId:Int,cartItem:(Item,Int)):Unit
  def removeItemFromCart(userId:Int,cartItem:(Item,Int)):Unit
  def updateItem(userId:Int,updatedItem:(Item,Int)):Unit
}
