package Assignment1

object Weekday{

  def main(args: Array[String]): Unit = {
    val weekdays: List[String] = List("Monday","Tuesday","Wednesday",
      "Thursday","Friday","Saturday","Sunday")

    val product: Map[String,Double] = Map(("Jabłko",3),("Avokado",3.48),("Pomidor LUZ",4.99),("Mleko Polskie 1L",2.49),
      ("Somersby Mango 0.5x4",11.94),("Serek Capri 220G",3.48),("Imbir Luz",14.98))

    val numbers: List[Int] = List(0,1,-2,-21,-3,-4,15,6,17,8,9,10,12,0)

    val ingredient = ("Sugar" , 25, true)


    forLoop(weekdays)
    onlyS(weekdays)
    whileLoop(weekdays)

    println("2(a). Recursive Function \n"+ recursive(weekdays))
    println("2(b). Reverse Recursive Function\n"+reverseRecursive(weekdays))

    println("3. Tail recursive Function \n"+ tailRecursive(weekdays))

    listFoldLeft(weekdays)
    listFoldRight(weekdays)
    onlySfoldLeft(weekdays)


    println("5. Map Products and Prices\n"+giveDiscount(product,10))

    println("6. Number increased by 1\n"+listIncreasedByOne(numbers))

    println("7. Absolute numbers in the range <-5,12>\n"+absoluteRange(numbers))

    println("8. Tuple with 3 values of 3 different types\n"+ingredient)

    println("9. List without Zeros\n"+removeZ(numbers,0))

    println("10. Option Examples.")
    println("Options method getOrElse.")
    println("a. Get values larger than 21 from the List.")
    println(numbers.find(_ > 21).getOrElse(numbers.max+" is the maximum number in the List"))
    println("b. Get values larger than 15 from the List.")
    println(numbers.find(_ > 12).getOrElse(numbers.max+" is the maximum number in the List"))

    val opt: Option[Int] = Some(5)
    val opt2: Option[Int] = None

    println("Option method isEmpty.")
    println("Is val opt, empty: "+opt.isEmpty)
    println("Is val opt2, empty: "+opt2.isEmpty)
  }

  def forLoop(l:List[String]){
    var result = ""
    var counter = 0
    for(day <- l){
      result = result + day
      counter = counter+ 1
      if(counter < l.length)
        result = result+", "
    }
    println("1(a). For Loop:\n"+result)
  }

  def onlyS(l:List[String]){
    var result = ""
    var counter = 0
    for(day <- l;if(day.startsWith("S"))){
      result = result + day
      counter = counter+ 1
      if(day != l.last)
        result = result+", "
    }
    println("1(b). The string should contain only days with names starting with “S”\n"+result)
  }

  def whileLoop(l:List[String]){
    var result = ""
    var counter = 0
    while(counter < l.length){
      result = result + l(counter)
      counter = counter+ 1
      if(counter < l.length)
        result = result+", "
    }
    println("1(c). While Loop\n"+result)
  }

  def recursive(l:List[String]): String = l match {
    case Nil => ""
    case x :: head => x +", "+recursive(head)
  }

  def reverseRecursive(l:List[String]): String = l match {
    case Nil => ""
    case x :: head => reverseRecursive(head) + x + ", "
  }

  def tailRecursive(l:List[String]): String = {
    def tailRecursiveInnerMethod(l:List[String],currentString:String): String = l match {
      case Nil => currentString
      case x :: head => tailRecursiveInnerMethod(head ,currentString+x+", ")
    }
    tailRecursiveInnerMethod(l,"")
  }

  def listFoldLeft(l:List[String]){
    var s = l.foldLeft(""){
      (initial: String,next: String)=> initial+next+", "}
    println("4(a). FoldLeft\n"+s)
  }

  def listFoldRight(l:List[String]){
    var f = l.foldRight(""){
      (next: String,initial: String)=> next+", "+initial}
    println("4(b). FoldRight\n"+f)
  }

  def onlySfoldLeft(l:List[String]){
    var m = l.filter(p =>(p.startsWith("S"))).foldLeft(""){_+_+", "}
    println("4(c). FoldLeft, the string should contain only days with names starting with “S”\n"+m)
  }

  def giveDiscount(m: Map[String, Double], discount: Int): Map[String, Double] = {
    return m map { case (name, price) =>
      (name, BigDecimal(price * (100-discount)/100).setScale(2, BigDecimal.RoundingMode.HALF_UP).toDouble)}
  }

  def listIncreasedByOne(l:List[Int]): List[Int] =  {
    return l map{m:Int =>m+1}
  }

  def absoluteRange(l:List[Int]): List[Int] = {
    return l.filter(m => m >= -5 && m < 12).map(_.abs)
  }

  def printTuple(t:Tuple3[String,Int,Boolean]){
    print(t)
  }

  def removeZ(list: List[Int], n: Int): List[Int] = list match {
    case Nil => Nil
    case h :: t =>
      if (h == n)
        removeZ(t, n)
      else
        h :: removeZ(t, n)
  }
}
