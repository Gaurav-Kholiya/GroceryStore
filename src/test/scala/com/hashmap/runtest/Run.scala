package runtest

import com.hashmap.dao.{CartDao, CartDaoImp, ItemsDaoImp}
import com.hashmap.model.Catalogue
import com.hashmap.readingRes.XMLRead
import com.hashmap.services.{CartService, CatalogueService,  SchedulerService}

import scala.xml.NodeSeq


object Run extends App{

  val xmlRead=new XMLRead
  val itemsDao=new ItemsDaoImp
  val catalogueService=new CatalogueService(new ItemsDaoImp)
  val nodeSeq: NodeSeq =xmlRead.getXMLContent("src/test/scala/com/hashmap/resources/Catalogue.xml")
  val cartDao=new CartDaoImp
  val cartService=new CartService(cartDao,itemsDao)
 // val checkOutService=new CheckOutService(cartDao,itemsDao)

  catalogueService.setItemStock(catalogueService.getItemsFromXml(nodeSeq))
 // println(catalogueService.BuildCatalogue.getCatalogue)

  //val schedulerService=new SchedulerService("src/test/scala/com/hashmap/resources/Catalogue3.xml",xmlRead,itemsDao)
  //schedulerService.fromDeltaXml()

  cartService.addItemToCart(111,101,3)
  cartService.addItemToCart(111,102,5)
  cartService.addItemToCart(111,103,10)
  cartService.removeItemFromCart(111,103)
  cartService.updateCartItemQuantity(111,101,50)
  cartDao.getCart(111).cart.foreach(println)
  //println(checkOutService.calculateTotalPrice(111))
  //checkOutService.purchase(111)
  //itemsDao.getItemStocks.foreach(println)
}
