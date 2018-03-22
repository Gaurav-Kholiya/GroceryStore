package com.hashmap.readingRes

import java.io.File

import scala.xml.{Elem, NodeSeq, XML}

class XMLRead() {

  //getting xml content
  def getXMLContent(xmlFilePath:String):NodeSeq={
    val elem= XML.loadFile(xmlFilePath)
    val items=elem \\ "item"
    items
  }
}
