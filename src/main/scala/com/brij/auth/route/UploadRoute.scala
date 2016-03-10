package com.brij.auth.route

import spray.http.MultipartContent
import spray.routing.Directives

/**
  * Created by bpant on 3/1/16.
  */
trait FileUploadRoute extends Directives {

//curl -v -F key1=value1 -F upload=@/Users/bpant/Desktop/xld/myfile.txt localhost:8080/fileUpload
  val uploadRoute = {
    path("fileUpload") {
      entity(as[MultipartContent]) { data =>
        post {
          val dataInParts = data.parts.seq map {
            data => (data.name.get -> data)
          }
          val dataInPartsMap = Map(dataInParts: _*)
          dataInPartsMap map (data => print("ssss " + data._2))
          complete("done")
        }

      }
    }
  }
}