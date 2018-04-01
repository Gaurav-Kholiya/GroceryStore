package com.hashmap.services

import java.util.Calendar
import java.util.concurrent.{Executors, ScheduledExecutorService, TimeUnit}

import com.hashmap.dao.{ItemsDao, ItemsDaoImp}
import com.hashmap.model.{Item, Stock}
import com.hashmap.readingRes.XMLRead
import com.hashmap.utility.Parsing

import scala.xml.NodeSeq

class SchedulerService(filepath:String, xMLRead: XMLRead, itemsDao: ItemsDao){


  val calendar: Calendar = Calendar.getInstance()
  val scheduler: ScheduledExecutorService = Executors.newScheduledThreadPool(1)


  def getInitialDelay(target:Int):Int={
    val hour = Calendar.HOUR_OF_DAY
    if(hour<target) target-hour
    else target-hour+24
  }


  def fromDeltaXml(): Unit = {
    scheduler.scheduleAtFixedRate(new Runnable {
      override def run(): Unit = {
        val newSeq=xMLRead.getXMLContent(filepath)
        refillStock(newSeq)
        //itemsDao.getItemStocks.foreach(println)
      }
    },0, 10, TimeUnit.SECONDS)
  }


  def refillStock(nodeSeq: NodeSeq):Boolean={
    val newItems=nodeSeq.map(Parsing.toItemStock).toList
    if(newItems.isEmpty) false
    else{
      newItems.foreach(appendStock)
      true
    }
  }


  def appendStock(newItemStock:Stock):Unit={

    if(itemsDao.getItemStocks.contains(newItemStock.item)){
      itemsDao.appendItemStock(newItemStock.item,newItemStock.quantity)
    }else itemsDao.addItemStock(newItemStock)
  }

}