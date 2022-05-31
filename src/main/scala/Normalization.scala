import scala.io.Source

object Normalization extends App {

  def printToFile(f: java.io.File)(op: java.io.PrintWriter => Unit) {
    val p = new java.io.PrintWriter(f)
    try { op(p) } finally { p.close() }
  }

  def thruFile(filepath: String)={
    val lines : Iterator[String] = Source.fromFile("data.csv").getLines()

    (0 until iter.length).foldLeft("start"){(m,n)=>
      val next = iter.next
      val x = next.split(",").last.toDouble
    }
  }

  def giveMinMax(): (Double, Double) ={
//    val lines : Iterator[String] = Source.fromFile("data.csv").getLines()
    val lines = Iterator("1,200.0","1,300.0","1,2.0","1,1000.0")
    val start = lines.next.split(",").last.toDouble
    (0 until lines.length).foldLeft((start,start)){(minmax,z)=>
      val next = lines.next.split(",").last.toDouble
      next match {
        case n if n > minmax._2 => (minmax._1, n)
        case n if n < minmax._1 => (n, minmax._2)
        case _ => (minmax._1, minmax._2)
      }
    }
  }

  println(giveMinMax())

//  def giveMin(iter: Iterator[Double]): Double ={
//    val lines : Iterator[String] = Source.fromFile("data.csv").getLines()
//    val start = lines.next.split(",").last.toDouble
//    (0 until iter.length).foldLeft(start){(m,n)=>
//      val next = lines.next.split(",").last.toDouble
//      if (next < m ){
//        next
//      } else m
//    }
//  }



//  val max = Source.fromFile("data.csv").getLines().flatMap(line => line.split(","))
//  val min =
//
//  val words = Source.fromFile("data.csv").getLines().flatMap(line => line.split(","))
////    .map(case (id, number) => )
//
//  def normalization()


}
