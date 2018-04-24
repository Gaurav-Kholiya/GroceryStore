package com.hashmap.TestService

import com.hashmap.readingRes.XMLRead
import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

import scala.reflect.io.File

@RunWith(classOf[JUnitRunner])
class ReadingResTest extends FunSuite {

  val xmlRead=new XMLRead

  test("testing file path is correct or not"){
   assert(File("src/test/scala/com/hashmap/resources/Catalogue.xml").exists)
  }

  test("testing getXMLContent method in XMLRead"){
    val n=xmlRead.getXMLContent("src/test/scala/com/hashmap/resources/Catalogue.xml").toList.length
    assert(n!=0)
  }
  test("if xml item nodes are not present in XML"){
    val n=xmlRead.getXMLContent("src/test/scala/com/hashmap/resources/Catalogue2.xml").toList.length
    assert(n==0)
  }

}
