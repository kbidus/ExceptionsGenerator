package com.sumologic.exceptions.raygun

import java.util.Random

import com.mindscapehq.raygun4java.core.RaygunClient
import runner.Exceptions.exceptions

class RaygunMain {

  private val rnd = new Random()

  def start(): Unit = {
    println("start raygun")

    val client = new RaygunClient("rcEKXy19ezqDJB62eFG3YA")
    for(i <- 0 until 10) {
        try
          throw exceptions(rnd.nextInt(exceptions.length)).getConstructor(classOf[String]).newInstance(s"Arithmetic exception nr $i from Raygun")
        catch {
          case e: Exception =>
            println(e)
            client.send(e)
        }
    }
  }
}