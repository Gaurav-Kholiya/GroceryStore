package readingrestest

import com.hashmap.readingRes.XMLRead
import org.scalatest.FunSuite

import scala.reflect.io.File

class ReadingResTest extends FunSuite{

  test("testing file path is correct or not"){
   assert(File("src/test/scala/resources/Catalogue.xml").exists)
  }

  val xmlRead=new XMLRead

  test("testing getXMLContent method in XMLRead"){
    val n=xmlRead.getXMLContent("src/test/scala/resources/Catalogue.xml").toList.length
    assert(n!=0)
  }
  test("if xml item nodes are not present in XML"){
    val n=xmlRead.getXMLContent("src/test/scala/resources/Catalogue2.xml").toList.length
    assert(n==0)
  }

}
