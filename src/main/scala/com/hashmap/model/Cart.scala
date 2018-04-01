package com.hashmap.model


case class Cart(cart:Map[Item,Int]){

  def getCart:Map[Item,Int]={
    cart
  }
}