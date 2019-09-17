package com.sumologic.exceptions.bugsnag

import java.util.Random

import com.bugsnag.Bugsnag
import runner.Exceptions.exceptions

class BugsnagMain {
  private val rnd = new Random()

  def start(): Unit = {
    println("start bugsnag")
    val bugsnag = new Bugsnag("dfe21f61ce741e7ff5644f27102c86c9");
    for(i <- 0 until 10) {
      try
        throw exceptions(rnd.nextInt(exceptions.length)).getConstructor(classOf[String]).newInstance(s"Arithmetic exception nr $i from Bugsnag")
      catch {
        case e: Exception =>
          println(e)
          bugsnag.notify(e)
      }
    }
    bugsnag.close()
  }
}