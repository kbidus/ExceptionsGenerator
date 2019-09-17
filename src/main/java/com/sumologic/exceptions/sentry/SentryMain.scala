package com.sumologic.exceptions.sentry

import java.util.Random

import io.sentry.Sentry
import runner.Exceptions.exceptions

class SentryMain {
  private val rnd = new Random()
  def start(): Unit = {
    println("start sentry")

    Sentry.init("https://9aec5abab52441b49525735cb3b9f0c5@sentry.io/1726748")
    for(i <- 0 until 10) {
      try
        throw exceptions(rnd.nextInt(exceptions.length)).getConstructor(classOf[String]).newInstance(s"Arithmetic exception nr $i from Sentry")
      catch {
        case e: Exception =>
          println(e)
          Sentry.capture(e)
      }
    }
  }
}