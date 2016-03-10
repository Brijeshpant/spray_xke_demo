package com.brij.route

import spray.httpx.SprayJsonSupport._
import spray.json.DefaultJsonProtocol._
import spray.routing._

/**
  * Created by bpant on 3/10/16.
  */

trait MyTestRoutes extends Directives {

  val testRoutes: Route = {
    path("app") {
      post{
        path("user"){
      complete {
          "it is Cool isn't it"
        }
        }
      }
    }~path("api") {
      post{
        path("user1"){
          complete {
            "it is Cool isn't it FROM USER"
          }
        }
      }
    }
  }
}