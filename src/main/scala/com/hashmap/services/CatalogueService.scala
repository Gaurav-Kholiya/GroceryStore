package com.hashmap.services

import com.hashmap.dao.CatalogueDaoImp
import model.Item


class CatalogueService(catalogueDaoImp: CatalogueDaoImp){

  def getCatalogue:List[Item]={
    val catalogueItems=catalogueDaoImp.getItems.toList
    catalogueItems
  }
}
