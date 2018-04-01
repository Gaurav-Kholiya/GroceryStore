package com.hashmap.dao
import com.hashmap.model.{Cart, Item}
import com.hashmap.repository.CartRepositoryImp

class CartDaoImp extends CartDao {

  override def getCart(id: Int): Cart = {
    CartRepositoryImp.getCart(id)
  }

  override def addItemToCart(userId: Int, cartItem: (Item, Int)): Unit = {
    CartRepositoryImp.addItemToCart(userId,cartItem)
  }

  override def removeCartItem(userId: Int, cartItem: (Item, Int)): Unit = {
    CartRepositoryImp.removeItemFromCart(userId,cartItem)
  }

  override def updateCartItem(userId: Int, updatedItem: (Item, Int)): Unit = {
    CartRepositoryImp.updateItem(userId,updatedItem)
  }
}
