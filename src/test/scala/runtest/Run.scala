package runtest

import com.hashmap.services.{CatalogueService, XMLService}
import com.hashmap.dao.CatalogueDaoImp
import com.hashmap.readingRes.XMLRead

object Run extends App{

  val xmlRead=new XMLRead
  val catalogueDaoImp=new CatalogueDaoImp
  val xmlService=new XMLService(catalogueDaoImp)
  val catalogueService=new CatalogueService(catalogueDaoImp)

  val getContent=xmlRead.getXMLContent("src/test/scala/resources/Catalogue.xml")

  xmlService.getItemsFromXml(getContent)
  catalogueService.getItems
  val items=catalogueService.getCatalogue
  items.foreach(println)

}
