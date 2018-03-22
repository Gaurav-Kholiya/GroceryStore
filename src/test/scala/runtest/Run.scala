package runtest

import com.hashmap.services.{CatalogueService, XMLService}
import com.hashmap.dao.CatalogueDaoImp
import com.hashmap.readingRes.XMLRead
import model.Catalogue

object Run extends App{

  val xmlRead=new XMLRead
  val catalogueDaoImp=new CatalogueDaoImp
  val xmlService=new XMLService(catalogueDaoImp)
  val catalogue=new Catalogue(xmlService,catalogueDaoImp)
  val catalogueService=new CatalogueService(catalogueDaoImp)

  val getContent=xmlRead.getXMLContent("src/test/scala/resources/Catalogue.xml")

  xmlService.getItemsFromXml(getContent)
  catalogue.getItems
  val items=catalogueService.getCatalogue
  items.foreach(println)

}
