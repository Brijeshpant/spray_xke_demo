package com.brij.auth.route

import spray.routing.Directives

/**
  * Created by bpant on 3/1/16.
  */
case class UserStr(id:Int,name:String)
trait UserRoute extends Directives {
  val userRoute = get {
    path("user" /IntNumber /Segment){ (id,name)=>
    complete {
      s"Good work such mai $id $name"
    }
    }
  }
}
