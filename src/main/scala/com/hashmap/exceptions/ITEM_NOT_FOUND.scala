package com.hashmap.exceptions

class ITEM_NOT_FOUND(message:String) extends Exception{

  def this(){
    this("Invalid Item")
  }

  override def getMessage: String = {
    message
  }
}

