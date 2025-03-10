package KV

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object RDD_test_reduceByKey {
  def main(args: Array[String]): Unit = {
    val sparkConf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("Map")
    val sc = new SparkContext(sparkConf)
    val rdd = sc.makeRDD(
      List(("a",1),("b",2),("c",3))
    )
    //reducebykey:相同的key进行value数据的聚合操作
    //两两计算
    rdd.reduceByKey((num, num1) => num + num1).collect().foreach(print)


    sc.stop()

  }

}
