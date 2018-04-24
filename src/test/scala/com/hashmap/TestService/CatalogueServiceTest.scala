package TestService

import com.hashmap.dao.ItemsDaoImp
import com.hashmap.readingRes.XMLRead
import com.hashmap.services.CatalogueService
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.{BeforeAndAfter, FunSuite}

import scala.xml.NodeSeq

@RunWith(classOf[JUnitRunner])
class CatalogueServiceTest extends FunSuite with BeforeAndAfter{

  val xmlRead=new XMLRead
  val catalogueService=new CatalogueService(new ItemsDaoImp)
  val nodeSeq: NodeSeq =xmlRead.getXMLContent("src/test/scala/com/hashmap/resources/Catalogue.xml")


  test("testing getItemsFromXml functionality"){
    assert(catalogueService.getItemsFromXml(nodeSeq).nonEmpty)
  }

  test("testing setItems functionality"){
    val Items=catalogueService.getItemsFromXml(nodeSeq)
    assert(catalogueService.setItemStock(Items).lengthCompare(Items.length) == 0)
  }

  test("testing checkAvailableStock"){
    val items=catalogueService.setItemStock(catalogueService.getItemsFromXml(nodeSeq))
    assert(catalogueService.checkAvailableStock(items.head._1)> -1)
  }

  test("testing buildCatalogue"){
    catalogueService.setItemStock(catalogueService.getItemsFromXml(nodeSeq))
    assert(catalogueService.BuildCatalogue.catalogue.nonEmpty)
  }
}
