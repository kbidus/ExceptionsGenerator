package com.sumologic.exceptions.rollbar

import java.util.Random

import com.rollbar.notifier.Rollbar
import com.rollbar.notifier.config.ConfigBuilder.withAccessToken
import runner.Exceptions.exceptions

class RollbarMain {

  private val rnd = new Random()
  def start(): Unit = {
    println("start rollbar")

    val config = withAccessToken("929776b5c91e48e4850db7983f40a932").
      environment("production").codeVersion("1.0.0").build
    val rollbar = Rollbar.init(config)
    for(i <- 0 until 10) {
      try
        throw exceptions(rnd.nextInt(exceptions.length)).getConstructor(classOf[String]).newInstance(s"Arithmetic exception nr $i from Rollbar")
      catch {
        case e: Exception =>
          println(e)
          rollbar.error(e)
      }
    }
    rollbar.close(true)
  }
}
