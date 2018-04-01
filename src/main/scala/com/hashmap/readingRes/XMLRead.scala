package com.hashmap.readingRes

import java.io.File

import scala.xml.{Elem, NodeSeq, XML}

class XMLRead() {

  def getXMLContent(xmlFilePath:String):NodeSeq={
    val elem= XML.loadFile(xmlFilePath)
    val items=elem \\ "item"
    items
  }
}
