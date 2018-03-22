package com.hashmap.services

import java.util.Calendar
import java.util.concurrent.{Executors, ScheduledExecutorService, TimeUnit}

import com.hashmap.dao.CatalogueDaoImp
import com.hashmap.model.ItemStock
import com.hashmap.readingRes.XMLRead
import com.hashmap.utility.Parsing

import scala.xml.NodeSeq

class SchedulerService(xMLRead: XMLRead,catalogueDaoImp: CatalogueDaoImp){
  def getInitialDelay(target:Int):Int={
    val hour = Calendar.HOUR_OF_DAY
    if(hour<target) target-hour
    else target-hour+24

  }
  val calendar: Calendar = Calendar.getInstance()
  val scheduler: ScheduledExecutorService = Executors.newScheduledThreadPool(1)

  def catalogueUpdate(): Unit = {
    scheduler.scheduleAtFixedRate(new Runnable {
      override def run(): Unit = {
        val newSeq=xMLRead.getXMLContent("src/test/scala/resources/Catalogue3.xml")
        updateXml(newSeq)
        //catalogueDaoImp.getItemStock.foreach(println)
      }
    },getInitialDelay(7), 24, TimeUnit.HOURS)
  }

  def updateXml(nodeSeq: NodeSeq):Unit={
    val newItems=nodeSeq.map(Parsing.toItemStock).toList
    newItems.foreach(updateCatalogueStock)
  }

  def updateCatalogueStock(newItemStock: ItemStock):Unit={
    val itemsStock=catalogueDaoImp.getItemStock.toList
    val temp = itemsStock.find(p=> p.item==newItemStock.item)
    if(temp.isEmpty){
      catalogueDaoImp.addItemStock(newItemStock)
    }
    if(temp.nonEmpty){
      val oldItemStock=temp.get
      val i=itemsStock.indexOf(oldItemStock)
      catalogueDaoImp.updateStock(i,newItemStock)
    }
  }
}