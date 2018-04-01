package com.hashmap.TestService

import com.hashmap.dao.ItemsDaoImp
import com.hashmap.readingRes.XMLRead
import com.hashmap.services.SchedulerService
import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner
import org.junit.Assert.assertFalse

@RunWith(classOf[JUnitRunner])
class SchedulerServiceTest extends FunSuite{

  val xmlRead=new XMLRead
  val itemsDao=new ItemsDaoImp
  val filepath="src/test/scala/com/hashmap/resources/Catalogue3.xml"
  val schedulerService=new SchedulerService(filepath,xmlRead,itemsDao)

  test("scheduler should update something"){
    assert(schedulerService.refillStock(xmlRead.getXMLContent(filepath)))
  }

  test("getInitialDelay testing"){
    assert(schedulerService.getInitialDelay(7)> -1)
  }

}
