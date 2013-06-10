package de.sahnwaldt.jc

import scala.util.Random

object IterateChars {
  
  def main(args: Array[String]): Unit = {
    val C = 10
    val N = 1000
    val L = 10000
    val M = 0
    var x = 0
    for (c <- 1 to C) {
      var nanos = System.nanoTime()
      for (n <- 1 to N) {
        val str = new Random(c).nextString(L)
        if (M == 0) {
          for (c <- str) {
            if (c == 0) x += 1
          }
        }
        else if (M == 1) {
          var i = 0
          while (i < str.length) {
            if (str.charAt(i) == 0) x += 1
            i += 1
          }
        }
        else if (M == 2) {
          val a = str.toCharArray
          var i = 0
          while (i < a.length) {
            if (a(i) == 0) x += 1
            i += 1
          }
        }
      }
      nanos = System.nanoTime() - nanos
      println(nanos / 1000000F / N)
    }
  }

}