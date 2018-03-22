package com.hashmap.dao


import com.hashmap.database.CatalogueDbImp
import com.hashmap.model.ItemStock
import model.Item

import scala.collection.mutable.ListBuffer


class CatalogueDaoImp extends CatalogueDao {


  override def getItems: ListBuffer[Item] = {
    CatalogueDbImp.getAllItems
  }
  override def getItemStock: ListBuffer[ItemStock] ={
    CatalogueDbImp.getAllItemsStock
  }

  override def addItem(item: Item): Unit ={
    CatalogueDbImp.addToItems(item)
  }

  override def addItemStock(itemStock: ItemStock): Unit={
    CatalogueDbImp.addToItemsStock(itemStock)
  }
}

