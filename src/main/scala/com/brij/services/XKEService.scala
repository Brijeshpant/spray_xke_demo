package com.brij
package services

import com.brij.domain.xke.XKE

import scala.collection.mutable.ListBuffer

/**
  * Created by bpant on 3/10/16.
  */
object XKEService {
  var xkes = ListBuffer.empty[XKE]

  def createXke(xke: XKE) = {
    xkes += xke
  }

  def getXkesByUser(userName: String): List[XKE] = {
    xkes.filter(x => x.presenter == userName).toList
  }

  def getAllXkes() = {
    xkes.toList
  }

  def deleteXke(xke: XKE) = {
    xkes -= xke

  }

}
