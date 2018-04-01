//package com.hashmap.services
//
//import com.hashmap.dao.CartDao
//import com.hashmap.model.Cart
//
//class OrderSummaryService(cartDao:CartDao, checkOutService: CheckOutService) {
//
//  def generateOrderSummary(userId:Int):Unit={
//    val cartItems=cartDao.getCart(userId)
//    val totalPrice=checkOutService.calculateTotalPrice(userId:Int)
//    checkOutService.purchase(userId:Int)
//    cartItems.foreach(f=>println(f._1._1+" Quantity : "+f._1._2+" => INR "+f._2))
//    println("Total Paid Amount : INR "+totalPrice)
//  }
//}
