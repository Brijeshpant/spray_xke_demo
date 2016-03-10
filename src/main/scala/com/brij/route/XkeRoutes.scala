package com.brij
package route

import domain.xke.XKE
import spray.routing.Directives
import util.DomainApiFormatter
import spray.json.DefaultJsonProtocol._
import spray.httpx.SprayJsonSupport._
import services._


/**
  * Created by bpant on 3/10/16.
  */

trait XkeRoutes extends Directives with DomainApiFormatter {
  val xkeRoute = pathPrefix("api") {
    pathPrefix("xke") {
      import ApiFormatProtocol._
      post {
          entity(as[XKE]) {
            xke=>
            XKEService.createXke(xke)
          complete("xke created $XKE(xke,\"AA\",\"ss\")")
          }
        }~get {
          path("all") {
            complete(XKEService.getAllXkes())
          }
        }
    }
  }
}

