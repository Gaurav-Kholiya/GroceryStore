package com.hashmap.dao

import com.hashmap.model.{Cart, Item}

trait CartDao {

  def getCart(id:Int):Cart
  def addItemToCart(userId:Int,cartItem:(Item,Int)):Unit
  def removeCartItem(userId:Int,cartItem:(Item,Int)):Unit
  def updateCartItem(userId:Int,updatedItem:(Item,Int)):Unit
}
