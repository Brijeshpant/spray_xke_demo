package com.brij
package route

import domain.xke.XKE
import spray.http.StatusCodes
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
        //curl -XPOST -i 'http://localhost:8080/api/xke' -d '{"topic":"Spray","presenter":"Brij","xkeType":"Tech"}' -H Content-type:"application/json"
        entity(as[XKE]) {
            xke=>
            XKEService.createXke(xke)
          complete(StatusCodes.Created ,s"xke created $xke")
          }
        }~get {
          path("all") {
            //curl localhost:8080/api/xke/all
            complete(XKEService.getAllXkes())
          }
        }
    }
  }
}

