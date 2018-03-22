package servicestest

import com.hashmap.services.{CatalogueService, XMLService}
import com.hashmap.dao.CatalogueDaoImp
import com.hashmap.readingRes.XMLRead

import org.scalatest.{BeforeAndAfter, FunSuite}

import scala.xml.NodeSeq

class CatalogueServiceTest extends FunSuite with BeforeAndAfter{

  val catalogueDaoImp=new CatalogueDaoImp
  val xmlService=new XMLService(catalogueDaoImp)
  val xmlRead=new XMLRead()
  val catalogueService=new CatalogueService(catalogueDaoImp)
  val getContent: NodeSeq =xmlRead.getXMLContent("src/test/scala/resources/Catalogue.xml")

  before{
    xmlService.getItemsFromXml(getContent)
    catalogueService.getItems
  }
  test("testing buildCatalogue functionality"){
    assert(catalogueService.getCatalogue.nonEmpty)
  }
}
