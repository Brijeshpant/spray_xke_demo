package com.brij.domain

/**
  * Created by bpant
  */
case class User(id:String,userName: String, password: String,age:Int=0){
  def passwordMatcher(password: String): Boolean = {
    this.password == password
  }
}

class AuthInfo(val user: User) {
  def hasPermission(permission: String) = {
    // Code to verify whether user has the given permission      }
  }
}

