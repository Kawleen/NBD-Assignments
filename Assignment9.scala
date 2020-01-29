package Assignment9

object assignments9 {
    def main(args: Array[String]): Unit = {
      println("Task1:")
      val task1: Task1[String] = new Task1("Task1")
      task1.applyFunction(a => a.toUpperCase)
      println(task1.getContent)

      println("Task2:")
      var no: No = new No()
      println("No.isInstanceOf[Maybe[_]]:"+ no.isInstanceOf[Maybe[_]])
      var yes: Yes[String] = new Yes("a")
      println("Yes.isInstanceOf[Maybe[_]]: " + yes.isInstanceOf[Maybe[_]])

      println("Task3:")
      val task3no: Task3[No] = new Task3[No](new No())
      task3no.applyFunction(a => a)
      println(task3no.getContent)
      val task3yes: Task3[Yes[String]] = new Task3[Yes[String]](new Yes("Task3"))
      task3yes.applyFunction(a => new Yes(a.getContent.toUpperCase() + a.getContent.toLowerCase))
      println(task3yes.getContent.getContent)

      println("Task4:")
      val task4no: Task4[No] = new Task4[No](new No())
      println(task4no.getOrElse)
      val task4yes: Task4[Yes[String]] = new Task4[Yes[String]](new Yes("Task4"))
      println(task4yes.getOrElse)

    }
  }

  class Task1[A](c: A) {
    private var _c: A = c
    def getContent: A = _c
    def applyFunction(f: A => A): A =
    {
      _c = f(_c)
      return _c
    }
  }

  trait Maybe[A]
  class No extends Maybe[Nothing]
  class Yes[A](value: A) extends Maybe[A] {
    private var v: A = value
    def getContent: A = v
  }

  class Task3[A](c: A) {
    private var _c: A = c
    def getContent: A = _c

    def applyFunction(f: A => A): A =
    {
      if (f(_c).isInstanceOf[No])
        return _c
      else if (f(_c).isInstanceOf[Yes[_]]) {
        _c = f(_c).asInstanceOf[A]
        return _c
      } else
        return null.asInstanceOf[A];
    }
  }

  class Task4[A](c: A) {
    private var _c: A = c
    def getContent: A = _c
    def getOrElse[B]: B =
    {
      if (_c.isInstanceOf[No])
        return "NO class, no content".asInstanceOf[B]
      else if (_c.isInstanceOf[Yes[_]])
        return _c.asInstanceOf[Yes[A]].getContent.asInstanceOf[B]
      else
        return null.asInstanceOf[B];
    }
  }