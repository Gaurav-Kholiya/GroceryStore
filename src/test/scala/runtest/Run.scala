package runtest

import com.hashmap.services.{CatalogueService, SchedulerService, XMLService}
import com.hashmap.dao.CatalogueDaoImp
import com.hashmap.readingRes.XMLRead

object Run extends App{

  val xmlRead=new XMLRead
  val catalogueDaoImp=new CatalogueDaoImp
  val xmlService=new XMLService(catalogueDaoImp)
  val catalogueService=new CatalogueService(catalogueDaoImp)
  val schedulerService=new SchedulerService(xmlRead,catalogueDaoImp)

  val getContent=xmlRead.getXMLContent("src/test/scala/resources/Catalogue.xml")

  xmlService.getItemsFromXml(getContent)
  catalogueService.getItems

  schedulerService.catalogueUpdate()    //calling scheduler

  val items=catalogueService.getCatalogue
  items.foreach(println)

}
