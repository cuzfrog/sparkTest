package com.github.cuzfrog.spark

import org.apache.spark.{SparkConf, SparkContext}

import Numeric.Implicits._

/**
  * Created by scjf on 8/25/2016.
  */
object MyApp {
  def main(args: Array[String]) {
    val conf = new SparkConf()
      .setAppName("App1")
      .setMaster(args.head)
      .set("log4j.configuration", "log4j.properties")
    val sc = new SparkContext(conf)
    val l1 = List(1, 7, 8, 567l, 33.66)
    val r = sc.parallelize(l1).reduce(sum(_, _))
    println(s"Completed:$r")
  }

  def sum[T: Numeric](a: T, b: T): T = a + b

}
