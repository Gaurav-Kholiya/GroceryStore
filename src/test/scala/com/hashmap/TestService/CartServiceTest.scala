package com.hashmap.TestService

import com.hashmap.dao.{CartDaoImp, ItemsDaoImp}
import com.hashmap.model.{Item, Price, Size}
import com.hashmap.readingRes.XMLRead
import com.hashmap.services.{CartService, CatalogueService}
import org.scalatest.{BeforeAndAfter, FunSuite}
import org.junit.Assert.{assertFalse}
import scala.xml.NodeSeq

class CartServiceTest extends FunSuite with BeforeAndAfter{

  val xmlRead=new XMLRead
  val catalogueService=new CatalogueService(new ItemsDaoImp)
  val nodeSeq: NodeSeq =xmlRead.getXMLContent("src/test/scala/com/hashmap/resources/Catalogue.xml")
  val cartDao=new CartDaoImp
  val itemsDao=new ItemsDaoImp
  val cartService=new CartService(cartDao,itemsDao)

  before{
    catalogueService.setItemStock(catalogueService.getItemsFromXml(nodeSeq))
  }

    test("add item to cart"){
      assert( cartService.addItemToCart(111,101,2)==Right(Item(101,"LUX bath soap",Size(20,"gm"),Price(12.0,"INR"))))
    }

//    test("add item with wrong item id"){
//      assertFalse( cartService.addItemToCart(111,100,2).isLeft)
//    }
}
