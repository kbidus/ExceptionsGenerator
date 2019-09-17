package runner

object Exceptions {
  val exceptions = List[Class[_ <: Throwable]](
    classOf[ArithmeticException],
    classOf[IndexOutOfBoundsException],
    classOf[ClassCastException],
    classOf[ArrayIndexOutOfBoundsException],
    classOf[IllegalArgumentException],
    classOf[InterruptedException],
    classOf[NoSuchElementException],
    classOf[NullPointerException],
    classOf[NumberFormatException],
    classOf[StringIndexOutOfBoundsException],
    classOf[UnsupportedOperationException],
    classOf[SecurityException],
    classOf[InstantiationException]
  )

}
