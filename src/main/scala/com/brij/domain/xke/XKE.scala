package com.brij.domain.xke


import domain.{userSXkes, XkeType}


case class XKE(topic:String,presenter:String,xkeType:String)
case class XKEs(userXkes:Map[String,List[XKE]])


