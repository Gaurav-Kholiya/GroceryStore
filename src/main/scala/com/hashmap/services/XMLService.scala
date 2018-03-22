package com.hashmap.services

import com.hashmap.dao.CatalogueDaoImp
import com.hashmap.model.ItemStock
import com.hashmap.utility.Parsing

import scala.xml.NodeSeq

class XMLService(catalogueDaoImp:CatalogueDaoImp){

  def setItemStock(itemStock: List[ItemStock]):Unit={
     itemStock.foreach(catalogueDaoImp.addItemStock)
  }

  def getItemsFromXml(nodeSeq: NodeSeq):List[ItemStock]={
      val itemStock=nodeSeq.map(Parsing.toItemStock).toList
      setItemStock(itemStock)
      itemStock
  }

}
