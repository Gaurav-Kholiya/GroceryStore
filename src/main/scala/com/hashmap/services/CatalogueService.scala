package com.hashmap.services

import com.hashmap.dao.ItemsDao
import com.hashmap.model.{Catalogue, Item, Stock}
import com.hashmap.utility.Parsing

import scala.xml.NodeSeq



class CatalogueService(itemsDao: ItemsDao){

  def BuildCatalogue:Catalogue ={
    val items=itemsDao.getItems
    Catalogue(items)
  }


  def getItemsFromXml(nodeSeq: NodeSeq):List[Stock]={
    val items=nodeSeq.map(Parsing.toItemStock).toList
    items
  }


  def setItemStock(itemStock: List[Stock]):List[(Item,Int)]={
    itemStock.foreach(itemsDao.addItemStock)
    itemsDao.getItemStocks.toList
  }


  def checkAvailableStock(item:Item):Int={
    val itemStock=itemsDao.getItemStocks.find(_._1==item)
    itemStock.get._2
  }

}
