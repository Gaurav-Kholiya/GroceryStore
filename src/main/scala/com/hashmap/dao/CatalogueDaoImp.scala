package com.hashmap.dao


import com.hashmap.database.DbImp
import com.hashmap.model.{Item, ItemStock}


import scala.collection.mutable.ListBuffer


class CatalogueDaoImp extends CatalogueDao {


  override def getItems: ListBuffer[Item] = {
    DbImp.getAllItems
  }
  override def getItemStock: ListBuffer[ItemStock] ={
    DbImp.getAllItemsStock
  }

  override def addItem(item: Item): Unit ={
    DbImp.addToItems(item)
  }

  override def addItemStock(itemStock: ItemStock): Unit={
    DbImp.addToItemsStock(itemStock)
  }

  override def update(i: Int, item: Item): Unit = {
    DbImp.updateItem(i,item)
  }

  override def updateStock(i: Int, itemStock: ItemStock): Unit = {
    DbImp.updateItemStock(i,itemStock)
  }
}

