package Assignment2

object SecondAssignment {
  def main(args: Array[String]): Unit = {
    val workdays: List[String] = List("monday","tuesday","wednesday", "thursday","friday")
    val weekends: List[String] = List("saturday","sunday")

    println("1. Day is weekday or weekend")
    println("Saturday is "+whichDay("saturday",workdays,weekends))
    println("Monday is "+whichDay("MoNdAy",workdays,weekends))
    println("Mooday is "+whichDay("Mooday",workdays,weekends))

    println("2. Deposit and Withdraw from Bank Account")
    var obj = new BankAccount(34);
    obj.deposit(10)
    var obj2 = new BankAccount()
    obj2.withdraw(10)

    var mateusz = new Person ("Mateusz","Morawiecki ","Poland")
    var donald = new Person("Donald","Trump","United States of America") with Teacher
    var justin = new Person("Justin","Trudeau","Canada")

    var dude = new Person("Marshall","Mathers","Hollywood") with Employee with Student
    var lilWayne = new Person("Michal","Carter","Hollywood") with Student with Employee

    println("3. Greeting for People from Different Countries")
    println(greetings(mateusz))
    println(greetings(donald))
    println(greetings(justin))
    println(greetings(dude))

    println("4. Function as a parameter to a function.")
    val square = (x: Int) => x*x
    val double = (x: Int) =>  x * 2

    println("Square the number 2, thrice: " + executeAndPrint(square, 2))
    println("Double the number 2, thrice: "+ executeAndPrint(double, 2))

    println("5. Teacher, Student and Employee Traits")
    dude.setSalary(500)
    lilWayne.setSalary(100)
    donald.setSalary(700)
    println("Marshall is an Employee first, then Student. His salary is "+dude.getSalary()+". Amount he pay as tax is "+dude.getTaxToPay())
    println("Michal is a Student first, then an Employee. His salary is "+lilWayne.getSalary()+". Amount he pay as tax is "+lilWayne.getTaxToPay())
    println("Donald is a Teacher. His salary is"+donald.getSalary()+". Amount he pays tax is "+donald.getTaxToPay())


  }
  trait Student extends Person {
    override def getTaxToPay(): Double = 0
  }

  trait Teacher extends Employee {
    override def getTaxToPay(): Double = 0.1*salary
  }

  trait Employee extends Person {
    var salary: Double

    override def getTaxToPay(): Double = 0.2 * salary

  }

  def executeAndPrint(f:(Int) => Int, x: Int): Int =  {
    val result = f(f(f(x)))
    return result
  }

  def greetings(p:Person)=(p.getCountry()) match {
      case "Poland" => "Dzien Dobry "+ p.getName()
      case "United States of America" => "Mr. President"
      case "Canada" => "Sat Shri Akal "+ p.getName() +" Ji"
      case _ => "Hey "+p.getName()
    }

  def whichDay(s:String,work:List[String],end:List[String]):String = s match {
    case x if work.contains(x.toLowerCase) => "Weekday"
    case x if end.contains(x) => "Weekend"
    case _ => "Not a day"
  }

}

