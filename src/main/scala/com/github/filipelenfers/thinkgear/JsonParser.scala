package com.github.filipelenfers.thinkgear

import net.liftweb.json._
import language.implicitConversions

object ParserLiftJson {

  implicit val formats = DefaultFormats

  def parse(input: String): ThinkgearResponse = parseOpt(input) match {
    case Some(parsedJson) => parsedJson.extract[ThinkgearResponse] 
    case None =>  ThinkgearResponse.empty
  }

  def hasField(jVal:JValue, field:String) = jVal.filter( j => 
    j match { 
      case JField(n,_) => n==field
      case _ => false 
    }
  ).length > 0

}