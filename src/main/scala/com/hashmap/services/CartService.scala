package com.hashmap.services

import com.hashmap.dao.{CartDao, ItemsDao}
import com.hashmap.exceptions.ITEM_NOT_FOUND
import com.hashmap.model.{Cart, Item}


import scala.util.{Failure, Success, Try}



 class CartService(cartDao: CartDao,itemsDao: ItemsDao) {


  def addItemToCart(userId:Int,itemId:Int,quantity:Int):Either[Failure[ITEM_NOT_FOUND],Item]= {
    itemAvailableInCatalogue(itemId)  match{
      case None=>Left(Failure(throw new ITEM_NOT_FOUND))
      case Some(item)=>
       addItem(userId, quantity,item)
       Right(item)
    }
  }

  def addItem(userId: Int, quantity: Int, item: Item): Unit = {
    val cartItem = item -> quantity
    cartDao.addItemToCart(userId, cartItem)
  }

  def itemAvailableInCatalogue(itemID:Int):Option[Item]={
     itemsDao.getItems.find(_.id==itemID)
//    match {
//      case None=>Failure(throw new ITEM_NOT_FOUND("Invalid Item id"))
//      case Some(x)=>Success(x)
//    }
  }

  def removeItemFromCart(userId:Int,cartItemId:Int):Unit={
      val cartItem=cartDao.getCart(userId).cart.find(_._1.id==cartItemId).get
      cartDao.removeCartItem(userId,cartItem)
  }


  def updateCartItemQuantity(userId:Int,cartItemID:Int, updatedQuantity:Int):Unit={
    val cartItem=cartDao.getCart(userId).cart.find(_._1.id==cartItemID).get
    val updatedItem=cartItem._1->updatedQuantity
    cartDao.updateCartItem(userId,updatedItem)
  }

}
