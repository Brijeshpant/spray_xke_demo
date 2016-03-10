package com.brij.auth.route

import com.brij.domain.User
import com.brij.domain.xke.{ XKEs, XKE}
import com.brij.util.DomainApiFormatter

import spray.routing.{Route, HttpServiceActor, Directives}
import spray.httpx.SprayJsonSupport._


/**
  * Created by bpant on 3/1/16.
  */
trait DemoRoute extends Directives with DomainApiFormatter {
  import ApiFormatProtocol._
  val demoRoute = get {
    path("kke") {
        complete(List(XKE("spray based rest service", "brijesh", "scala"),XKE("Another xke", "brijesh1", "scala")))
    }/*~
      path("userXkes") {
        complete(UserXKEs(Map("brijesh"->List(XKE("spray based rest service", "brijesh", "scala"),XKE("Another xke", "brijesh1", "scala")))))
      }*/
  }
}

class MainService(route: Route) extends HttpServiceActor {
  override def receive: Receive = runRoute(route)
}

object MainService extends DemoRoute with UserRoute with FileUploadRoute {
  val route = demoRoute ~ userRoute ~ uploadRoute
}
