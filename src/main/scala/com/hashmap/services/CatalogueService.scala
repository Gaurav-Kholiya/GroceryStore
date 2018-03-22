package com.hashmap.services

import com.hashmap.dao.CatalogueDaoImp
import com.hashmap.model.{Item, ItemStock}



class CatalogueService(catalogueDaoImp: CatalogueDaoImp){

  def getItems:List[Item] ={
    val items=catalogueDaoImp.getItemStock.map(splitItem).toList
    setItems(items)
    items
  }

  def splitItem(itemStock:ItemStock):Item={
    itemStock.item
  }

  def setItems(items: List[Item]):Unit={
    items.foreach(catalogueDaoImp.addItem)
  }

  def getCatalogue:List[Item]={
    val catalogueItems=catalogueDaoImp.getItems.toList
    catalogueItems
  }
}
