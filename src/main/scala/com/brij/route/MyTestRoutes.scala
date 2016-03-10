package com.brij.route

import spray.httpx.SprayJsonSupport._
import spray.json.DefaultJsonProtocol._
import spray.routing._

/**
  * Created by bpant on 3/10/16.
  */

trait MyTestRoutes extends Directives {

  val testRoutes: Route = {
    pathPrefix("app") {
      post {
        path("user") {
          //curl -X POST localhost:8080/app/user
          complete("it is Cool isn't it")
        }
      }~ path(IntNumber / Segment) { (intVal, stringVal) =>
        //curl http://localhost:8080/app/1/someString
        complete {
          s"received parameters are $intVal $stringVal"
        }
      }
    } ~ pathPrefix("api") {
      path("user1") {
        //curl  localhost:8080/api/user1
        complete("it is Cool isn't it FROM USER")
      } ~ parameter("name".as[String]) { name =>
        //curl http://localhost:8080/api?name=Brijesh
        complete {
          s"name is $name"
        }
      }
    }
  }
}