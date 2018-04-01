//package com.hashmap.services
//
//import com.hashmap.dao.{CartDao, ItemsDao}
//import com.hashmap.model.Cart
//
//
//class CheckOutService(cartDao: CartDao, itemsDao:ItemsDao) {
//
//
//  def calculateTotalPrice(userId:Int):Double={
//    val allPrice=cartDao.getCart(userId).cart
//    val total=allPrice.sum
//    total
//  }
//
//  def purchase(userId:Int):Unit={
//    val purchasedItems=cartDao.getCart(userId).cart.keys.toList
//    for(i<-purchasedItems.indices){
//      itemsDao.updateAfterPurchase(purchasedItems(i)._1,purchasedItems(i)._2)
//    }
//  }
//
//}
