package model

import com.hashmap.services.XMLService
import com.hashmap.dao.CatalogueDaoImp
import com.hashmap.model.ItemStock

class Catalogue(xmlService: XMLService,catalogueDaoImp: CatalogueDaoImp){

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

}
