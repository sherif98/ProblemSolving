object Test extends App {

  println("hello")

  val array = Array(2, 4, 5)
  val newArray = array.map(_ * 2)
  println(newArray.mkString(" "))

}
