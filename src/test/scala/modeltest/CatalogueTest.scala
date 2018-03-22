package modeltest

import com.hashmap.services.XMLService
import com.hashmap.dao.CatalogueDaoImp
import com.hashmap.readingRes.XMLRead
import model.Catalogue
import org.scalatest.{BeforeAndAfter, FunSuite}

class CatalogueTest extends FunSuite with BeforeAndAfter{

  val catalogueDaoImp=new CatalogueDaoImp
  val xmlService=new XMLService(catalogueDaoImp)
  val xmlRead=new XMLRead()
  val catalogue=new Catalogue(xmlService,catalogueDaoImp)
  val getContent=xmlRead.getXMLContent("src/test/scala/resources/Catalogue.xml")

  before{
     xmlService.getItemsFromXml(getContent)
  }
  test("testing getItemStock is not returning empty list"){
    assert(catalogue.getItems.nonEmpty)
  }
}
