import java.io.FileWriter
import scala.io.Source

object Normalization extends App {

  val filepathResult = "result.txt"
  val fw = new FileWriter(filepathResult, true)

  val filepathIn = "data.txt"
  val (max, min) = giveMinMax(filepathIn)

  thruFile(filepathIn, max, min)
  fw.close()


  def thruFile(filepath: String, max: Double, min: Double)={
    val linesThruLenght = Source.fromFile(filepath).getLines().length
    val linesThru = Source.fromFile(filepath).getLines()
    (0 until linesThruLenght).foldLeft(0){(m,n)=>
      val x = linesThru.next.split(",").last.toDouble
      val resultNormalization = normalizeValue(x, max, min)
      val resultLine = s"${n},${resultNormalization}\n"
      println(resultLine)
      try{
        fw.write(resultLine)
      }
      n
    }
  }

  def giveMinMax(fileIn: String): (Double, Double) ={
    val linesLenght  = Source.fromFile(fileIn).getLines().length
    val lines  = Source.fromFile(fileIn).getLines()
//    val lines = Iterator("1,200.0","1,300.0","1,2.0","1,1000.0")
    val start = lines.next.split(",").last.toDouble
    (0 until (linesLenght-1)).foldLeft((start,start)){ (minmax, z)=>
      val next = lines.next.split(",").last.toDouble
      next match {
        case n if n > minmax._2 => (minmax._1, n)
        case n if n < minmax._1 => (n, minmax._2)
        case _ => (minmax._1, minmax._2)
      }
    }
  }

  def normalizeValue(x: Double, max: Double, min: Double): Double={
    val up = x-min
    val down = max-min
    (up/down)*2-1
  }

}
